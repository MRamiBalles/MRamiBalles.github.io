clear, clc, close all

pathMain = "Sistemas de Percepción\Parte3\";
pathActual = pathMain + "02_FaseEntrenamiento_Caso4_KNN_LDA/";

addpath(pathMain + 'Funciones')

%% Cargamos el espacio de características
nombreFichero = "espacioCcas_CirculoTriangulo_Cuadrado_knn.mat";
load(pathActual + "01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/" + nombreFichero);
nombreFichero = 'nombresProblema_knn.mat';
load(pathActual + "01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/" + nombreFichero);

clear nombreFichero;

nombresProblema = [];
nombresProblema.descriptores = nombresProblemaOI.descriptores(espacioCcas);
nombresProblema.clases = nombresProblemaOI.clases;
nombresProblema.simbolos = nombresProblemaOI.simbolos;

%% Entrenamiento del clasificador k-NN
k = 5; % Número de vecinos
XTrain = XoI;
YTrain = YoI;

% YTest = funcion_knn(XTest, XTrain , YTrain, k);

save(pathActual + '01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/descriptores_atributos_knn.mat','nombresProblema');
% save(pathActual + 'DatosGenerados/funcion_decision.mat','d');

save(pathActual + "01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/espacioCcas_knn_Circulo_Cuadrado_Triangulo.mat","espacioCcas", 'XoI','YoI', 'nombresProblema')

rmpath(pathMain + 'Funciones')