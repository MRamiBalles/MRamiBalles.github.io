% XFondo = X(Y == 1) 
valoresY = unique(Y);
FoI = Y == valoresY(2); % Filas de la clase de interes
XColor = X(FoI, :);

numAgrup = 5;
idx = funcion_kmeans(XColor, numAgrup);
% idxM = kmeans(XColor, numAgrup)
% Representar agrupaciones
close all
representa_datos_por_agrupacion(X, idx);
numDatos = size(X,1);
numDim = size(X,2);
idx = zeros(numDatos,1);


representa_datos_color_seguimiento_fondo(X,Y)
figure
XColor_1 = XColor(idx == 2, :);

datosMultiplesEsferas = zeros(numAgrup, 6);
XFondo = X(FoI, :);
for i = 1:numAgrup
    XColor_i = XColor(idx == i, :)
    calcula_datos_esfera(XColor_i, XFondo)
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear, clc, close all
addpath('./02_Extraer_Representar_Datos/VariablesGeneradas/') % Cargar X e Y
load DatosColorSinOutliers.mat

XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
%valoresY = unique(Y);
%FoI = Y == valoresY(2);
%xClase = X(FoI,:);

addpath("03_DisenoClasificador\Funciones\")
addpath("04_AjusteClasificador_ImgCalib\Funciones\")
numAgrup = 3; % Número de agrupaciones a realizar
datosMultiplesEsferas = calcula_datos_multiples_Esferas(XColor, XFondo, numAgrup);
load 03_DisenoClasificador\VariablesGeneradas\DatosMultiplesEsferas.mat
[idx2, centroides2] = kmeans(double(XColor), numAgrup);
[idx, centroides] = funcion_kmeans(XColor, numAgrup);
save ('03_DisenoClasificador\VariablesGeneradas\DatosMultiplesEsferas3Agrup.mat', "datosMultiplesEsferas")
%P = centroides2';
%NP = XColor';
datosMultiplesEsferas = zeros(numAgrup, 6);

for i = 1:numAgrup
    centroide = centroides(i,:);
    puntosColor = XColor(idx == i, :);
    
    vecDistanciasSeguimiento = calcula_distancia_punto_a_nube_puntos(centroide', puntosColor');
    r1 = max(vecDistanciasSeguimiento);
    
    % Calcular distancias de fondo
    vecDistanciasFondo = calcula_distancia_punto_a_nube_puntos(centroide', XFondo');
    r2 = min(vecDistanciasFondo);
    
    % Calcular radio medio
    r3 = (r1 + r2) / 2;

    % Almacenar los datos en la matriz datosMultiplesEsferas
    datosMultiplesEsferas(i, :) = [centroide, r1, r2, r3];
end

datosEsferas = calcula_datos_multiples_Esferas(XColor, XFondo, numAgrup);
valoresY = unique(Y);
FoI = Y == valoresY(1);
xFondo = X(FoI, :);
representa_datos_multiples_esferas(XColor, XFondo, datosMultiplesEsferas) 

save("03_DisenoClasificador\VariablesGeneradas\DatosMultiplesEsferas.mat")

clear, clc, close all
load("03_DisenoClasificador\VariablesGeneradas\DatosMultiplesEsferas5Agrup.mat")

load 01_GeneracionMaterial\MaterialGenerado\ImagenesCalibracion.mat
addpath('03_DisenoClasificador\Funciones\')

NumImg = 5;
nRadios = length(radios);
centroides = datosMultiplesEsferas(:, 1:3);
radios = datosMultiplesEsferas(:, 4:6);

%% Todos los pixeles:

for i = 1:NumImg
    imagen = sprintf('I%d', i);
    I = eval(imagen);
    % disp(size(I))

    % Calcula la detección de la esfera en la imagen
    Ib1 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 1), centroides);
    Ib2 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 2), centroides);
    Ib3 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 3), centroides);
    
    % Muestra la imagen original con los centroides resaltados
    figure;
    subplot(2,2,1)
    imshow(I);
    hold on;
    title('Imagen original');
    
    % Resto de subplots con los pixeles que quedan dentro de las esferas:
    subplot(2, 2, 2);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib1);
    plot(cols, rows, 'r.');
    legend('Puntos dentro de la esfera grande');
    title('Imagen con esfera grande');

    subplot(2, 2, 3);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib2);
    plot(cols, rows, 'g.');
    legend('Puntos dentro de la esfera pequeña');
    title('Imagen con esfera pequeña');

    subplot(2, 2, 4);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib3);
    plot(cols, rows, 'b.');
    legend('Puntos dentro de la esfera mediana');
    title('Imagen con esfera mediana');
end

ROI = roipoly(I14);
R = I(:,:,1);
G = I(:,:,2);
B = I(:,:,3);
numPixUmbral = sum(ROI(:));
porcentajesPixeles = round([numPixUmbral * .25, numPixUmbral * .50, numPixUmbral * .75]);
numPixUmbral = numPixUmbral*.5
datos = [R(ROI) G(ROI) B(ROI)];
mediaDatos = mean(datos)
save("03_DisenoClasificador\VariablesGeneradas\numPixUmbral.mat", "porcentajesPixeles")


load("03_DisenoClasificador\VariablesGeneradas\numPixUmbral.mat")
numPixUmbral = porcentajesPixeles(3)
%% Eleccion del radio para el clasificador considerando umbral de conectividad

numPixUmbral = sum(ROI(:));
porcentajesPixeles = round([numPixUmbral * .25, numPixUmbral * .50, numPixUmbral * .75]); % Escoger 75%

NumImg = 14;
for i = 1:NumImg
    imagen = sprintf('I%d', i);
    I = eval(imagen); 

    Ib1 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 1), centroides); % Escoger
    Ib2 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 2), centroides); 
    Ib3 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 3), centroides);

    figure;
    %% Probar radios:
    Io = funcion_visualiza(I, Ib1, [255 0 0], false);
    
    subplot(2, 2, 1)
    imshow(Io);
    hold on;
    title('Imagen original');
    for j = 1 : size(porcentajesPixeles(:))
        % Detectar las esferas en la imagen actual usando sus datos de radio y posición, y eliminando las esferas que tienen menos del porcentaje especificado de área
        %% Cambiar radios para escoger mejor opcion
        Ib = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosMultiplesEsferas(:, 4), datosMultiplesEsferas(:, 1:3)), porcentajesPixeles(j));
        Io = funcion_visualiza(I, Ib, [255 0 0], false);
        subplot(2, 2, j+1)
        imshow(Io), hold on;
    end
end

datosEsferasClasificador = [centroides, radios(:,3)];
save("04_AjusteClasificador_ImgCalib\Variables Generadas\datosEsferasClasificador3Agrup.mat", "datosEsferasClasificador")
save("04_AjusteClasificador_ImgCalib\Variables Generadas\numPix.mat","numPixUmbral")