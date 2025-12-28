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

package urium.riscv.instructions;

import urium.riscv.registers.Register;

/**
 * Class to create instructions for the RISC-V processor
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

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//                       RISC-V 32G Instructions                    //
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Creates an addition instruction "add  rt, rs1, rs2"
	 */
	public static Instruction createADD(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(ADD, rt, rs1, rs2);
	}

	/**
	 * Creates an add-immediate instruction "addi  rt, rs1, value"
	 */
	public static Instruction createADDI(Register rt, Register rs1, int value) 
	{
		return new RRIInstruction(ADDI, rt, rs1, value);
	}
	
	/**
	 * Creates an AND instruction "and  rt, rs1, rs2"
	 */
	public static Instruction createAND(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(AND, rt, rs1, rs2);
	}
	
	/**
	 * Creates a branch-if-equal-to instruction "beq  rs1, rs2, label"
	 */
	public static Instruction createBEQ(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BEQ, rs1, rs2, label);
	}

	/**
	 * Creates a branch-if-greater-than-or-equal-to instruction "bge  rs1, rs2, label"
	 */
	public static Instruction createBGE(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BGE, rs1, rs2, label);
	}

	/**
	 * Creates a branch-if-less-than instruction "blt  rs1, rs2, label"
	 */
	public static Instruction createBLT(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BLT, rs1, rs2, label);
	}
	
	/**
	 * Creates a branch-if-not-equal-to instruction "bne  rs1, rs2, label"
	 */
	public static Instruction createBNE(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BNE, rs1, rs2, label);
	}
	
	/**
	 * Creates a divide instruction "div  rt, rs1, rs2"
	 */
	public static Instruction createDIV(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(DIV, rt, rs1, rs2);
	}
	
	/**
	 * Creates a load-upper-immediate instruction "lui  rt, value"
	 */
	public static Instruction createLUI(Register rt, int value) 
	{
		return new RIInstruction(LUI, rt, value);
	}
	
	/**
	 * Creates a load word instruction "lw  rt, offset(rs)"
	 */
	public static Instruction createLW(Register target, Register reg, int offset) 
	{
		return new RDRInstruction(LW, target, reg, offset);
	}

	/**
	 * Creates a multiply instruction "mul  rt, rs1, rs2"
	 */
	public static Instruction createMUL(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(MUL, rt, rs1, rs2);
	}

	/**
	 * Creates an OR instruction "or  rt, rs1, rs2"
	 */
	public static Instruction createOR(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(OR, rt, rs1, rs2);
	}
	
	/**
	 * Creates a remainder instruction "rem  rt, rs1, rs2"
	 */
	public static Instruction createREM(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(REM, rt, rs1, rs2);
	}
	
	/**
	 * Creates a subtraction instruction "sub  rt, rs1, rs2"
	 */
	public static Instruction createSUB(Register rt, Register rs1, Register rs2) 
	{
		return new RRRInstruction(SUB, rt, rs1, rs2);
	}
	
	/**
	 * Creates a store word instruction "sw  rs, offset(rt)"
	 */
	public static Instruction createSW(Register source, Register reg, int offset) 
	{
		return new RDRInstruction(SW, source, reg, offset);
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//                     RISC-V (Pesudo) Instructions                 //
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Creates a branch instruction "b label"
	 */
	public static Instruction createB(String label) 
	{
		return new LabelInstruction(B, label);
	}
	
	/**
	 * Creates a branch-if-greater-than instruction "bgt  rs1, rs2, label"
	 */
	public static Instruction createBGT(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BGT, rs1, rs2, label);
	}

	/**
	 * Creates a branch-if-less-than-or-equal-to instruction "ble  rs1, rs2, label"
	 */
	public static Instruction createBLE(Register rs1, Register rs2, String label) 
	{
		return new RRLInstruction(BLE, rs1, rs2, label);
	}
	
	/**
	 * Creates a branch-if-not-zero instruction "bnez rs1, label"
	 */
	public static Instruction createBNEZ(Register rs1, String label) 
	{
		return new RLInstruction(BNEZ, rs1, label);
	}

	/**
	 * Creates a jump-and-link instruction "jal label"
	 */
	public static Instruction createJAL(String label) 
	{
		return new LabelInstruction(JAL, label);
	}
	
	/**
	 * Creates a load immediate instruction "li rt, value"
	 */
	public static Instruction createLI(Register rt, int value) 
	{
		return new RIInstruction(LI, rt, value);
	}
	
	/**
	 * Creates a move instruction "mv rt, rs"
	 */
	public static Instruction createMV(Register rt, Register rs) 
	{
		return new RRInstruction(MV, rt, rs);
	}
	
	/**
	 * Creates an inverse sign instruction "neg rt, rs"
	 */
	public static Instruction createNEG(Register rt, Register rs) 
	{
		return new RRInstruction(NEG, rt, rs);
	}
	
	/**
	 * Creates a NOT instruction "not rt, rs"
	 */
	public static Instruction createNOT(Register rt, Register rs) 
	{
		return new RRInstruction(NOT, rt, rs);
	}
	
	/**
	 * Creates a return instruction "ret"
	 */
	public static Instruction createRET() 
	{
		return new NInstruction(RET);
	}
}
