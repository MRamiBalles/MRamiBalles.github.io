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

package urium.ast;

/**
 * Class describing the different data types
 * 
 * @author Francisco J. Moreno Velo
 */
public class DataType {
	
	//----------------------------------------------------------------//
	//                           Constants                            //
	//----------------------------------------------------------------//
	
	/**
	 * Data type: int 
	 */
	public static final int INT_TYPE = 0;

	/**
	 * Data type: char
	 */
	public static final int CHAR_TYPE = 1;

	/**
	 * Data type: boolean
	 */
	public static final int BOOLEAN_TYPE = 2;

	/**
	 * Data type: reference to int
	 */
	public static final int INT_REF_TYPE = 3;

	/**
	 * Data type: reference to char
	 */
	public static final int CHAR_REF_TYPE = 4;

	/**
	 * Data type: reference to boolean
	 */
	public static final int BOOLEAN_REF_TYPE = 5;
	
	/**
	 * Tipo de dato erróneo
	 */
	public static final int MISMATCH_TYPE = -1;
	
	//--------------------------------------------------------------//
	//                       Constant objects                       //
	//--------------------------------------------------------------//

	/**
	 * Object representing the int data type
	 */
	public static final DataType int_type = new DataType(INT_TYPE);

	/**
	 * Object representing the char data type
	 */
	public static final DataType char_type = new DataType(CHAR_TYPE);

	/**
	 * Object representing the boolean data type
	 */
	public static final DataType boolean_type = new DataType(BOOLEAN_TYPE);

	/**
	 * Object representing the data type of a reference to an int
	 */
	public static final DataType int_ref_type = new DataType(INT_REF_TYPE);

	/**
	 * Object representing the data type of a reference to a char
	 */
	public static final DataType char_ref_type = new DataType(CHAR_REF_TYPE);
	
	/**
	 * Object representing the data type of a reference to a boolean
	 */
	public static final DataType boolean_ref_type = new DataType(BOOLEAN_REF_TYPE);
	
	/**
	 * Object representing an incorrect data type
	 */
	public static final DataType mismatch_type = new DataType(MISMATCH_TYPE);	
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * code indicating the data type
	 */
	private int kind;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	private DataType(int kind) 
	{
		this.kind = kind;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//

	/**
	 * Gets the code of the data type
	 */
	public int getKind() 
	{
		return this.kind;
	}
	
	/**
	 * Gets the name used in procedure labels
	 */
	public String toLabel() 
	{
		switch(kind) 
		{
			case INT_TYPE: return "int";
			case CHAR_TYPE: return "char";
			case BOOLEAN_TYPE: return "boolean";
			case INT_REF_TYPE: return "out_int";
			case CHAR_REF_TYPE: return "out_char";
			case BOOLEAN_REF_TYPE: return "out_boolean";
			case MISMATCH_TYPE: return "error";
			default: return "";
		}
	}

}
