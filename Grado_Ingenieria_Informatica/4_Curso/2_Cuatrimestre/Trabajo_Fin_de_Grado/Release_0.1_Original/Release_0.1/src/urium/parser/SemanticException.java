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

package urium.parser;

/**
 * Class that describes a semantic exception
 * 
 * @author Francisco J. Moreno Velo
 */
public class SemanticException extends Exception {

	/**
	 * Generated serial version id
	 */
	private static final long serialVersionUID = 2709406750596946010L;
	
	//----------------------------------------------------------------//
	//                           Constants                            //
	//----------------------------------------------------------------//

	public static final int LIBRARY_NAME_EXCEPTION = 1;
	public static final int DUPLICATE_PROCEDURE_EXCEPTION = 2;
	public static final int DUPLICATE_ARGUMENT_EXCEPTION = 3;
	public static final int DUPLICATE_VARIABLE_EXCEPTION = 4;
	public static final int UNKNOWN_LIBRARY_EXCEPTION = 5;
	public static final int UNKNOWN_PROCEDURE_EXCEPTION = 6;
	public static final int UNKNOWN_VARIABLE_EXCEPTION = 7;
	public static final int INVALID_CONDITION_EXCEPTION = 8;
	public static final int TYPE_MISMATCH_EXCEPTION = 9;
	public static final int NUMBER_FORMAT_EXCEPTION = 10;
	public static final int UNREACHABLE_CODE_EXCEPTION = 11;
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Error message
	 */
	private String msg;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public SemanticException(int code, Token token) 
	{
		this.msg = "Parse exception at row "+token.beginLine;
		msg += ", column "+token.beginColumn+".\n";
		msg += getExplanationForCode(code)+"\n";
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Obtiene el mensaje de error
	 */
	public String toString() 
	{
		return this.msg;
	}
	
	//----------------------------------------------------------------//
	//                          Private methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the error description
	 */
	private static String getExplanationForCode(int code) 
	{
		switch(code) 
		{
		case LIBRARY_NAME_EXCEPTION:
			return "  Library name does not corresponds to file name.";
		case DUPLICATE_PROCEDURE_EXCEPTION:
			return "  Duplicate procedure.";
		case DUPLICATE_VARIABLE_EXCEPTION:
			return "  Duplicate variable.";
		case DUPLICATE_ARGUMENT_EXCEPTION:
			return "  Duplicate argument.";
		case UNKNOWN_LIBRARY_EXCEPTION:
			return "  Unknown library.";
		case UNKNOWN_PROCEDURE_EXCEPTION:
			return "  Unknown procedure.";
		case UNKNOWN_VARIABLE_EXCEPTION:
			return "  Unknown variable.";
		case INVALID_CONDITION_EXCEPTION:
			return "  Non-boolean expression."; 
		case TYPE_MISMATCH_EXCEPTION: 
			return "  Type mismatch.";
		case NUMBER_FORMAT_EXCEPTION:
			return "  Invalid literal value.";
		case UNREACHABLE_CODE_EXCEPTION:
			return "  Unreachable code.";
		default: return "";
		}
	}
}
