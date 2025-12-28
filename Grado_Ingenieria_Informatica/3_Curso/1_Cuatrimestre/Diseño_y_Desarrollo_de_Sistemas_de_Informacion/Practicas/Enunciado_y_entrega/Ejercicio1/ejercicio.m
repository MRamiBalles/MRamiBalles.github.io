%% EJERCICIO 1
% Apartado 1:
clc, clear, close all
% imshow("Ej1.png")

I = imread("Ej1.png");
Ib = I > 10; 

% Filtramos las dos agrupaciones menores:
numPixUmbral = 50;
IbFilt = funcion_filtra_objetos(Ib, numPixUmbral); 
[Ie, Ne] = funcion_etiquetar(IbFilt); %% Etiqueta con vecindad 4

areas = funcion_calcula_areas(Ie, Ne);
[areasOrd, ind] = sort(areas);

%% Sabemos que la otra region ruidosa es la mayor:
% Por tanto los indices de interes son los de las posiciones 1 y 2:
indInteres = [ind(1) ind(2)]

Io = zeros(size(Ie)); 
for i = 1:numel(indInteres)
    Io(Ie == indInteres(i)) = 1;
end

figure; imshow(Io); title('Regiones ruidosas eliminadas');
imwrite(Io,"./Enunciado_y_entrega/Ejercicio1/Io.jpg")

%%%%%%%%%%%%%%%%%%%%%%%%%%
% Apartado 2:
rojo = [255 0 0];
verde = [0 255 0];
azul = [0 0 255];
[Ietiq, Ne] = funcion_etiquetar(Io);
areas = funcion_calcula_areas(Ietiq, Ne);
centroides = funcion_calcula_centroides(Ietiq, Ne);
[areasOrd, ind] = sort(areas); 
indCuad = ind(end); 
indTri = ind(end-1);

% Visualizar en rojo el cuadrado y en verde el triángulo
Io = funcion_visualiza(I, Ietiq == indCuad, rojo, false);
funcion_visualiza(Io, Ietiq == indTri, verde, true);
hold on
% Encontrar el centro del cuadrado
centro_cuadrado = round(centroides(indCuad, :));

% Dibujar un punto azul en el centro del cuadrado
plot(centro_cuadrado(1), centro_cuadrado(2), 'bo', 'MarkerSize', 10, 'MarkerFaceColor', 'b');
title('Píxeles del cuadrado en rojo, triángulo en verde, y centro del cuadrado en azul');
