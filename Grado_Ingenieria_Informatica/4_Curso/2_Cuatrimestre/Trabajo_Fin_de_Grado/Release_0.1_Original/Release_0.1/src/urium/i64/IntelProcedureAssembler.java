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

package urium.i64;

import java.io.PrintStream;
import java.util.Vector;
import java.util.Stack;

import urium.ast.TypeSystem;
import urium.code.*;
import urium.i64.instructions.Instruction;
import urium.i64.instructions.InstructionFactory;
import urium.i64.registers.OffsetRegister;
import urium.i64.registers.Register;
import urium.i64.registers.RegisterSet;

/**
 * Class containing the description of an assembly procedure for the Intel-64 platform
 * 
 * @author Francisco J. Moreno Velo
 */
public class IntelProcedureAssembler {

	//----------------------------------------------------------------//
	//                            Constants                           //
	//----------------------------------------------------------------//
	
	/**
	 * Pointer size in words (1 word, 4 bytes) in the Intel-64 platform
	 */
	private static int PTRSIZE = 2;
	
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
	 * A counter for the creation of new labels
	 */
	private int labelcount;
	
	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public IntelProcedureAssembler(ProcedureCodification codif) 
	{
		this.label = codif.getLabel().replace(".","_");
		this.size = createFrameIntel64(codif);
		this.callstack = new Stack<CodeLiteral>();
		this.list = createAssembler(codif);
		this.labelcount = 0;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the procedure start label
	 */
	public String getMethodLabel() 
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
		stream.println(";------------------------------------------------------------------");
		stream.println("; " + label);
		stream.println(";------------------------------------------------------------------");
		stream.println();
		stream.println(label+" PROC");

		for (int i = 0; i < list.length; i++)
			stream.println(list[i].getAssembler());

		stream.println(label+ " ENDP");
		stream.println();
	}

	//----------------------------------------------------------------//
	//                         Private methods                        //
	//----------------------------------------------------------------//

	/**
	 * Assigns the variable locations in the stack frame (Intel-64 architecture)
	 */
	private int createFrameIntel64(ProcedureCodification codif) 
	{
		CodeVariable[] arg = codif.getArguments();
		CodeVariable[] var = codif.getVariables();
	
		// variables locales (4 bytes)+ temporales (4 bytes)+(hueco del 24)
		int framesize = 4*(var.length-arg.length)+16;
		if(framesize <32) framesize = 32;
		
		int argloc = framesize + 16; // framesize + rip + rbp
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
		
		// Instrucciones de entrada a la función
		vector.add(InstructionFactory.createPUSH(RegisterSet.rbp));
		vector.add(InstructionFactory.createSUB(RegisterSet.rsp, size));
		vector.add(InstructionFactory.createMOV(RegisterSet.rbp, RegisterSet.rsp));
		
		// Traduce a ensamblador el cuerpo de la función
		CodeInstruction codelist[] = codif.getCodeInstructionList();
		for (int i = 0; i < codelist.length; i++) 
		{
			createAssembler(vector, codelist[i]);
		}
		
		// Instrucciones de salida de la función
		vector.add(InstructionFactory.createLabel(this.getMethodLabel()+"_ENDP"));
		vector.add(InstructionFactory.createMOV(RegisterSet.rsp, RegisterSet.rbp));
		vector.add(InstructionFactory.createADD(RegisterSet.rsp, size));
		vector.add(InstructionFactory.createPOP(RegisterSet.rbp));
		vector.add(InstructionFactory.createRET());
		
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
		Register reg = translateLoadIntValue(vector, source, RegisterSet.eax);
		translateStoreIntValue(vector, target, reg);
	}

	/**
	 * Generates the assembly code for an addition instruction
	 */
	private void translateADD(Vector<Instruction> vector, CodeAddress target,CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		vector.add(InstructionFactory.createADD(source1_reg, source2_reg));
		translateStoreIntValue(vector, target, source1_reg);
	}

