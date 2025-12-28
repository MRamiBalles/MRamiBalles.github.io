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
 * Class describing an instruction on three registers
 * 
 * @author Francisco J. Moreno Velo
 */
public class RRRInstruction extends Instruction {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Target register
	 */
	private Register target;

	/**
	 * First source register
	 */
	private Register source1;

	/**
	 * Second source register
	 */
	private Register source2;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on references to the registers)
	 */
	public RRRInstruction(int code, Register target, Register s1, Register s2) 
	{
		super(code);
		this.target = target;
		this.source1 = s1;
		this.source2 = s2;
	}

	/**
	 * Constructor (based on the register codes)
	 */
	public RRRInstruction(int code, int target, int s1, int s2) 
	{
		super(code);
		this.target = new Register(target);
		this.source1 = new Register(s1);
		this.source2 = new Register(s2);
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
	 * Gets the first source register
	 */
	public Register getSource1() 
	{
		return this.source1;
	}

	/**
	 * Gets the second source register
	 */
	public Register getSource2() 
	{
		return this.source2;
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public String getAssembler() 
	{
		String asm = "\t" + getInstructionName();
		asm += " " + target.getName();
		asm += " " + source1.getName();
		asm += " " + source2.getName();
		return asm;
	}

}
