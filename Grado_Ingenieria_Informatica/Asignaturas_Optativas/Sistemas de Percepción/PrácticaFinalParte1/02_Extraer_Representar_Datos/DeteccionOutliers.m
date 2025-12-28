clc, clear
addpath('./02_Extraer_Representar_Datos/VariablesGeneradas/') % Cargar X e Y
load DatosColor.mat

XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
%x = XColor(:,3); %% Valores azules de los pixeles que me interesan
%[min(x) max(x)]
%close all, hist(x), figure, boxplot(x) %% Mediana, primer y tercer cuartil
%median(x)
valoresY = unique(Y);
filasoI = Y == valoresY(posClaseInteres);
pos_outliers = [];

r = XColor(filasoI,1);
g = XColor(filasoI,2);
b = XColor(filasoI,3);
rOrd = sort(r);
gOrd = sort(g);
bOrd = sort(b);
numVal = length(bOrd);

posQ1 = round(0.25*numVal)
Q1b = bOrd(posQ1) 
% Q1 = prctile(XColor, 25)
posQ2 = round(0.5*numVal) % Mediana
Q2b = bOrd(posQ2)
posQ3 = round(0.75*numVal) 
Q3b = bOrd(posQ3)

% Q2 = prctile(XColor, 50)
Q1r = rOrd(posQ1) 
Q3r = rOrd(posQ3)

% Q3 = prctile(XColor, 75)
Q1g = gOrd(posQ1) 
Q3g = gOrd(posQ3)

RangoIntercuartilicoR = Q3r - Q1r;
vMinAceptadoR = Q1r - 1.5*RangoIntercuartilicoR
vMaxAceptadoR = Q3r + 1.5*RangoIntercuartilicoR
RangoIntercuartilicoG = Q3g - Q1g;
vMinAceptadoG = Q1g - 1.5*RangoIntercuartilicoG
vMaxAceptadoG = Q3g + 1.5*RangoIntercuartilicoG
RangoIntercuartilicoB = Q3b - Q1b;
vMinAceptadoB = Q1b - 1.5*RangoIntercuartilicoB
vMaxAceptadoB = Q3b + 1.5*RangoIntercuartilicoB

%% Otra forma :
% media = mean(x);
% desv = std(x);
% vMinAcep = media - 2.69*desv
% vMaxAcep = media + 2.69*desv

%% Outliers :
% out = x < vMinAceptado | x > vMaxAceptado %% Solo datos del objeto de seguimiento

outR = (X(:,1) < vMinAceptadoR | X(:,1) > vMaxAceptadoR) & Y == 1;
outG = (X(:,2) < vMinAceptadoG | X(:,2) > vMaxAceptadoG) & Y == 1; %% XColor ya cuenta con Y == 1!!!!!
outB = (X(:,3) < vMinAceptadoB | X(:,3) > vMaxAceptadoB) & Y == 1; %% Datos del color de seguimiento 
out = outR | outG | outB;

filasOut = find(out) %% Posiciones de x donde hay un outlier


%%%%%%%%%%%%%%%%%%%%%%%

addpath 02_Extraer_Representar_Datos\Funciones\
    
%% Detectar outliers con funciones :
posCoI = 2; %% Importante -> Valores de  Y == 1 : pos 1 => 0; pos 2 = 1..
pos_out = funcion_detecta_outliers_clase_interes(X,Y,posCoI);

% canal = [1,2,3]
pos_rOut = funcion_detecta_outliers_clase_interes_por_canal(X, Y, posCoI, 1);
X(pos_rOut, :) = [];
Y(pos_rOut) = [];


pos_gOut = funcion_detecta_outliers_clase_interes_por_canal(X, Y, posCoI, 2);
X(pos_rOut, :) = [];
Y(pos_rOut) = [];

pos_bOut = funcion_detecta_outliers_clase_interes_por_canal(X, Y, posCoI, 3);
X(pos_rOut, :) = [];
Y(pos_rOut) = [];

% Eliminar las filas correspondientes a los outliers de X e Y
X(pos_out, :) = [];
Y(pos_out) = [];
X2 = X;
Y2 = Y;
%pwd
addpath 02_Extraer_Representar_Datos\VariablesGeneradas\
save('02_Extraer_Representar_Datos\VariablesGeneradas\DatosColorSinOutliers2.mat', 'X', 'Y')

