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

import java.io.PrintStream;
import urium.ast.struct.LibraryDeclaration;
import urium.ast.struct.Procedure;

/**
 * Class that describes the intermediate code of a library
 * 
 * @author Francisco J. Moreno Velo
 */
public class LibraryCodification {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Library name
	 */
	private String name;

	/**
	 * List of imported libraries
	 */
	private String[] imported;

	/**
	 * List of procedures
	 */
	private ProcedureCodification[] procedure;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public LibraryCodification(LibraryDeclaration decl)
	{
		this.name = decl.getName();
		this.imported = decl.getImported();
		Procedure[] proc = decl.getProcedures();
		this.procedure = new ProcedureCodification[proc.length];

		for(int i=0; i<proc.length; i++) 
		{
			this.procedure[i] = new ProcedureCodification(proc[i]);
		}
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Gets the full name of the library
	 */
	public String getName() 
	{
		return this.name;
	}

	/**
	 * Gets the list of imported libraries
	 */
	public String[] getImported() 
	{
		return this.imported;
	}

	/**
	 * Gets the list of procedures
	 */
	public ProcedureCodification[] getProcedureCodifications() 
	{
		return this.procedure;
	}

	/**
	 * Write the library intermediate code on the stream
	 */
	public void print(PrintStream stream) 
	{
		for(int i=0; i<procedure.length; i++) 
		{
			stream.println("; %%%%%%%%%%%%%%%");
			stream.println("; "+procedure[i].getLabel());
			stream.println("; %%%%%%%%%%%%%%%");
			procedure[i].print(stream);
			stream.println(";");
			stream.println(";");
		}
	}
}
