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

package urium.i64.registers;

/**
 * Interface giving codes to the Intel-64 architecture registers
 * 
 * @author Francisco J. Moreno Velo
 */
public interface RegisterConstants {

	//--------------------------------------------------------------//
	//      Constants (General purpose registers with 64 bits)      //
	//--------------------------------------------------------------//

	public int RAX = 0;
	public int RBX = 1;
	public int RCX = 2;
	public int RDX = 3;
	public int RBP = 4;
	public int RSI = 5;
	public int RDI = 6;
	public int RSP = 7;
	public int R8 = 8;
	public int R9 = 9;
	public int R10 = 10;
	public int R11 = 11;
	public int R12 = 12;
	public int R13 = 13;
	public int R14 = 14;
	public int R15 = 15;

	//--------------------------------------------------------------//
	//      Constants (General purpose registers with 32 bits)      //
	//--------------------------------------------------------------//
	
	public int EAX = 16;
	public int EBX = 17;
	public int ECX = 18;
	public int EDX = 19;
	public int EBP = 20;
	public int ESI = 21;
	public int EDI = 22;
	public int ESP = 23;
	public int R8D = 24;
	public int R9D = 25;
	public int R10D = 26;
	public int R11D = 27;
	public int R12D = 28;
	public int R13D = 29;
	public int R14D = 30;
	public int R15D = 31;
	
	//--------------------------------------------------------------//
	//      Constants (General purpose registers with 16 bits)      //
	//--------------------------------------------------------------//

	public int AX = 32;
	public int BX = 33;
	public int CX = 34;
	public int DX = 35;
	public int BP = 36;
	public int SI = 37;
	public int DI = 38;
	public int SP = 39;
	public int R8W = 40;
	public int R9W = 41;
	public int R10W = 42;
	public int R11W = 43;
	public int R12W = 44;
	public int R13W = 45;
	public int R14W = 46;
	public int R15W = 47;
	
	//--------------------------------------------------------------//
	//      Constants (General purpose registers with 8 bits)       //
	//--------------------------------------------------------------//

	public int AL = 48;
	public int BL = 49;
	public int CL = 50;
	public int DL = 51;
	public int BPL = 52;
	public int SIL = 53;
	public int DIL = 54;
	public int SPL = 55;
	public int R8B = 56;
	public int R9B = 57;
	public int R10B = 58;
	public int R11B = 59;
	public int R12B = 60;
	public int R13B = 61;
	public int R14B = 62;
	public int R15B = 63;
	
	public int AH = 64;
	public int BH = 65;
	public int CH = 66;
	public int DH = 67;
	
	//--------------------------------------------------------------//
	//             Constants (Floating point registers)             //
	//--------------------------------------------------------------//

	public int FPR0 = 68;
	public int FPR1 = 69;
	public int FPR2 = 70;
	public int FPR3 = 71;
	public int FPR4 = 72;
	public int FPR5 = 73;
	public int FPR6 = 74;
	public int FPR7 = 75;
	
	//--------------------------------------------------------------//
	//                  Constants (Register types)                  //
	//--------------------------------------------------------------//

	public int SIZE_8 = 8;
	public int SIZE_16 = 16;
	public int SIZE_32 = 32;
	public int SIZE_64 = 64;
	public int SIZE_FLOAT = -64;
}
