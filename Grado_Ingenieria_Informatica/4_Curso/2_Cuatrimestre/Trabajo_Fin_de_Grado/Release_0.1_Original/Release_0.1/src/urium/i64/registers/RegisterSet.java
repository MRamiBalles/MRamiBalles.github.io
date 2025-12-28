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
 * Class containing all the registers of the Intel-64 architecture
 * 
 * @author Francisco J. Moreno Velo
 */
public class RegisterSet implements RegisterConstants {
	
	//----------------------------------------------------------------//
	//                            Constants                           //
	//----------------------------------------------------------------//

	// 64 bits registers
	public static Register rax = new Register(RAX);
	public static Register rbx = new Register(RBX);
	public static Register rcx = new Register(RCX);
	public static Register rdx = new Register(RDX);
	public static Register rbp = new Register(RBP);
	public static Register rsi = new Register(RSI);
	public static Register rdi = new Register(RDI);
	public static Register rsp = new Register(RSP);
	public static Register r8 = new Register(R8);
	public static Register r9 = new Register(R9);
	public static Register r10 = new Register(R10);
	public static Register r11 = new Register(R11);
	public static Register r12 = new Register(R12);
	public static Register r13 = new Register(R13);
	public static Register r14 = new Register(R14);
	public static Register r15 = new Register(R15);
	
	// 32 bits registers
	public static Register eax = new Register(EAX);
	public static Register ebx = new Register(EBX);
	public static Register ecx = new Register(ECX);
	public static Register edx = new Register(EDX);
	public static Register ebp = new Register(EBP);
	public static Register esi = new Register(ESI);
	public static Register edi = new Register(EDI);
	public static Register esp = new Register(ESP);
	public static Register r8D = new Register(R8D);
	public static Register r9D = new Register(R9D);
	public static Register r10D = new Register(R10D);
	public static Register r11D = new Register(R11D);
	public static Register r12D = new Register(R12D);
	public static Register r13D = new Register(R13D);
	public static Register r14D = new Register(R14D);
	public static Register r15D = new Register(R15D);
	
	// 16 bits registers
	public static Register ax = new Register(AX);
	public static Register bx = new Register(BX);
	public static Register cx = new Register(CX);
	public static Register dx = new Register(DX);
	public static Register bp = new Register(BP);
	public static Register si = new Register(SI);
	public static Register di = new Register(DI);
	public static Register sp = new Register(SP);
	public static Register r8W = new Register(R8W);
	public static Register r9W = new Register(R9W);
	public static Register r10W = new Register(R10W);
	public static Register r11W = new Register(R11W);
	public static Register r12W = new Register(R12W);
	public static Register r13W = new Register(R13W);
	public static Register r14W = new Register(R14W);
	public static Register r15W = new Register(R15W);
	
	// 8 bits registers
	public static Register al = new Register(AL);
	public static Register bl = new Register(BL);
	public static Register cl = new Register(CL);
	public static Register dl = new Register(DL);
	public static Register bpl = new Register(BPL);
	public static Register sil = new Register(SIL);
	public static Register dil = new Register(DIL);
	public static Register spl = new Register(SPL);
	public static Register r8B = new Register(R8B);
	public static Register r9B = new Register(R9B);
	public static Register r10B = new Register(R10B);
	public static Register r11B = new Register(R11B);
	public static Register r12B = new Register(R12B);
	public static Register r13B = new Register(R13B);
	public static Register r14B = new Register(R14B);
	public static Register r15B = new Register(R15B);
	public static Register ah = new Register(AH);
	public static Register bh = new Register(BH);
	public static Register ch = new Register(CH);
	public static Register dh = new Register(DH);
	
