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

package urium.riscv.registers;

/**
 * Class containing all the registers of the RISC-V processor
 * 
 * @author Francisco J. Moreno Velo
 */
public class RegisterSet implements RegisterConstants {

	//----------------------------------------------------------------//
	//                            Constants                           //
	//----------------------------------------------------------------//

	public static Register zero = new Register(GPR_ZERO);
	public static Register ra = new Register(GPR_RA);
	public static Register sp = new Register(GPR_SP);
	public static Register gp = new Register(GPR_GP);
	public static Register tp = new Register(GPR_TP);
	public static Register t0 = new Register(GPR_T0);
	public static Register t1 = new Register(GPR_T1);
	public static Register t2 = new Register(GPR_T2);
	public static Register s0 = new Register(GPR_S0);
	public static Register s1 = new Register(GPR_S1);
	public static Register a0 = new Register(GPR_A0);
	public static Register a1 = new Register(GPR_A1);
	public static Register a2 = new Register(GPR_A2);
	public static Register a3 = new Register(GPR_A3);
	public static Register a4 = new Register(GPR_A4);
	public static Register a5 = new Register(GPR_A5);
	public static Register a6 = new Register(GPR_A6);
	public static Register a7 = new Register(GPR_A7);
	public static Register s2 = new Register(GPR_S2);
	public static Register s3 = new Register(GPR_S3);
	public static Register s4 = new Register(GPR_S4);
	public static Register s5 = new Register(GPR_S5);
	public static Register s6 = new Register(GPR_S6);
	public static Register s7 = new Register(GPR_S7);
	public static Register s8 = new Register(GPR_S8);
	public static Register s9 = new Register(GPR_S9);
	public static Register s10 = new Register(GPR_S10);
	public static Register s11 = new Register(GPR_S11);
	public static Register t3 = new Register(GPR_T3);
	public static Register t4 = new Register(GPR_T4);
	public static Register t5 = new Register(GPR_T5);
	public static Register t6 = new Register(GPR_T6);

	public static Register ft0 = new Register(FT0);
	public static Register ft1 = new Register(FT1);
	public static Register ft2 = new Register(FT2);
	public static Register ft3 = new Register(FT3);
	public static Register ft4 = new Register(FT4);
	public static Register ft5 = new Register(FT5);
	public static Register ft6 = new Register(FT6);
	public static Register ft7 = new Register(FT7);
	public static Register fs0 = new Register(FS0);
	public static Register fs1 = new Register(FS1);
	public static Register fa0 = new Register(FA0);
	public static Register fa1 = new Register(FA1);
	public static Register fa2 = new Register(FA2);
	public static Register fa3 = new Register(FA3);
	public static Register fa4 = new Register(FA4);
	public static Register fa5 = new Register(FA5);
	public static Register fa6 = new Register(FA6);
	public static Register fa7 = new Register(FA7);
	public static Register fs2 = new Register(FS2);
	public static Register fs3 = new Register(FS3);
	public static Register fs4 = new Register(FS4);
	public static Register fs5 = new Register(FS5);
	public static Register fs6 = new Register(FS6);
	public static Register fs7 = new Register(FS7);
	public static Register fs8 = new Register(FS8);
	public static Register fs9 = new Register(FS9);
	public static Register fs10 = new Register(FS10);
	public static Register fs11 = new Register(FS11);
	public static Register ft8 = new Register(FT8);
	public static Register ft9 = new Register(FT9);
	public static Register ft10 = new Register(FT10);
	public static Register ft11 = new Register(FT11);
	
	public static Register ustatus = new Register(USTATUS);
	public static Register fflags = new Register(FFLAGS);
	public static Register frm = new Register(FRM);
	public static Register fcsr = new Register(FCSR);
	public static Register uie = new Register(UIE);
	public static Register utvec = new Register(UTVEC);
	public static Register uscratch = new Register(USCRATCH);
	public static Register uepc = new Register(UEPC);
	public static Register ucause = new Register(UCAUSE);
	public static Register utval = new Register(UTVAL);
	public static Register uip = new Register(UIP);
	public static Register cycle = new Register(CYCLE);
	public static Register time = new Register(TIME);
	public static Register instret = new Register(INSTRET);
	public static Register cycleh = new Register(CYCLEH);
	public static Register timeh = new Register(TIMEH);
	public static Register instreth = new Register(INSTRETH);
	public static Register pc = new Register(PC);
	
	public static Register fp = s0;
	
	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the register from its code
	 */
	public static Register getRegister(int code) 
	{
		switch (code) {
		case GPR_ZERO:
			return zero;
		case GPR_RA:
			return ra;
		case GPR_SP:
			return sp;
		case GPR_GP:
			return gp;
		case GPR_TP:
			return tp;
		case GPR_T0:
			return t0;
		case GPR_T1:
			return t1;
		case GPR_T2:
			return t2;
		case GPR_S0:
			return s0;
		case GPR_S1:
			return s1;
		case GPR_A0:
			return a0;
		case GPR_A1:
			return a1;
		case GPR_A2:
			return a2;
		case GPR_A3:
			return a3;
		case GPR_A4:
			return a4;
		case GPR_A5:
			return a5;
		case GPR_A6:
			return a6;
		case GPR_A7:
			return a7;
		case GPR_S2:
			return s2;
		case GPR_S3:
			return s3;
		case GPR_S4:
			return s4;
		case GPR_S5:
			return s5;
		case GPR_S6:
			return s6;
		case GPR_S7:
			return s7;
		case GPR_S8:
			return s8;
		case GPR_S9:
			return s9;
		case GPR_S10:
			return s10;
		case GPR_S11:
			return s11;
		case GPR_T3:
			return t3;
		case GPR_T4:
			return t4;
		case GPR_T5:
			return t5;
		case GPR_T6:
			return t6;
		case FT0:
			return ft0;
		case FT1:
			return ft1;
		case FT2:
			return ft2;
		case FT3:
			return ft3;
		case FT4:
			return ft4;
		case FT5:
			return ft5;
		case FT6:
			return ft6;
		case FT7:
			return ft7;
		case FS0:
			return fs0;
		case FS1:
			return fs1;
		case FA0:
			return fa0;
		case FA1:
			return fa1;
		case FA2:
			return fa2;
		case FA3:
			return fa3;
		case FA4:
			return fa4;
		case FA5:
			return fa5;
		case FA6:
			return fa6;
		case FA7:
			return fa7;
		case FS2:
			return fs2;
		case FS3:
			return fs3;
		case FS4:
			return fs4;
		case FS5:
			return fs5;
		case FS6:
			return fs6;
		case FS7:
			return fs7;
		case FS8:
			return fs8;
		case FS9:
			return fs9;
		case FS10:
			return fs10;
		case FS11:
			return fs11;
		case FT8:
			return ft8;
		case FT9:
			return ft9;
		case FT10:
			return ft10;
		case FT11:
			return ft11;
		case USTATUS:
			return ustatus;
		case FFLAGS:
			return fflags;
		case FRM:
			return frm;
		case FCSR:
			return fcsr;
		case UIE:
			return uie;
		case UTVEC:
			return utvec;
		case USCRATCH:
			return uscratch;
		case UEPC:
			return uepc;
		case UCAUSE:
			return ucause;
		case UTVAL:
			return utval;
		case UIP:
			return uip;
		case CYCLE:
			return cycle;
		case TIME:
			return time;
		case INSTRET:
			return instret;
		case CYCLEH:
			return cycleh;
		case TIMEH:
			return timeh;
		case INSTRETH:
			return instreth;
		case PC:
			return pc;
		default:
			return null;
		}
	}
}

