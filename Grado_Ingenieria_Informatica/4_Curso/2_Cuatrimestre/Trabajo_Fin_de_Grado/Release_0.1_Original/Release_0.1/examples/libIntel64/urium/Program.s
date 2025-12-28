;------------------------------------------------------------------
; Copyright (c) 2024, Francisco J. Moreno Velo                   
; All rights reserved.                                             
;------------------------------------------------------------------

;------------------------------------------------------------------
; urium_Program_getArgCount_out_int
;------------------------------------------------------------------

urium_Program_getArgCount_out_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

	MOV eax, dword ptr[urium_Program_argc]
	MOV rbx, qword ptr[rbp+48]
	MOV dword ptr[rbx+0], eax

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Program_getArgCount_out_int ENDP  

;------------------------------------------------------------------
; urium_Program_getArgLength_int_out_int
;------------------------------------------------------------------

urium_Program_getArgLength_int_out_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

	MOV eax, dword ptr[rbp+48]
	MOV ebx, 0
	CMP eax, ebx
	JL urium_Program_getArgLength_int_out_int_9
	MOV ebx, dword ptr[urium_Program_argc]
	CMP eax, ebx
	JGE urium_Program_getArgLength_int_out_int_9
	MOV rdx, qword ptr[urium_Program_argv]
	MOV eax, dword ptr[rbp+48]
	SHL rax, 3
	ADD rdx, rax 
	MOV rbx, qword ptr[rdx]
	MOV eax, 0
	MOV dx, 0
urium_Program_getArgLength_int_out_int_1:
	MOV cx, word ptr[rbx]
	CMP cx, dx
	JE urium_Program_getArgLength_int_out_int_endp
	ADD eax, 1
	ADD rbx, 2
	JMP urium_Program_getArgLength_int_out_int_1
urium_Program_getArgLength_int_out_int_9:
	MOV eax, -1
urium_Program_getArgLength_int_out_int_endp:
	MOV rbx, qword ptr[rbp+52]
	MOV dword ptr[rbx+0], eax

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Program_getArgLength_int_out_int ENDP  

;------------------------------------------------------------------
; urium_Program_getIntArg_int_out_int
;------------------------------------------------------------------

urium_Program_getIntArg_int_out_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

;

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Program_getIntArg_int_out_int ENDP  

;------------------------------------------------------------------
; urium_Program_getCharArg_int_int_out_char
;------------------------------------------------------------------

urium_Program_getCharArg_int_int_out_char PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

	MOV eax, dword ptr[rbp+48]
	MOV ebx, 0
	CMP eax, ebx
	JL urium_Program_getCharArg_int_int_out_char_9
	MOV ebx, dword ptr[urium_Program_argc]
	CMP eax, ebx
	JGE urium_Program_getCharArg_int_int_out_char_9
	MOV rdx, qword ptr[urium_Program_argv]
	MOV eax, dword ptr[rbp+48]
	SHL rax, 3
	ADD rdx, rax 
	MOV rbx, qword ptr[rdx]

; en rbx está el puntero a argv[i]
	MOV eax, dword ptr[rbp+52]
	MOV edx, 0
	CMP eax, edx
	JL urium_Program_getCharArg_int_int_out_char_9
; si el índice del caracter es negativo saltar al error


urium_Program_getCharArg_int_int_out_char_9:
	MOV eax, 0
urium_Program_getCharArg_int_int_out_char_endp:
	MOV rbx, qword ptr[rbp+56]
	MOV dword ptr[rbx+0], eax
	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Program_getCharArg_int_int_out_char ENDP  

;------------------------------------------------------------------
; urium_Program_exit_int
;------------------------------------------------------------------

urium_Program_exit_int PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

;

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET 
urium_Program_exit_int ENDP  
