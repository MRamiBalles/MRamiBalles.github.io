#------------------------------------------------------------------
# Program arguments
#------------------------------------------------------------------

	.data

	.globl	URIUM.PROGRAM.ARGC
	.align	2
URIUM.PROGRAM.ARGC:
	.word		0

	.globl	URIUM.PROGRAM.ARGV
	.align	2
URIUM.PROGRAM.ARGV:
	.word		0

#------------------------------------------------------------------
# Standard startup code
# Save the program arguments 'argc' (a0) and 'argv' (a1)  
# Invoke the procedure "Main.main"
#------------------------------------------------------------------

	.text
	.globl __start
__start:
	la t0, URIUM.PROGRAM.ARGC
	sw a0, 0(t0)
	la t0, URIUM.PROGRAM.ARGV
	sw a1, 0(t0)
	jal Main.main
	li a7, 10
	ecall			# ecall 10 (exit)

