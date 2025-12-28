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
 * Abstract class describing an assembly instruction of the MIPS-32 processor
 * 
 * @author Francisco J. Moreno Velo
 */
public abstract class Instruction implements InstructionSet {

	//----------------------------------------------------------------//
	//                         Private members                        //
	//----------------------------------------------------------------//

	/**
	 * Instruction code
	 */
	private int code;

	//----------------------------------------------------------------//
	//                            Constructor                         //
	//----------------------------------------------------------------//

	/**
	 * Constructor
	 */
	public Instruction(int code) 
	{
		this.code = code;
	}

	//----------------------------------------------------------------//
	//                          Public methods                        //
	//----------------------------------------------------------------//

	/**
	 * Gets the instruction code
	 */
	public int getCode() 
	{
		return this.code;
	}

	/**
	 * Gets the name of the assembler instruction
	 */
	public String getInstructionName() 
	{
		switch (code) 
		{
		case ADD:
			return "add";
		case ADDI:
			return "addi";
		case AND:
			return "and";
		case ANDI:
			return "andi";
		case AUIPC:
			return "auipc";	
		case BEQ:
			return "beq";
		case BGE:
			return "bge";
		case BGEU:
			return "bgeu";
		case BLT:
			return "blt";
		case BLTU:
			return "bltu";
		case BNE:
			return "bne";
		case CSRRC:
			return "csrrc";
		case CSRRCI:
			return "csrrci";	
		case CSRRS:
			return "csrrs";
		case CSRRSI:
			return "csrrsi";
		case CSRRW:
			return "csrrw";
		case CSRRWI:
			return "csrrwi";
		case DIV:
			return "div";
		case DIVU:
			return "divu";
		case EBREAK:
			return "ebreak";
		case ECALL:
			return "ecall";
		case FADD_D:
			return "fadd.d";
		case FADD_S:
			return "fadd.s";
		case FCLASS_D:
			return "fclass.d";
		case FCLASS_S:
			return "fclass.s";
		case FCVT_D_S:
			return "fcvt.d.s";
		case FCVT_D_W:
			return "fcvt.d.w";
		case FCVT_D_WU:
			return "fcvt.d.wu";
		case FCVT_S_D:
			return "fcvt.s.d";
		case FCVT_S_W:
			return "fcvt.s.w";
		case FCVT_S_WU:
			return "fcvt.s.wu";
		case FCVT_W_D:
			return "fcvt.w.d";
		case FCVT_W_S:
			return "fcvt.w.s";
		case FCVT_WU_D:
			return "fcvt.wu.d";
		case FCVT_WU_S:
			return "fcvt.wu.s";
		case FDIV_D:
			return "fdiv.d";
		case FDIV_S:
			return "fdiv.s";
		case FENCE:
			return "fence";
		case FENCE_I:
			return "fence.i";
		case FEQ_D:
			return "feq.d";
		case FEQ_S:
			return "feq.s";
		case FLD:
			return "fld";
		case FLE_D:
			return "fle.d";
		case FLE_S:
			return "fle.s";
		case FLT_D:
			return "flt.d";
		case FLT_S:
			return "flt.s";
		case FLW:
			return "flw";
		case FMADD_D:
			return "fmadd.d";
		case FMADD_S:
			return "fmadd.s";
		case FMAX_D:
			return "fmax.d";
		case FMAX_S:
			return "fmax.s";
		case FMIN_D:
			return "fmin.d";
		case FMIN_S:
			return "fmin.s";
		case FMSUB_D:
			return "fmsub.d";
		case FMSUB_S:
			return "fmsub.s";
		case FMUL_D:
			return "fmul.d";
		case FMUL_S:
			return "fmul.s";
		case FMV_S_X:
			return "fmv.s.x";
		case FMV_X_S:
			return "fmv.x.s";
		case FNMADD_D:
			return "fnmadd.d";
		case FNMADD_S:
			return "fnmadd.s";
		case FNMSUB_D:
			return "fnmsub.d";
		case FNMSUB_S:
			return "fnmsub.s";
		case FSD:
			return "fsd";
		case FSGNJ_D:
			return "fsgnj.d";
		case FSGNJ_S:
			return "fsgnj.s";
		case FSGNJN_D:
			return "fsgnjn.d";
		case FSGNJN_S:
			return "fsgnjn.s";
		case FSQRT_D:
			return "fsqrt.d";
		case FSQRT_S:
			return "fsqrt.s";
		case FSUB_D:
			return "fsub.d";
		case FSUB_S:
			return "fsub.s";
		case FSW:
			return "fsw";
		case JAL:
			return "jal";
		case JALR:
			return "jalr";
		case LB:
			return "lb";
		case LBU:
			return "lbu";
		case LH:
			return "lh";
		case LHU:
			return "lhu";
		case LUI:
			return "lui";
		case LW:
			return "lw";
		case MUL:
			return "mul";
		case MULH:
			return "mulh";
		case MULHSU:
			return "mulhsu";
		case MULHU:
			return "mulhu";
		case OR:
			return "or";
		case ORI:
			return "ori";
		case REM:
			return "rem";
		case REMU:
			return "remu";	
		case SB:
			return "sb";
		case SH:
			return "sh";
		case SLL:
			return "sll";
		case SLLI:
			return "slli";
		case SLT:
			return "slt";
		case SLTI:
			return "slti";
		case SLTIU:
			return "sltiu";
		case SLTU:
			return "sltu";
		case SRA:
			return "sra";
		case SRAI:
			return "srai";
		case SRL:
			return "srl";
		case SRLI:
			return "srli";
		case SUB:
			return "sub";
		case SW:
			return "sw";
		case URET:
			return "uret";
		case WFI:
			return "wfi";
		case XOR:
			return "xor";
		case XORI:
			return "xori";
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
		//                     RISC-V (Pesudo) Instructions                 //
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

		case B:
			return "b";
		case BEQZ:
			return "beqz";
		case BGEZ:
			return "bgez";
		case BGT:
			return "bgt";
		case BGTU:
			return "bgtu";
		case BGTZ:
			return "bgtz";
		case BLE:
			return "ble";
		case BLEU:
			return "bleu";
		case BLEZ:
			return "blez";
		case BLTZ:
			return "bltz";
		case BNEZ:
			return "bnez";
		case CALL:
			return "call";
		case CSRC:
			return "csrc";
		case CSRCI:
			return "csrci";
		case CSRR:
			return "csrr";
		case CSRS:
			return "csrs";
		case CSRSI:
			return "csrsi";
		case CSRW:
			return "csrw";
		case CSRWI:
			return "csrwi";
		case FABS_D:
			return "fabs.d";
		case FABS_S:
			return "fabs.s";
		case FGE_D:
			return "fge.d";
		case FGE_S:
			return "fge.s";
		case FGT_D:
			return "fgt.d";
		case FGT_S:
			return "fgt.s";
		case FMV_D:
			return "fmv.d";
		case FMV_S:
			return "fmv.s";
		case FMV_W_X:
			return "fmv.w.x";
		case FMV_X_W:
			return "fmv.x.w";
		case FNEG_D:
			return "fneg.d";
		case FNEG_S:
			return "fneg.s";
		case FRCSR:
			return "frcsr";
		case FRFLAGS:
			return "frflags";
		case FRRM:
			return "frrm";
		case FRSR:
			return "frsr";
		case FSCSR:
			return "fscsr";
		case FSFLAGS:
			return "fsflags";
		case FSRM:
			return "fsrm";
		case FSSR:
			return "fssr";
		case J:
			return "j";
		case JR:
			return "jr";
		case LA:
			return "la";
		case LI:
			return "li";
		case MV:
			return "mv";
		case NEG:
			return "neg";
		case NOP:
			return "nop";
		case NOT:
			return "not";
		case RDCYCLE:
			return "rdcycle";
		case RDCYCLEH:
			return "rdcycleh";
		case RDINSTRET:
			return "rdinstret";
		case RDINSTRETH:
			return "rdinstreth";
		case RDTIME:
			return "rdtime";
		case RDTIMEH:
			return "rdtimeh";
		case RET:
			return "ret";
		case SEQZ:
			return "seqz";
		case SEXT_B:
			return "sext.b";
		case SEXT_H:
			return "sext.h";
		case SGT:
			return "sgt";
		case SGTU:
			return "sgtu";
		case SGTZ:
			return "sgtz";
		case SLTZ:
			return "sltz";
		case SNEZ:
			return "snez";
		case TAIL:
			return "tail";
		case ZEXT_B:
			return "zext.b";
		case ZEXT_H:
			return "zext.h";
		default:
			return "";
		}
	}

	/**
	 * Gets the text of the assembler instruction
	 */
	public abstract String getAssembler();

}

