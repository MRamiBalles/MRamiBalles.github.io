clear all
clc
tiempoVirtual = 0:0.1:2*pi;
y = signalv0(tiempoVirtual);
plot(tiempoVirtual, y);
n  = 1;
tstart = tic;
tiempoReal = toc(tstart);
while tiempoReal < 2*pi
    n = n+1;
    tiempoReal(n) = toc(tstart);
    tiempoReal(n);
    salida = signalv0(tiempoReal);
end

hold on
plot(tiempoReal, salida, '.b')
