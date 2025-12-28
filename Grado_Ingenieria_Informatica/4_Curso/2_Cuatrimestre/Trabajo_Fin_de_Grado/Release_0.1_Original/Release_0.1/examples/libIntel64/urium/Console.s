;------------------------------------------------------------------
; Copyright (c) 2024, Francisco J. Moreno Velo                   
; All rights reserved.                                             
;------------------------------------------------------------------

extrn GetStdHandle: PROC
extrn WriteFile: PROC
extrn ReadFile: PROC

.data
  urium_Console_print_char_msg db 'AB', 0
  Written db 0

.code

;------------------------------------------------------------------
; urium_Console_print_char
;------------------------------------------------------------------

urium_Console_print_char PROC
	LEA rax, [urium_Console_print_char_msg]
	MOV bl, byte ptr [rsp+8]
	MOV [rax],bl
	SUB rsp, 32
	MOV rcx, -11
	CALL GetStdHandle
	ADD rsp, 32
	SUB rsp, 48
	MOV rcx, rax
	LEA rdx, [urium_Console_print_char_msg]
	MOV r8, 1
	LEA r9, [Written]
 	MOV qword ptr [rsp + 4 * 8], 0
	CALL WriteFile
	ADD rsp, 48
	RET 0
urium_Console_print_char ENDP 

;------------------------------------------------------------------
; urium_Console_print_digit
;------------------------------------------------------------------

urium_Console_print_digit PROC
	LEA rax, [urium_Console_print_char_msg]
	MOV ebx, dword ptr [rsp+8]
	MOV ecx, '0'
	ADD ecx, ebx
	MOV [rax],ecx
	SUB rsp, 32
	MOV rcx, -11
	CALL GetStdHandle
	ADD rsp, 32
	SUB rsp, 48
	MOV rcx, rax
	LEA rdx, [urium_Console_print_char_msg]
	MOV r8, 1
	LEA r9, [Written]
 	MOV qword ptr [rsp + 4 * 8], 0
	CALL WriteFile
	ADD rsp, 48
	RET 0
urium_Console_print_digit ENDP 

;------------------------------------------------------------------
; urium_Console_digits_int
;------------------------------------------------------------------

urium_Console_digits_int PROC
	PUSH rbp
	MOV rbp, rsp
	MOV eax, dword ptr [rbp+16]
	MOV ecx, 10
	MOV ebx, 1000000000
	CMP eax, ebx
	JG urium_Console_digits_int_endp
	MOV ecx, 1
	MOV ebx, 10
	CMP eax, ebx
	JL urium_Console_digits_int_endp
urium_Console_digits_int_1:
	ADD ecx, 1
	IMUL ebx, 10
	CMP eax, ebx
	JL urium_Console_digits_int_endp
	JMP urium_Console_digits_int_1
urium_Console_digits_int_endp:
	MOV eax, ecx
	MOV rsp, rbp
	POP rbp
	RET
urium_Console_digits_int ENDP

;------------------------------------------------------------------
; Console_power10_int
;------------------------------------------------------------------

urium_Console_power10_int PROC
	PUSH rbp
	MOV rbp, rsp
	MOV eax, dword ptr [rbp+16]
	MOV ecx, 0
	MOV ebx, 9
	CMP eax, ebx
	JG urium_Console_power10_int_endp
	MOV ebx, 1
	MOV ecx, 10
	CMP eax, ebx
	JE urium_Console_power10_int_endp
urium_Console_power10_int_1:
	IMUL ecx, 10
	ADD ebx, 1
	CMP eax, ebx
	JE urium_Console_power10_int_endp
	JMP urium_Console_power10_int_1
urium_Console_power10_int_endp:
	MOV eax, ecx
	MOV rsp, rbp
	POP rbp
	RET
urium_Console_power10_int ENDP

;------------------------------------------------------------------
; urium_Console_print_int
;------------------------------------------------------------------

urium_Console_print_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp
	MOV eax, dword ptr [rbp+48]
	MOV ebx, 0
	CMP eax, ebx
	JL urium_Console_print_int_1
	JMP urium_Console_print_int_2
urium_Console_print_int_1:
	SUB rsp, 4
	MOV eax, 45
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_char
	ADD rsp, 4
	MOV eax, dword ptr [rbp+48]
	NEG eax
	MOV dword ptr [rbp+48], eax
urium_Console_print_int_2:
	SUB rsp, 4
	MOV eax, dword ptr [rbp+48]
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_digits_int
	ADD rsp, 4
	MOV dword ptr [rbp+0], eax
urium_Console_print_int_3:
	MOV eax, dword ptr [rbp+0]
	MOV ebx, 1
	CMP eax, ebx
	JG urium_Console_print_int_4
	JMP urium_Console_print_int_5
urium_Console_print_int_4:
	SUB rsp, 4
	MOV eax, dword ptr [rbp+0]
	SUB eax, 1
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_power10_int
	ADD rsp, 4
	MOV dword ptr [rbp+8], eax
	MOV eax, dword ptr [rbp+48]
	MOV ebx, dword ptr [rbp+8]
	MOV edx, 0
	IDIV ebx
	MOV dword ptr [rbp+16], eax
	SUB rsp, 4
	MOV eax, dword ptr [rbp+16]
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_digit
	ADD rsp, 4
	MOV eax, dword ptr [rbp+48]
	MOV ebx, dword ptr [rbp+8]
	MOV edx, 0
	IDIV ebx
	MOV dword ptr [rbp+48], edx
	MOV eax, dword ptr [rbp+0]
	SUB eax, 1
	MOV dword ptr [rbp+0], eax
	JMP urium_Console_print_int_3
urium_Console_print_int_5:
	SUB rsp, 4
	MOV eax, dword ptr [rbp+48]
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_digit
	ADD rsp, 4
