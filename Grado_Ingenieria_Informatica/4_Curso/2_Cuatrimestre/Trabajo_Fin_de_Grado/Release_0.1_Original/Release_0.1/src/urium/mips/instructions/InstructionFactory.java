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

package urium.mips.instructions;

import urium.mips.registers.Register;
import urium.mips.registers.RegisterSet;

/**
 * Class to create instructions for the MIPS-32 processor
 * 
 * @author Francisco J. Moreno Velo
 */
public class InstructionFactory implements InstructionSet {

	/**
	 * Creates a label "label:"
	 */
	public static Instruction createLabel(String label) 
	{
		return new LabelInstruction(LABEL, label);
	}

	//------------------------------------------------------------------//
	//               Aligned CPU Load/Store Instructions                //
	//------------------------------------------------------------------//

	/**
	 * Creates a load word instruction "lw  target offset(source)"
	 */
	public static Instruction createLW(Register target, Register reg, int offset) 
	{
		return new RDRInstruction(LW, target, reg, offset);
	}

	/**
	 * Creates a store word instruction "sw source offset(base)"
	 */
	public static Instruction createSW(Register source, Register reg, int offset) 
	{
		return new RDRInstruction(SW, source, reg, offset);
	}

	//------------------------------------------------------------------//
	//             Unaligned CPU Load and Store Instructions            //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//           Atomic Update CPU Load and Store Instructions          //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//              Coprocessor Load and Store Instructions             //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	// FPU Load and Store Instructions Using Register+Register Addressing//
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//            ALU Instructions With an Immediate Operand            //
	//------------------------------------------------------------------//

	/**
	 * Creates an add-immediate instruction "addiu target source value"
	 */
	public static Instruction createADDIU(Register target, Register source,	int value) 
	{
		return new RRIInstruction(ADDIU, target, source, value);
	}

	/**
	 * Creates a load immediate instruction "li target value". 
	 * It's an alias to "ori target $r0 value"
	 */
	public static Instruction createLI(Register target, int value) 
	{
		return new RRIInstruction(ORI, target, RegisterSet.r0, value);
	}

	/**
	 * Creates an OR-Immediate instruction "ori target r0 value"
	 */
	public static Instruction createORI(Register target, Register source, int value)
	{
		return new RRIInstruction(ORI, target, source, value);
	}

	/**
	 * Creates a XOR-immediate instruction "xori target source value"
	 */
	public static Instruction createXORI(Register target, Register source,int value) 
	{
		return new RRIInstruction(XORI, target, source, value);
	}

	/**
	 * Creates a load upper immediate instruction "lui target value"
	 */
	public static Instruction createLUI(Register target, int value) 
	{
		return new RIInstruction(LUI, target, value);
	}

	/**
	 * Creates a set-less-than-immediate instruction "slti target r0 value"
	 */
	public static Instruction createSLTI(Register target, Register source, int value) 
	{
		return new RRIInstruction(SLTI, target, source, value);
	}

	//------------------------------------------------------------------//
	//                  Three-Operand ALU Instructions                  //
	//------------------------------------------------------------------//

	/**
	 * Creates an addition instruction "addu target source1 source2"
	 */
	public static Instruction createADDU(Register target, Register source1,	Register source2) 
	{
		return new RRRInstruction(ADDU, target, source1, source2);
	}

	/**
	 * Creates an AND instruction "and target source1 source2"
	 */
	public static Instruction createAND(Register target, Register source1,	Register source2) 
	{
		return new RRRInstruction(AND, target, source1, source2);
	}

	/**
	 * Creates an OR instruction "or target source1 source2"
	 */
	public static Instruction createOR(Register target, Register source1, Register source2) 
	{
		return new RRRInstruction(OR, target, source1, source2);
	}

	/**
	 * Creates a XOR instruction "xor target source1 source2"
	 */
	public static Instruction createXOR(Register target, Register source1,Register source2) 
	{
		return new RRRInstruction(XOR, target, source1, source2);
	}

	/**
	 * Creates a subtraction instruction "subu target source1 source2"
	 */
	public static Instruction createSUBU(Register target, Register source1,	Register source2) 
	{
		return new RRRInstruction(SUBU, target, source1, source2);
	}

	/**
	 * Creates a move instruction "move target source" 
	 * It's an alias to "or target $r0 source"
	 */
	public static Instruction createMOVE(Register target, Register source) 
	{
		return new RRRInstruction(OR, target, RegisterSet.r0, source);
	}