	/**
	 * Generates the assembly code for a subtraction instruction
	 */
	private void translateSUB(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createSUB(source1_reg,source2_reg));
		translateStoreIntValue(vector, target, source1_reg);
	}

	/**
	 * Generates the assembly code for a multiplication instruction
	 */
	private void translateMUL(Vector<Instruction> vector, CodeAddress target,CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createIMUL(source1_reg, source2_reg));
		translateStoreIntValue(vector, target, source1_reg);
	}

	/**
	 * Generates the assembly code for a division instruction
	 */
	private void translateDIV(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		String newlabel = this.label+"_ASM"+labelcount;
		labelcount++;
		
		translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createMOV(RegisterSet.edx,0));
		vector.add(InstructionFactory.createCMP(RegisterSet.eax, RegisterSet.edx));
		vector.add(InstructionFactory.createJGE(newlabel));
		vector.add(InstructionFactory.createMOV(RegisterSet.edx, 4294967295L));
		vector.add(InstructionFactory.createLabel(newlabel));
		vector.add(InstructionFactory.createIDIV(source2_reg));
		translateStoreIntValue(vector, target, RegisterSet.eax);
	}

	/**
	 * Generates the assembly code for a remainder instruction
	 */
	private void translateMOD(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		String newlabel = this.label+"_ASM"+labelcount;
		labelcount++;
		
		translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createMOV(RegisterSet.edx,0));
		vector.add(InstructionFactory.createCMP(RegisterSet.eax, RegisterSet.edx));
		vector.add(InstructionFactory.createJGE(newlabel));
		vector.add(InstructionFactory.createMOV(RegisterSet.edx, 4294967295L));
		vector.add(InstructionFactory.createLabel(newlabel));
		vector.add(InstructionFactory.createIDIV(source2_reg));
		translateStoreIntValue(vector, target, RegisterSet.edx);
	}

	/**
	 * Generates the assembly code for a sign change instruction
	 */
	private void translateINV(Vector<Instruction> vector, CodeAddress target, CodeAddress source) 
	{
		Register source_reg = translateLoadIntValue(vector, source, RegisterSet.eax);
		vector.add(InstructionFactory.createNEG(source_reg));
		translateStoreIntValue(vector, target, source_reg);
	}
	
	/**
	 * Generates the assembly code for a pointer instruction
	 */
	private void translatePOINTER(Vector<Instruction> vector, CodeAddress target, CodeAddress source1) 
	{
		CodeVariable var = (CodeVariable) source1;
		if(TypeSystem.isReference(var.getType()))
		{
			translateLoadIntWithDirectAddressing(vector,(CodeVariable) source1,RegisterSet.rax);
			translateStoreIntWithDirectAddressing(vector,(CodeVariable) target,RegisterSet.rax);
		}
		else
		{
			vector.add(InstructionFactory.createMOV(RegisterSet.rax, RegisterSet.rbp));
			vector.add(InstructionFactory.createADD(RegisterSet.rax, var.getOffset()));
			translateStoreIntWithDirectAddressing(vector,(CodeVariable) target,RegisterSet.rax);
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
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createAND(source1_reg, source2_reg));
		translateStoreIntValue(vector, target, source1_reg);
	}

	/**
	 * Generates the assembly code for a logical disjunction
	 */
	private void translateOR(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2,RegisterSet.ebx);
		vector.add(InstructionFactory.createOR(source1_reg, source2_reg));
		translateStoreIntValue(vector, target, source1_reg);
	}

	/**
	 * Generates the assembly code for a logical negation
	 */
	private void translateNOT(Vector<Instruction> vector, CodeAddress target,CodeAddress source1) 
	{ 
		Register source1_reg = translateLoadIntValue(vector, source1,RegisterSet.eax);
		vector.add(InstructionFactory.createXOR(source1_reg, 1));
		translateStoreIntValue(vector, target, source1_reg);
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
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJE(label));
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 != source2)
	 */
	private void translateJMPNE(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJNE(label));
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source1 > source2)
	 */
	private void translateJMPGT(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJG(label));
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 >= source2)
	 */
	private void translateJMPGE(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJGE(label));
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source1 < source2)
	 */
	private void translateJMPLT(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJL(label));
	}

	/**
	 * Generates the assembly code for the conditional jump 
	 * jump if(source1 <= source2)
	 */
	private void translateJMPLE(Vector<Instruction> vector, CodeAddress target,	CodeAddress source1, CodeAddress source2) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		Register source2_reg = translateLoadIntValue(vector, source2, RegisterSet.ebx);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, source2_reg));
		vector.add(InstructionFactory.createJLE(label));
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
		vector.add(InstructionFactory.createJMP(label));
	}

	/**
	 * Generates the assembly code for the conditional jump  
	 * jump if(source != 0)
	 */
	private void translateJMP1(Vector<Instruction> vector, CodeAddress target, CodeAddress source1) 
	{
		Register source1_reg = translateLoadIntValue(vector, source1, RegisterSet.eax);
		String label = target.toString();
		vector.add(InstructionFactory.createCMP(source1_reg, 1));
		vector.add(InstructionFactory.createJE(label));
	}

	//----------------------------------------------------------------//
	//             Translation of procedure call instructions         //
	//----------------------------------------------------------------//

	/**
	 * Generates the assembly code for the endp instruction
	 */
	private void translateENDP(Vector<Instruction> vector) 
	{
		vector.add(InstructionFactory.createJMP(this.label + "_ENDP"));
	}

	/**
	 * Generates the assembly code for the instruction that stores a call parameter
	 */
	private void translatePARAM(Vector<Instruction> vector, CodeAddress target, CodeAddress source1, CodeAddress source2) 
	{
		Register r;
		if (target instanceof CodeLiteral)
		{
			r = translateLoadIntLiteral(vector, (CodeLiteral) target, RegisterSet.eax);
		}
		else 
		{
			CodeVariable var = (CodeVariable) target;
			if( TypeSystem.isReference(var.getType()) )
			{
				r = translateLoadIntWithDirectAddressing(vector, var, RegisterSet.rax);
			}
			else
			{
				r = translateLoadIntWithDirectAddressing(vector, var, RegisterSet.eax);
			}
		}
				
		String hex1 = ((CodeLiteral) source1).getHexDescription();
		int offset1 = Integer.parseInt(hex1, 16);
		String hex2 = ((CodeLiteral) source2).getHexDescription();
		int offset2 = Integer.parseInt(hex2, 16);
		int offset = offset1 + offset2*PTRSIZE;
		
		vector.add(InstructionFactory.createMOV(new OffsetRegister(r.getSize(),offset,RegisterSet.rsp), r));
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

		vector.add(InstructionFactory.createSUB(RegisterSet.rsp,offset));
	}

	/**
	 * Generates the assembly code for the procedure call instruction
	 */
	private void translateCALL(Vector<Instruction> vector, CodeAddress target) 
	{
		vector.add(InstructionFactory.createCALL(target.toString()));	
		CodeLiteral argsize = callstack.pop();
		String hex = argsize.getHexDescription();
		int offset = Integer.parseInt(hex, 16);
		vector.add(InstructionFactory.createADD(RegisterSet.rsp,offset));
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
		vector.add(InstructionFactory.createMOV(r, value));
		return r;
	}
	
	/**
	 * Generates the assembly code to load an integer value by direct addressing
	 */
	private Register translateLoadIntWithDirectAddressing(Vector<Instruction> vector, CodeVariable variable, Register r)
	{
		if(variable.inRegister())
		{
			return RegisterSet.getRegister(variable.getOffset());
		}
		else
		{
			vector.add(InstructionFactory.createMOV(r, new OffsetRegister(r.getSize(),variable.getOffset(),RegisterSet.rbp)));
			return r;
		}
	}

	/**
	 * Generates the assembly code to load an integer value by indirect addressing
	 */
	private Register translateLoadIntWithIndirectAddressing(Vector<Instruction> vector,	CodeVariable var, Register r)
	{
		if (var.inRegister())  // Variable stored in a register
		{
			Register reg = RegisterSet.getRegister(var.getRegister());
			vector.add(InstructionFactory.createMOV(r, new OffsetRegister(RegisterSet.SIZE_64, 0, reg)));
			return r;
		} 
		else // Variable stored in the stack frame
		{ 
			vector.add(InstructionFactory.createMOV(RegisterSet.rax, new OffsetRegister(RegisterSet.SIZE_64, var.getOffset(), RegisterSet.rbp)));
			vector.add(InstructionFactory.createMOV(r, new OffsetRegister(r.getSize(), 0, RegisterSet.rax)));
			return r;
		}	
	}
	
	/**
	 * Generates the assembly code to store an integer value
	 */
	private void translateStoreIntValue(Vector<Instruction> vector, CodeAddress address, Register reg)
	{
		CodeVariable var = (CodeVariable) address;
		
		if( TypeSystem.isReference(var.getType()) )
		{
			translateStoreIntWithIndirectAddressing(vector,var,reg);
		}
		else
		{
			translateStoreIntWithDirectAddressing(vector,var,reg);
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
			vector.add(InstructionFactory.createMOV(new OffsetRegister(r.getSize(), 0, reg),r));
		} 
		else 
		{ 
			Register reg = RegisterSet.rax;
			if(reg == RegisterSet.To64bits(r)) reg = RegisterSet.rbx;
			vector.add(InstructionFactory.createMOV(reg, new OffsetRegister(RegisterSet.SIZE_64, var.getOffset(), RegisterSet.rbp)));
			vector.add(InstructionFactory.createMOV(new OffsetRegister(r.getSize(), 0, reg),r));
		}
	}
	
	/**
	 * Generates the assembly code to store an integer value by direct addressing
	 */
	private void translateStoreIntWithDirectAddressing(Vector<Instruction> vector, CodeVariable var, Register r) 
	{
		if(var.inRegister()) 
		{ 
			Register r_variable = RegisterSet.getRegister(var.getOffset());
			vector.add(InstructionFactory.createMOV(r_variable,r));
		} 
		else
		{
			vector.add(InstructionFactory.createMOV(new OffsetRegister(r.getSize(),var.getOffset(),RegisterSet.rbp), r));
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
}
