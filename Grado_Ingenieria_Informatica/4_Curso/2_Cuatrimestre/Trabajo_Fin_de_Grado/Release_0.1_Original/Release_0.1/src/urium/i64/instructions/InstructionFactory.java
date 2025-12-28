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

package urium.i64.instructions;

import urium.i64.registers.*;

/**
 * Class to create instructions for the Intel-64 architecture
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

	/**
	 * Creates a push instruction "PUSH reg"
	 */
	public static Instruction createPUSH(Register r)
	{
		return new RInstruction(PUSH, r);
	}
	
	/**
	 * Creates a pop instruction "POP reg"
	 */
	public static Instruction createPOP(Register r)
	{
		return new RInstruction(POP, r);
	}
	
	/**
	 * Creates a call instruction "CALL label"
	 */
	public static Instruction createCALL(String label)
	{
		return new LabelInstruction(CALL, label);
	}
	
	/**
	 * Creates a return instruction "RET"
	 */
	public static Instruction createRET()
	{
		return new NInstruction(RET);
	}
	
	/**
	 * Creates a move instruction "MOV target, source"
	 */
	public static Instruction createMOV(Register t, Register s)
	{
		return new RRInstruction(MOV, t, s);
	}
	
	/**
	 * Creates a move instruction "MOV target, address"
	 */
	public static Instruction createMOV(Register t, OffsetRegister d)
	{
		return new RDRInstruction(MOV, t, d);
	}
	
	/**
	 * Creates a move instruction "MOV address, source"
	 */
	public static Instruction createMOV(OffsetRegister d, Register r)
	{
		return new DRRInstruction(MOV, d, r);
	}
	
	/**
	 * Creates a move instruction "MOV target, integer_literal"
	 */
	public static Instruction createMOV(Register t, int value)
	{
		return new RIInstruction(MOV, t, value);
	}
	
	/**
	 * Creates a move instruction "MOV target, long_literal"
	 */
	public static Instruction createMOV(Register t, long value)
	{
		return new RIInstruction(MOV, t, value);
	}
	
	/**
	 * Creates an addition instruction "ADD target, source"
	 */
	public static Instruction createADD(Register t, Register s)
	{
		return new RRInstruction(ADD, t, s);
	}
	
	/**
	 * Creates an addition instruction "ADD target, integer_literal"
	 */
	public static Instruction createADD(Register t, int value)
	{
		return new RIInstruction(ADD, t, value);
	}
	
	/**
	 * Creates a subtraction instruction "SUB target, source"
	 */
	public static Instruction createSUB(Register t, Register s)
	{
		return new RRInstruction(SUB, t, s);
	}
	
	/**
	 * Creates a subtraction instruction "SUB target, integer_literal"
	 */
	public static Instruction createSUB(Register t, int value)
	{
		return new RIInstruction(SUB, t, value);
	}
	
	/**
	 * Creates a multiply instruction "IMUL target, source"
	 */
	public static Instruction createIMUL(Register t, Register s)
	{
		return new RRInstruction(IMUL, t, s);
	}
	
	/**
	 * Creates a divide instruction "IDIV source"
	 */
	public static Instruction createIDIV(Register r)
	{
		return new RInstruction(IDIV, r);
	}
	
	/**
	 * Creates an inverse sign instruction "NEG target"
	 */
	public static Instruction createNEG(Register r)
	{
		return new RInstruction(NEG, r);
	}
	
	/**
	 * Creates a compare instruction "CMP register, register"
	 */
	public static Instruction createCMP(Register r1, Register r2)
	{
		return new RRInstruction(CMP, r1, r2);
	}
	
	/**
	 * Creates a compare instruction "CMP register, integer_literal"
	 */
	public static Instruction createCMP(Register r1, int v)
	{
		return new RIInstruction(CMP, r1, v);
	}
	
	/**
	 * Creates a jump instruction "JMP label"
	 */
	public static Instruction createJMP(String label)
	{
		return new LabelInstruction(JMP, label);
	}
	
	/**
	 * Creates a jump-if-equals instruction "JE label"
	 */
	public static Instruction createJE(String label)
	{
		return new LabelInstruction(JE, label);
	}
	
	/**
	 * Creates a jump-if-not-equals instruction "JNE label"
	 */
	public static Instruction createJNE(String label)
	{
		return new LabelInstruction(JNE, label);
	}
	
	/**
	 * Creates a jump-if-greater-than instruction "JG label"
	 */
	public static Instruction createJG(String label)
	{
		return new LabelInstruction(JG, label);
	}
	
	/**
	 * Creates a jump-if-less-than instruction "JL label"
	 */
	public static Instruction createJL(String label)
	{
		return new LabelInstruction(JL, label);
	}
	
	/**
	 * Creates a jump-if-greater-than-or-equals-to instruction "JGE label"
	 */
	public static Instruction createJGE(String label)
	{
		return new LabelInstruction(JGE, label);
	}
	
	/**
	 * Creates a jump-if-less-than-or-equals-to instruction "JLE label"
	 */
	public static Instruction createJLE(String label)
	{
		return new LabelInstruction(JLE, label);
	}
	
	/**
	 * Creates an AND instruction "AND target, source"
	 */
	public static Instruction createAND(Register t, Register s)
	{
		return new RRInstruction(AND, t, s);
	}
	
	/**
	 * Creates an OR instruction "OR target, source"
	 */
	public static Instruction createOR(Register t, Register s)
	{
		return new RRInstruction(OR, t, s);
	}
	
	/**
	 * Creates a XOR instruction "XOR target, source"
	 */
	public static Instruction createXOR(Register t, int v)
	{
		return new RIInstruction(XOR, t, v);
	}
}
