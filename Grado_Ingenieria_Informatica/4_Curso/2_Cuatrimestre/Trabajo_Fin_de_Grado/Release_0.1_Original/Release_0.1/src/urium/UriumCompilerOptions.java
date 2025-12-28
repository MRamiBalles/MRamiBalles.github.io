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

package urium;

import java.io.*;
import java.util.Vector;

/**
 * Class that stores compilation options
 * 
 * @author Francisco J. Moreno Velo
 */
public class UriumCompilerOptions {

	//----------------------------------------------------------------//
	//                           Constants                            //
	//----------------------------------------------------------------//
	
	public static final int MIPS = 0;
	public static final int INTEL = 1;
	public static final int RISCV = 2;
	
	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//
	
	/**
	 * Working directory
	 */
	private File workingdir;
	
	/**
	 * List of source file directories
	 */
	private Vector<File> includeDir;

	/**
	 * List of compiled library directories
	 */
	private Vector<File> libDir;
	
	/**
	 * Flag to generate the intermediate code in text mode
	 */
	private boolean verbose;
	
	/**
	 * Output file name
	 */
	private String output;
	
	/**
	 * Platform to compile:
	 * 0 --- MIPS
	 * 1 --- Intel 64
	 * 2 --- RISC-V
	 */
	private int back_end;
	  
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public UriumCompilerOptions(String[] args)
	{
		this.workingdir = new File(System.getProperty("user.dir"));
		this.includeDir = new Vector<File>();
		this.libDir = new Vector<File>();
		this.verbose = false;
		this.output = "Application";
		this.back_end = MIPS;
		
		for(int i=0; i<args.length; i++)
		{
			if(args[i].equals("-I") && i+1<args.length) { this.includeDir.addElement(new File(args[i+1])); i++; }
			else if(args[i].equals("-L") && i+1<args.length) { this.libDir.addElement(new File(args[i+1])); i++; }
			else if(args[i].equals("-o") && i+1<args.length) { this.output = args[i+1]; i++; }
			else if(args[i].equals("-v")) this.verbose = true;
			else if(args[i].equals("-mips")) this.back_end = MIPS;
			else if(args[i].equals("-i64")) this.back_end = INTEL;
			else if(args[i].equals("-riscv")) this.back_end = RISCV;
			else if(!args[i].startsWith("-")) this.workingdir = new File(args[i]);
		}
	}

	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Get the working directory
	 */
	public File getWorkingDir()
	{
		return this.workingdir;
	}
	
	/**
	 * Adds a directory to the list of source file directories
	 */
	public void addIncludeDir(File f)
	{
		this.includeDir.addElement(f);
	}
	
	/**
	 * Search for a source file in all directories 
	 */
	public File getSourceFile(String name) throws FileNotFoundException
	{
		File file;
		String filename=name.replace('.', File.separatorChar);
		
		file = new File(this.workingdir,filename+".ur");
		
		if(file.exists()) return file;
		
		for(int i=0; i<includeDir.size(); i++)
		{
			File dir = includeDir.elementAt(i);
			file = new File(dir,filename+".ur");
			if(file.exists()) return file;			
		}
		
		throw new FileNotFoundException();
	}
	
	/**
	 * Search for a compiled file in all directories  
	 */
	public File getLibFile(String name)
	{
		File file;
		String filename = name.replace('.', File.separatorChar);
		
		file = new File(this.workingdir,filename+".s");
		if(file.exists()) return file;
		
		for(int i=0; i<libDir.size(); i++)
		{
			File dir = libDir.elementAt(i);
			file = new File(dir,filename+".s");
			if(file.exists()) return file;			
		}
		
		return null;
	}
	
	/**
	 * Indicates whether to generate the intermediate code in text mode
	 */
	public boolean verboseMode()
	{
		return this.verbose;
	}
	
	/**
	 * Obtiene el nombre del fichero de salida
	 */
	public String getOutputName()
	{
		return this.output;
	}
	
	/**
	 * Obtiene el código de la plataforma de destino
	 */
	public int getBackEnd()
	{
		return this.back_end;
	}
	
}

