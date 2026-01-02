%% Generacion de patrones de entrenamiento
% 23 Descriptores a utilizar:
% Circularidad: 1
% Excentricidad: 2
% Solidez_CHull(Solidity): 3
% Extension_BBox(Extent): 4
% Extension_BBox(Invariante Rotacion): 5
% Hu1-Hu7: 6-12
% DF1-DF10: 13-22
% NumEuler: 23

% Leer una imagen en escala de grises
I = imread('cielo.jpg');

% Si la imagen es RGB, conviértela a escala de grises
if size(I, 3) == 3
    I = rgb2gray(I);
end

% Calcular el umbral usando Otsu
T = funcion_otsu(I);

% Mostrar el umbral calculado
disp(['El umbral calculado por Otsu es: ', num2str(T)]);

% Aplicar el umbral a la imagen
Ibin = I > T;
imshow(I)
% Mostrar la imagen binarizada
imshow(Ibin);
h = imhist(I);
bar(h);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%55
clear, clc, close all
addpath("..\..\Práctica 5\Funciones\")
I = imread('cielo.jpg');
clase_objetos = 1; % Asignar la clase correspondiente a los objetos en la imagen

% Llamar a la función para segmentar la imagen
[Ietiq, N] = funcion_segmenta_imagen(I);

% Calcular los descriptores de cada región
XImagen = funcion_calcula_descriptores_imagen(Ietiq, N);

% Generar Yimagen
Yimagen = funcion_genera_Yimagen(N, clase_objetos);

% Generar la estructura de nombres de problema
nombresProblema = generar_nombres_problema();

% Guardar los datos en el archivo conjunto_datos.mat
guardar_conjunto_datos(XImagen, Yimagen, nombresProblema);

% Mostrar el resultado
disp(['Número de regiones conectadas: ', num2str(N)]);
disp('Descriptores de las regiones:');
disp(XImagen);
disp('Clases de las regiones:');
disp(Yimagen);