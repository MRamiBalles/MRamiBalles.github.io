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

package urium.riscv.instructions;

/**
 * Interface that describes the codes of all the instructions of the 
 * RISC-V processor
 * 
 * @author Francisco J. Moreno Velo
 */
public interface InstructionSet {

	/** Label */
	public int LABEL = 1;

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//                       RISC-V 32G Instructions                    //
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/** Addition */
	public int ADD = 2;
	
	/** Addition immediate */
	public int ADDI = 3;
	
	/** Bitwise and */
	public int AND = 4;
	
	/** Bitwise and immediate */
	public int ANDI = 5;
	
	/** Add upper immediate to pc*/
	public int AUIPC = 6;	
	
	/** Branch if equal */
	public int BEQ = 7;
	
	/** Branch if greater than or equal */
	public int BGE = 8;
	
	/** Branch if greater than or equal (unsigned) */
	public int BGEU = 9;
	
	/** Branch if less than */
	public int BLT = 10;
	
	/** Branch if less than (unsigned) */
	public int BLTU = 11;
	
	/** Branch if not equal */
	public int BNE = 12;
	
	/** Atomic Read/Clear CSR */
	public int CSRRC = 13;
	
	/** Atomic Read/Clear CSR Immediate */
	public int CSRRCI = 14;	
	
	/** Atomic Read/Set CSR */
	public int CSRRS = 15;
	
	/** Atomic Read/Set CSR Immediate */
	public int CSRRSI = 16;
	
	/** Atomic Read/Write CSR */
	public int CSRRW = 17;
	
	/** Atomic Read/Write CSR Immediate */
	public int CSRRWI = 18;
	
	/** Division */
	public int DIV = 19;
	
	/** Division (unsigned) */
	public int DIVU = 20;
	
	/** Pause execution */
	public int EBREAK = 21;
	
	/** Issue a system call */
	public int ECALL = 22;
	
	/** Floating add (64 bits) */
	public int FADD_D = 23;
	
	/** Floating add (32 bits) */
	public int FADD_S = 24;
	
	/** Classify a floating number (64 bits) */
	public int FCLASS_D = 25;
	
	/** Classify a floating number (32 bits) */
	public int FCLASS_S = 26;
	
	/** Convert a float to a double */
	public int FCVT_D_S = 27;
	
	/** Convert an integer to a double */
	public int FCVT_D_W = 28;

	/** Convert an unisgned integer to a double */
	public int FCVT_D_WU = 29;
	
	/** Convert a double to a float */
	public int FCVT_S_D = 30;
	
	/** Convert an integer to a float */
	public int FCVT_S_W = 31;

	/** Convert an unisgned integer to a float */
	public int FCVT_S_WU = 32;
	
	/** Convert a double to an integer */
	public int FCVT_W_D = 33;
	
	/** Convert a float to an integer */
	public int FCVT_W_S = 34;
	
	/** Convert a double to an unsigned integer */
	public int FCVT_WU_D = 35;
	
	/** Convert a float to an unsigned integer */
	public int FCVT_WU_S = 36;
	
	/** Floating division (64 bits) */
	public int FDIV_D = 37;
	
	/** Floating division (32 bits) */
	public int FDIV_S = 38;
	
	/** Ensure that IO and memory accesses before the fence
	 * happen before the following IO and memory accesses are
	 * viewed by a different thread */
	public int FENCE = 39;
	
	/** Ensure that stores to instruction memory are visible 
	 * to instruction fetches */
	public int FENCE_I = 40;
	
	/** Floating equals (64 bits) */
	public int FEQ_D = 41;
	
	/** Floating equals (32 bits) */
	public int FEQ_S = 42;
	
	/** Load a double from memory */
	public int FLD = 43;
	
	/** Floating less than or equals (64 bits) */
	public int FLE_D = 44;
	
	/** Floating less than or equals (32 bits) */
	public int FLE_S = 45;
	
	/** Floating less than (64 bits) */
	public int FLT_D = 46;
	
	/** Floating less than (32 bits) */
	public int FLT_S = 47;
	
	/** Load a float from memory */
	public int FLW = 48;
	
	/** Fused multiply add (64 bits) */
	public int FMADD_D = 49;
	
	/** Fused multiply add (32 bits) */
	public int FMADD_S = 50;
	
	/** Floating maximum (64 bits) */
	public int FMAX_D = 51;
	
	/** Floating maximum (32 bits) */
	public int FMAX_S = 52;
	
