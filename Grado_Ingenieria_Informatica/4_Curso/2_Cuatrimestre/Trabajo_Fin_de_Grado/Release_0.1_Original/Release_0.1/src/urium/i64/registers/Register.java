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
 * Class describing a register of the Intel-64 architecture
 * 
 * @author Francisco J. Moreno Velo
 */
public class Register implements RegisterConstants {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Register code
	 */
	private int num;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public Register(int num) 
	{
		this.num = num;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the register code
	 */
	public int getCode() 
	{
		return this.num;
	}

	/**
	 * Gets the register name used in the assembler code
	 */
	public String getName() 
	{
		switch (num) {
		case RAX:
			return "rax";
		case RBX:
			return "rbx";
		case RCX:
			return "rcx";
		case RDX:
			return "rdx";
		case RBP:
			return "rbp";
		case RSI:
			return "rsi";
		case RDI:
			return "rdi";
		case RSP:
			return "rsp";
		case R8:
			return "r8";
		case R9:
			return "r9";
		case R10:
			return "r10";
		case R11:
			return "r11";
		case R12:
			return "r12";
		case R13:
			return "r13";
		case R14:
			return "r14";
		case R15:
			return "r15";
		case EAX:
			return "eax";
		case EBX:
			return "ebx";
		case ECX:
			return "ecx";
		case EDX:
			return "edx";
		case FPR0:
			return "fpr0";
		case FPR1:
			return "fpr1";
		case FPR2:
			return "fpr2";
		case FPR3:
			return "fpr3";
		case FPR4:
			return "fpr4";
		case FPR5:
			return "fpr5";
		case FPR6:
			return "fpr6";
		case FPR7:
			return "fpr7";	
		default:
			return "r" + num;
		}
	}
	
	/**
	 * Gets the register size
	 */
	public int getSize()
	{
		switch(num)
		{
		case RAX:
		case RBX:
		case RCX:
		case RDX:
		case RBP:
		case RSI:
		case RDI:
		case RSP:
		case R8:
		case R9:
		case R10:
		case R11:
		case R12:
		case R13:
		case R14:
		case R15:
			return SIZE_64;
		case EAX:
		case EBX:
		case ECX:
		case EDX:
		case EBP: 
		case ESI: 
		case EDI: 
		case ESP: 
		case R8D: 
		case R9D: 
		case R10D: 
		case R11D: 
		case R12D: 
		case R13D: 
		case R14D: 
		case R15D: 
			return SIZE_32;
		case AX: 
		case BX: 
		case CX: 
		case DX: 
		case BP: 
		case SI: 
		case DI: 
		case SP: 
		case R8W: 
		case R9W: 
		case R10W: 
		case R11W: 
		case R12W: 
		case R13W: 
		case R14W: 
		case R15W: 
			return SIZE_16;
		case AL: 
		case BL: 
		case CL: 
		case DL: 
		case BPL: 
		case SIL: 
		case DIL: 
		case SPL: 
		case R8B: 
		case R9B: 
		case R10B: 
		case R11B: 
		case R12B: 
		case R13B: 
		case R14B: 
		case R15B: 
		case AH: 
		case BH: 
		case CH: 
		case DH: 
			return SIZE_8;
		case FPR0:
		case FPR1:
		case FPR2:
		case FPR3:
		case FPR4:
		case FPR5:
		case FPR6:
		case FPR7:
			return SIZE_FLOAT;	
		default:
			return 0;
		}
	}
}
