%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Simulación del movimiento de un robot móvil
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

clear all
clc

MAPA = imread('cuadro4.bmp');

%Transformación para colocar correctamente el origen del Sistema de
%Referencia
MAPA(1:end,:,:)=MAPA(end:-1:1,:,:);
% image(MAPA);
% axis xy
delta=35;
j=1;

global l
global radio_rueda
global camino
global pose
global punto
%cargamos el camino

%camino=load('camino.dat');

% punto_partida = [115 161];
angulo_partida = pi;
% punto_llegada = [41 200];
% angulo_llegada = 3*pi/2;
% waypoint1 = [100 50]
% waypoint2 = [200 240]
% dd = 5;
% da = dd;
% Pdx = punto_partida(1) + dd*cos(angulo_partida);
% Pdy = punto_partida(2) + dd*sin(angulo_partida);
% Pax = punto_llegada(1) - da*cos(angulo_llegada);
% Pay = punto_llegada(2) - da*sin(angulo_llegada);
% 
% xc = [punto_partida(1) Pdx waypoint1(1) waypoint2(1) Pax punto_llegada(1)]
% yc = [punto_partida(2) Pdy waypoint1(2) waypoint2(2) Pay punto_llegada(2)]
% ds=1; %distancia entre puntos en cm.
% camino=funcion_spline_cubica_varios_puntos(xc,yc,ds)';
camino = A_estrella(MAPA, delta)
tstart=tic;
   Optimal_path_original=Alg_estrella(MAPB, xStart, yStart, xTarget, yTarget); %llama al algoritmo
   Optimal_path_original=[Optimal_path_original;xStart, yStart]; %mete la configuración inicial
   Optimal_path=((Optimal_path_original-1)*delta)+(delta/2); %convierte los indices de las celdas 
                                                             %del mápa básico MAPB en índices de las celdas 
                                                             %del mapa original. Se le resta 1para devolver
                                                             %el origen al (0,0)
   
tfinal=toc(tstart) 

punto_partida = [xStart 161];
punto_llegada = [41 200];
l = 3.5; %distancia entre rudas delanteras y traseras, tambien definido en modelo
radio_rueda=1;

%Condiciones iniciales 
pose0 = [camino(:,1); camino(:,2); angulo_partida];
t0=0;

%final de la simulación
tf=30;

%paso de integracion
h=0.1;
%vector tiempo
t=0:h:tf;
%indice de la matriz
k=0;

%inicialización valores iniciales
pose(:,k+1)=pose0;

t(k+1)=t0;


while (t0+h*k) < tf,
    %actualización
    k=k+1;
    
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %valores de los parámetros de control
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

 %para representar el punto onjetivo sobre la trayectoria
 
orden_minimo = minima_distancia (camino, [pose(1,k) pose(2,k)]);
look_ahead = 3;
if (orden_minimo+look_ahead) > length(camino)
   % look_ahead = 0.2;
   % punto_destino=[camino(orden_minimo+look_ahead,1) camino(orden_minimo+look_ahead,2)];
   % if (orden_minimo+look_ahead)==length(camino)
         break
   end
% else
    punto_destino=[camino(orden_minimo+look_ahead,1) camino(orden_minimo+look_ahead,2)];
% end
%punto_destino=[camino(orden_minimo+look_ahead,1) camino(orden_minimo+look_ahead,2)];

delta=((pose(1,k)-punto_destino(1))*sin(pose(3,k)))-((pose(2,k)-punto_destino(2))*cos(pose(3,k)));
Lh=sqrt((pose(1,k)-punto_destino(1))^2+(pose(2,k)-punto_destino(2))^2);

distancia_alfinal=sqrt((pose(1,k)-camino(end,1))^2+(pose(2,k)-camino(end,2))^2);
kp=1; % cambiado de 1
V=kp*distancia_alfinal;
if V>30
    V=30;
end

rho=2*delta/Lh^2;

radio_curvatura=10;
W=V*rho;

velocidad_derecha=(V+W*l)/radio_rueda;
velocidad_izquierda=(V-W*l)/radio_rueda;
 
conduccion=[velocidad_derecha velocidad_izquierda];
punto = punto_destino;

    
%metodo de integración ruge-kuta

pose(:,k+1)=kuta_diferencial_mapa(t(k),pose(:,k),h,conduccion, MAPA);%da el angulo, la x y la y

end