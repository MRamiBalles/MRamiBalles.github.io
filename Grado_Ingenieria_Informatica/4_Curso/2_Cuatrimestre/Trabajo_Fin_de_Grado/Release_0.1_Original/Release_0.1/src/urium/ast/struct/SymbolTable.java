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
import java.util.Stack;
import urium.ast.DataType;

/**
 * Class that develops the symbol table
 * 
 * @author Francisco J. Moreno Velo
 */
public class SymbolTable {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Table of libraries stored in the symbol table
	 */
	private Hashtable<String, LibraryDeclaration> libraries;
	
	/**
	 * Active library
	 */
	private LibraryDeclaration activeLibrary;
	
	/**
	 * Active procedure
	 */
	private Procedure activeProcedure;
	
	/**
	 * Stack of variable scopes
	 */
	private Stack<Hashtable<String, Variable>> stack;

	//----------------------------------------------------------------//
	//                          Constructor                           //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public SymbolTable() 
	{
		this.libraries = new Hashtable<String, LibraryDeclaration>();
		this.stack = new Stack<Hashtable<String, Variable>>();
		this.activeLibrary = null;
		this.activeProcedure = null;
	}

	//----------------------------------------------------------------//
	//                         Public methods                         //
	//----------------------------------------------------------------//

	/**
	 * Add a library to the symbol table
	 */
	public void addLibrary(LibraryDeclaration lib) 
	{
		String libname = lib.getName();
		if(!libraries.containsKey(libname)) 
		{
			this.libraries.put(libname, lib);
		}
	}
	
	/**
	 * Gets the specified library
	 */
	public LibraryDeclaration getLibrary(String libname) 
	{
		if(libraries.containsKey(libname)) return libraries.get(libname);
		return null;
	}
	
	/**
	 * Gets the list of libraries as an array
	 */
	public LibraryDeclaration[] getLibraries() 
	{
		Object[] objects = libraries.values().toArray();
		LibraryDeclaration[] libs = new LibraryDeclaration[objects.length];
		for(int i=0; i<objects.length; i++) libs[i] = (LibraryDeclaration) objects[i];
		return libs;
	}
	
	/**
	 * Gets the active library
	 */
	public LibraryDeclaration getActiveLibrary() 
	{
		return this.activeLibrary;
	}
	
	/**
	 * Sets the active library
	 */
	public void setActiveLibrary(String libname) 
	{
		if(libraries.containsKey(libname)) this.activeLibrary = libraries.get(libname);
		else this.activeLibrary = null;
	}
	
	/**
	 * Gets the active procedure
	 */
	public Procedure getActiveProcedure() {
		return this.activeProcedure;
	}
	
	/**
	 * Sets the active procedure
	 */
	public void setActiveProcedure(String name, DataType[] type) 
	{
		if(activeLibrary == null) return;
		this.activeProcedure = activeLibrary.getAnyProcedure(name, type);
		if(this.activeProcedure == null) return;
		
		// Creates the first variable scope
		this.stack.clear();
		Hashtable<String,Variable> scope0 = new Hashtable<String, Variable>();
		Variable[] args = this.activeProcedure.getArguments();
		for(Variable arg: args) scope0.put(arg.getName(), arg);
		this.stack.push(scope0);
	}
	
	/**
	 * Creates a new variable declaration scope
	 */
	public void createScope() 
	{
		this.stack.push(new Hashtable<String, Variable>());
	}

	/**
	 * Removes a variable declaration scope
	 */
	public void deleteScope() 
	{
		this.stack.pop();
	}

	/**
	 * Adds a variable declaration to the active procedure
	 */
	public void addLocalVariable(Variable var) 
	{
		if(activeProcedure == null) return;
		this.activeProcedure.addLocalVariable(var);
		this.stack.lastElement().put(var.getName(), var);
	}

	/**
	 * Adds an argument declaration to the active procedure
	 */
	public void addArgument(Variable var) 
	{
		if(activeProcedure == null) return;
		this.activeProcedure.addArgument(var);
		this.stack.lastElement().put(var.getName(), var);
	}
	
	/**
	 * Gets a variable declaration from its identifier
	 */
	public Variable getVariable(String name) 
	{
		int size = this.stack.size();
		for (int i = size - 1; i >= 0; i--) 
		{
			Hashtable<String, Variable> table = this.stack.elementAt(i);
			if (table.containsKey(name)) return (Variable) table.get(name);
		}
		return null;
	}

	/**
	 * Gets a variable declaration from its identifier by searching only in the last scope
	 */
	public Variable getVariableInScope(String name) 
	{
		Hashtable<String, Variable> table = this.stack.lastElement();
		if (table.containsKey(name))
		{
			return (Variable) table.get(name);
		}
		else
		{
			return null;
		}
	}
}
