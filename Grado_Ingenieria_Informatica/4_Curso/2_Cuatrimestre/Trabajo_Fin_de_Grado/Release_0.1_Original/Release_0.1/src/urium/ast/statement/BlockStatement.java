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

package urium.ast.statement;

/**
 * Class describing a block of statements
 * 
 * @author Francisco J. Moreno Velo
 */
public class BlockStatement extends Statement {
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * List of statements
	 */
	private Statement[] list;
	
	/**
	 * Flag indicating that the statement block always reaches a return;
	 */
	private boolean returns;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public BlockStatement()
	{
		this.list = new Statement[0];
		this.returns = false;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//

	/**
	 * Get the list of statements
	 */
	public Statement[] getStatementList() 
	{
		return this.list;
	}

	/**
	 *  Checks if the statement block always reaches a return
	 */
	public boolean returns() 
	{
		return this.returns;
	}
	
	/**
	 * Adds a statement to the list
	 */
	public void addStatement(Statement stm) 
	{
		if(stm == null) return;
		if(stm.returns()) returns = true; 
		
		Statement[] aux = new Statement[list.length+1];
		System.arraycopy(list,0,aux,0,list.length);
		aux[list.length] = stm;
		list = aux;
	}
}