clc, clear
load ./02_Extraer_Representar_Datos/VariablesGeneradas/DatosColorSinOutliers.mat
addpath('03_DisenoClasificador\Funciones\')
addpath('02_Extraer_Representar_Datos\Funciones\')


%% Centroide de la nube de puntos sin outliers:
valoresY = unique(Y);
pos = 2; % Color de seguimiento -> 1
filasoI = Y == valoresY(pos);
XColor = X(filasoI, :);
XFondo = X(not(filasoI),:);

addpath('03_DisenoClasificador\Funciones\')
%% Representacion esferas (funcion -> representa_datos_color_seguimiento_fondo)
datosE = calcula_datos_esfera(XColor, XFondo)
centroide = datosE(1:3);
radios = datosE(4:6);
% radios = cat(2,r1,r2,r3);

save('02_Extraer_Representar_Datos\VariablesGeneradas\datosEsfera2', 'centroide', 'radios')

clc,clear
load ./02_Extraer_Representar_Datos/VariablesGeneradas/datosEsfera2.mat
%% Dibujar caja
rmin = min(XColor(:,1))
gmin = min(XColor(:,2))
bmin = min(XColor(:,3))
rmax = max(XColor(:,1))
gmax = max(XColor(:,2))
bmax = max(XColor(:,3))


datosE = calcula_datos_esfera(XColor, XFondo)
centroide = datosE(1:3);
r1 = datosE(4);
r2 = datosE(5);
r3 = datosE(6);
% centroide = mean(XColor);

%% Primer apartado: Incluir toda la nube del objeto de interes
P = centroide';
NP = XColor';
addpath('../03_DisenoClasificador/Funciones/')
vecDistancias = calcula_distancia_punto_a_nube_puntos(P,NP);
r1 = max(vecDistancias);

%% Punto mas cercano de la nube de fondo:
% XFondo = X(not(filasoI),:);
filasf = Y == valoresY(1); % Colores fondo 
XFondo = X(filasf, :);
NP = XFondo';
vecDistanciasFondo = calcula_distancia_punto_a_nube_puntos(P, NP);
r2 = min(vecDistanciasFondo);

%% Radio medio:
r3 = (r1+r2)/2;


% Subplot 1: Representación original de los datos azules y otros colores de fondo

subplot(2, 2, 1);
plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
hold on
plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
axis([0 255 0 255 0 255]);

% Definir los vértices de la caja
x = [rmin, rmax, rmax, rmin, rmin; rmin, rmax, rmax, rmin, rmin];
y = [gmin, gmin, gmax, gmax, gmin; gmin, gmin, gmax, gmax, gmin];
z = [bmin, bmin, bmin, bmin, bmin; bmax, bmax, bmax, bmax, bmax];

% Dibujar las líneas del cubo
plot3(x, y, z, 'g', 'LineWidth', 2); % Caras horizontales
hold on;
for i = 1:size(x, 2)
    plot3(x(:, i), y(:, i), z(:, i), 'g', 'LineWidth', 2); % Líneas verticales
end
%grid on
% Dibujar las líneas que conectan las caras del cubo
plot3(x(1,:), y(1,:), z(1,:), 'g', 'LineWidth', 2);
plot3(x(2,:), y(2,:), z(2,:), 'g', 'LineWidth', 2);
plot3(x(1,1:2), y(1,1:2), z(1,1:2), 'g', 'LineWidth', 2);
plot3(x(2,1:2), y(2,1:2), z(2,1:2), 'g', 'LineWidth', 2);
legend('Datos Color', 'Datos Fondo');
xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
title('Representación original');

% Resto de subplots con las esferas:
nRadios = length(radios);
for i = 1:nRadios
    ri = radios(i);

    subplot(2, 2, i+1);
    plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
    hold on;
    plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
    representa_esfera(centroide, ri);
    axis([0 255 0 255 0 255]);
    legend('Datos Color', 'Datos Fondo');
    xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
    if i == 1
        title('Representacion con esfera de mayor radio');
    elseif i == 2
        title('Representacion con esfera de menor radio');
    else
        title('Representacion con esfera de radio medio');
    end
end

%% Representar mediante funcion
addpath('./02_Extraer_Representar_Datos/VariablesGeneradas/') % Cargar X e Y
load DatosColorSinOutliers.mat

XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
representa_datos_color_seguimiento_fondo(XColor, XFondo)


%% Ejercicio 3.2.1 -> Imagenes de calibración:

clear, close all, clc
addpath('01_GeneracionMaterial\MaterialGenerado\')
load 01_GeneracionMaterial\MaterialGenerado\ImagenesCalibracion.mat
load 02_Extraer_Representar_Datos\VariablesGeneradas\datosEsfera2.mat
addpath('03_DisenoClasificador\Funciones\')

%% Lectura de imagenes y extraccion de datos
ruta = './01_GeneracionMaterial/MaterialGenerado/'

imagenes = load([ruta 'ImagenesCalibracion.mat'])
for i = 1:14 
    sentencia = ['imagen = imagenes.I' num2str(i) ';'];
    eval(sentencia)
    Icalib(:,:,:,i) = imagen;
end
[F, C, NumComp, NumImg] = size(Icalib);

% Establecer el path donde se encuentran los archivos necesarios
pathsArchivos = "PracticaFinal_P1\Implementacion\03_DisenoClasificador\";
%NumImg = 3
nRadios = length(radios);
centro_radio1 = [centroide, radios(1)];
centro_radio2 = [centroide, radios(2)];
centro_radio3 = [centroide, radios(3)];

%% Todos los pixeles:

for i = 1:NumImg
    imagen = sprintf('I%d', i);
    I = eval(imagen);
    % disp(size(I))

    % Calcula la detección de la esfera en la imagen
    Ib1 = calcula_deteccion_1esfera_en_imagen(I, centro_radio1);
    Ib2 = calcula_deteccion_1esfera_en_imagen(I, centro_radio2);
    Ib3 = calcula_deteccion_1esfera_en_imagen(I, centro_radio3);
    
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

%% Todos los centroides segun las distintas agrupaciones:

for i = 1:NumImg
    imagen = sprintf('I%d', i);
    I = eval(imagen);
    % disp(size(I))

    % Calcula la detección de la esfera en la imagen
    Ib1 = calcula_deteccion_1esfera_en_imagen(I, centro_radio1);
    Ib2 = calcula_deteccion_1esfera_en_imagen(I, centro_radio2);
    Ib3 = calcula_deteccion_1esfera_en_imagen(I, centro_radio3);

    [Ie1, N1] = bwlabel(Ib1); %funcion_etiquetar(Ib1)
    [Ie2, N2] = bwlabel(Ib2); %funcion_etiquetar(Ib2)
    [Ie3, N3] = bwlabel(Ib3); %funcion_etiquetar(Ib3)

     % Calcula las propiedades de las agrupaciones etiquetadas
    propiedades1 = regionprops(Ie1, 'Centroid');
    propiedades2 = regionprops(Ie2, 'Centroid');
    propiedades3 = regionprops(Ie3, 'Centroid');
    
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
    for j = 1:N1
        hold on;
        plot(propiedades1(j).Centroid(1), propiedades1(j).Centroid(2), 'r*');
        legend('Agrupaciones dentro de la esfera grande');
        title('Imagen con esfera grande');
    end
    subplot(2, 2, 3);
    imshow(I);
    hold on;
    for j = 1:N2
        hold on;
        plot(propiedades2(j).Centroid(1), propiedades2(j).Centroid(2), 'g*');
        legend('Agrupaciones dentro de la esfera pequeña');
        title('Imagen con esfera pequeña');
    end
    subplot(2, 2, 4);
    imshow(I);
    for j = 1:N3
        hold on;
        plot(propiedades3(j).Centroid(1), propiedades3(j).Centroid(2), 'b*');
        legend('Agrupaciones dentro de la esfera mediana');
        title('Imagen con esfera mediana');
    end
end

%% final del bucle
    % Dibuja los centroides de las agrupaciones
    for j = 1:N1
        plot(propiedades1(j).Centroid(1), propiedades1(j).Centroid(2), 'r*');
    end
    
    for j = 1:N2
        plot(propiedades2(j).Centroid(1), propiedades2(j).Centroid(2), 'g*');
    end
    
    for j = 1:N3
        plot(propiedades3(j).Centroid(1), propiedades3(j).Centroid(2), 'b*');
    end
    
    hold off;
    title(['Imagen ', num2str(i)]);
    pause(3);

%% Clasificador basado en superficie esferica:
%% Teniendo Centroide y Radio - > calcula_deteccion_1esfera_en_imagen(I, centro_radio)
Ib = MatrizDistancia < Radio; % funcion_visualiza

numDatosColor = size(XColor, 1);
numDatosFondo = size(XFondo, 2);
vecDistancias = zeros(1, numDatosColor);
for i = 1:numDatosColor
    B = NP(:,i); %% XColor o XFondo!
    vecDistancias(i) = sqrt(sum((A-B).^2));
end


%% Otra forma sin bucle: 
CentroideAmp = repmat(centroide, 1, numDatosColor);
vecDistancias(i) = sqrt(sum((CentroideAmp - NP).^2));
