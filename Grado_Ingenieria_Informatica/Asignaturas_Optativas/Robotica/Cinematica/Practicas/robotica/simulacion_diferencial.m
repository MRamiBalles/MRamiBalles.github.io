
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Simulación del movimiento de un robot móvil
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

clear all
clc

j=1;
global l
global radio_rueda
global camino
global pose
global punto

%cargamos el camino
camino=load('camino.dat');

l = 3.5; %distancia entre rudas delanteras y traseras, tambien definido en modelo
radio_rueda = 1;

%Condiciones iniciales 
pose0 = [0; 0; 0];
t0 = 0;
%final de la simulación
tf = 15;
%paso de integracion
h = 0.1;
%vector tiempo
t = 0:h:tf;
%indice de la matriz
k = 0;

%inicialización valores iniciales
pose(:,k+1) = pose0;
t(k+1) = t0;
% Modificacion :
punto_destino = [45 15];
while (t0+h*k) < tf,
    %actualización
    k = k+1;
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %valores de los parámetros de control
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

delta = (pose(1,k) - punto_destino(1))*sin(pose(3,k)) - ((pose(2,k) - punto_destino(2))*cos(pose(3,k)));
Lh = sqrt((pose(1,k) - punto_destino(1))^2 + (pose(2,k) - punto_destino(2))^2);

V = Lh;
if V > 3.5
    V=3.5;
end
rho = 2*delta/(Lh^2);
w = V*rho; %V/radio_curvatura; 
vd = (V+w*l)/radio_rueda;
vi = (V-w*l)/radio_rueda;

phi = atan(rho*l);
conduccion = [vd vi];
 
%para representar el punto onjetivo sobre la trayectoria
 
punto = [45 15];

%metodo de integración ruge-kuta
pose(:,k+1) = kuta_diferencial(t(k),pose(:,k),h,conduccion);

end

%indice de la matriz
k = 0;
t0 = 0;

%inicialización valores iniciales
pose(1) = 45;
pose(2) = 15;
punto_destino = [78 3];

while (t0+h*k) < tf,
    %actualización
    k=k+1;
    
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %valores de los parámetros de control
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

delta = (pose(1,k) - punto_destino(1))*sin(pose(3,k)) - ((pose(2,k) - punto_destino(2))*cos(pose(3,k)));
Lh = sqrt((pose(1,k) - punto_destino(1))^2 + (pose(2,k) - punto_destino(2))^2);

V = Lh;
if V > 3.5
    V=3.5;
end
rho = 2*delta/(Lh^2);
w = V*rho; %V/radio_curvatura; 
vd = (V+w*l)/radio_rueda;
vi = (V-w*l)/radio_rueda;

phi = atan(rho*l);
conduccion=[vd vi];
punto=[78 3];

%metodo de integración ruge-kuta
pose(:,k+1)=kuta_diferencial(t(k),pose(:,k),h,conduccion);

end



