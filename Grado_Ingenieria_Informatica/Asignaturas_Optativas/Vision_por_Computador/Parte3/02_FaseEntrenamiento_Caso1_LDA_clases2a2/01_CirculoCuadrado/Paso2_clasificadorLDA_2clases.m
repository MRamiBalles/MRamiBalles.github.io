clear, clc, close all

pathMain = "Sistemas de Percepción\Parte3\";
pathActual = pathMain + "02_FaseEntrenamiento_Caso1_LDA_clases2a2/01_CirculoCuadrado/";

addpath(pathMain + 'Funciones')

%% Cargamos datos de interes

%% Cargamos el espacio de características obtenido en la etapa de selección de descriptores
nombreFichero = "espacioCcas_Circulo_Cuadrado.mat";
load(pathActual + "DatosGenerados/" + nombreFichero);

clear nombreFichero;

%% Calculamos la función de decisión lineal -> Clasificador LDA
[d1, d2, d12, coeficientes_d12] = funcion_calcula_hiperplanoLDA_2Clases_2_3_Dim(XoI, YoI);

%% Representamos muestras y plano del clasificador
close all
funcion_representa_hiperplano_separacion_2_3_Dim(coeficientes_d12, XoI);
title('Plano de Separacion del Clasificador LDA: Circulos - Cuadrados')
xlabel('Hu1')
ylabel('DF5')
zlabel('DF7')

load(pathActual + "DatosGenerados/nombresProblema.mat");
% funcion_representa_muestras_clasificacion_binaria_con_frontera(XoI, YoI, nombresProblemaOI, coeficientes_d12)
save(pathActual + "DatosGenerados/espacioCcas_LDA_Circulo_Cuadrado.mat", "d12", "coeficientes_d12","espacioCcas", 'XoI','YoI', "nombresProblemaOI")

rmpath(pathMain + 'Funciones')