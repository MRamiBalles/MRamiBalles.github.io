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

package urium.ast.struct;

import java.util.Hashtable;
import java.util.Vector;
import urium.ast.*;

/**
 * Class that stores information about the declaration of a library
 * 
 * @author Francisco J. Moreno Velo
 */
public class LibraryDeclaration {
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Full name of the library
	 */
	private String name;

	/**
	 * List of imported libraries
	 */
	private Hashtable<String, String> imported;

	/**
	 * Native library flag
	 */
	private boolean isNative;
	
	/**
	 * Procedure list
	 */
	private Vector<Procedure> procedures;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public LibraryDeclaration(String name) 
	{
		this.name = name.toString();
		this.imported = new Hashtable<String,String>();
		this.isNative = false;
		this.procedures = new Vector<Procedure>();
	}
	
	//----------------------------------------------------------------//
	//                         Public methods                         //
	//----------------------------------------------------------------//

	/**
	 * Check if the library is native
	 */
	public boolean isNative()
	{
		return isNative;
	}
	
	/**
	 * Set the type of library (native or normal)
	 */
	public void setNative(boolean b)
	{
		this.isNative = b;
	}
	
	/**
	 * Gets the name of the library
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * Add a library to the list of imported libraries
	 */
	public void addImportedLibrary(String alias, String libname) 
	{
		if(!imported.containsKey(alias)) this.imported.put(alias,libname);
	}
	
	/**
	 * Gets the list of imported libraries
	 */
	public String[] getImported() 
	{
		Object[] obj = imported.values().toArray();
		String[] imp = new String[obj.length];
		for(int i=0; i<imp.length; i++) imp[i] = (String) obj[i];
		return imp;
	}
	
	/**
	 * Check if a certain name is among the imported classes
	 */
	public boolean isImported(String importedname) 
	{
		return imported.containsValue(importedname);
	}
	
	/**
	 * Gets the real name of an imported library from its alias name
	 */
	public String getLibraryNameFromAlias(String alias)
	{
		return this.imported.get(alias);
	}
	
	/**
	 * Add the definition of a procedure
	 */
	public void addProcedure(Procedure proc) 
	{
		this.procedures.add(proc);
	}
	
	/**
	 * Get the list of public and private procedures
	 */
	public Procedure[] getProcedures() 
	{
		Object[] obj = procedures.toArray();
		Procedure[] all = new Procedure[obj.length];
		for(int i=0; i<all.length; i++) all[i] = (Procedure) obj[i];
		return all;
	}
	
	/**
	 * Search for a procedure by its name and argument types
	 */
	public Procedure getAnyProcedure(String name, DataType[] type) 
	{
		for(Procedure proc : procedures)
		{
			if(proc.match(name,type) ) return proc;
		}
		return null;
	}
	
	/**
	 * Search for a public procedure by its name and argument types
	 */
	public Procedure getPublicProcedure(String name, DataType[] type) 
	{
		for(Procedure proc : procedures)
		{
			if(proc.getAccess() == Access.PUBLIC_ACCESS && proc.match(name,type) ) return proc;
		}
		return null;
	}
}
