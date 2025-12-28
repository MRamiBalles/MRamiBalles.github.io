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
 * Class describing a binary operation
 * 
 * @author Francisco J. Moreno Velo
 */
public class BinaryExpression extends OperatorExpression {

	//----------------------------------------------------------------//
	//                           Constants                            //
	//----------------------------------------------------------------//

	/**
	 * Operator: AND
	 */
	public static final int AND = 1;

	/**
	 * Operator: OR
	 */
	public static final int OR = 2;

	/**
	 * Operator: PROD
	 */
	public static final int PROD = 3;

	/**
	 * Operator: DIV
	 */
	public static final int DIV = 4;

	/**
	 * Operator: MOD
	 */
	public static final int MOD = 5;

	/**
	 * Operator: PLUS
	 */
	public static final int PLUS = 6;

	/**
	 * Operator: MINUS
	 */
	public static final int MINUS = 7;

	/**
	 * Operator: EQ
	 */
	public static final int EQ = 8;

	/**
	 * Operator: NEQ
	 */
	public static final int NEQ = 9;

	/**
	 * Operator: GT
	 */
	public static final int GT = 10;

	/**
	 * Operator: GE
	 */
	public static final int GE = 11;

	/**
	 * Operator: LT
	 */
	public static final int LT = 12;

	/**
	 * Operator: LE
	 */
	public static final int LE = 13;

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Operation code
	 */
	private int op;
	
	/**
	 * Left operand
	 */
	private Expression left;
	
	/**
	 * Right operand
	 */
	private Expression right;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public BinaryExpression(int op, Expression left, Expression right) 
	{
		super(computeType(op,left,right));
		this.op = op;
		this.left = left;
		this.right = right;
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
	 * Gets the left operand
	 */
	public Expression getLeftExpression() 
	{
		return this.left;
	}
	
	/**
	 * Gets the right operand
	 */
	public Expression getRightExpression() 
	{
		return this.right;
	}
	
	//----------------------------------------------------------------//
	//                          Private methods                       //
	//----------------------------------------------------------------//

	/**
	 * Computes the data type of the operation
	 */
	private static DataType computeType(int op, Expression left, Expression right)
	{
		switch(op)
		{
		case AND:
		case OR:
		case EQ:
		case NEQ:
		case LT:
		case LE:
		case GT:
		case GE:
			return DataType.boolean_type;
		case PLUS:
		case MINUS:
		case PROD:
		case DIV:
		case MOD:
			return left.getType();
		default:
			return DataType.mismatch_type;
		}
	}
}
