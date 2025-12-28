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
 * Class containing methods that implement the language's type system
 * 
 * @author Francisco J. Moreno Velo
 */
public class TypeSystem {

	/**
	 * Checks that a data type is an integer
	 */
	public static boolean isInteger(DataType type) 
	{
		switch(type.getKind()) 
		{
		case DataType.INT_TYPE:
		case DataType.INT_REF_TYPE:
			return true;
		case DataType.CHAR_TYPE:
		case DataType.CHAR_REF_TYPE:
		case DataType.BOOLEAN_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return false;	
		default:
			return false;
		}
	}
	
	/**
	 * Checks that a data type is a boolean
	 */
	public static boolean isBoolean(DataType type) 
	{
		switch(type.getKind()) 
		{
		case DataType.BOOLEAN_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return true;	
		case DataType.INT_TYPE:
		case DataType.INT_REF_TYPE:
		case DataType.CHAR_TYPE:
		case DataType.CHAR_REF_TYPE:
			return false;
		default:
			return false;
		}
	}
	
	/**
	 * Checks that a data type is a character
	 */
	public static boolean isChar(DataType type) 
	{
		switch(type.getKind()) 
		{
		case DataType.CHAR_TYPE:
		case DataType.CHAR_REF_TYPE:
			return true;
		case DataType.INT_TYPE:
		case DataType.INT_REF_TYPE:
		case DataType.BOOLEAN_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return false;	
		default:
			return false;
		}
	}
	
	/**
	 * Checks that a data type is numeric
	 */
	public static boolean isNumeric(DataType type) 
	{
		switch(type.getKind()) 
		{
		case DataType.INT_TYPE:
		case DataType.INT_REF_TYPE:
			return true;
		case DataType.CHAR_TYPE:
		case DataType.CHAR_REF_TYPE:
		case DataType.BOOLEAN_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return false;	
		default:
			return false;
		}
	}

	/**
	 * Checks that two data types can be sorted with '>' or '<'
	 */
	public static boolean isOrderable(DataType type1, DataType type2) 
	{
		if(isNumeric(type1) && isNumeric(type2)) return true;
		if(isChar(type1) && isChar(type2)) return true;
		return false;
	}
	
	/**
	 * Checks that two data types can be compared with '=' o '!='
	 */
	public static boolean isComparable(DataType type1, DataType type2) 
	{
		if(isNumeric(type1) && isNumeric(type2)) return true;
		if(isBoolean(type1) && isBoolean(type2)) return true;
		if(isChar(type1) && isChar(type2)) return true;
		return false;
	}
	
	/**
	 * Tests whether a value of data type 'type2' can be assigned to
	 * a variable of data type 'type1'
	 */
	public static boolean isAssignable(DataType type1, DataType type2) 
	{
		if(isNumeric(type1) && isNumeric(type2)) return true;
		if(isBoolean(type1) && isBoolean(type2)) return true;
		if(isChar(type1) && isChar(type2)) return true;
		return false;
	}

	/**
	 * Checks that a data type is a reference
	 */
	public static boolean isReference(DataType type) 
	{
		switch(type.getKind()) 
		{
		case DataType.INT_REF_TYPE:
		case DataType.CHAR_REF_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return true;
		case DataType.INT_TYPE:
		case DataType.CHAR_TYPE:
		case DataType.BOOLEAN_TYPE:
			return false;	
		default:
			return false;
		}
	}
	
	/**
	 * Gets the reference type corresponding to a basic type
	 */
	public static DataType getReference(DataType type)
	{
		switch(type.getKind()) 
		{
		case DataType.INT_TYPE:
		case DataType.INT_REF_TYPE:
			return DataType.int_ref_type;
		case DataType.CHAR_TYPE:
		case DataType.CHAR_REF_TYPE:
			return DataType.char_ref_type;
		case DataType.BOOLEAN_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
			return DataType.boolean_ref_type;
		default:
			return null;
		}
	}
	
	/**
	 * Gets the size (in bytes) of the data type
	 */
	public static int getNumberOfBytes(DataType type)
	{
		switch(type.getKind()) 
		{
		case DataType.INT_TYPE:
		case DataType.CHAR_TYPE:
		case DataType.BOOLEAN_TYPE:
			return 4;
		case DataType.INT_REF_TYPE:
		case DataType.CHAR_REF_TYPE:
		case DataType.BOOLEAN_REF_TYPE:
		default:
			return 0;
		}
	}
}
