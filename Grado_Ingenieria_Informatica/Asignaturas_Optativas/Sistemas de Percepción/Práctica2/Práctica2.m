% Dibujar X amarillas:

clc, close all
I = imread('Práctica0\P0_2_IniciacionImagenesMatlab\X.jpg')
imshow(I)
umbral = 100;
Ib = I < umbral;
color = [255,255,0];
R = I, G = I, B = I;
R(Ib) = color(1); G(Ib) = color(2); B(Ib) = color(3);
If = cat(3,R,G,B);
imshow(If)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Ic = imread('Práctica1\P1_1.jpg')
imshow(Ic)
Ic2 = double(Ic);
I = (Ic2(:,:,1) + Ic2(:,:,2) + Ic2(:,:,3))/3; %% Suma a mano
figure, imshow(uint8(I))

Ib = I < 200 & I > 100;
color = [255,0,0];
R = Ic(:,:,1), G = Ic(:,:,2), B = Ic(:,:,3);
R(Ib) = color(1); G(Ib) = color(2); B(Ib) = color(3);
If = cat(3,R,G,B);
imshow(If)

Io = funcion_visualiza(Ic,Ib,color)
figure, imshow(Io)


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Ic = imread('Práctica1\P1_1.jpg');
I = double(Ic(:,:,1) + Ic(:,:,2) + Ic(:,:,3))/3;
Ib1 = I < 75;
color1 = [0,255,0];
If = funcion_visualiza(Ic, Ib1, color1)
%imshow(If)
Ib2 = I > 150;
%unos = sum(Ib2(:))
color2 = [0,0,255];
funcion_visualiza(If, Ib2, color2, true)


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Calcular el área del circulo
clear
clc, close all
Ic = imread('Práctica0\P0_2_IniciacionImagenesMatlab\X.jpg');
imshow(Ic)

% I = (double(Ic(:,:,1) + Ic(:,:,2) + Ic(:,:,3)))/3;
% imshow(uint8(I))
Ib = Ic < 100;
figure, imshow(Ib)
area = sum(Ib(:));
color = [0,255,255];
funcion_visualiza(Ic, Ib, color, true);
title(['El numero de pixeles de las X es : ' num2str(area)])

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Borde de ceros
I = rand(3,6);
[f,c] = size(I);
I_con_borde = [zeros(1, c+2); [zeros(f, 1), I, zeros(f, 1)]; zeros(1, c+2)]


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
I = imread('Práctica2\ImagenBinaria.tif')
imshow(I)
Ib = I > 100;
imtool(Ib)
[Ie,Ne] = funcion_etiquetar(Ib)
imtool(Ie)
color = [[255,0,0];[0,255,0];[0,0,255];[255,255,0];[255,0,255];[0,255,255]];
colores = round(255*rand(Ne,3));
% R = Ie; G = Ie; B = Ie;
% R(Ie == 1) = color(1,1); G(Ie == 1) = color(1,2); B(Ie == 1) = color(1,3); 
% R(Ie == 2) = color(2,1); G(Ie == 2) = color(2,2); B(Ie == 2) = color(2,3); 
% R(Ie == 3) = color(3,1); G(Ie == 3) = color(3,2); B(Ie == 3) = color(3,3); 
% R(Ie == 4) = color(4,1); G(Ie == 4) = color(4,2); B(Ie == 4) = color(4,3); 
% R(Ie == 5) = color(5,1); G(Ie == 5) = color(5,2); B(Ie == 5) = color(5,3); 
% R(Ie == 6) = color(6,1); G(Ie == 6) = color(6,2); B(Ie == 6) = color(6,3); 
Icolor = uint8(Ib);
for i = 1:Ne
    Ibin = Ie == i;
    colori = colores(i,:);
    Icolor = funcion_visualiza(Icolor, Ibin, colori);
end
figure, imshow(Icolor)


If = cat(3,R,G,B);
imtool(If)

% Bwlabel cambia el orden al recorrer la Ib, usar la transpuesta para
%comparar
Ietiq_bwlabel = bwlabel(Ib');
Ietiq_bwlabel = Ietiq_bwlabel';
imtool(Ietiq_bwlabel)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Ejercicio 4:
I = imread('Práctica2\ImagenBinaria.tif');
Ib = I > 10;
[Ie,Ne] = funcion_etiquetar(Ib)

a = funcion_calcula_areas(Ie, Ne);
c = funcion_calcula_centroides(Ie,Ne);
% Representar los centroides de las agrupaciones con mayor y menor area
[aOrd,ind] = sort(a);
% minArea = aOrd(1)
% maxArea = aOrd(6)
indicesInteres =  [ind(1) ind(Ne)]
cInteres = c(indicesInteres, :)
imshow(Ib), hold on, plot(cInteres(:,1), cInteres(:,2),'*r')
% imshow(Ib), hold on, plot(c(:,1),c(:,2),'*r')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Ejercicio 5:

I = imread('Práctica2\ImagenBinaria.tif');
Ib = I > 0;
[Ie,Ne] = funcion_etiquetar(Ib)
% [IeMatlab, NMatlab] = bwlabel(Ib);
% IeMatlab'
a = funcion_calcula_areas(Ie, Ne);
[aOrd,ind] = sort(a, 'descend');
numPix = aOrd(2);
Ibfilt = funcion_filtra_objetos(Ib, numPix);
% IbfiltMat = bwareaopen(Ib, numPix);
% stats = regionprops(Ie,'Area','Centroid');
% areas = cat(q,stats.Area)
% centroides = cat(1,stats.Centroid)
figure, imshow(Ibfilt)


%% Pruebas con vecindad funcion_etiquetar
IbPrueba = [1 0 1 1 0 1 0 1; 1 1 0 0 1 1 1 1; 1 1 1 1 0 0 0 0]
addpath('../Práctica0/')
% Vecindad 4:
[Ie4, N4] = funcion_etiquetar(IbPrueba)
funcion_compara_matrices(IbPrueba, Ie4) %% Iguales!

[Ie8, N8] = funcion_etiquetar8(IbPrueba)