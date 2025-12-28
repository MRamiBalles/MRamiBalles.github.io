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
 * Interface giving codes to the RISC-V processor registers
 * 
 * @author Francisco J. Moreno Velo
 */
public interface RegisterConstants {

	//--------------------------------------------------------------//
	//             Constants (General purpose registers)            //
	//--------------------------------------------------------------//

	public int GPR_ZERO = 0;
	public int GPR_RA = 1;
	public int GPR_SP = 2;
	public int GPR_GP = 3;
	public int GPR_TP = 4;
	public int GPR_T0 = 5;
	public int GPR_T1 = 6;
	public int GPR_T2 = 7;
	public int GPR_S0 = 8;
	public int GPR_S1 = 9;
	public int GPR_A0 = 10;
	public int GPR_A1 = 11;
	public int GPR_A2 = 12;
	public int GPR_A3 = 13;
	public int GPR_A4 = 14;
	public int GPR_A5 = 15;
	public int GPR_A6 = 16;
	public int GPR_A7 = 17;
	public int GPR_S2 = 18;
	public int GPR_S3 = 19;
	public int GPR_S4 = 20;
	public int GPR_S5 = 21;
	public int GPR_S6 = 22;
	public int GPR_S7 = 23;
	public int GPR_S8 = 24;
	public int GPR_S9 = 25;
	public int GPR_S10 = 26;
	public int GPR_S11 = 27;
	public int GPR_T3 = 28;
	public int GPR_T4 = 29;
	public int GPR_T5 = 30;
	public int GPR_T6 = 31;
	
	//--------------------------------------------------------------//
	//              Constants (Floating point registers)            //
	//--------------------------------------------------------------//

	public int FT0 = 100;
	public int FT1 = 101;
	public int FT2 = 102;
	public int FT3 = 103;
	public int FT4 = 104;
	public int FT5 = 105;
	public int FT6 = 106;
	public int FT7 = 107;
	public int FS0 = 108;
	public int FS1 = 109;
	public int FA0 = 110;
	public int FA1 = 111;
	public int FA2 = 112;
	public int FA3 = 113;
	public int FA4 = 114;
	public int FA5 = 115;
	public int FA6 = 116;
	public int FA7 = 117;
	public int FS2 = 118;
	public int FS3 = 119;
	public int FS4 = 120;
	public int FS5 = 121;
	public int FS6 = 122;
	public int FS7 = 123;
	public int FS8 = 124;
	public int FS9 = 125;
	public int FS10 = 126;
	public int FS11 = 127;
	public int FT8 = 128;
	public int FT9 = 129;
	public int FT10 = 130;
	public int FT11 = 131;

	//--------------------------------------------------------------//
	//            Constants (control and status registers)          //
	//--------------------------------------------------------------//

	public int USTATUS = 200;
	public int FFLAGS = 201;
	public int FRM = 202;
	public int FCSR = 203;
	public int UIE = 204;
	public int UTVEC = 205;
	public int USCRATCH = 206;
	public int UEPC = 207;
	public int UCAUSE = 208;
	public int UTVAL = 209;
	public int UIP = 210;
	public int CYCLE = 211;
	public int TIME = 212;
	public int INSTRET = 213;
	public int CYCLEH = 214;
	public int TIMEH = 215;
	public int INSTRETH = 216;
	public int PC = 217;
}
