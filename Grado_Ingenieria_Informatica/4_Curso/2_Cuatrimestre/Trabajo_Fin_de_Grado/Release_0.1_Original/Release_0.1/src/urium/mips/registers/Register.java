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

package urium.mips.registers;

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
	//                           Constructor                          //
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
		case GPR_R0:
			return "$0";
		case GPR_AT:
			return "$at";
		case GPR_V0:
			return "$v0";
		case GPR_V1:
			return "$v1";
		case GPR_A0:
			return "$a0";
		case GPR_A1:
			return "$a1";
		case GPR_A2:
			return "$a2";
		case GPR_A3:
			return "$a3";
		case GPR_T0:
			return "$t0";
		case GPR_T1:
			return "$t1";
		case GPR_T2:
			return "$t2";
		case GPR_T3:
			return "$t3";
		case GPR_T4:
			return "$t4";
		case GPR_T5:
			return "$t5";
		case GPR_T6:
			return "$t6";
		case GPR_T7:
			return "$t7";
		case GPR_S0:
			return "$s0";
		case GPR_S1:
			return "$s1";
		case GPR_S2:
			return "$s2";
		case GPR_S3:
			return "$s3";
		case GPR_S4:
			return "$s4";
		case GPR_S5:
			return "$s5";
		case GPR_S6:
			return "$s6";
		case GPR_S7:
			return "$s7";
		case GPR_T8:
			return "$t8";
		case GPR_T9:
			return "$t9";
		case GPR_K0:
			return "$k0";
		case GPR_K1:
			return "$k1";
		case GPR_GP:
			return "$gp";
		case GPR_SP:
			return "$sp";
		case GPR_FP:
			return "$fp";
		case GPR_RA:
			return "$ra";
		case FPR_0:
			return "$f0";
		case FPR_1:
			return "$f1";
		case FPR_2:
			return "$f2";
		case FPR_3:
			return "$f3";
		case FPR_4:
			return "$f4";
		case FPR_5:
			return "$f5";
		case FPR_6:
			return "$f6";
		case FPR_7:
			return "$f7";
		case FPR_8:
			return "$f8";
		case FPR_9:
			return "$f9";
		case FPR_10:
			return "$f10";
		case FPR_11:
			return "$f11";
		case FPR_12:
			return "$f12";
		case FPR_13:
			return "$f13";
		case FPR_14:
			return "$f14";
		case FPR_15:
			return "$f15";
		case FPR_16:
			return "$f16";
		case FPR_17:
			return "$f17";
		case FPR_18:
			return "$f18";
		case FPR_19:
			return "$f19";
		case FPR_20:
			return "$f20";
		case FPR_21:
			return "$f21";
		case FPR_22:
			return "$f22";
		case FPR_23:
			return "$f23";
		case FPR_24:
			return "$f24";
		case FPR_25:
			return "$f25";
		case FPR_26:
			return "$f26";
		case FPR_27:
			return "$f27";
		case FPR_28:
			return "$f28";
		case FPR_29:
			return "$f29";
		case FPR_30:
			return "$f30";
		case FPR_31:
			return "$f31";
		default:
			return "$" + num;
		}
	}
}
