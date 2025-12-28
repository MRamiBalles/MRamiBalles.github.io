cd('C:/Users/Manu/Desktop/Sistemas de Percepción/Parte2/Práctica 4/Funciones');
clear, clc
% Cargar la imagen
Ic = imread('cielo.jpg');
I = mean(Ic, 3)
imshow(uint8(I))
h = imhist(I)

Tmem = funcion_min_entre_max(Ic)

%% Representar:
figure;
bar(h);
hold on;
line([Tmem Tmem], [0 max(h)], 'Color', 'r');
title('Histograma con Umbral');

I_bin = I > Tmem;
imshow(I_bin)
% Mostrar la imagen binarizada
figure;
imshow(I_bin);
title('Imagen Binarizada');

%% isodata:
Ti = funcion_isodata(I, 0.1)
figure;
bar(h);
hold on;
line([Ti Ti], [0 max(h)], 'Color', 'r');
title('Histograma con Umbral');

I_bin = I > Ti;

% Mostrar la imagen binarizada
figure;
imshow(I_bin);
title('Imagen Binarizada');


%% otsu:
Ic = imread('cielo.jpg');
imshow(Ic)
h = imhist(Ic)

To = funcion_otsu(Ic)
255*graythresh(Ic)
figure;
bar(h);
hold on;
line([To To], [0 max(h)], 'Color', 'r');
title('Histograma con Umbral');

I_bin = I > To;

% Mostrar la imagen binarizada
figure;
imshow(I_bin);
title('Imagen Binarizada');