urium_Console_print_int_endp:
	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET
urium_Console_print_int ENDP

;------------------------------------------------------------------
; urium_Console_printBits_int
;------------------------------------------------------------------

urium_Console_printBits_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp
	MOV r15d, 31
urium_Console_printBits_int_1:
	MOV eax, dword ptr [rbp+48]
	BT eax, r15d
	JC urium_Console_printBits_int_2
	SUB rsp, 4
	MOV eax, '0'
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_char
	ADD rsp, 4
	JMP urium_Console_printBits_int_3
urium_Console_printBits_int_2:
	SUB rsp, 4
	MOV eax, '1'
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_char
	ADD rsp, 4
urium_Console_printBits_int_3:
	SUB r15d, 1
	JNS urium_Console_printBits_int_1
urium_Console_printBits_int_endp:
	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET
urium_Console_printBits_int ENDP

;------------------------------------------------------------------
; urium_Console_printHex_int
;------------------------------------------------------------------

urium_Console_printHex_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp
	MOV r15, 28
urium_Console_printHex_int_1:
	MOV cl, r15b
	MOV eax, dword ptr [rbp+48]
	SAR eax, cl
	AND eax, 15
	CMP eax, 10
	JGE urium_Console_printHex_int_2
	SUB rsp, 4
	ADD eax, '0'
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_char
	ADD rsp, 4
	JMP urium_Console_printHex_int_3
urium_Console_printHex_int_2:
	SUB rsp, 4
	ADD eax, 55
	MOV dword ptr [rsp+0], eax
	CALL urium_Console_print_char
	ADD rsp, 4
urium_Console_printHex_int_3:
	SUB r15, 4
	JNS urium_Console_printHex_int_1
urium_Console_printHex_int_endp:
	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET
urium_Console_printHex_int ENDP

;------------------------------------------------------------------
; urium_Console_readChar
;------------------------------------------------------------------

urium_Console_readChar PROC
	LEA rax, [urium_Console_print_char_msg]
	MOV bl, byte ptr [rsp+8]
	MOV [rax],bl
	SUB rsp, 32
	MOV rcx, -10
	CALL GetStdHandle
	ADD rsp, 32
	SUB rsp, 48
	MOV rcx, rax
	LEA rdx, [urium_Console_print_char_msg]
	MOV r8, 1
	LEA r9, [Written]
 	MOV qword ptr [rsp + 4 * 8], 0
	CALL ReadFile
	ADD rsp, 48
	MOV rax, 0
	MOV al, byte ptr [urium_Console_print_char_msg]
	RET 
urium_Console_readChar ENDP 

;------------------------------------------------------------------
; urium_Console_readChar_out_char
;------------------------------------------------------------------

urium_Console_readChar_out_char PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

	LEA rax, [urium_Console_print_char_msg]
	MOV bl, byte ptr [rsp+8]
	MOV [rax],bl
	SUB rsp, 32
	MOV rcx, -10
	CALL GetStdHandle
	ADD rsp, 32
	SUB rsp, 48
	MOV rcx, rax
	LEA rdx, [urium_Console_print_char_msg]
	MOV r8, 1
	LEA r9, [Written]
 	MOV qword ptr [rsp + 4 * 8], 0
	CALL ReadFile
	ADD rsp, 48
	MOV rax, 0
	MOV al, byte ptr [urium_Console_print_char_msg]

	MOV rbx, qword ptr [rbp+48]
	MOV dword ptr[rbx+0], eax

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Console_readChar_out_char ENDP 

;------------------------------------------------------------------
; urium_Console_readInt_out_int
;------------------------------------------------------------------

urium_Console_readInt_out_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp
	MOV eax, 0
	MOV dword ptr [rbp+0], eax
	CALL urium_Console_readChar
	MOV dword ptr [rbp+8], eax
urium_Console_readInt_out_int_1:
	MOV eax, dword ptr [rbp+8]
	MOV ebx, 32
	CMP eax, ebx
	JNE urium_Console_readInt_out_int_3
urium_Console_readInt_out_int_2:
	CALL urium_Console_readChar
	MOV dword ptr [rbp+8], eax
	JMP urium_Console_readInt_out_int_1
urium_Console_readInt_out_int_3:
	MOV eax, dword ptr [rbp+8]
	MOV ebx, 9
	CMP eax, ebx
	JE urium_Console_readInt_out_int_2
urium_Console_readInt_out_int_4:
	MOV eax, dword ptr [rbp+8]
	MOV ebx, 48
	CMP eax, ebx
	JL urium_Console_readInt_out_int_5
	MOV eax, dword ptr [rbp+8]
	MOV ebx, 57
	CMP eax, ebx
	JG urium_Console_readInt_out_int_5
	MOV eax, dword ptr [rbp+0]
	MOV ebx, 10
	IMUL eax, ebx
        MOV ebx, dword ptr [rbp+8]
        SUB ebx, '0'
	ADD eax, ebx
	MOV dword ptr [rbp+0], eax
	CALL urium_Console_readChar
	MOV dword ptr [rbp+8], eax
	JMP urium_Console_readInt_out_int_4
urium_Console_readInt_out_int_5:
	MOV eax, dword ptr [rbp+8]
	MOV ebx, 10
	CMP eax, ebx
	JE urium_Console_readInt_out_int_endp
	CALL urium_Console_readChar
	MOV dword ptr [rbp+8], eax
	JMP urium_Console_readInt_out_int_5
urium_Console_readInt_out_int_endp:
	MOV eax, dword ptr [rbp+0]

	MOV rbx, qword ptr [rbp+48]
	MOV dword ptr[rbx+0], eax

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET
urium_Console_readInt_out_int ENDP
