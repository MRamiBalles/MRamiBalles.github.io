
extrn ExitProcess: PROC   ; external functions in system libraries
extrn GetCommandLineW: PROC 
extrn CommandLineToArgvW: PROC

;------------------------------------------------------------------
; Program arguments
;------------------------------------------------------------------

.data

	urium_Program_argc dd 0
	urium_Program_argv dq 0

;------------------------------------------------------------------
; Standard startup code
; Save the program arguments: 'argc' and 'argv'
; Invoke the procedure "Main.main"
;------------------------------------------------------------------

;
; LPWSTR GetCommandLineW();
;
; LPWSTR * CommandLineToArgvW(
;  [in]  LPCWSTR lpCmdLine, 
;  [out] int     *pNumArgs
; );
;


.code

Start PROC
	PUSH rbp
	SUB rsp, 32
	MOV rbp, rsp

	CALL GetCommandLineW
	SUB rsp, 32
	MOV rcx, rax
	LEA rdx, dword ptr[rsp+0]
	CALL CommandLineToArgvW
	MOV ebx, dword ptr[rsp+0]
	ADD rsp, 32
	MOV dword ptr[urium_Program_argc], ebx
	MOV qword ptr[urium_Program_argv], rax

	CALL Main_main
	CALL ExitProcess

	MOV rsp, rbp
	ADD rsp, 32
	POP rbp
	RET
Start ENDP
