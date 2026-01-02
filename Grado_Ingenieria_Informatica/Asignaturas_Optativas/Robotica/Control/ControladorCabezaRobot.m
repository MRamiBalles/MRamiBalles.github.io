clc
clear all
mapa = [];
j = 0;
Amplitud = pi/2;
Delay = 2;
Periodo = 6;
tf = 4*pi;
% Señal virtual :
tiempoSimulado = 0:0.05:tf;
y = signal_vf_v2(tiempoSimulado, Periodo, Delay, Amplitud);
punto = animatedline('Marker', '*');
n = 1;
tstart = tic;
tiempoReal(n) = 0;
referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);

while tiempoReal(n) < tf
    n = n + 1;
    tiempoReal(n) = toc(tstart);
    % tiempoReal(n)
    referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);
    hold on
    mapa_out = pinta_robot_v3(0, 0, pi/2, referencia(n), 5, mapa)
    drawnow
end
