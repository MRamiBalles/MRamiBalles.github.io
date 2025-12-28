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
 * Interface giving codes to the MIPS-32 processor registers
 * 
 * @author Francisco J. Moreno Velo
 */
public interface RegisterConstants {

	//--------------------------------------------------------------//
	//             Constants (General purpose registers)            //
	//--------------------------------------------------------------//

	public int GPR_R0 = 0;
	public int GPR_AT = 1;
	public int GPR_V0 = 2;
	public int GPR_V1 = 3;
	public int GPR_A0 = 4;
	public int GPR_A1 = 5;
	public int GPR_A2 = 6;
	public int GPR_A3 = 7;
	public int GPR_T0 = 8;
	public int GPR_T1 = 9;
	public int GPR_T2 = 10;
	public int GPR_T3 = 11;
	public int GPR_T4 = 12;
	public int GPR_T5 = 13;
	public int GPR_T6 = 14;
	public int GPR_T7 = 15;
	public int GPR_S0 = 16;
	public int GPR_S1 = 17;
	public int GPR_S2 = 18;
	public int GPR_S3 = 19;
	public int GPR_S4 = 20;
	public int GPR_S5 = 21;
	public int GPR_S6 = 22;
	public int GPR_S7 = 23;
	public int GPR_T8 = 24;
	public int GPR_T9 = 25;
	public int GPR_K0 = 26;
	public int GPR_K1 = 27;
	public int GPR_GP = 28;
	public int GPR_SP = 29;
	public int GPR_FP = 30;
	public int GPR_RA = 31;

	//--------------------------------------------------------------//
	//              Constants (Floating point registers)            //
	//--------------------------------------------------------------//

	public int FPR_0 = 32;
	public int FPR_1 = 33;
	public int FPR_2 = 34;
	public int FPR_3 = 35;
	public int FPR_4 = 36;
	public int FPR_5 = 37;
	public int FPR_6 = 38;
	public int FPR_7 = 39;
	public int FPR_8 = 40;
	public int FPR_9 = 41;
	public int FPR_10 = 42;
	public int FPR_11 = 43;
	public int FPR_12 = 44;
	public int FPR_13 = 45;
	public int FPR_14 = 46;
	public int FPR_15 = 47;
	public int FPR_16 = 48;
	public int FPR_17 = 49;
	public int FPR_18 = 50;
	public int FPR_19 = 51;
	public int FPR_20 = 52;
	public int FPR_21 = 53;
	public int FPR_22 = 54;
	public int FPR_23 = 55;
	public int FPR_24 = 56;
	public int FPR_25 = 57;
	public int FPR_26 = 58;
	public int FPR_27 = 59;
	public int FPR_28 = 60;
	public int FPR_29 = 61;
	public int FPR_30 = 62;
	public int FPR_31 = 63;

}