	/**
	 * Creates a set-less-than instruction "slt target source1 source2"
	 */
	public static Instruction createSLT(Register target, Register source1,Register source2) 
	{
		return new RRRInstruction(SLT, target, source1, source2);
	}

	/**
	 * Creates a set-less-than-unsigned instruction "sltu target source1 source2"
	 */
	public static Instruction createSLTU(Register target, Register source1, Register source2) 
	{
		return new RRRInstruction(SLTU, target, source1, source2);
	}

	//------------------------------------------------------------------//
	//                   Two-Operand ALU Instructions                   //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                       Shift Instructions                         //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                   Multiply/Divide Instructions                   //
	//------------------------------------------------------------------//

	/**
	 * Creates a multiply instruction "mult source1 source2"
	 */
	public static Instruction createMULT(Register source1, Register source2) 
	{
		return new RRInstruction(MULT, source1, source2);
	}

	/**
	 * Creates a divide instruction "div source1 source2"
	 */
	public static Instruction createDIV(Register source1, Register source2) 
	{
		return new RRInstruction(DIV, source1, source2);
	}

	/**
	 * Creates a move-from-low instruction "mflo target"
	 */
	public static Instruction createMFLO(Register target) 
	{
		return new RInstruction(MFLO, target);
	}

	/**
	 * Creates a move-from-high instruction "mfhi target"
	 */
	public static Instruction createMFHI(Register target) 
	{
		return new RInstruction(MFHI, target);
	}

	//------------------------------------------------------------------//
	// Unconditional Jump Within a 256 Megabyte Region                  //
	//------------------------------------------------------------------//

	/**
	 * Creates an unconditional jump instruction "j label"
	 */
	public static Instruction createJ(String label) 
	{
		return new LabelInstruction(J, label);
	}

	/**
	 * Creates a jump-and-link instruction "jal label"
	 */
	public static Instruction createJAL(String label) 
	{
		return new LabelInstruction(JAL, label);
	}

	/**
	 * Creates an unconditional jump instruction "jr target"
	 */
	public static Instruction createJR(Register target) {
		return new RInstruction(JR, target);
	}
	
	//------------------------------------------------------------------//
	// PC-Relative Conditional Branch Instructions Comparing Two Regs   //
	//------------------------------------------------------------------//

	/**
	 * Creates a branch-if-equal instruction "beq s1 s2 label"
	 */
	public static Instruction createBEQ(Register s1, Register s2, String label) 
	{
		return new RRLInstruction(BEQ, s1, s2, label);
	}

	/**
	 * Creates a branch-if-not-equal instruction "bne s1 s2 label"
	 */
	public static Instruction createBNE(Register s1, Register s2, String label) 
	{
		return new RRLInstruction(BNE, s1, s2, label);
	}

	//------------------------------------------------------------------//
	//  PC-Relative Conditional Branch Instructions Comparing With Zero //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//               Deprecated Branch Likely Instructions              //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                     Serialization Instruction                    //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//              System Call and Breakpoint Instructions             //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//       Trap-on-Condition Instructions Comparing Two Registers     //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//    Trap-on-Condition Instructions Comparing an Immediate Value   //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                 CPU Conditional Move Instructions                //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                       Prefetch Instructions                      //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                         NOP Instructions                         //
	//------------------------------------------------------------------//

	/**
	 * Creates a no-operation instruction "nop"
	 */
	public static Instruction createNOP() 
	{
		return new NInstruction(NOP);
	}

	//------------------------------------------------------------------//
	//                 FPU Move To and From Instructions                //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                   FPU IEEE Arithmetic Operations                 //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//                     FPU Comparing Operations                     //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//               FPU-Approximate Arithmetic Operations              //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//           FPU Multiply-Accumulate Arithmetic Operations          //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//      FPU Conversion Operations Using the FCSR Rounding Mode      //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//     FPU Conversion Operations Using a Directed Rounding Mode     //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//              FPU Formatted Operand Move Instructions             //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//          FPU Conditional Move on True/False Instructions         //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//              FPU Conditional Branch Instructions                 //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//       Deprecated FPU Conditional Branch Likely Instructions      //
	//------------------------------------------------------------------//

	//------------------------------------------------------------------//
	//        CPU Conditional Move on FPU True/False Instructions       //
	//------------------------------------------------------------------//

}