	// Floating point registers
	public static Register fpr0 = new Register(FPR0);
	public static Register fpr1 = new Register(FPR1);
	public static Register fpr2 = new Register(FPR2);
	public static Register fpr3 = new Register(FPR3);
	public static Register fpr4 = new Register(FPR4);
	public static Register fpr5 = new Register(FPR5);
	public static Register fpr6 = new Register(FPR6);
	public static Register fpr7 = new Register(FPR7);
	
	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the register from its code
	 */
	public static Register getRegister(int code) 
	{
		switch (code) {
		case RAX:
			return rax;
		case RBX:
			return rbx;
		case RCX:
			return rcx;
		case RDX:
			return rdx;
		case RBP:
			return rbp;
		case RSI:
			return rsi;
		case RDI:
			return rdi;
		case RSP:
			return rsp;
		case R8:
			return r8;
		case R9:
			return r9;
		case R10:
			return r10;
		case R11:
			return r11;
		case R12:
			return r12;
		case R13:
			return r13;
		case R14:
			return r14;
		case R15:
			return r15;
		case EAX:
			return eax;
		case EBX:
			return ebx;
		case ECX:
			return ecx;
		case EDX:
			return edx;
		case EBP: 
			return ebp;
		case ESI: 
			return esi;
		case EDI: 
			return edi;
		case ESP: 
			return esp;
		case R8D: 
			return r8D;
		case R9D: 
			return r9D;
		case R10D: 
			return r10D;
		case R11D: 
			return r11D;
		case R12D: 
			return r12D;
		case R13D: 
			return r13D;
		case R14D: 
			return r14D;
		case R15D: 
			return r15D;
		case AX: 
			return ax;
		case BX: 
			return bx;
		case CX: 
			return cx;
		case DX: 
			return dx;
		case BP: 
			return bp;
		case SI: 
			return si;
		case DI: 
			return di;
		case SP: 
			return sp;
		case R8W: 
			return r8W;
		case R9W: 
			return r9W;
		case R10W: 
			return r10W;
		case R11W: 
			return r11W;
		case R12W: 
			return r12W;
		case R13W: 
			return r13W;
		case R14W: 
			return r14W;
		case R15W: 
			return r15W;
		case AL: 
			return al;
		case BL: 
			return bl;
		case CL: 
			return cl;
		case DL: 
			return dl;
		case BPL: 
			return bpl;
		case SIL: 
			return sil;
		case DIL: 
			return dil;
		case SPL: 
			return spl;
		case R8B: 
			return r8B;
		case R9B: 
			return r9B;
		case R10B: 
			return r10B;
		case R11B: 
			return r11B;
		case R12B: 
			return r12B;
		case R13B: 
			return r13B;
		case R14B: 
			return r14B;
		case R15B: 
			return r15B;
		case AH: 
			return ah;
		case BH: 
			return bh;
		case CH: 
			return ch;
		case DH: 
			return dh;
		case FPR0:
			return fpr0;
		case FPR1:
			return fpr1;
		case FPR2:
			return fpr2;
		case FPR3:
			return fpr3;
		case FPR4:
			return fpr4;
		case FPR5:
			return fpr5;
		case FPR6:
			return fpr6;
		case FPR7:
			return fpr7;
		default:
			return null;
		}
	}
	
	/**
	 * Gets the 32 bits version of a register 
	 */
	public static Register To32bits(Register r)
	{
		if(r.getSize() == SIZE_32) return r;
		switch(r.getCode())
		{
		case RAX: return eax;
		case RBX: return ebx;
		case RCX: return ecx;
		case RDX: return edx;
		case RBP: return ebp;
		case RSI: return esi;
		case RDI: return edi;
		case RSP: return esp;
		case R8:  return r8D;
		case R9:  return r9D;
		case R10: return r10D;
		case R11: return r11D;
		case R12: return r12D;
		case R13: return r13D;
		case R14: return r14D;
		case R15: return r15D;

		case AX:  return eax;  
		case BX:  return ebx;
		case CX:  return ecx;
		case DX:  return edx;
		case BP:  return ebp;
		case SI:  return esi;
		case DI:  return edi;
		case SP:  return esp;
		case R8W: return r8D;
		case R9W: return r9D;
		case R10W: return r10D;
		case R11W: return r11D;
		case R12W: return r12D;
		case R13W: return r13D;
		case R14W: return r14D;
		case R15W: return r15D;

		case AL: return eax;
		case BL: return ebx;
		case CL: return ecx;
		case DL: return edx;
		case BPL: return ebp;
		case SIL: return esi;
		case DIL: return edi;
		case SPL: return esp;
		case R8B: return r8D;
		case R9B: return r9D;
		case R10B: return r10D;
		case R11B: return r11D;
		case R12B: return r12D;
		case R13B: return r13D;
		case R14B: return r14D;
		case R15B: return r15D;
		case AH: return eax;
		case BH: return ebx;
		case CH: return ecx;
		case DH: return edx;
		default: return r;
		}
	}
	
	/**
	 * Gets the 64 bits version of a register 
	 */
	public static Register To64bits(Register r)
	{
		if(r.getSize() == SIZE_64) return r;
		switch(r.getCode())
		{
		case EAX: return rax;
		case EBX: return rbx;
		case ECX: return rcx;
		case EDX: return rdx;
		case EBP: return rbp;
		case ESI: return rsi;
		case EDI: return rdi;
		case ESP: return rsp;
		case R8D:  return r8;
		case R9D:  return r9;
		case R10D: return r10;
		case R11D: return r11;
		case R12D: return r12;
		case R13D: return r13;
		case R14D: return r14;
		case R15D: return r15;

		case AX:  return rax;  
		case BX:  return rbx;
		case CX:  return rcx;
		case DX:  return rdx;
		case BP:  return rbp;
		case SI:  return rsi;
		case DI:  return rdi;
		case SP:  return rsp;
		case R8W: return r8;
		case R9W: return r9;
		case R10W: return r10;
		case R11W: return r11;
		case R12W: return r12;
		case R13W: return r13;
		case R14W: return r14;
		case R15W: return r15;

		case AL: return rax;
		case BL: return rbx;
		case CL: return rcx;
		case DL: return rdx;
		case BPL: return rbp;
		case SIL: return rsi;
		case DIL: return rdi;
		case SPL: return rsp;
		case R8B: return r8;
		case R9B: return r9;
		case R10B: return r10;
		case R11B: return r11;
		case R12B: return r12;
		case R13B: return r13;
		case R14B: return r14;
		case R15B: return r15;
		case AH: return rax;
		case BH: return rbx;
		case CH: return rcx;
		case DH: return rdx;
		default: return r;
		}
	}
}
