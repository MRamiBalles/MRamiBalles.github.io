%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Ejemplo de la llamada a la función 
% funcion_spline_cubica_varios_puntos.m
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all
% xc=[0 10 40 80 80 80];
% yc=[0 0 40 40 100 120];

punto_partida = [15 66];
angulo_partida = pi;
punto_llegada = [41 20];
angulo_llegada = 3*pi/2;
waypoint1 = [45 15]
waypoint2 = [78 03]
dd = 5;
da = dd;
Pdx = punto_partida(1) + dd*cos(angulo_partida);
Pdy = punto_partida(2) + dd*sin(angulo_partida);
Pax = punto_llegada(1) - da*cos(angulo_llegada);
Pay = punto_llegada(2) - da*sin(angulo_llegada);

xc = [punto_partida(1) Pdx waypoint1(1) waypoint2(1) Pax punto_llegada(1)]
yc = [punto_partida(2) Pdy waypoint1(2) waypoint2(2) Pay punto_llegada(2)]
ds=3; %distancia entre puntos en cm.
camino=funcion_spline_cubica_varios_puntos(xc,yc,ds)';

plot(camino(:,1),camino(:,2),'or','LineWidth',3)
hold on
plot(xc,yc,'*g')