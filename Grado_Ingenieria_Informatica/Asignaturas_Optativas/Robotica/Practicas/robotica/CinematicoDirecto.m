clear all

matriz_pinza = eye(4) % matriz unidad
tiempo = 0;
posicion = [7 8 9 1]';
angulos = [pi/4 pi/2 pi/4];

q=[0 -1.5700 -1.5700 -1.5700 1.5700 0];
% matriz_pinza = Desplazamiento(posicion(1), posicion(2), posicion(3)) * Rotacionz(angulos(1))*Rotaciony(angulos(2))*Rotacionz(angulos(3))

matriz = funcion_pinta_UR3_new(q, matriz_pinza)

while tiempo < 20
    
    tiempo = tiempo + 1;
    matriz_pinza = Desplazamiento( posicion(1), posicion(2), posicion(3)) * Rotacionz(tiempo *angulos(1))*Rotaciony(angulos(2))*Rotacionz(angulos(3))
    
end
