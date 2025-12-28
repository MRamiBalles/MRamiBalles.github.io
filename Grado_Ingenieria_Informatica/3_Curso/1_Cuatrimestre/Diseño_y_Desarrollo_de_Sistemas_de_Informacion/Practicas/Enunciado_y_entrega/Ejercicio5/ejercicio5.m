clc; clear; close all;
load("Enunciado_y_entrega\Ejercicio5\VariablesRequeridas\parametros_clasificador.mat");
I = imread("Enunciado_y_entrega\Ejercicio5\VariablesRequeridas\ImTest.jpg");

% Realizar la detección de las esferas en la imagen
Ib = calcula_deteccion_multiples_esferas_en_imagen(I, datosMultiplesEsferas_clasificador(:, 4), datosMultiplesEsferas_clasificador(:, 1:3));

% Visualizar la imagen con las detecciones en amarillo
Io = funcion_visualiza(I, Ib, [255 255 0], false);
figure; imshow(Io); title('Primera gráfica: Píxeles dentro de esferas');

% Detectar las agrupaciones de píxeles con un mínimo de numPix píxeles
IbFilt = bwareaopen(Ib, round(numPix));

% Encontrar las propiedades de las agrupaciones filtradas
stats = regionprops(IbFilt, 'Centroid', 'Area');
[~, idxMax] = max([stats.Area]);
centroideMax = round(stats(idxMax).Centroid);

% Visualizar la imagen con las detecciones en amarillo
Io2 = funcion_visualiza(I, IbFilt, [255 255 0], false);
figure; imshow(Io2); title('Segunda gráfica: Agrupaciones de píxeles');
hold on;

% Dibujar una caja roja 7x7 centrada en el centroide de la agrupación mayor
halfSize = 3; % Tamaño de la mitad de la caja (7x7)
xCoords = [centroideMax(1)-halfSize, centroideMax(1)+halfSize, centroideMax(1)+halfSize, centroideMax(1)-halfSize, centroideMax(1)-halfSize];
yCoords = [centroideMax(2)-halfSize, centroideMax(2)-halfSize, centroideMax(2)+halfSize, centroideMax(2)+halfSize, centroideMax(2)-halfSize];
plot(xCoords, yCoords, 'r', 'LineWidth', 2);

hold off;

%%%%%%%%%%%%%%%%%%%%%
%% Otra forma de hacer el cuadrado: 

%imshow(Io2); title('Segunda gráfica: Agrupaciones de píxeles');

% Dibujar una caja roja 7x7 centrada en el centroide de la agrupación mayor
%hold on;
%rectangle('Position', [centroideMax(1)-3, centroideMax(2)-3, 7, 7], 'EdgeColor', 'r', 'LineWidth', 2);
%hold off;

% Dibujar una caja roja 7x7 centrada en el centroide de la agrupación mayor
halfSize = 3; % Tamaño de la mitad de la caja (7x7)
for x = max(1, centroideMax(1)-halfSize):min(size(I,2), centroideMax(1)+halfSize)
    for y = max(1, centroideMax(2)-halfSize):min(size(I,1), centroideMax(2)+halfSize)
        if abs(x - centroideMax(1)) == halfSize || abs(y - centroideMax(2)) == halfSize
            Io2(y, x, 1) = 255; % R
            Io2(y, x, 2) = 0;   % G
            Io2(y, x, 3) = 0;   % B
        end
    end
end

imshow(Io2); title('Segunda gráfica: Agrupaciones de píxeles con caja roja centrada en el centroide mayor');
