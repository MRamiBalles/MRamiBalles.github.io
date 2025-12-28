#------------------------------------------------------------------
# Copyright (c) 2024, Francisco J. Moreno Velo                   
# All rights reserved.                                             
#------------------------------------------------------------------

#------------------------------------------------------------------
# urium.Console.print.char
#------------------------------------------------------------------

	.globl	urium.Console.print.char
urium.Console.print.char:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw a0, 8(sp) 
	li a7, 11
	ecall
urium.Console.print.char.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Console.print.int
#------------------------------------------------------------------

	.globl	urium.Console.print.int
urium.Console.print.int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw a0, 8(sp)
	li a7, 1
	ecall
urium.Console.print.int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Console.printBits.int
#------------------------------------------------------------------

	.globl	urium.Console.printBits.int
urium.Console.printBits.int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	lw t2, 8(s0)
	li t0, 0x0
	li t1, 0x20
urium.Console.printBits.int.1:
	bge t0, t1 urium.Console.printBits.int.endp
	bge t2, zero urium.Console.printBits.int.2
	li a0, 0x31
	li a7, 11
	ecall
	b urium.Console.printBits.int.3
urium.Console.printBits.int.2:
	li a0, 0x30
	li a7, 11
	ecall
urium.Console.printBits.int.3:
	slli t2, t2, 1
	addi t0, t0, 1
	b urium.Console.printBits.int.1
urium.Console.printBits.int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Console.printHex.int
#------------------------------------------------------------------

	.globl	urium.Console.printHex.int
urium.Console.printHex.int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	li t0, 28
urium.Console.printHex.int.1:
	lw a0, 8(s0)
	srl a0, a0, t0
	andi a0, a0, 0x0f
	li t1, 0x0a
	bge a0, t1, urium.Console.printHex.int.2
	addi a0, a0, 0x30
	li a7, 11
	ecall
	b urium.Console.printHex.int.3
urium.Console.printHex.int.2:
	addi a0, a0, 0x37
	li a7, 11
	ecall
urium.Console.printHex.int.3:
	addi t0, t0, -4
	bge t0, zero, urium.Console.printHex.int.1
urium.Console.printHex.int.endp:
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Console.readInt.out_int
#------------------------------------------------------------------

	.globl	urium.Console.readInt.out_int
urium.Console.readInt.out_int:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	li a7, 5
	ecall
urium.Console.readInt.out_int.endp:
	lw t0, 8(s0)
	sw a0, 0(t0)
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret

#------------------------------------------------------------------
# urium.Console.readChar.out_char
#------------------------------------------------------------------

	.globl	urium.Console.readChar.out_char
urium.Console.readChar.out_char:
	addi sp, sp, -8
	sw ra, 4(sp)
	sw s0, 0(sp)
	or s0, zero, sp
	li a7, 12
	ecall
urium.Console.readChar.out_char.endp:
	lw t0, 8(s0)
	sw a0, 0(t0)
	or sp, zero, s0
	lw ra, 4(sp)
	lw s0, 0(sp)
	addi sp, sp, 8
	ret
