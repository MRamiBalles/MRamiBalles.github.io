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

package urium.riscv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import urium.code.LibraryCodification;
import urium.code.ProcedureCodification;


/**
 * Class containing the description of an assembly library for the RISC-V platform
 * 
 * @author Francisco J. Moreno Velo
 */
public class RiscvLibraryAssembler {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Library name
	 */
	private String name;

	/**
	 * List of procedure codes
	 */
	private RiscvProcedureAssembler[] procedure;
	
	//----------------------------------------------------------------//
	//                             Constructor                        //
	//----------------------------------------------------------------//
	
	/**
	 * Constructor
	 */
	public RiscvLibraryAssembler(LibraryCodification codif)
	{
		this.name = codif.getName();
		ProcedureCodification[] proc = codif.getProcedureCodifications();

		this.procedure = new RiscvProcedureAssembler[proc.length];
		for (int i = 0; i < proc.length; i++) 
		{
			procedure[i] = new RiscvProcedureAssembler(proc[i]);
		}
	}
	
	//----------------------------------------------------------------//
	//                           Public methods                       //
	//----------------------------------------------------------------//
	
	/**
	 * Generates the assembler file
	 */
	public void generateFile(File workingdir)
	{
		FileOutputStream fos;
		try 
		{
			String filename=name.replace('.', File.separatorChar);
			fos = new FileOutputStream(new File(workingdir,filename + ".s"));
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return;
		}
		
		PrintStream stream = new PrintStream(fos);
		printCopyright(stream);

		for (int i = 0; i < procedure.length; i++) 
		{
			procedure[i].print(stream);
		}
		stream.close();
	}
	
	//----------------------------------------------------------------//
	//                          Private methods                       //
	//----------------------------------------------------------------//

	/**
	 * Writes the copyright notice to the output stream
	 */
	private void printCopyright(PrintStream stream) 
	{
		stream.println("#------------------------------------------------------------------");
		stream.println("# Copyright (c) 2024, Francisco J. Moreno Velo                     ");
		stream.println("# All rights reserved.                                             ");
		stream.println("#------------------------------------------------------------------");
		stream.println();
	}
}
