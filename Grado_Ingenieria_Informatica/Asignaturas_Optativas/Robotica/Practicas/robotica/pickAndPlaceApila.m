cla
clear all
close all
codigo = 03;
% Identificador = Iniciacion('RBDK', codigo)
Identificador = Iniciacion('Robot_1', codigo)
velocidad = 4.5; aceleracion = 0.5;
% MoveJ_Robot_lab([0, -3*pi/4, -pi/2, 0, 0, 0], 1, 1, Identificador, codigo)
% configuración pick y place
posicion_pick = [20 -10 0];
alfa=0; beta=0; gamma=0;
  
matriz_pick_global = Desplazamiento(posicion_pick(1), posicion_pick(2), posicion_pick(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionz(gamma);

posicion_place=[20 10 0];
alfa=0; beta=0; gamma=0;
matriz_place_global = Desplazamiento(posicion_place(1), posicion_place(2), posicion_place(3))*Rotacionz(alfa)*Rotaciony(beta)*Rotacionz(gamma);

% Definicion del agarre y configuracion problema cinematico inverso
agarre2 = Desplazamiento(0,0,4)*Rotacionx(pi);
agarre3 = Desplazamiento(0,-0.8,4)*Rotacionx(-pi/2)*Rotacionz(pi/2);


codo=1;
avance=1;
simetrico=0;
RG2_lab(110, Identificador, codigo) 
% Abrimos la pinza del robot
for cont = 1:3
% Definicion conf pinza Pick y Place
matriz_pinza_pick_global = matriz_pick_global * agarre2;
matriz_pinza_place_global = matriz_place_global * agarre2;


% Configuracion de agarre calculada.

% Definicion movimientos: 
% Movimiento de aproximacion pick 
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_pick_global*Desplazamiento(0, 0, -5), codo, avance, simetrico);
MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)


% Movimiento de pick
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_pick_global, codo, avance, simetrico);
MoveL_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)

RG2_lab(25, Identificador, codigo)

% Movimiento de despegue
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(Desplazamiento(0, 0, 5)*matriz_pinza_pick_global,codo,avance,simetrico);
MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)

% Movimiento de aproximacion place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(Desplazamiento(0, 0, 5)*matriz_pinza_place_global,codo,avance,simetrico);
MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)

% Movimiento de place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_place_global, codo, avance, simetrico);
MoveL_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)
RG2_lab(110, Identificador, codigo) 

% Movimiento de despegue place
[q1,q2,q3,q4,q5,q6] = inv_kinema_ur3_new(matriz_pinza_place_global*Desplazamiento(0, 0, -5),codo,avance,simetrico);
MoveJ_Robot_lab([q1 q2 q3 q4 q5 q6], aceleracion, velocidad, Identificador, codigo)

%   Actualizacion del pick & place
matriz_pick_global = matriz_pick_global*Desplazamiento(10,0,0);
if cont == 2
        matriz_place_global = matriz_place_global*Desplazamiento(-1.5,0,6);
    else 
        matriz_place_global = matriz_place_global*Desplazamiento(3,0,0);
    end
end
Ready_lab(Identificador, codigo)