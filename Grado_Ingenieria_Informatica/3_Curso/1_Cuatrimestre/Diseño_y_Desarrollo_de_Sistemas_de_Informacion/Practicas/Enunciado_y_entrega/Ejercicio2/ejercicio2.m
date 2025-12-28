%% Ejercicio 2 - apartado Extracción de datos- Representacion de datos
% Apartado 1: 
clc, clear, close all
addpath("Enunciado_y_entrega\Ejercicio2\VariablesRequeridas\")
I = imread("ImTrain.jpg")

numRegiones = 2;
datos = [];

R = I(:,:,1);
G = I(:,:,2);
B = I(:,:,3);

figure;
imshow(I);
%% Obtenemos las caracteristicas del color de interes:
for i = 1:numRegiones
    ROI = roipoly(I);
    numPix = sum(ROI(:));
    datos = [datos; i*ones(numPix,1) R(ROI) G(ROI) B(ROI)];
end

datosPared = datos(:, 2:4); 
YPared = ones(size(datosPared, 1), 1);

% Obtener los parametros del fondo
ROI = roipoly(I);
numPix = sum(ROI(:));
datosFondo = [];
datosFondo = [datosFondo; i*ones(numPix,1) R(ROI) G(ROI) B(ROI)]

datosFondo = datosFondo(:, 2:4); 
YFondo = zeros(size(datosFondo, 1), 1);

%Generar los conjuntos X e Y:
 X = [datosPared ; datosFondo];
 Y = [YPared; YFondo];

 save("Enunciado_y_entrega\Ejercicio2\VariablesRequeridas\conjunto_datos_original.mat", "X","Y")

 %%%%%%%%%%%%%%

posCoI = 2;
pos_bOut = funcion_detecta_outliers_clase_interes_por_canal(X, Y, posCoI, 3);
X(pos_bOut, :) = [];
Y(pos_bOut) = [];
save("Enunciado_y_entrega\Ejercicio2\VariablesRequeridas\conjunto_datos.mat", "X","Y")

%%%%%%%%%%%%%%
%Representacion:
load("conjunto_datos_original.mat")
XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
figure;
subplot(2,1,1)
plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
    hold on
    plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
    axis([0 255 0 255 0 255]);
    
    legend('Datos Color', 'Datos Fondo');
    xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
title('Imagen con outliers');

load("conjunto_datos.mat")
XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
figure;
subplot(2,1,1)
plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
    hold on
    plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
    axis([0 255 0 255 0 255]);
    
    legend('Datos Color', 'Datos Fondo');
    xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
title('Imagen sin outliers');
