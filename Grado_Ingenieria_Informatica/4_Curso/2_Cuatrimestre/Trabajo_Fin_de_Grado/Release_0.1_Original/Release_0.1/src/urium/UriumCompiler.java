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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import urium.parser.UriumHeaderParser;
import urium.parser.UriumBodyParser;
import urium.ast.struct.LibraryDeclaration;
import urium.ast.struct.SymbolTable;
import urium.code.LibraryCodification;
import urium.mips.Mips32LibraryAssembler;
import urium.i64.IntelLibraryAssembler;
import urium.riscv.RiscvLibraryAssembler;

/**
 * Class that develops the entry point to the compiler.
 * 
 * @author Francisco J. Moreno Velo
 */
public class UriumCompiler {

	//----------------------------------------------------------------//
	//                         Public methods                         //
	//----------------------------------------------------------------//

	/**
	 * Entry point to the compiler
	 */
	public static void main(String[] args) 
	{
		UriumCompilerOptions options = new UriumCompilerOptions(args);
			
		SymbolTable symtab = parseHeaders(options);
				
		if(symtab == null) return;

		boolean result = parseBodies(options,symtab);
		if(!result) return;
		
		if(options.getBackEnd() == UriumCompilerOptions.MIPS) backendMips32(options, symtab);
		if(options.getBackEnd() == UriumCompilerOptions.INTEL) backendIntel64(options, symtab);
		if(options.getBackEnd() == UriumCompilerOptions.RISCV) backendRiscv(options, symtab);
	}

	//----------------------------------------------------------------//
	//                   Private methods (analysis)                   //
	//----------------------------------------------------------------//

	/**
	 * Creates the symbol table by parsing the header of ".ur" files
	 */
	private static SymbolTable parseHeaders(UriumCompilerOptions options) 
	{
		SymbolTable symtab = new SymbolTable();

		LibraryDeclaration mainlib = execHeaderParser(options, "Main");
		if(mainlib == null) return null;
		symtab.addLibrary(mainlib);

		Stack<String> stack = new Stack<String>();
		String[] imported_name = mainlib.getImported();
		for (int i = 0; i < imported_name.length; i++) 
		{
			stack.push(imported_name[i]);
		}
		while (!stack.empty()) 
		{
			String libName = (String) stack.pop();
			if (symtab.getLibrary(libName) != null) continue;
			LibraryDeclaration library = execHeaderParser(options, libName);
			if(library == null) return null;
			symtab.addLibrary(library);
			String[] imp = library.getImported();
			for (int i = 0; i < imp.length; i++) stack.push(imp[i]);
		}

		return symtab;
	}

	/**
	 * Parses an Urium file and extracts header information
	 */
	private static LibraryDeclaration execHeaderParser(UriumCompilerOptions options, String filename) 
	{
		try
		{
			File file = options.getSourceFile(filename);
			FileInputStream fis = new FileInputStream(file);
			UriumHeaderParser header = new UriumHeaderParser(fis);
			LibraryDeclaration library = header.parse(filename);
			if(header.getErrorCount() >0) 
			{
				printError(options.getWorkingDir(),filename, header.getErrorCount(), header.getErrorMsg());
				return null;
			}
			
			return library;
		}
		catch (FileNotFoundException ex1) 
		{
			printError(options.getWorkingDir(), filename, 1, "File "+filename+".ur doesn't exist.");
			return null;
		}
	}

