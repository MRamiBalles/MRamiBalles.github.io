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
 * Interface describing the instruction codes
 * 
 * @author Francisco J. Moreno Velo
 */
public interface CodeConstants {

	/**
	 * Label
	 */
	public int LABEL = 1;
	
	/**
	 * Assignment
	 */
	public int ASSIGN = 2;
	
	/**
	 * Addition
	 */
	public int ADD = 3;
		
	/**
	 * Subtraction
	 */
	public int SUB = 4;
	
	/**
	 * Product
	 */
	public int MUL = 5;
	
	/**
	 * Division
	 */
	public int DIV = 6;
	
	/**
	 * Remainder
	 */
	public int MOD = 7;
	
	/**
	 * Sign change
	 */
	public int INV = 8;
	
	/**
	 * Logical conjunction
	 */
	public int AND = 9;
	
	/**
	 * Logical disjunction
	 */
	public int OR = 10;

	/**
	 * Logical negation
	 */
	public int NOT = 11;
	
	/**
	 * Unconditional jump
	 */
	public int JUMP = 12;

	/**
	 * Jump if equals
	 */
	public int JMPEQ = 13;
	
	/**
	 * Jump if not equals
	 */
	public int JMPNE = 14;
	
	/**
	 * Jump if greater than
	 */
	public int JMPGT = 15;
	
	/**
	 * Jump if greater than or equal to
	 */
	public int JMPGE = 16;
	
	/**
	 * Jump if less than
	 */
	public int JMPLT = 17;
	
	/**
	 * Jump if less than or equal to
	 */
	public int JMPLE = 18;
	
	/**
	 * Jump if true
	 */
	public int JMP1 = 19;
	
	/**
	 * Stores a parameter for the next call to a procedure
	 */
	public int PARAM = 20;

	/**
	 * Call to a procedure
	 */
	public int CALL = 21;

	/**
	 * End of a procedure
	 */
	public int ENDP = 22;

	/**
	 * Prepare the next call to a procedure
	 */
	public int PRECALL = 23;
	
	/**
	 * Memory address of a variable 
	 */
	public int POINTER = 24;
}
