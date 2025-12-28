#------------------------------------------------------------------
# Copyright (c) 2024, Francisco J. Moreno Velo                   
# All rights reserved.                                             
#------------------------------------------------------------------

#------------------------------------------------------------------
# urium.Program.getArgCount.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getArgCount.out_int
	.ent	urium.Program.getArgCount.out_int
urium.Program.getArgCount.out_int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $v0 URIUM.PROGRAM.ARGC
	lw $v1 8($fp)
	nop
	sw $v0 0($v1)
urium.Program.getArgCount.out_int.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Program.getArgCount.out_int

#------------------------------------------------------------------
# urium.Program.getArgLength.int.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getArgLength.int.out_int
	.ent	urium.Program.getArgLength.int.out_int
urium.Program.getArgLength.int.out_int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $v1 8($fp)
	lw $v0 URIUM.PROGRAM.ARGC
	slt $a0 $v1 $0	
	bne $a0 $0 urium.Program.getArgLength.int.out_int.9
	nop
	sltu $a0 $v1 $v0
	bne $a0 $0 urium.Program.getArgLength.int.out_int.1
	nop
urium.Program.getArgLength.int.out_int.9:
	lw $v1 12($fp)
	addiu $v0 $0 -1
	sw $v0 0($v1)
	j urium.Program.getArgLength.int.out_int.endp
	nop	
urium.Program.getArgLength.int.out_int.1:
	lw $a0 8($fp)
	lw $v0 URIUM.PROGRAM.ARGV
	sll $a0 $a0 2
	addu $v0 $v0 $a0
	lw $v1 0($v0)
	ori $a0 $0 0
urium.Program.getArgLength.int.out_int.2:
	addu $v0 $v1 $a0
	lb $a1 0($v0)
	nop
	beq $a1 $0 urium.Program.getArgLength.int.out_int.3
	nop
	addiu $a0 $a0 1
	j urium.Program.getArgLength.int.out_int.2
	nop
urium.Program.getArgLength.int.out_int.3:
	lw $v1 12($fp)
	nop
	sw $a0 0($v1)
urium.Program.getArgLength.int.out_int.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Program.getArgLength.int.out_int

#------------------------------------------------------------------
# urium.Program.getIntArg.int.out_int
#------------------------------------------------------------------

	.globl	urium.Program.getIntArg.int.out_int
	.ent	urium.Program.getIntArg.int.out_int
urium.Program.getIntArg.int.out_int:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $v1 8($fp)
	lw $v0 URIUM.PROGRAM.ARGC
	slt $a0 $v1 $0	
	bne $a0 $0 urium.Program.getIntArg.int.out_int.3
	nop
	sltu $a0 $v1 $v0
	beq $a0 $0 urium.Program.getIntArg.int.out_int.3
	nop
	lw $v0 URIUM.PROGRAM.ARGV
	sll $v1 $v1 2
	addu $v0 $v0 $v1
	lw $v1 0($v0)
	ori $a2 $0 0 
	ori $a0 $0 0 
urium.Program.getIntArg.int.out_int.1:
	addu $v0 $v1 $a0
	lb $a1 0($v0)
	nop
	beq $a1 $0 urium.Program.getIntArg.int.out_int.2
	nop
	ori $v0 $0 48
	sltu $v0 $a1 $v0
	bne $v0 $0 urium.Program.getIntArg.int.out_int.3
	nop
	ori $v0 $0 57
	sltu $v0 $v0 $a1
	bne $v0 $0 urium.Program.getIntArg.int.out_int.3
	nop
	ori $v0 $0 10
	mul $a2 $a2 $v0
	ori $v0 $0 48
	subu $v0 $a1 $v0
	addu $a2 $a2 $v0
	addiu $a0 $a0 1
	j urium.Program.getIntArg.int.out_int.1
	nop	
urium.Program.getIntArg.int.out_int.2:	
	lw $v1 12($fp)
	nop
	sw $a2 0($v1)
	j urium.Program.getIntArg.int.out_int.endp
	nop
urium.Program.getIntArg.int.out_int.3:
	lw $v1 12($fp)
	addiu $v0 $0 -1
	sw $v0 0($v1)
urium.Program.getIntArg.int.out_int.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Program.getIntArg.int.out_int

#------------------------------------------------------------------
# urium.Program.getCharArg.int.int.out_char
#------------------------------------------------------------------

	.globl	urium.Program.getCharArg.int.int.out_char
	.ent	urium.Program.getCharArg.int.int.out_char
urium.Program.getCharArg.int.int.out_char:
	addiu $sp $sp -8
	sw $ra 4($sp)
	sw $fp 0($sp)
	or $fp $0 $sp
	lw $v1 8($fp)
	lw $v0 URIUM.PROGRAM.ARGC
	slt $a0 $v1 $0	
	bne $a0 $0 urium.Program.getCharArg.int.int.out_char.4
	nop
	sltu $a0 $v1 $v0
	beq $a0 $0 urium.Program.getCharArg.int.int.out_char.4
	nop
urium.Program.getCharArg.int.int.out_char.1:
	lw $a0 8($fp)
	lw $v0 URIUM.PROGRAM.ARGV
	sll $a0 $a0 2
	addu $v0 $v0 $a0
	lw $v1 0($v0)
	lw $a1 12($fp)
	nop
	slt $a0 $a1 $0	
	bne $a0 $0 urium.Program.getCharArg.int.int.out_char.4
	nop
	ori $a0 $0 0
urium.Program.getCharArg.int.int.out_char.2:
	addu $v0 $v1 $a0
	lb $a2 0($v0)
	beq $a0 $a1 urium.Program.getCharArg.int.int.out_char.3
	nop
	beq $a2 $0 urium.Program.getCharArg.int.int.out_char.4
	nop
	addiu $a0 $a0 1
	j urium.Program.getCharArg.int.int.out_char.2
	nop
urium.Program.getCharArg.int.int.out_char.3:
	lw $v0 16($fp)
	nop
	sw $a2 0($v0)
	j urium.Program.getCharArg.int.int.out_char.endp
	nop
urium.Program.getCharArg.int.int.out_char.4:
	lw $v1 16($fp)
	ori $v0 $0 0
	sw $v0 0($v1)
urium.Program.getCharArg.int.int.out_char.endp:
	or $sp $0 $fp
	lw $ra 4($sp)
	lw $fp 0($sp)
	addiu $sp $sp 8
	jr $ra
	nop
	.end	urium.Program.getCharArg.int.int.out_char

#------------------------------------------------------------------
# urium.Program.exit.int
#------------------------------------------------------------------

	.globl	urium.Program.exit.int
	.ent	urium.Program.exit.int
urium.Program.exit.int:
	lw $a0 0($sp)
	li $v0 17
	syscall			# syscall 17 ( exit2(result) )
	nop
	.end	urium.Program.exit.int
