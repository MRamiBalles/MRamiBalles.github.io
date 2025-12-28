clear all
clc

% Para dibujar la señal de referencia :
j = 0;
Amplitud = pi/2;
Delay = 2;
Periodo = 6;
Rango = 4*pi;

% Señal virtual :
tiempoSimulado = 0:0.1:Rango;
y = signal_vf_v2(tiempoSimulado, Periodo, Delay, Amplitud);
% plot(tiempoVirtual, y, '_r');

n = 1;
tiempoReal(n) = 0;
referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);

tstart = tic;
while tiempoReal(n) < Rango
    n = n + 1;
    tiempoReal(n) = toc(tstart);
    % tiempoReal(n)
    referencia(n) = signal_vf_v2(tiempoReal(n), Periodo, Delay, Amplitud);
  
    % EN EL FUTURO :
    % Leer posición del motor
    % Calcular acción de control a partir de la referencia
    % Mandar la acción de control al ladrillo (tensión)

    cla % Borrar la pantalla
    grid on
    title('Gráfica Tiempo')
    xlabel('Rango', 'FontSize', 16,'FontWeight','bold');
    ylabel('Amplitud', 'FontSize', 16,'FontWeight','bold');
    plot(tiempoSimulado, y, '.b') % Dibujamos el seno
    hold on
    plot(tiempoReal(n), referencia(n), 'Or') % Dibujamos el punto que recorre el seno
    axis([0 Rango -(Amplitud+1) (Amplitud+1)])
    drawnow
end
