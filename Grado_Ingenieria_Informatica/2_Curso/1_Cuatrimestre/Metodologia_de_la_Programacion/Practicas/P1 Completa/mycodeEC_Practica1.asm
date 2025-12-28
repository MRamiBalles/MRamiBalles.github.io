.model small ;1 segmento para datos y otro para codigo

.data 

    cadena db 5,0,0,0,0,0,0
    pesobn db 8,4,2,1
    pesoc1 db 7,4,2,1
    
.code   
    
    mov ax, seg cadena    ;inicializacion
    mov ds, ax
    
    mov dx, offset cadena ;desplazamiento en el seg datos para almacenar caracteres
    mov ah, 0ah  ;obtener una linea de datos del teclado 
    int 21h    ;interrupcion 0x21
    
    sub cadena[2], 48 ;Conversion de ASCII a binario
    sub cadena[3], 48
    sub cadena[4], 48
    sub cadena[5], 48
    
    ;cmp cont, 0
    ;je fin
    
     
    mov al, cadena[3]
    mul pesobn[1] 
    
    mov bl, al 
    
    mov al, cadena[4]
    mul pesobn[2]
    add bl, al
    
    mov al, cadena[5]
    mul pesobn[3]
    add bl, al
    
    ;mov dh, bl
    
    ;mov al, cadena[2]
    ;mul pesobn[0]
    ;add bl, al  
    
    
    mov al, cadena[2]
    mul pesoc1[0] 
    sub bl, al
    ;mov bx, dh
    
    
    
    
    
    
    
    
    mov ax, bx
    mov bl, 10
                ;en ah se almacena el resto (unidad) y en al el cociente
    div bl
    mov cl, al
    add cl, 48  
    mov ch, ah
    add ch, 48    
    
    
    ;mov al, cadena[2]
    ;mul pesoc1[0] 
    ;sub dh, al
    ;mov bl, dh 
    
    
    ;mov ax, bx
    ;mov bl, 10
                ;en ah se almacena el resto (unidad) y en al el cociente
    ;div bl
    ;mov cl, al
    ;add cl, 48  
    ;mov ch, ah
    ;add ch, 48
    
    
    ;establece modo texto de pantalla para imprimir los digitos en decimal
    
    mov al, 03h
    mov ah, 00h
    int 10h
    
    mov ax, 0b800h
    mov es, ax
    mov di, 0
    
    mov ah, 00001111b     ;fondo negro y texto blanco
    mov al, cl
    mov es:[di], ax
    mov al, ch
    mov es:[di+2], ax
    
    mov ah, 00h
    int 16h
    
;fin

    mov ah, 4ch  ; Esta rutina finalizara el programa y devolvera el control al DOS.
    int 21h
    
end
    

