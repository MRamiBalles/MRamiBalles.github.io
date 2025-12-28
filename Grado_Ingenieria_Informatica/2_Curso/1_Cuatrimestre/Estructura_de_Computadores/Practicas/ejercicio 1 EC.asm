.model small

.data

    cadena db 5,0,0,0,0,0,0
    peso db 8,4,2,1
    bin db 0
    comp1 db 0
    signoc1 db '+'
    
.code 
                     
    
    mov ax, seg cadena   
    mov ds, ax
    
    
    mov dx, offset cadena  
    mov ah, 0ah
    int 21h
    
    
    
    sub cadena [2], 48  
    sub cadena [3], 48
    sub cadena [4], 48
    sub cadena [5], 48
    
    
    
    
    mov al, cadena[2]
    mul peso[0]
    
    mov bl, al
                 
    mov al, cadena[3]
    mul peso[1]
    add bl, al 
    
    mov al, cadena[4]
    mul peso[2]
    add bl, al
    
    mov al, cadena[5]
    mul peso[3]
    add bl, al
    
    mov bin,bl
    
    
    
    
    cmp cadena[2],1
    je negativo 
    
    jmp fin 
    
    
    negativo:   
    
    mov al,cadena [3]
    not al    
    and al, 00000001b
    mov cadena[3],al
    
    mov al,cadena [4]
    not al         
    and al, 00000001b
    mov cadena[4],al
    
    mov al,cadena [5]
    not al           
    and al, 00000001b
    mov cadena[5],al
    
    
    mov signoc1, '-'
    
    
    fin: 
    
    mov bx, 0
    mov al, cadena[3]
    mul peso[1]
    add bl, al 
    
    mov al, cadena[4]
    mul peso[2]
    add bl, al
    
    mov al, cadena[5]
    mul peso[3]
    add bl, al
    
    mov comp1,bl
    
    
    
    mov ax,0b800h
    mov es, ax
    
    
    mov ah, 00001111b
    
    mov al, 'B'
    mov es:[160], ax
    mov al, 'N'
    mov es:[162], ax
    mov al, ':'
    mov es:[164], ax
    mov ah, 0
    mov al, bin
    mov bl, 10d
    div bl
    add al, 48
    mov es:[166], al
    add ah, 48
    mov es:[168], ah
    
    
    mov ah, 00001111b
    mov al, 'C'
    mov es:[320], ax
    mov al, '1'
    mov es:[322], ax
    mov al, ':'
    mov es:[324], ax
    mov al, signoc1
    mov es:[326], ax
    mov al, comp1
    add al, 48
    mov es:[328], ax
    
    
                           
       
    mov ah, 4Ch
    int 21h  
end
    


