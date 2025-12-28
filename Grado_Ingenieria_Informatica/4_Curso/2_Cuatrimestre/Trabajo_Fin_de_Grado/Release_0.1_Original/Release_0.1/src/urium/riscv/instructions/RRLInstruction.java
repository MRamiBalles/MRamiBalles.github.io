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
 * Class describing an instruction on two registers and a label
 * 
 * @author Francisco J. Moreno Velo
 */
public class RRLInstruction extends Instruction {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * First register
	 */
	private Register reg1;

	/**
	 * Second register
	 */
	private Register reg2;

	/**
	 * Label
	 */
	private String label;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on references to the registers)
	 */
	public RRLInstruction(int code, Register r1, Register r2, String lb) 
	{
		super(code);
		this.reg1 = r1;
		this.reg2 = r2;
		this.label = lb;
	}

	/**
	 * Constructor (based on register codes)
	 */
	public RRLInstruction(int code, int s1, int s2, String lb) 
	{
		super(code);
		this.reg1 = new Register(s1);
		this.reg2 = new Register(s2);
		this.label = lb;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the label
	 */
	public String getLabel() 
	{
		return this.label;
	}

	/**
	 * Gets the first register
	 */
	public Register getRegister1() 
	{
		return this.reg1;
	}

	/**
	 * Gets the second register
	 */
	public Register getRegister2() 
	{
		return this.reg2;
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public String getAssembler() 
	{
		String asm = "\t" + getInstructionName();
		asm += " " + reg1.getName();
		asm += ", " + reg2.getName();
		asm += ", " + label;
		return asm;
	}

}
