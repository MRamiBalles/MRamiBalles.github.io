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

package urium.ast.expression;

import urium.ast.DataType;

/**
 * Class describing a unary operation
 * 
 * @author Francisco J. Moreno Velo
 */
public class UnaryExpression extends OperatorExpression {

	//----------------------------------------------------------------//
	//                           Constants                            //
	//----------------------------------------------------------------//

	/**
	 * No operation
	 */
	public static final int NONE = 0;

	/**
	 * Operation: PLUS
	 */
	public static final int PLUS = 1;

	/**
	 * Operation: MINUS
	 */
	public static final int MINUS = 2;

	/**
	 * Operation: NOT
	 */
	public static final int NOT = 3;

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Operation code
	 */
	private int op;
	
	/**
	 * Expression operand
	 */
	private Expression exp;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public UnaryExpression(int op, Expression exp) 
	{
		super(computeType(op,exp));
		this.op = op;
		this.exp = exp;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//

	/**
	 * Gets the operation code
	 */
	public int getOperator() 
	{
		return this.op;
	}
	
	/**
	 * Gets the operand
	 */
	public Expression getExpression() 
	{
		return this.exp;
	}
	
	//----------------------------------------------------------------//
	//                          Private methods                       //
	//----------------------------------------------------------------//

	/**
	 * Computes the data type of the operation
	 */
	private static DataType computeType(int op, Expression exp)
	{
		switch(op)
		{
		case NOT: 
			return DataType.boolean_type;
		case MINUS: 
			return exp.getType();
		default: 
			return exp.getType();
		}
	}
}
