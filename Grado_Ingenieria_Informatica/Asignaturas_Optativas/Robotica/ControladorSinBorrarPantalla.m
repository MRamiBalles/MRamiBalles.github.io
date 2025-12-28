clear all
clc

% Para dibujar la señal de referencia :
j = 0;
Amplitud = pi/2;
Delay = 2;
Periodo = 6;
tf = 4*pi;
% Señal virtual :
tiempoSimulado = 0:0.05:tf;
y = signal_vf_v2(tiempoSimulado, Periodo, Delay, Amplitud);
plot(tiempoSimulado, y, '.r');
punto = animatedline('Marker', '*');
n = 1;
tstart = tic;
tiempoReal(n) = 0;
% referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);


while tiempoReal(n) < tf
    n = n + 1;
    tiempoReal(n) = toc(tstart);
    % tiempoReal(n)
    referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);
   
    % EN EL FUTURO :
    % Leer posición del motor
    % Calcular acción de control a partir de la referencia
    % Mandar la acción de control al ladrillo (tensión)
    grid on
    title('Gráfica Tiempo')
    xlabel('Rango', 'FontSize', 16,'FontWeight','bold');
    ylabel('Amplitud', 'FontSize', 16,'FontWeight','bold');
    clearpoints(punto);
    addpoints(punto, tiempoReal(n), referencia(n));
    axis([0 tf -Amplitud-1 Amplitud+1]);
    drawnow
end