	/**
	 * Complete the analysis of the code of each library
	 */
	private static boolean parseBodies(UriumCompilerOptions options, SymbolTable symtab)
	{
		LibraryDeclaration[] libs = symtab.getLibraries();

		for(LibraryDeclaration lib: libs) 
		{
			if(lib.isNative()) continue;
			String libname = lib.getName();
			try 
			{
				File file = options.getSourceFile(libname);
				FileInputStream fis = new FileInputStream(file);
				UriumBodyParser parser = new UriumBodyParser(fis);
				parser.parse(libname, symtab);
				if (parser.getErrorCount() > 0) 
				{
					printError(options.getWorkingDir(),libname,parser.getErrorCount(), parser.getErrorMsg());
					return false;
				}
			} 
			catch(FileNotFoundException ex) 
			{	
				printError(options.getWorkingDir(), libname, 1, "File "+libname+".ur doesn't exist.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Generates the error file
	 */
	private static void printError(File workingdir, String filename, int count, String msg) 
	{
		try 
		{
			FileOutputStream errorfile =  new FileOutputStream(new File((File)null, "UriumCompilationErrors.txt"));
			PrintStream errorStream = new PrintStream(errorfile);
			errorStream.println("[File "+filename+".ur] "+count+" error"+(count>0?"s":"")+" found:");
			errorStream.println(msg);
			errorStream.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	//----------------------------------------------------------------//
	//                Private methods (MIPS32 backend)                //
	//----------------------------------------------------------------//
	
	/**
	 * Develops the compiler back-end by generating code for the MIPS32 platform
	 */
	private static void backendMips32(UriumCompilerOptions options, SymbolTable symtab)
	{
		LibraryDeclaration[] libraries = symtab.getLibraries();
		
		PrintStream stream = createApplicationFile(options);
		if(stream == null) return;
			
		File kernel = options.getLibFile("urium.Kernel");
		if (kernel != null) appendFile(stream, kernel);
		
		for(int i=0; i< libraries.length; i++) 
		{
			File asmfile = options.getLibFile(libraries[i].getName());
			if (asmfile != null)
			{
				appendFile(stream, asmfile);
			}
			else 
			{  
				createMipsCode(options, libraries[i]);
				File newAsmFile = options.getLibFile(libraries[i].getName());
				appendFile(stream, newAsmFile);
				newAsmFile.delete();
			}
		}
		
		stream.close();
	}
	
	/**
	 * Generates the assembly code file associated with the library
	 */
	private static void createMipsCode(UriumCompilerOptions options, LibraryDeclaration library)  
	{
		try
		{
			LibraryCodification codif = new LibraryCodification(library);
			if(options.verboseMode()) createCodeFile(options, codif);
			Mips32LibraryAssembler assembler = new Mips32LibraryAssembler(codif);
			assembler.generateFile(options.getWorkingDir());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			printError(options.getWorkingDir(), library.getName(), 1, ex.toString());
		}
	}	
	
	//----------------------------------------------------------------//
	//                Private methods (Intel64 backend)               //
	//----------------------------------------------------------------//

	/**
	 * Develops the compiler back-end by generating code for the Intel64 platform
	 */
	private static void backendIntel64(UriumCompilerOptions options, SymbolTable symtab)
	{
		LibraryDeclaration[] libraries = symtab.getLibraries();
		
		PrintStream stream = createApplicationFile(options);
		if(stream == null) return;
			
		File kernel = options.getLibFile("urium.Kernel");
		if (kernel != null) appendFile(stream, kernel);
		
		for(int i=0; i< libraries.length; i++) 
		{
			File asmfile = options.getLibFile(libraries[i].getName());
			if (asmfile != null)
			{
				appendFile(stream, asmfile);
			}
			else 
			{  
				createIntel64Code(options, libraries[i]);
				File newAsmFile = options.getLibFile(libraries[i].getName());
				appendFile(stream, newAsmFile);
				newAsmFile.delete();
			}
		}
		
		stream.println();
		stream.println("End");
		stream.println();
		
		stream.close();
	}
	
	/**
	 * Generates the assembly code file associated with the library
	 */
	private static void createIntel64Code(UriumCompilerOptions options, LibraryDeclaration library)  
	{
		try
		{
			LibraryCodification codif = new LibraryCodification(library);
			if(options.verboseMode()) createCodeFile(options, codif);
			IntelLibraryAssembler assembler = new IntelLibraryAssembler(codif);
			assembler.generateFile(options.getWorkingDir());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			printError(options.getWorkingDir(), library.getName(), 1, ex.toString());
		}
	}	
	
	//----------------------------------------------------------------//
	//                Private methods (RISCV backend)                 //
	//----------------------------------------------------------------//
	
	/**
	 * Develops the compiler back-end by generating code for the RISCV platform
	 */
	private static void backendRiscv(UriumCompilerOptions options, SymbolTable symtab)
	{
		LibraryDeclaration[] libraries = symtab.getLibraries();
		
		PrintStream stream = createApplicationFile(options);
		if(stream == null) return;

		File kernel = options.getLibFile("urium.Kernel");
		if (kernel != null) appendFile(stream, kernel);
		
		for(int i=0; i< libraries.length; i++) 
		{
			File asmfile = options.getLibFile(libraries[i].getName());
			if (asmfile != null)
			{
				appendFile(stream, asmfile);
			}
			else 
			{  
				createRiscvCode(options, libraries[i]);
				File newAsmFile = options.getLibFile(libraries[i].getName());
				appendFile(stream, newAsmFile);
				newAsmFile.delete();
			}
		}
		
		stream.close();
	}
	
	/**
	 * Generates the assembly code file associated with the library
	 */
	private static void createRiscvCode(UriumCompilerOptions options, LibraryDeclaration library)  
	{
		try
		{
			LibraryCodification codif = new LibraryCodification(library);
			if(options.verboseMode()) createCodeFile(options, codif);
			RiscvLibraryAssembler assembler = new RiscvLibraryAssembler(codif);
			assembler.generateFile(options.getWorkingDir());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			printError(options.getWorkingDir(), library.getName(), 1, ex.toString());
		}
	}	
	
	//----------------------------------------------------------------//
	//                      Private methods (Common)                  //
	//----------------------------------------------------------------//
	
	/**
	 * Generates a file with the intermediate code in text mode
	 */
	private static void createCodeFile(UriumCompilerOptions options, LibraryCodification codif)
	{
		try
		{
			String libname = codif.getName();
			File codefile = new File(options.getWorkingDir(), libname+ ".code");
			FileOutputStream codefos = new FileOutputStream(codefile);
			PrintStream codestream = new PrintStream(codefos);
			codif.print(codestream);
			codestream.close();
		}
		catch (FileNotFoundException ex) 
		{
			printError(options.getWorkingDir(), "Main", 1, "Can't create intermediate code file");
		}
	}
	
	/**
	 * Creates the output file of the compilation process
	 */
	private static PrintStream createApplicationFile(UriumCompilerOptions options)
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(new File(options.getWorkingDir(), options.getOutputName()+".s"));
			PrintStream stream = new PrintStream(fos);
			return stream;
		}
		catch (FileNotFoundException ex) 
		{
			printError(options.getWorkingDir(), "Main", 1, "Can't create output file");
			return null;
		}
	}
	
	/**
	 * Adds the contents of the file to the final result of the compilation process
	 */
	private static void appendFile(PrintStream stream, File file) 
	{
		try 
		{
			FileInputStream fis = new FileInputStream(file);
			byte[] content = new byte[fis.available()];
			fis.read(content);
			fis.close();
			stream.println();
			stream.write(content);
		} 
		catch (Exception ex) 
		{
		}
	}
}
