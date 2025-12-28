cla
clear all
% configuración de la pieza
posicion=[20 -10 0];
alfa=0; beta=-pi/3; gamma=pi/6;
  
matriz_pieza=Desplazamiento(posicion(1), posicion(2), posicion(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionx(gamma);

%pinta_pieza_delgada(matriz_pieza)
pinta_bloque(matriz_pieza,'b')

matriz_agarre = Desplazamiento(0,0,4) * Rotaciony(pi)*Rotacionz(-pi/2);
matriz_pinza = matriz_pieza * matriz_agarre;
q=[0 -1.5700 -1.5700 -1.5700 1.5700 0];

matriz = funcion_pinta_UR3_new(q, matriz_pinza)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

cla
clear all
% configuración de la pieza
posicion=[20 -10 0]; % Error si [20 -50 0]
alfa=pi/2; beta=0; gamma=-pi/2; % error si pi/3
  
matriz_pieza=Desplazamiento(posicion(1), posicion(2), posicion(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionx(gamma);

%pinta_pieza_delgada(matriz_pieza)
pinta_bloque(matriz_pieza,'b')

matriz_agarre = Desplazamiento(0,0,4) * Rotaciony(pi)*Rotacionz(-pi/2);
matriz_pinza = matriz_pieza * matriz_agarre;

% resuelvo el problema cinemático inverso
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza,1,1,1);

matriz = funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], matriz_pinza)




 
 

