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

package urium.code;

import urium.ast.DataType;

/**
 * Class describing the reference to a variable
 * 
 * @author Francisco J. Moreno Velo
 */
public class CodeVariable extends CodeAddress {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Data type of the variable
	 */
	private DataType type;
	
	/**
	 * Variable name
	 */
	private String name;

	/**
	 * Variable name in the source code
	 */
	private String des;
	
	/**
	 * Variable location in the stack frame
	 */
	private int offset;
	
	/**
	 * Processor register in which the variable is stored
	 */
	private int register;
	
	/**
	 * Flag indicating that the variable is stored in a register
	 */
	private boolean inRegister;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public CodeVariable(DataType type, String name, String des) 
	{
		this.type = type;
		this.name = name;
		this.des = des;
		this.offset = -1;
		this.register = -1;
		this.inRegister = false;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the data type of the variable
	 */
	public DataType getType() 
	{
		return this.type;
	}
	
	/**
	 * Gets the variable name
	 */
	public String toString() 
	{
		return this.name;
	}

	/**
	 * Gets the name used in the source code
	 */
	public String getDescription() 
	{
		return this.des;
	}

	/**
	 * Gets the variable location in the stack frame
	 */
	public int getOffset()
	{
		return this.offset;
	}
	
	/**
	 * Gets the code of the register where the variable is stored
	 */
	public int getRegister()
	{
		return this.register;
	}
	
	/**
	 * Checks if the variable is stored in a register
	 */
	public boolean inRegister()
	{
		return this.inRegister;
	}
	
	/**
	 * Sets the variable location in the stack frame
	 */
	public void setOffset(int o)
	{
		this.offset = o;
	}
	
	/**
	 * Sets the code of the register where the variable is stored
	 */
	public void setRegister(int code)
	{
		this.register = code;
	}
	
	/**
	 * Sets the flag indicating that the variable is stored in a register
	 */
	public void setInRegister(boolean flag)
	{
		this.inRegister = flag;
	}
}
