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
 * Class describing a register of the MIPS-32 processor
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
		case GPR_ZERO:
			return "zero";
		case GPR_RA:
			return "ra";
		case GPR_SP:
			return "sp";
		case GPR_GP:
			return "gp";
		case GPR_TP:
			return "tp";
		case GPR_T0:
			return "t0";
		case GPR_T1:
			return "t1";
		case GPR_T2:
			return "t2";
		case GPR_S0:
			return "s0";
		case GPR_S1:
			return "s1";
		case GPR_A0:
			return "a0";
		case GPR_A1:
			return "a1";
		case GPR_A2:
			return "a2";
		case GPR_A3:
			return "a3";
		case GPR_A4:
			return "a4";
		case GPR_A5:
			return "a5";
		case GPR_A6:
			return "a6";
		case GPR_A7:
			return "a7";
		case GPR_S2:
			return "s2";
		case GPR_S3:
			return "s3";
		case GPR_S4:
			return "s4";
		case GPR_S5:
			return "s5";
		case GPR_S6:
			return "s6";
		case GPR_S7:
			return "s7";
		case GPR_S8:
			return "s8";
		case GPR_S9:
			return "s9";
		case GPR_S10:
			return "s10";
		case GPR_S11:
			return "s11";
		case GPR_T3:
			return "t3";
		case GPR_T4:
			return "t4";
		case GPR_T5:
			return "t5";
		case GPR_T6:
			return "t6";
		case FT0:
			return "ft0";
		case FT1:
			return "ft1";
		case FT2:
			return "ft2";
		case FT3:
			return "ft3";
		case FT4:
			return "ft4";
		case FT5:
			return "ft5";
		case FT6:
			return "ft6";
		case FT7:
			return "ft7";
		case FS0:
			return "fs0";
		case FS1:
			return "fs1";
		case FA0:
			return "fa0";
		case FA1:
			return "fa1";
		case FA2:
			return "fa2";
		case FA3:
			return "fa3";
		case FA4:
			return "fa4";
		case FA5:
			return "fa5";
		case FA6:
			return "fa6";
		case FA7:
			return "fa7";
		case FS2:
			return "fs2";
		case FS3:
			return "fs3";
		case FS4:
			return "fs4";
		case FS5:
			return "fs5";
		case FS6:
			return "fs6";
		case FS7:
			return "fs7";
		case FS8:
			return "fs8";
		case FS9:
			return "fs9";
		case FS10:
			return "fs10";
		case FS11:
			return "fs11";
		case FT8:
			return "ft8";
		case FT9:
			return "ft9";
		case FT10:
			return "ft10";
		case FT11:
			return "ft11";
		case USTATUS:
			return "ustatus";
		case FFLAGS:
			return "fflags";
		case FRM:
			return "frm";
		case FCSR:
			return "fcsr";
		case UIE:
			return "uie";
		case UTVEC:
			return "utvec";
		case USCRATCH:
			return "uscratch";
		case UEPC:
			return "uepc";
		case UCAUSE:
			return "ucause";
		case UTVAL:
			return "utval";
		case UIP:
			return "uip";
		case CYCLE:
			return "cycle";
		case TIME:
			return "time";
		case INSTRET:
			return "instret";
		case CYCLEH:
			return "cycleh";
		case TIMEH:
			return "timeh";
		case INSTRETH:
			return "instreth";
		case PC:
			return "pc";
		default:
			return "$" + num;
		}
	}
}
