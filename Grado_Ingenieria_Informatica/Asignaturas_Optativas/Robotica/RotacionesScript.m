I = eye(4);
posicion = [7 8 9 1]';
angulos = [pi/4 pi/2 pi/4];

pinta_bloque(I, 'b');

Matriz_Configuracion = Desplazamiento(posicion(1), posicion(2), posicion(3)) * Rotacionz(angulos(1))*Rotaciony(angulos(2))*Rotacionz(angulos(3))
pinta_bloque(Matriz_Configuracion, 'r');
xlabel('X')
ylabel('Y')
zlabel('Z')

pLocal1 = [1.5 1.5 6 1]'; %coordenadas de un vertice en la posicion inicial
pLocal2 = [1.5 -1.5 6 1]';
pLocal3 = [-1.5 1.5 6 1]';
pLocal4 = [-1.5 -1.5 6 1]';
pLocal5 = [1.5 1.5 0 1]';
pLocal6 = [1.5 -1.5 0 1]';
pLocal7 = [-1.5 1.5 0 1]';
pLocal8 = [-1.5 -1.5 0 1]';

pGlobal1 = Matriz_Configuracion*pLocal1
plot3(pGlobal1(1), pGlobal1(2), pGlobal1(3), '*k')

hold on

pGlobal2 = Matriz_Configuracion*pLocal2
plot3(pGlobal2(1), pGlobal2(2), pGlobal2(3), '*k')
pGlobal3 = Matriz_Configuracion*pLocal3
plot3(pGlobal3(1), pGlobal3(2), pGlobal3(3), '*k')
pGlobal4 = Matriz_Configuracion*pLocal4
plot3(pGlobal4(1), pGlobal4(2), pGlobal4(3), '*k')
pGlobal5 = Matriz_Configuracion*pLocal5
plot3(pGlobal5(1), pGlobal5(2), pGlobal5(3), '*k')
pGlobal6 = Matriz_Configuracion*pLocal6
plot3(pGlobal6(1), pGlobal6(2), pGlobal6(3), '*k')
pGlobal7 = Matriz_Configuracion*pLocal7
plot3(pGlobal7(1), pGlobal7(2), pGlobal7(3), '*k')
pGlobal8 = Matriz_Configuracion*pLocal8
plot3(pGlobal8(1), pGlobal8(2), pGlobal8(3), '*k')
