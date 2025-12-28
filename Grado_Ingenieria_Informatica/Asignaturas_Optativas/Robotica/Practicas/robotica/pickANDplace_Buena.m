cla
clear all
close all
codigo = 1;
%Identificador = Iniciacion('RBDK', codigo)
% MoveJ_Robot_lab(angulos, aceleracion, velocidad, Identificador, codigo)
% MoveJ_Robot_lab([0, -3*pi/4, -pi/2, 0, 0, 0], 1, 1, Identificador, codigo)
% configuración pick y place
posicion_pick=[30 0 0];
alfa=0; beta=0; gamma=0;
  
matriz_pick_global = Desplazamiento(posicion_pick(1), posicion_pick(2), posicion_pick(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionz(gamma);
pinta_bloque(matriz_pick_global,'b')

posicion_place=[20 10 0];
alfa=0; beta=0; gamma=0;
matriz_place_global = Desplazamiento(posicion_place(1), posicion_place(2), posicion_place(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionz(gamma);
pinta_bloque(matriz_place_global,'r')

% Definicion del agarre y configuracion problema cinematico inverso
agarre2 = Desplazamiento(0,0,4)*Rotacionx(pi);
agarre3 = Desplazamiento(0,-0.8,4)*Rotacionx(-pi/2)*Rotacionz(pi/2);


codo=1;
avance=1;
simetrico=0;
%RG2_lab(110, Identificador, codigo) 
% Abrimos la pinza del robot
%for cont = 1:3

% Definicion conf pinza Pick y Place
matriz_pinza_pick_global = matriz_pick_global * agarre3;
matriz_pinza_place_global = matriz_place_global * agarre3;


% Configuracion de agarre calculada.

% Definicion movimientos: 
% Movimiento de aproximacion pick 
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_pick_global*Desplazamiento(0, 0, -5), codo, avance, simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], matriz_pinza_pick_global*Desplazamiento(0, 0, -5));
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)
pause
cla
pinta_piezas

% Movimiento de pick
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_pick_global, codo, avance, simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], matriz_pinza_pick_global);
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)

pause
cla
pinta_piezas
%RG2_lab(80, Identificador, codigo)

% Movimiento de despegue
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(Desplazamiento(0, 0, 5)*matriz_pinza_pick_global,codo,avance,simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], Desplazamiento(0, 0, 5)*matriz_pinza_pick_global);
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)
 
pause
cla
pinta_piezas

% Movimiento de aproximacion place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(Desplazamiento(0, 0, 5)*matriz_pinza_place_global,codo,avance,simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], Desplazamiento(0, 0, 5)*matriz_pinza_place_global);
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)

pause
cla
pinta_piezas

% Movimiento de place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_place_global, codo, avance, simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], matriz_pinza_place_global);
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)

pause
cla
pinta_piezas

% Movimiento de despegue place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_place_global*Desplazamiento(0, 0, -5),codo,avance,simetrico);
funcion_pinta_UR3_new([q1 q2 q3 q4 q5 q6], matriz_pinza_place_global*Desplazamiento(0, 0, -5));
pause
%MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], 1, 1, Identificador, codigo)
%   Actualizacion del pick & place
matriz_pick_global = matriz_pick_global*Desplazamiento(10,0,0);
matriz_place_global = matriz_place_global*Desplazamiento(10,0,0);

%end
%Ready_lab(Identificador, codigo)
