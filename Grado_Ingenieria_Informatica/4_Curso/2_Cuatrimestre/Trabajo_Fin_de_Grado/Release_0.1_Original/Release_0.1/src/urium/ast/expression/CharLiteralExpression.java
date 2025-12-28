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
 * Class that describes a character literal
 * 
 * @author Francisco J. Moreno Velo
 */
public class CharLiteralExpression extends LiteralExpression {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Literal value
	 */
	private char value;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor (based on a string)
	 */
	public CharLiteralExpression(String lexeme) 
	{
		super(DataType.char_type);
		this.value = getCharFromString(lexeme);
	}
	
	/**
	 * Constructor (based on a value)
	 */
	public CharLiteralExpression(char value) 
	{
		super(DataType.char_type);
		this.value = value;
	}
		
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the value
	 */
	public char getValue() 
	{
		return this.value;
	}
	
	/**
	 * Obtains the character from the lexeme for the different formats
	 */
	private char getCharFromString(String lexeme) 
	{
		char[] content = lexeme.toCharArray();
		
		// Normal character
		if(content.length == 3) return content[1];
		
		// Special character
		if(content[2] == 'n') return '\n';
		if(content[2] == 'r') return '\r';
		if(content[2] == 't') return '\t';
		if(content[2] == 'b') return '\b';
		if(content[2] == 'f') return '\f';
		if(content[2] == '\\') return '\\';
		if(content[2] == '\'') return '\'';
		if(content[2] == '\"') return '\"';
		
		// Octal format
		if(content[2] >= '0' && content[2] <= '7') 
		{
			int val = content[2]-'0';
			if(content[3] != '\'') 
			{
				val *= 8;
				val += content[3]-'0';
				if(content[4] != '\'') 
				{
					val *= 8;
					val += content[4]-'0';
				}
			}
			return (char) val;
		}
		
		// Unicode format 
		if(content[2] == 'u' || content[2] == 'U') 
		{
			String sval = "0x"+content[3]+content[4]+content[5]+content[6];
			int val = Integer.parseInt(sval);
			return (char) val;
		}
		
		// Unreachable
		return '\0';
	}
}
