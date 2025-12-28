#------------------------------------------------------------------
# Copyright (c) 2024, Francisco J. Moreno Velo                   
# All rights reserved.                                             
#------------------------------------------------------------------

#------------------------------------------------------------------
# urium.Program.getArgCount.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getArgCount.out_int
urium.Program.getArgCount.out_int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw t0, URIUM.PROGRAM.ARGC
	lw a0, 8(s0)
	sw t0, 0(a0)
urium.Program.getArgCount.out_int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Program.getArgLength.int.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getArgLength.int.out_int
urium.Program.getArgLength.int.out_int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw a0, 8(s0)
	lw t0, URIUM.PROGRAM.ARGC
	blt a0, zero, urium.Program.getArgLength.int.out_int.3
	blt t0, a0, urium.Program.getArgLength.int.out_int.3
	lw t0, URIUM.PROGRAM.ARGV
	slli a0, a0, 2
	add t1, t0, a0
	lw t0, 0(t1)
	li a0, 0
urium.Program.getArgLength.int.out_int.1:
	add t1, t0, a0
	lb a1, 0(t1)
	beq a1, zero, urium.Program.getArgLength.int.out_int.2
	addi a0, a0, 1
	b urium.Program.getArgLength.int.out_int.1
urium.Program.getArgLength.int.out_int.2:
	lw a1, 12(s0)
	sw a0, 0(a1)
	b urium.Program.getArgLength.int.out_int.endp
urium.Program.getArgLength.int.out_int.3:
	lw a1, 12(s0)
	li t1, -1
	sw t1, 0(a1)
urium.Program.getArgLength.int.out_int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Program.getIntArg.int.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getIntArg.int.out_int
urium.Program.getIntArg.int.out_int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw a0, 8(s0)
	lw t0, URIUM.PROGRAM.ARGC
	blt a0, zero, urium.Program.getIntArg.int.out_int.3
	blt t0, a0, urium.Program.getIntArg.int.out_int.3
	lw t0, URIUM.PROGRAM.ARGV
	slli a0, a0, 2
	add t1, t0, a0
	lw t0, 0(t1)
	li a0, 0
	li a2, 0
urium.Program.getIntArg.int.out_int.1:
	add t1, t0, a0
	lb a1, 0(t1)
	beq a1, zero, urium.Program.getIntArg.int.out_int.2
	li t1, 48
	blt a1, t1, urium.Program.getIntArg.int.out_int.3
	li t1, 57
	bgt a1, t1, urium.Program.getIntArg.int.out_int.3
	li t1, 10
	mul a2, a2, t1
	addi a1, a1, -48
	add a2, a2, a1
	addi a0, a0, 1
	b urium.Program.getIntArg.int.out_int.1
urium.Program.getIntArg.int.out_int.2:
	lw a1, 12(s0)
	sw a2, 0(a1)
	b urium.Program.getIntArg.int.out_int.endp
urium.Program.getIntArg.int.out_int.3:
	lw a1, 12(s0)
	li a2, -1
	sw a2, 0(a1)
urium.Program.getIntArg.int.out_int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Program.getCharArg.int.int.out_char
#------------------------------------------------------------------

	.globl	urium.Program.getCharArg.int.int.out_char
urium.Program.getCharArg.int.int.out_char:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw a0, 8(s0)
	lw t0, URIUM.PROGRAM.ARGC
	blt a0, zero, urium.Program.getCharArg.int.int.out_char.3
	blt t0, a0, urium.Program.getCharArg.int.int.out_char.3
	lw t0, URIUM.PROGRAM.ARGV
	slli a0, a0, 2
	add t1, t0, a0
	lw t0, 0(t1)
	li a0, 0
	lw a1, 12(s0)
	blt a1, zero, urium.Program.getCharArg.int.int.out_char.3
urium.Program.getCharArg.int.int.out_char.1:
	add t1, t0, a0
	lb a2, 0(t1)
	beq a0, a1, urium.Program.getCharArg.int.int.out_char.2
	beq a2, zero, urium.Program.getCharArg.int.int.out_char.3
	addi a0, a0, 1
	b urium.Program.getCharArg.int.int.out_char.1
urium.Program.getCharArg.int.int.out_char.2:
	lw a1, 16(s0)
	sw a2, 0(a1)
	b urium.Program.getCharArg.int.int.out_char.endp
urium.Program.getCharArg.int.int.out_char.3:
	lw a1, 16(s0)
	sw zero, 0(a1)
urium.Program.getCharArg.int.int.out_char.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Program.exit.int
#------------------------------------------------------------------

	.globl	urium.Program.exit.int
urium.Program.exit.int:
	lw a0, 0(sp)
	li a7, 93
	ecall			# syscall 93 ( exit2(result) )
	nop
	ret
