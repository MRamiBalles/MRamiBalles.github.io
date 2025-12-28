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
 * Class that describes an integer literal
 * 
 * @author Francisco J. Moreno Velo
 */
public class IntegerLiteralExpression extends LiteralExpression {
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Literal value
	 */
	private int value;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on a string)
	 */
	public IntegerLiteralExpression(String lexeme) 
	{
		super(DataType.int_type);
    	if(lexeme.startsWith("0x") || lexeme.startsWith("0X")) this.value = parseHexInt(lexeme.substring(2));
    	else if(lexeme.startsWith("0b") || lexeme.startsWith("0B")) this.value = parseBinaryInt(lexeme.substring(2));
    	else if(lexeme.startsWith("0")) this.value = Integer.parseInt(lexeme,8);
    	else this.value = Integer.parseInt(lexeme);
	}
	
	/**
	 * Constructor (based on a value)
	 */
	public IntegerLiteralExpression(int value) 
	{
		super(DataType.int_type);
		this.value = value;
	}
		
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the integer value
	 */
	public int getValue() 
	{
		return this.value;
	}

	/**
	 * Gets the value from the hexadecimal description avoiding the sign error.
	 */
	public static int parseHexInt(String hex) 
	{
		if(hex.length() !=8 ) return Integer.parseInt(hex,16);
		char first = hex.charAt(0);
		if(first >= '0' && first <= '7') return Integer.parseInt(hex,16);
		int hex7 = Integer.parseInt(hex.substring(1),16);
		int hex8 = Integer.parseInt(""+first,16);
		return (hex8<<28 | hex7);
	}
	
	/**
	 * Obtains the value from the binary description avoiding the sign error.
	 */
	public static int parseBinaryInt(String bin) 
	{
		if(bin.length() !=32 ) return Integer.parseInt(bin,2);
		char first = bin.charAt(0);
		if(first == '0') return Integer.parseInt(bin,2);
		int bin31 = Integer.parseInt(bin.substring(1),2);
		return (1<<31 | bin31);
	}
}