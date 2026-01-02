
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
tf = 30;

%paso de integracion
h = 0.1;
%vector tiempo
t = 0:h:tf;
%indice de la matriz
k = 0;

%inicialización valores iniciales
pose(:,k+1) = pose0;

t(k+1) = t0;

while (t0+h*k) < tf,
    %actualización
    k = k+1;
    
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %valores de los parámetros de control
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

orden_minimo = minima_distancia (camino, [pose(1,k) pose(2,k)]);
look_ahead = 15;
if orden_minimo+look_ahead > length(camino)
    look_ahead = 3;
end
% if pose(1:2,k) == [56.2776 37.3825]
%     look_ahead = 3
% else
%     look_ahead = 17; % Cuanto mas pequeño, mas inestable el seguimiento. Si es demasiado grande empieza a separarse de la trayectoria
% end
    % Modificacion :
punto_destino = [camino(orden_minimo+ look_ahead,1) camino(orden_minimo + look_ahead,2)];
delta = (pose(1,k) - punto_destino(1))*sin(pose(3,k)) - ((pose(2,k) - punto_destino(2))*cos(pose(3,k)));
Lh = sqrt((pose(1,k) - punto_destino(1))^2 + (pose(2,k) - punto_destino(2))^2);

distancia_alfinal = sqrt((pose(1,k) - camino(end, 1))^2 + (pose(2,k) - camino(end, 2))^2);
kp = 1;
% V = kp*Lh;
V = kp*distancia_alfinal;
if V > 20
    V = 20;
end
% V = 10;
rho = 2*delta/(Lh^2);
%radio_curvatura = 10;
w = V*rho; %V/radio_curvatura; 
vd = (V+w*l)/radio_rueda;
vi = (V-w*l)/radio_rueda;

phi = atan(rho*l);

 
conduccion = [vd vi];
 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 
%para representar el punto onjetivo sobre la trayectoria
 
punto = pose(1:2,k);

%metodo de integración ruge-kuta
pose(:,k+1) = kuta_diferencial(t(k),pose(:,k),h,conduccion);

end