	/** Floating minimum (64 bits) */
	public int FMIN_D = 53;
	
	/** Floating minimum (32 bits) */
	public int FMIN_S = 54;
	
	/** Fused multiply subtract (64 bits) */
	public int FMSUB_D = 55;
	
	/** Fused multiply subtract (32 bits) */
	public int FMSUB_S = 56;
	
	/** Floating multiply (64 bits) */
	public int FMUL_D = 57;
	
	/** Floating multiply (32 bits) */
	public int FMUL_S = 58;
	
	/** Move from GPR to float */
	public int FMV_S_X = 59;
	
	/** Move from float to GPR */
	public int FMV_X_S = 60;
	
	/** Fused negated multiply add (64 bits) */
	public int FNMADD_D = 61;
	
	/** Fused negated multiply add (32 bits) */
	public int FNMADD_S = 62;
	
	/** Fused negated multiply subtract (64 bits) */
	public int FNMSUB_D = 63;
	
	/** Fused negated multiply subtract (32 bits) */
	public int FNMSUB_S = 64;
	
	/** Store a double to memory */
	public int FSD = 65;
	
	/** Floating sign injection (64 bits) */
	public int FSGNJ_D = 66;
	
	/** Floating sign injection (32 bits) */
	public int FSGNJ_S = 67;
	
	/** Floating sign injection inverted (64 bits) */
	public int FSGNJN_D = 68;
	
	/** Floating sign injection inverted (32 bits) */
	public int FSGNJN_S = 69;
	
	/** Floating square root (64 bits) */
	public int FSQRT_D = 70;
	
	/** Floating square root (32 bits) */
	public int FSQRT_S = 71;
	
	/** Floating subtract (64 bits) */
	public int FSUB_D = 72;
	
	/** Floating subtract (32 bits) */
	public int FSUB_S = 73;
	
	/** Store a float to memory */
	public int FSW = 74;
	
	/** Jump and link */
	public int JAL = 75;
	
	/** Jump and link register */
	public int JALR = 76;
	
	/** Load byte from memory (sign extended) */
	public int LB = 77;
	
	/** Load byte from memory (zero extended) */
	public int LBU = 78;
	
	/** Load halfword from memory (sign extended) */
	public int LH = 79;
	
	/** Load halfword from memory (zero extended) */
	public int LHU = 80;
	
	/** Load upper immediate */
	public int LUI = 81;
	
	/** Load word from memory */
	public int LW = 82;
	
	/** Multiply (low 32 bits)*/
	public int MUL = 83;
	
	/** Multiply signed (high 32 bits)*/
	public int MULH = 84;
	
	/** Multiply signed-unsigned (high 32 bits)*/
	public int MULHSU = 85;
	
	/** Multiply unsigned (high 32 bits)*/
	public int MULHU = 86;
	
	/** Bitwise or */
	public int OR = 87;
	
	/** Bitwise or immediate */
	public int ORI = 88;
	
	/** Remainder of integer division (signed) */
	public int REM = 89;
	
	/** Remainder of integer division (unsigned) */
	public int REMU = 90;	
	
	/** Store byte to memory */
	public int SB = 91;
	
	/** Store halfword to memory */
	public int SH = 92;
	
	/** Shift left logical */
	public int SLL = 93;
	
	/** Shift left logical immediate */
	public int SLLI = 94;
	
	/** Set less than */
	public int SLT = 95;
	
	/** Set less than immediate */
	public int SLTI = 96;
	
	/** Set less than immediate (unsigned) */
	public int SLTIU = 97;
	
	/** Set less than (unsigned) */
	public int SLTU = 98;
	
	/** Shift right arithmetic */
	public int SRA = 99;
	
	/** Shift right arithmetic immediate */
	public int SRAI = 100;
	
	/** Shift right logic */
	public int SRL = 101;
	
	/** Shift right logic immediate */
	public int SRLI = 102;
	
	/** Subtract */
	public int SUB = 103;
	
	/** Store word to memory */
	public int SW = 104;
	
	/** Return from an interrupt or exception */
	public int URET = 105;
	
	/** Wait for interrupt */
	public int WFI = 106;
	
	/** Bitwise xor */
	public int XOR = 107;
	
	/** Bitwise xor immediate */
	public int XORI = 108;
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//                     RISC-V (Pesudo) Instructions                 //
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/** Branch unconditionally */
	public int B = 109;
	
	/** Branch if zero */
	public int BEQZ = 110;
	
