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

/**
 * Class describing an instruction on two registers and an immediate value
 * 
 * @author Francisco J. Moreno Velo
 */
public class RRIInstruction extends Instruction {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Target register
	 */
	private Register target;

	/**
	 * Source register
	 */
	private Register source;

	/**
	 * Immediate value
	 */
	private int value;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on references to the registers)
	 */
	public RRIInstruction(int code, Register target, Register s1, int value) 
	{
		super(code);
		this.target = target;
		this.source = s1;
		this.value = value;
	}

	/**
	 * Constructor (based on the register codes)
	 */
	public RRIInstruction(int code, int target, int s, int value) 
	{
		super(code);
		this.target = new Register(target);
		this.source = new Register(s);
		this.value = value;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the target register
	 */
	public Register getTarget() 
	{
		return this.target;
	}

	/**
	 * Gets the source register
	 */
	public Register getSource() 
	{
		return this.source;
	}

	/**
	 * Gets the immediate value
	 */
	public int getValue() 
	{
		return this.value;
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public String getAssembler() 
	{
		String asm = "\t" + getInstructionName();
		asm += " " + target.getName();
		asm += " " + source.getName();
		asm += " 0x" + Integer.toHexString(value);
		return asm;
	}

}
