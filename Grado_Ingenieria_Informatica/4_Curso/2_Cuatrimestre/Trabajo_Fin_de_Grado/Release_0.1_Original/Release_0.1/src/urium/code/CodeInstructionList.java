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

/**
 * Class describing a list of intermediate code instructions
 * 
 * @author Francisco J. Moreno Velo
 */
public class CodeInstructionList {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Instruction list
	 */
	private CodeInstruction[] list;

	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public CodeInstructionList() 
	{
		this.list = new CodeInstruction[0];
	}

	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the instruction list
	 */
	public CodeInstruction[] getList() 
	{
		return this.list;
	}

	/**
	 * Adds a new instruction to the list
	 */
	public void addInstruction(CodeInstruction inst)
	{
		CodeInstruction[] aux = new CodeInstruction[list.length+1];
		System.arraycopy(list,0,aux,0,list.length);
		aux[list.length] = inst;
		list = aux;
	}

	/**
	 * Adds several new instructions to the list
	 */
	public void addInstructionList(CodeInstruction[] instlist) 
	{
		CodeInstruction[] aux = new CodeInstruction[list.length+instlist.length];
		System.arraycopy(list,0,aux,0,list.length);
		System.arraycopy(instlist,0,aux,list.length,instlist.length);
		list = aux;
	}

}