	/** Branch if greater than or equal to zero */
	public int BGEZ = 111;
	
	/** Branch if greater than */
	public int BGT = 112;
	
	/** Branch if greater than (unsigned) */
	public int BGTU = 113;
	
	/** Branch if greater than zero */
	public int BGTZ = 114;
	
	/** Branch if less than or equal */
	public int BLE = 115;
	
	/** Branch  if less than or equal (unsigned) */
	public int BLEU = 116;
	
	/** Branch  if less than or equal to zero */
	public int BLEZ = 117;
	
	/** Branch  if less than zero */
	public int BLTZ = 118;
	
	/** Branch  if not equal to zero */
	public int BNEZ = 119;
	
	/** Call a subroutine */
	public int CALL = 120;
	
	/** Clear bits in control and status register */
	public int CSRC = 121;
	
	/** Clear bits in control and status register */
	public int CSRCI = 122;
	
	/** Read bits in control and status register */
	public int CSRR = 123;
	
	/** Set bits in control and status register */
	public int CSRS = 124;
	
	/** Set bits in control and status register immediate */
	public int CSRSI = 125;
	
	/** Write bits in control and status register */
	public int CSRW = 126;
	
	/** Write bits in control and status register */
	public int CSRWI = 127;
	
	/** Floating absolute value (64 bits) */
	public int FABS_D = 128;
	
	/** Floating absolute value (32 bits) */
	public int FABS_S = 129;
	
	/** Floating greater than or equal (64 bits) */
	public int FGE_D = 130;
	
	/** Floating greater than or equal (32 bits) */
	public int FGE_S = 131;
	
	/** Floating greater than (64 bits) */
	public int FGT_D = 132;
	
	/** Floating greater than (32 bits) */
	public int FGT_S = 133;
	
	/** Move floating registers (64 bits) */
	public int FMV_D = 134;
	
	/** Move floating registers (32 bits) */
	public int FMV_S = 135;
	
	/** Move bits from floating register to integer register */
	public int FMV_W_X = 136;
	
	/** Move bits from integer register to floating register */
	public int FMV_X_W = 137;
	
	/** Floating negation (64 bits) */
	public int FNEG_D = 138;
	
	/** Floating negation (32 bits) */
	public int FNEG_S = 139;
	
	/** Read floating control and status register */
	public int FRCSR = 140;
	
	/** Read floating flags register */
	public int FRFLAGS = 141;
	
	/** Read floating rounding mode register */
	public int FRRM = 142;
	
	/** Alias for frcsr */
	public int FRSR = 143;
	
	/** Write floating control and status register */
	public int FSCSR = 144;
	
	/** Write floating flags register */
	public int FSFLAGS = 145;
	
	/** Write floating rounding mode register  */
	public int FSRM = 146;
	
	/** Alias for fscsr */
	public int FSSR = 147;
	
	/** Jump */
	public int J = 148;
	
	/** Jump register */
	public int JR = 149;
	
	/** Load address */
	public int LA = 150;
	
	/** Load immediate */
	public int LI = 151;
	
	/** Move register */
	public int MV = 152;
	
	/** Negation */
	public int NEG = 153;
	
	/** No operation */
	public int NOP = 154;
	
	/** Bitwise not */
	public int NOT = 155;
	
	/** Read from cycle register */
	public int RDCYCLE = 156;
	
	/** Read from cycleh register */
	public int RDCYCLEH = 157;
	
	/** Read from instret register */
	public int RDINSTRET = 158;
	
	/** Read from instreth register */
	public int RDINSTRETH = 159;
	
	/** Read from time register */
	public int RDTIME = 160;
	
	/** Read from timeh register */
	public int RDTIMEH = 161;
	
	/** Return from subroutine */
	public int RET = 162;
	
	/** Set equal to zero */
	public int SEQZ = 163;
	
	/** Sign extension byte */
	public int SEXT_B = 164;
	
	/** Sign extension halfword */
	public int SEXT_H = 165;
	
	/** Set greater than */
	public int SGT = 166;
	
	/** Set grater than (unsigned) */
	public int SGTU = 167;
	
	/** Set greater than zero */
	public int SGTZ = 168;
	
	/** Set less than zero */
	public int SLTZ = 169;
	
	/** Set not equal zero */
	public int SNEZ = 170;
	
	/** Tail call */
	public int TAIL = 171;
	
	/** Zero extended byte */
	public int ZEXT_B = 172;
	
	/** Zero extended halfword */
	public int ZEXT_H = 173;
}
