#------------------------------------------------------------------
# Copyright (c) 2024, Francisco J. Moreno Velo                   
# All rights reserved.                                             
#------------------------------------------------------------------

#------------------------------------------------------------------
# urium.Console.print.char
#------------------------------------------------------------------

	.globl	urium.Console.print.char
	.ent	urium.Console.print.char
urium.Console.print.char:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $a0 8($sp)
	ori $v0 $0 11
	syscall
urium.Console.print.char.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Console.print.char

#------------------------------------------------------------------
# urium.Console.print.int
#------------------------------------------------------------------

	.globl	urium.Console.print.int
	.ent	urium.Console.print.int
urium.Console.print.int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $a0 8($sp)
	ori $v0 $0 1
	syscall
urium.Console.print.int.endp:
	sw $v0 8($fp)
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Console.print.int

#------------------------------------------------------------------
# urium.Console.printBits.int
#------------------------------------------------------------------

	.globl	urium.Console.printBits.int
	.ent	urium.Console.printBits.int
urium.Console.printBits.int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $t2 8($fp)
	ori $t0 $0 0x0
	ori $t1 $0 0x20
urium.Console.printBits.int.1:
	slt $v0 $t0 $t1
	beq $v0 $0 urium.Console.printBits.int.endp
	nop
	slt $v0 $t2 $0
	beq $v0 $0 urium.Console.printBits.int.2
	nop
	ori $a0 $0 0x31
	ori $v0 $0 11
	syscall
	j urium.Console.printBits.int.3
	nop
urium.Console.printBits.int.2:
	ori $a0 $0 0x30
	ori $v0 $0 11
	syscall
urium.Console.printBits.int.3:
	sll $t2 $t2 1
	addi $t0 $t0 1
	j urium.Console.printBits.int.1
	nop
urium.Console.printBits.int.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Console.printBits.int

#------------------------------------------------------------------
# urium.Console.printHex.int
#------------------------------------------------------------------

	.globl	urium.Console.printHex.int
	.ent	urium.Console.printHex.int
urium.Console.printHex.int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	ori $t0 $0 28
urium.Console.printHex.int.1:
	lw $a0 8($fp)
	nop
	srlv $a0 $a0 $t0
	andi $a0 $a0 0x0f
	ori $a1 $0 0x0a
	slt $v0 $a0 $a1
	beq $v0 $0 urium.Console.printHex.int.2
	nop
	addiu $a0 $a0 0x30
	ori $v0 $0 11
	syscall
	j urium.Console.printHex.int.3
	nop
urium.Console.printHex.int.2:
	addiu $a0 $a0 0x37
	ori $v0 $0 11
	syscall
urium.Console.printHex.int.3:
	addiu $t0 $t0 -4
	slt $v0 $t0 $0
	beq $v0 $0 urium.Console.printHex.int.1
	nop
urium.Console.printHex.int.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Console.printHex.int

#------------------------------------------------------------------
# urium.Console.readInt.out_int
#------------------------------------------------------------------

	.globl	urium.Console.readInt.out_int
	.ent	urium.Console.readInt.out_int
urium.Console.readInt.out_int:
	addiu $sp $sp -12
	sw $ra 8($sp)
	sw $fp 4($sp)
	or $fp $0 $sp
	ori $v0 $0 5
	syscall
	nop
urium.Console.readInt.out_int.endp:
	lw $v1 12($fp)
	nop
	sw $v0 0($v1)
	or $sp $0 $fp
	lw $ra 8($sp)
	lw $fp 4($sp)
	addiu $sp $sp 12
	jr $ra
	nop
	.end	urium.Console.readInt.out_int

#------------------------------------------------------------------
# urium.Console.readChar.out_char
#------------------------------------------------------------------

	.globl	urium.Console.readChar.out_char
	.ent	urium.Console.readChar.out_char
urium.Console.readChar.out_char:
	addiu $sp $sp -12
	sw $ra 8($sp)
	sw $fp 4($sp)
	or $fp $0 $sp
	ori $v0 $0 12
	syscall
	nop
urium.Console.readChar.out_char.endp:
	lw $v1 12($fp)
	nop
	sw $v0 0($v1)
	or $sp $0 $fp
	lw $ra 8($sp)
	lw $fp 4($sp)
	addiu $sp $sp 12
	jr $ra
	nop
	.end	urium.Console.readChar.out_char

