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

package urium.mips.registers;

/**
 * Class that describes an offset over the value of a MIPS-32 processor register
 * 
 * @author Francisco J. Moreno Velo
 */
public class OffsetRegister {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Offset
	 */
	private int offset;

	/**
	 * Register
	 */
	private Register reg;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on the register)
	 */
	public OffsetRegister(int offset, Register reg) 
	{
		this.offset = offset;
		this.reg = reg;
	}

	/**
	 * Constructor (based on the register code)
	 */
	public OffsetRegister(int offset, int code) 
	{
		this.offset = offset;
		this.reg = new Register(code);
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the offset
	 */
	public int getOffset() 
	{
		return this.offset;
	}

	/**
	 * Gets the register
	 */
	public Register getRegister() 
	{
		return this.reg;
	}

	/**
	 * Gets the assembler representation
	 */
	public String getName() 
	{
		return offset + "(" + reg.getName() + ")";
	}
	
	/**
	 * Checks if it is the same register and offset
	 */
	public boolean equals(Register r, int o)
	{
		if(this.reg == r && this.offset == o) return true;
		return false;
	}
}
