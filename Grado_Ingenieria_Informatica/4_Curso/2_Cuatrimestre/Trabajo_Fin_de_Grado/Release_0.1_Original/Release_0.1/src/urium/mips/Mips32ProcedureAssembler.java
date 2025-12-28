//------------------------------------------------------------------//
//                        COPYRIGHT NOTICE                          //
//------------------------------------------------------------------//
// Copyright (c) 2024, Francisco J. Moreno Velo                     //
//                                                                  //
// Permission is hereby granted, free of charge, to any person      //
// obtaining a copy of this software and associated documentation   //
// files (the "Software"), to deal in the Software without          //
// restriction, including without limitation the rights to use,     //
// copy, modify, merge, publish, distribute, sublicense, and/or     //
// sell copies of the Software, and to permit persons to whom the   //
// Software is furnished to do so, subject to the following         //
// conditions:                                                      //
//                                                                  //
// - The above copyright notice and this permission notice shall be //
//   included in all copies or substantial portions of the Software.//
//                                                                  //
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,  //
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES  //
// OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND         //
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT      //
// HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,     //
// WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING     //
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR    //
// OTHER DEALINGS IN THE SOFTWARE.                                  //
//------------------------------------------------------------------//

//------------------------------------------------------------------//
//                      Universidad de Huelva                       //
//          Departamento de Tecnologías de la Información           //
//   Área de Ciencias de la Computación e Inteligencia Artificial   //
//------------------------------------------------------------------//
//                                                                  //
//                         Urium compiler                           //
//                                                                  //
//------------------------------------------------------------------//

package urium.mips;

import java.io.PrintStream;
import java.util.Vector;
import java.util.Stack;

import urium.ast.TypeSystem;
import urium.code.*;
import urium.mips.instructions.*;
import urium.mips.registers.*;


/**
 * Class containing the description of an assembly procedure for the MIPS32 platform
 * 
 * @author Francisco J. Moreno Velo
 */
public class Mips32ProcedureAssembler {

	//----------------------------------------------------------------//
	//                            Constants                           //
	//----------------------------------------------------------------//
	
	/**
	 * Pointer size in words (1 word, 4 bytes) in the MIPS32 platform
	 */
	private static int PTRSIZE = 1;
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Procedure start label
	 */
	private String label;

	/**
	 * Size of the stack frame
	 */
	private int size;

	/**
	 * Stack of PRECALL sizes. It is necessary to know the offset of 
	 * the Stack Pointer upon return from a call
	 */
	private Stack<CodeLiteral> callstack;

	/**
	 * List of assembler instructions
	 */
	private Instruction[] list;

	/**
	 * Register that is being read in the last instruction and therefore
	 * cannot be used until the next cycle.
	 */
	private Register fetchedRegister;
	
