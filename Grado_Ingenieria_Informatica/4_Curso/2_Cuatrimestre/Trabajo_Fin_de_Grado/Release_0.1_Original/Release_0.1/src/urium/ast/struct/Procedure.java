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

import java.util.Vector;
import urium.ast.*;
import urium.ast.statement.*;

/**
 * Class that stores information about a procedure
 * 
 * @author Francisco J. Moreno Velo
 */
public class Procedure {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Name of the library to which the procedure belongs
	 */
	private String libname;
	
	/**
	 * NAme of the procedure
	 */
	private String name;
	
	/**
	 * Access modifier
	 */
	private int access;
	
	/**
	 * Argument list
	 */
	private Variable[] argument;
	
	/**
	 * List of local variables
	 */
	private Variable[] localVar;
	
	/**
	 * Set of statements that develops the procedure
	 */
	private BlockStatement body;

	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public Procedure(int access, String name, String libname) 
	{
		this.access = access;
		this.name = name.toString();
		this.libname = libname.toString();
		this.argument = new Variable[0];
		this.localVar = new Variable[0];
		this.body = null;
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//

	/**
	 * Gets the name of the procedure
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * Gets the access modifier of the procedure
	 */
	public int getAccess() {
		return this.access;
	}
	
	/**
	 * Adds an argument
	 */
	public void addArgument(Variable var) 
	{
		Variable[] aux = new Variable[argument.length+1];
		System.arraycopy(argument,0,aux,0,argument.length);
		aux[argument.length] = var;
		argument = aux;
	}
	
	/**
	 * Adds a list of arguments
	 */
	public void addArgumentList(Vector<Variable> vector) 
	{
		Variable[] varg = new Variable[vector.size()];
		vector.copyInto(varg);
		
		Variable[] aux = new Variable[argument.length + varg.length];
		System.arraycopy(argument, 0, aux, 0, argument.length);
		System.arraycopy(varg, 0, aux, argument.length, varg.length);
		this.argument = aux;
	}
	
	/**
	 * Gets the list of arguments
	 */
	public Variable[] getArguments() 
	{
		return this.argument;
	}
	
	/**
	 * Gets the list of data types of the arguments
	 */	
	public DataType[] getArgumentTypes() 
	{
		DataType[] type = new DataType[argument.length];
		for (int i = 0; i < argument.length; i++) 
		{
			type[i] = argument[i].getType();
		}
		return type;
	}
	
	/**
	 * Sets the list of arguments using only their data types
	 */
	public void setArgumentTypes(DataType[] argTypes) 
	{
		int size = argTypes.length;
		this.argument = new Variable[size];
		for(int i=0; i<size; i++) 
		{
			argument[i] = new Variable(argTypes[i],"arg"+i);
		}
	}
	
	/**
	 * Compares the data types with those of the procedure, 
	 * returning true if the data types match
	 */
	public boolean match(String name, DataType[] argTypes) 
	{
		if(argTypes.length != argument.length) return false;
		if(!this.name.equals(name)) return false;
		for(int i=0; i<argument.length; i++) 
		{
			if(argument[i].getType() != argTypes[i]) return false;
		}
		return true;
	}
	
	/**
	 * Adds the declaration of a local variable
	 */
	public void addLocalVariable(Variable var) 
	{
		Variable[] aux = new Variable[localVar.length+1];
		System.arraycopy(localVar,0,aux,0,localVar.length);
		aux[localVar.length] = var;
		localVar = aux;
	}
	
	/**
	 * Gets the list of local variables
	 */
	public Variable[] getLocalVariables() 
	{
		return this.localVar;
	}
	
	/**
	 * Sets the statements of the procedure
	 */
	public void setBody(BlockStatement blockInst) 
	{
		this.body = blockInst;
	}
	
	/**
	 * Gets the statements of the procedure
	 */
	public BlockStatement getBody() 
	{
		return this.body;
	}
	
	/**
	 * Gets the procedure label used in the intermediate code
	 */
	public String getLabel() 
	{
		String label = libname+"."+name;
		for(int i=0; i<argument.length;i++) 
		{
			label += "."+argument[i].getType().toLabel();
		}
		return label;
	}	
}
