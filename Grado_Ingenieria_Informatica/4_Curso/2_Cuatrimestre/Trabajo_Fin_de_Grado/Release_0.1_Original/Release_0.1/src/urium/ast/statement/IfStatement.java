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

import urium.ast.expression.Expression;

/**
 * Class describing a while statement
 * 
 * @author Francisco J. Moreno Velo
 */
public class IfStatement extends Statement {
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Condition of the statement
	 */
	private Expression condition;
	
	/**
	 * Instruction to be executed if the condition is met
	 */
	private Statement thenInst;

	/**
	 * Instruction to be executed if the condition is not met
	 */
	private Statement elseInst;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public IfStatement(Expression exp, Statement thenInst, Statement elseInst)
	{
		this.condition = exp;
		this.thenInst = thenInst;
		this.elseInst = elseInst;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the condition
	 */
	public Expression getCondition()
	{
		return this.condition;
	}
	
	/**
	 * Gets the instruction to be executed if the condition is met
	 */
	public Statement getThenInstruction() 
	{
		return this.thenInst;
	}
	
	/**
	 * Gets the instruction to be executed if the condition is not met
	 */
	public Statement getElseInstruction() 
	{
		return this.elseInst;
	}
	
	/**
	 * Check if the statement always reaches a return
	 */
	public boolean returns() 
	{
		if(elseInst == null) return false;
		boolean thenBranch = thenInst.returns();
		boolean elseBranch = elseInst.returns();			
		return thenBranch && elseBranch;
	}
}
