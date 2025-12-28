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

package urium.i64.instructions;

/**
 * Interface that describes the codes of all the instructions of the 
 * Intel-64 architecture
 * 
 * @author Francisco J. Moreno Velo
 */
public interface InstructionSet {

	/** Label */
	public int LABEL = 1;
	
	/** Push */
	public int PUSH = 2;
	
	/** Pop */
	public int POP = 3;
	
	/** Enter */
	public int ENTER = 4;
	
	/** Leave */
	public int LEAVE = 5;
	
	/** Call */
	public int CALL = 6;
	
	/** Ret */
	public int RET = 7;
	
	/** MOV */
	public int MOV = 8;
	
	/** AADD */
	public int ADD = 9;
	
	/** SUB */
	public int SUB = 10;
	
	/** IMUL */
	public int IMUL = 11;	
	
	/** CMP */
	public int CMP = 12;	
	
	/** JE */
	public int JE = 13;	
	
	/** JNE */
	public int JNE = 14;	
	
	/** JG */
	public int JG = 15;
	
	/** JL */
	public int JL = 16;
	
	/** JGE */
	public int JGE = 17;
	
	/** JLE */
	public int JLE = 18;	
	
	/** JMP */
	public int JMP = 19;	
	
	/** AND */
	public int AND = 20;
	
	/** OR */
	public int OR = 21;
	
	/** XOR */
	public int XOR = 22;
	
	/** IDIV */
	public int IDIV = 23;
	
	/** NEG */
	public int NEG = 24;
	
}
