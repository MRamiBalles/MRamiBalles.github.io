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

import urium.riscv.registers.OffsetRegister;
import urium.riscv.registers.Register;

/**
 * Class describing an instruction on a register and an offset
 * 
 * @author Francisco J. Moreno Velo
 */
public class RDRInstruction extends Instruction {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Target register
	 */
	private Register target;

	/**
	 * Offset register
	 */
	private OffsetRegister source;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on references to the members)
	 */
	public RDRInstruction(int code, Register target, OffsetRegister s) 
	{
		super(code);
		this.target = target;
		this.source = s;
	}

	/**
	 * Constructor (based on references to the registers)
	 */
	public RDRInstruction(int code, Register target, Register s, int disp) 
	{
		super(code);
		this.target = target;
		this.source = new OffsetRegister(disp, s);
	}

	/**
	 * Constructor (based on register codes)
	 */
	public RDRInstruction(int code, int target, int source, int disp) 
	{
		super(code);
		this.target = new Register(target);
		this.source = new OffsetRegister(disp, source);
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
	 * Gets the offset register
	 */
	public OffsetRegister getSource() 
	{
		return this.source;
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public String getAssembler() 
	{
		String asm = "\t" + getInstructionName();
		asm += " " + target.getName();
		asm += ", " + source.getName();
		return asm;
	}

}