	/**
	 * Memory location that is being written in the last instruction and 
	 * therefore cannot be read until the next cycle.
	 */
	private OffsetRegister fetchedMemory;
	
	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public Mips32ProcedureAssembler(ProcedureCodification codif) 
	{
		this.label = codif.getLabel();
		this.size = createFrameMIPS(codif);
		this.callstack = new Stack<CodeLiteral>();
		this.list = createAssembler(codif);
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the procedure start label
	 */
	public String getLabel() 
	{
		return this.label;
	}

	/**
	 * Gets the list of assembler instructions
	 */
	public Instruction[] getInstructionList() 
	{
		return this.list;
	}

	/**
	 * Prints the assembler code on a stream
	 */
	public void print(PrintStream stream) 
	{
		stream.println("#------------------------------------------------------------------");
		stream.println("# " + label);
		stream.println("#------------------------------------------------------------------");
		stream.println();
		stream.println("\t.globl\t" + label);
		stream.println("\t.ent\t" + label);

		for (int i = 0; i < list.length; i++)
			stream.println(list[i].getAssembler());

		stream.println("\t.end\t" + label);
		stream.println();
	}

	//----------------------------------------------------------------//
	//                         Private methods                        //
	//----------------------------------------------------------------//

	/**
	 * Assigns the variable locations in the stack frame (MIPS32 architecture)
	 */
	private int createFrameMIPS(ProcedureCodification codif) 
	{
		CodeVariable[] arg = codif.getArguments();
		CodeVariable[] var = codif.getVariables();
		
		int framesize = 8; // ra + fp
		for(int i=arg.length; i<var.length; i++) 
		{
			if(var[i].inRegister()) continue;
			int varsize = TypeSystem.getNumberOfBytes(var[i].getType());
			if(TypeSystem.isReference(var[i].getType()) ) varsize = 4 * PTRSIZE;
			framesize += varsize;
		}

		int argloc = framesize;
		for(int i=0; i<arg.length; i++) 
		{
			var[i].setOffset(argloc);
			int varsize = TypeSystem.getNumberOfBytes(var[i].getType());
			if(TypeSystem.isReference(var[i].getType()) ) varsize = 4 * PTRSIZE;
			argloc += varsize;
		}

		int varloc = 0;
		for(int i=arg.length; i<var.length; i++) 
		{
			if(var[i].inRegister()) continue;
			var[i].setOffset(varloc);
			int varsize = TypeSystem.getNumberOfBytes(var[i].getType());
			if(TypeSystem.isReference(var[i].getType()) ) varsize = 4 * PTRSIZE;
			varloc += varsize;
		}
		return framesize;
	}
	
	/**
	 * Translates the intermediate code of the procedure into assembly code
	 */
	private Instruction[] createAssembler(ProcedureCodification codif) 
	{
		Vector<Instruction> vector = new Vector<Instruction>();

		// Instructions for starting the procedure
		//
		// procedure_label:             # Procedure start label
		// addiu $sp $sp -size          # Allocates memory space for the stack frame
		// sw $ra (size-4)($fp)         # Stores the return address
		// sw $fp (size-8)($fp)         # Stores the frame pointer
		// move $fp $sp                 # Sets the new frame pointer
		//
		vector.add(InstructionFactory.createLabel(label));
		vector.add(InstructionFactory.createADDIU(RegisterSet.sp, RegisterSet.sp, -size));
		vector.add(InstructionFactory.createSW(RegisterSet.ra, RegisterSet.sp,size - 4)); 
		vector.add(InstructionFactory.createSW(RegisterSet.fp, RegisterSet.sp, size - 8));
		vector.add(InstructionFactory.createMOVE(RegisterSet.fp, RegisterSet.sp)); 

		// Generates the assembler code for the body of the procedure
		CodeInstruction codelist[] = codif.getCodeInstructionList();
		for (int i = 0; i < codelist.length; i++) 
		{
			createAssembler(vector, codelist[i]);
		}

		// Procedure exit instructions
		//
		// procedure_label.return:      # Procedure return label
		// move $sp $fp                 # Free the memory space of the stack frame
		// lw $ra (size-8)($sp)         # Retrieves the return address
		// lw $fp (size-12)($sp)        # Retrieves the frame pointer
		// addiu $sp $sp size           # Retrieves the stack pointer
		// jr $ra                       # Jumps to the return address
		// nop                          # Blank instruction
		//
		vector.add(InstructionFactory.createLabel(label + ".endp"));  
		vector.add(InstructionFactory.createMOVE(RegisterSet.sp, RegisterSet.fp)); 
		vector.add(InstructionFactory.createLW(RegisterSet.ra, RegisterSet.sp, (size - 4))); 
		vector.add(InstructionFactory.createLW(RegisterSet.fp, RegisterSet.sp, (size - 8))); 
		vector.add(InstructionFactory.createADDIU(RegisterSet.sp,RegisterSet.sp, size));  
		vector.add(InstructionFactory.createJR(RegisterSet.ra)); 
		vector.add(InstructionFactory.createNOP());

		Instruction[] list = new Instruction[vector.size()];
		vector.toArray(list);
		return list;
	}

	/**
	 * Generates the assembly description of each of the instructions in the 
	 * intermediate code
	 */
	private void createAssembler(Vector<Instruction> vector,CodeInstruction inst) 
	{
		int kind = inst.getKind();
		CodeAddress target = inst.getTarget();
		CodeAddress source1 = inst.getSource1();
		CodeAddress source2 = inst.getSource2();

		switch (kind) 
		{
		case CodeConstants.LABEL:
			translateLabel(vector, target);
			break;
		case CodeConstants.ASSIGN:
			translateASSIGN(vector, target, source1);
			break;
		case CodeConstants.ADD:
			translateADD(vector, target, source1, source2);
			break;
		case CodeConstants.SUB:
			translateSUB(vector, target, source1, source2);
			break;
		case CodeConstants.MUL:
			translateMUL(vector, target, source1, source2);
			break;
		case CodeConstants.DIV:
			translateDIV(vector, target, source1, source2);
			break;
		case CodeConstants.MOD:
			translateMOD(vector, target, source1, source2);
			break;
		case CodeConstants.INV:
			translateINV(vector, target, source1);
			break;
		case CodeConstants.AND:
			translateAND(vector, target, source1, source2);
			break;
		case CodeConstants.OR:
			translateOR(vector, target, source1, source2);
			break;
		case CodeConstants.NOT:
			translateNOT(vector, target, source1);
			break;
		case CodeConstants.JMPEQ:
			translateJMPEQ(vector, target, source1, source2);
			break;
		case CodeConstants.JMPNE:
			translateJMPNE(vector, target, source1, source2);
			break;
		case CodeConstants.JMPGT:
			translateJMPGT(vector, target, source1, source2);
			break;
		case CodeConstants.JMPGE:
			translateJMPGE(vector, target, source1, source2);
			break;
		case CodeConstants.JMPLT:
			translateJMPLT(vector, target, source1, source2);
			break;
		case CodeConstants.JMPLE:
			translateJMPLE(vector, target, source1, source2);
			break;
		case CodeConstants.JUMP:
			translateJUMP(vector, target);
			break;
		case CodeConstants.JMP1:
			translateJMP1(vector, target, source1);
			break;
		case CodeConstants.PARAM:
			translatePARAM(vector, target, source1, source2);
			break;
		case CodeConstants.PRECALL:
			translatePRECALL(vector, target, source1);
			break;
		case CodeConstants.CALL:
			translateCALL(vector, target);
			break;
		case CodeConstants.ENDP:
			translateENDP(vector);
			break;
		case CodeConstants.POINTER:
			translatePOINTER(vector, target, source1);
			break;
		}
	}

	//----------------------------------------------------------------//
	//                      Translation of labels                     //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for a label
	 */
	private void translateLabel(Vector<Instruction> vector, CodeAddress label) 
	{
		CodeLabel codelb = (CodeLabel) label;
		vector.add(InstructionFactory.createLabel(codelb.toString()));
	}

	//----------------------------------------------------------------//
	//    Translation of arithmetic instructions for int data type    //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for an assignment instruction
	 */
	private void translateASSIGN(Vector<Instruction> vector,CodeAddress target, CodeAddress source) 
	{
		Register target_reg = getTargetRegister(target, RegisterSet.a0);
		Register reg = translateLoadIntValue(vector, source, target_reg);
		translateStoreIntValue(vector, target, reg);
	}

	/**
	 * Generates the assembly code for an addition instruction
	 */
	private void translateADD(Vector<Instruction> vector, CodeAddress target,CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createADDU(target_reg, source1_reg, source2_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a subtraction instruction
	 */
	private void translateSUB(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSUBU(target_reg, source1_reg,source2_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a multiplication instruction
	 */
	private void translateMUL(Vector<Instruction> vector, CodeAddress target,CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createMULT(source1_reg, source2_reg));
		vector.add(InstructionFactory.createMFLO(target_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a division instruction
	 */
	private void translateDIV(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createDIV(source1_reg, source2_reg));
		vector.add(InstructionFactory.createMFLO(target_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a remainder instruction
	 */
	private void translateMOD(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createDIV(source1_reg, source2_reg));
		vector.add(InstructionFactory.createMFHI(target_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a sign change instruction
	 */
	private void translateINV(Vector<Instruction> vector, CodeAddress target, CodeAddress source) 
	{
		Register source_reg = translateLoadIntValue(vector, source, RegisterSet.a0);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSUBU(target_reg, RegisterSet.r0, source_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}


	/**
	 * Generates the assembly code for a pointer instruction
	 */
	private void translatePOINTER(Vector<Instruction> vector, CodeAddress target, CodeAddress source1) 
	{
		CodeVariable var = (CodeVariable) source1;
		if(TypeSystem.isReference(var.getType()))
		{
			translateLoadIntWithDirectAddressing(vector,(CodeVariable) source1,RegisterSet.v0);
			if(needsNOP(RegisterSet.v0)) vector.add(InstructionFactory.createNOP());
			translateStoreIntWithDirectAddressing(vector,(CodeVariable) target,RegisterSet.v0);
		}
		else
		{
			vector.add(InstructionFactory.createADDIU(RegisterSet.v0, RegisterSet.fp, var.getOffset()));
			setFetched(null,null,0);
			translateStoreIntWithDirectAddressing(vector,(CodeVariable) target,RegisterSet.v0);
		}
	}
	
	//----------------------------------------------------------------//
	//                Translation of boolean instructions             //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for a logical conjunction
	 */
	private void translateAND(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createAND(target_reg, source1_reg, source2_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a logical disjunction
	 */
	private void translateOR(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg,source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createOR(target_reg, source1_reg, source2_reg));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	/**
	 * Generates the assembly code for a logical negation
	 */
	private void translateNOT(Vector<Instruction> vector, CodeAddress target,CodeAddress source1) 
	{ 
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register target_reg = getTargetRegister(target, RegisterSet.v0);
		if(needsNOP(source1_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSLTI(target_reg, source1_reg, 1));
		setFetched(null,null,0);
		translateStoreIntValue(vector, target, target_reg);
	}

	//----------------------------------------------------------------//
	//       Translation of conditional jumps for int data type       //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 == source2)
	 */
	private void translateJMPEQ(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createBEQ(source1_reg, source2_reg, label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 != source2)
	 */
	private void translateJMPNE(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createBNE(source1_reg, source2_reg, label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source1 > source2)
	 */
	private void translateJMPGT(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSLT(RegisterSet.v0, source2_reg, source1_reg));
		vector.add(InstructionFactory.createBNE(RegisterSet.v0, RegisterSet.r0,	label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 >= source2)
	 */
	private void translateJMPGE(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSLT(RegisterSet.v0, source1_reg, source2_reg));
		vector.add(InstructionFactory.createBEQ(RegisterSet.v0, RegisterSet.r0,	label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source1 < source2)
	 */
	private void translateJMPLT(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSLT(RegisterSet.v0, source1_reg, source2_reg));
		vector.add(InstructionFactory.createBNE(RegisterSet.v0, RegisterSet.r0,	label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 <= source2)
	 */
	private void translateJMPLE(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.a1);
		String label = target.toString();
		if(needsNOP(source1_reg, source2_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSLT(RegisterSet.v0, source2_reg, source1_reg));
		vector.add(InstructionFactory.createBEQ(RegisterSet.v0, RegisterSet.r0, label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	//----------------------------------------------------------------//
	//             Translation of other jump instructions             //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for an unconditional jump 
	 */
	private void translateJUMP(Vector<Instruction> vector, CodeAddress target) 
	{
		String label = target.toString();
		vector.add(InstructionFactory.createJ(label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source != 0)
	 */
	private void translateJMP1(Vector<Instruction> vector, CodeAddress target, CodeAddress source1) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.a0);
		String label = target.toString();
		if(needsNOP(source1_reg)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createBNE(source1_reg, RegisterSet.r0, label));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	//----------------------------------------------------------------//
	//             Translation of procedure call instructions         //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for the return instruction
	 */
	private void translateENDP(Vector<Instruction> vector) 
	{
		vector.add(InstructionFactory.createJ(this.label + ".endp"));
		vector.add(InstructionFactory.createNOP());
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the instruction that stores a call parameter
	 */
	private void translatePARAM(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register r;
		if (target instanceof CodeLiteral)
		{
			r = translateLoadIntLiteral(vector, (CodeLiteral) target, RegisterSet.a0);
		}
		else 
		{
			r = translateLoadIntWithDirectAddressing(vector, (CodeVariable) target, RegisterSet.a0);
		}
				
		String hex1 = ((CodeLiteral) source1).getHexDescription();
		int offset1 = Integer.parseInt(hex1, 16);
		String hex2 = ((CodeLiteral) source2).getHexDescription();
		int offset2 = Integer.parseInt(hex2, 16);
		int offset = offset1 + offset2*PTRSIZE;
		
		if(needsNOP(r)) vector.add(InstructionFactory.createNOP());
		vector.add(InstructionFactory.createSW(r, RegisterSet.sp, offset));
		setFetched(null,RegisterSet.sp, offset);
	}

	/**
	 * Generates assembly code to allocate stack memory to store the parameters of a call
	 */
	private void translatePRECALL(Vector<Instruction> vector, CodeAddress target, CodeAddress source1) 
	{	
		String hex1 = ((CodeLiteral) target).getHexDescription();
		int offset1 = Integer.parseInt(hex1, 16);
		String hex2 = ((CodeLiteral) source1).getHexDescription();
		int offset2 = Integer.parseInt(hex2, 16);
		int offset = offset1 + offset2*PTRSIZE;
		
		callstack.push(new CodeLiteral(offset));
		
		vector.add(InstructionFactory.createADDIU(RegisterSet.sp,RegisterSet.sp, -offset));
		setFetched(null,null,0);
	}

	/**
	 * Generates the assembly code for the procedure call instruction
	 */
	private void translateCALL(Vector<Instruction> vector, CodeAddress target) 
	{
		CodeLabel proclabel = (CodeLabel) target;
		vector.add(InstructionFactory.createJAL(proclabel.toString()));
		vector.add(InstructionFactory.createNOP());
		CodeLiteral argsize = callstack.pop();
		String hex = argsize.getHexDescription();
		int offset = Integer.parseInt(hex, 16);
		vector.add(InstructionFactory.createADDIU(RegisterSet.sp, RegisterSet.sp, offset));
		setFetched(null,null,0);
	}

	//----------------------------------------------------------------//
	//                   Load and store instructions                  //
	//----------------------------------------------------------------//

	/**
	 * Loads an integer value into a register
	 */
	private Register translateLoadIntValue(Vector<Instruction> vector,	CodeAddress address, Register r) 
	{
		if (address instanceof CodeLiteral)  // Literal value 
		{
			return translateLoadIntLiteral(vector, (CodeLiteral) address, r);
		}
		else if( TypeSystem.isReference( ((CodeVariable) address).getType()) )
		{
			return translateLoadIntWithIndirectAddressing(vector, (CodeVariable) address, r);
		}
		else
		{
			return translateLoadIntWithDirectAddressing(vector, (CodeVariable) address, r);
		}
	}

	/**
	 * Generates the assembly code to load an integer value into a register
	 */
	private Register translateLoadIntLiteral(Vector<Instruction> vector, CodeLiteral literal, Register r) 
	{
		String hex = literal.getHexDescription();
		int value = parseHexInt(hex);
		if (value<0 || value > 0x0FFFF) 
		{
			int upper = (value & 0xFFFF0000) >> 16;
			int lower = (value & 0x0000FFFF);
			vector.add(InstructionFactory.createLUI(r, upper));
			vector.add(InstructionFactory.createORI(r, r, lower));
		} 
		else
		{
			vector.add(InstructionFactory.createLI(r, value));
		}
		setFetched(null,null,0);
		return r;
	}

	/**
	 * Generates the assembly code to load an integer value by indirect addressing
	 */
	private Register translateLoadIntWithIndirectAddressing(Vector<Instruction> vector,	CodeVariable var, Register r)
	{
		if (var.inRegister())  // Variable stored in a register
		{
			Register reg = RegisterSet.getRegister(var.getRegister());
			vector.add(InstructionFactory.createLW(r, reg, 0));
			setFetched(r,null,0);
			return r;
		} 
		else // Variable stored in the stack frame
		{ 
			if(needsNOP(RegisterSet.fp, var.getOffset())) vector.add(InstructionFactory.createNOP());
			vector.add(InstructionFactory.createLW(r, RegisterSet.fp, var.getOffset()));
			vector.add(InstructionFactory.createNOP());
			vector.add(InstructionFactory.createLW(r, r, 0));
			setFetched(r,null,0);
			return r;
		}	
	}

	/**
	 * Generates the assembly code to load an integer value by direct addressing
	 */
	private Register translateLoadIntWithDirectAddressing(Vector<Instruction> vector, CodeVariable var, Register r)
	{
		if (var.inRegister()) // Variable stored in a register
		{
			return RegisterSet.getRegister(var.getRegister());
		} 
		else // Variable stored in the stack frame
		{ 
			if(needsNOP(RegisterSet.fp, var.getOffset())) vector.add(InstructionFactory.createNOP());
			vector.add(InstructionFactory.createLW(r, RegisterSet.fp, var.getOffset()));
			setFetched(r,null,0);
			return r;
		}		
	}

	/**
	 * Gets the register to store the result of an operation
	 */
	private Register getTargetRegister(CodeAddress address, Register r) 
	{
		CodeVariable tvar = (CodeVariable) address;
		if (tvar.inRegister())
		{
			return RegisterSet.getRegister(tvar.getRegister());
		}
		else
		{
			return r;
		}
	}

	/**
	 * Generates the assembly code to store an integer variable
	 */
	private void translateStoreIntValue(Vector<Instruction> vector, CodeAddress address, Register r) 
	{
		if(needsNOP(r)) vector.add(InstructionFactory.createNOP());
		CodeVariable var = (CodeVariable) address;

		if( TypeSystem.isReference(var.getType()) )
		{
			translateStoreIntWithIndirectAddressing(vector,var,r);
		}
		else
		{
			translateStoreIntWithDirectAddressing(vector,var,r);
		}
	}

	/**
	 * Generates the assembly code to store an integer value by direct addressing
	 */
	private void translateStoreIntWithIndirectAddressing(Vector<Instruction> vector, CodeVariable var, Register r) 
	{	
		if (var.inRegister() ) 
		{ 
			Register reg = RegisterSet.getRegister(var.getRegister());
			vector.add(InstructionFactory.createSW(r, reg, 0));
			setFetched(null,null,0);
		} 
		else 
		{ 
			Register reg = RegisterSet.t0;
			if(reg == r) reg = RegisterSet.t1;
			vector.add(InstructionFactory.createLW(reg, RegisterSet.fp, var.getOffset()));
			vector.add(InstructionFactory.createNOP());
			vector.add(InstructionFactory.createSW(r, reg, 0));
			setFetched(null,null,0);
		}
	}
	
	/**
	 * Generates the assembly code to store an integer value by direct addressing
	 */
	private void translateStoreIntWithDirectAddressing(Vector<Instruction> vector, CodeVariable var, Register r) 
	{	
		if (var.inRegister() && var.getRegister() != r.getCode()) 
		{ 
			Register target = RegisterSet.getRegister(var.getRegister());
			vector.add(InstructionFactory.createMOVE(target, r));
			setFetched(null,null,0);
		} 
		else if (!var.inRegister()) 
		{ 
			vector.add(InstructionFactory.createSW(r, RegisterSet.fp, var.getOffset()));
			setFetched(null,RegisterSet.fp, var.getOffset());
		}
	}
	
	/**
	 * Gets an integer value from its hexadecimal description
	 * avoiding the sign error
	 */
	private int parseHexInt(String hex) 
	{
		if(hex.length() <8 ) return Integer.parseInt(hex,16);
		char first = hex.charAt(0);
		if(first >= '0' && first <= '7') return Integer.parseInt(hex,16);
		int hex7 = Integer.parseInt(hex.substring(1),16);
		int hex8 = Integer.parseInt(""+first,16);
		return (hex8<<28 | hex7);
	}
	
	//----------------------------------------------------------------//
	//                Control of the fetched registers                //
	//----------------------------------------------------------------//

	/**
	 * Checks if a NOP operation is needed
	 */
	private boolean needsNOP(Register r)
	{
		if(this.fetchedRegister == r) return true;
		return false;
	}
	
	/**
	 * Checks if a NOP operation is needed
	 */
	private boolean needsNOP(Register r1, Register r2)
	{
		if(this.fetchedRegister == r1 || this.fetchedRegister == r2) return true;
		return false;
	}
	
	/**
	 * Checks if a NOP operation is needed
	 */
	private boolean needsNOP(Register dr, int dl)
	{
		if(this.fetchedMemory != null && this.fetchedMemory.equals(dr,dl)) return true;
		return false;
	}
	
	/**
	 * Sets the fetched flags
	 */
	private void setFetched(Register r, Register dr, int dl)
	{
		this.fetchedRegister = r;
		this.fetchedMemory = new OffsetRegister(dl,dr);
	}
}
