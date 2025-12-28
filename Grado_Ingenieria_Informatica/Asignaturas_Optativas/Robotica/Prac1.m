clc
clear all
mapa = [];
j = 0;
Amplitud = pi/2;
Delay = 2;
Periodo = 6;
tf = 10;
mi_Robot=legoev3('USB');
% Señal virtual :
tiempoSimulado = 0:0.5:tf;
y = signal_vf_v2(tiempoSimulado, Periodo, Delay, Amplitud);
punto = animatedline('Marker', '*');
%axis([0 10 0 1500]);
n = 1;
tstart = tic;
tiempoReal(n) = 0;
referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);
%% Definicion motor de la cabeza
motor_cabeza = motor(mi_Robot,'A');
start(motor_cabeza);
%% Necesario un reset
resetRotation(motor_cabeza)
giro_Cabeza(1)=double(readRotation(motor_cabeza));
%% Parar
%% solA: motor_cabeza.Speed=0;
%% solA: stop(motor_cabeza);
% Distancias - Sonar
 Sonar = sonicSensor(mi_Robot,4)

%while tiempoReal(n) < tf
while tiempoReal(n) < signal_vf_v2
    n = n + 1;
    tiempoReal(n) = toc(tstart);
    % tiempoReal(n)
    referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);
    %motor_cabeza.Speed=10;
    distancia(n) =double( readDistance(Sonar));
%% Controlar giro
giro_Cabeza(n)=double(readRotation(motor_cabeza));
    addpoints(punto,tiempoReal(n), distancia(n));%giro_Cabeza(n));
    drawnow
end
stop(motor_cabeza);
hold on;
plot(tiempoReal,giro_Cabeza);