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
 * Abstract class describing an assembly instruction of the Intel-64 architecture
 * 
 * @author Francisco J. Moreno Velo
 */
public abstract class Instruction implements InstructionSet {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Instruction code
	 */
	private int code;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public Instruction(int code) 
	{
		this.code = code;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the instruction code
	 */
	public int getCode() 
	{
		return this.code;
	}

	/**
	 * Gets the name of the assembler instruction
	 */
	public String getInstructionName() 
	{
		switch (code) 
		{
		case PUSH: return "PUSH";
		case POP: return "POP";
		case ENTER: return "ENTER";
		case LEAVE: return "LEAVE";
		case CALL: return "CALL";
		case RET: return "RET";
		case MOV: return "MOV";
		case ADD: return "ADD";
		case SUB: return "SUB";
		case IMUL: return "IMUL";
		case IDIV: return "IDIV";
		case NEG: return "NEG";
		case CMP: return "CMP";
		case JE: return "JE";
		case JNE: return "JNE";
		case JG: return "JG";
		case JL: return "JL";
		case JGE: return "JGE";
		case JLE: return "JLE";
		case JMP: return "JMP";
		case AND: return "AND";
		case OR: return "OR";
		case XOR: return "XOR";
		default:
			return "";
		}
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public abstract String getAssembler();

}
