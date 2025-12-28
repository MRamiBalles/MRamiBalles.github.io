clear, clc, close all

pathMain = "Sistemas de Percepción\Parte3\";
pathActual = pathMain + "02_FaseEntrenamiento_Caso4_KNN_LDA\";

addpath(pathActual + 'DatosGenerados')
addpath(pathMain + 'Funciones')
load conjunto_datos_estandarizados.mat
load nombresProblema.mat

% (Circulos (1), Cuadrados (2) y Triangulos (3))
%% Seleccionamos las clases involucradas
clasesOI = [1 2 3];
XoI = Z;
YoI = Y;
YoI(Y==3) = 1; % Creamos la clase circulo-triangulo -> es decir donde hay triangulos sera circulo

%% Seleccionamos los cuatro mejores descriptores para discriminar entre las muestras.
[espacioCcas, JespacioCcas]=funcion_selecciona_vector_ccas(XoI,YoI,4);
XoI = XoI(:,espacioCcas);

% Guardar los descriptores seleccionados
nombresProblemaOI = [];
nombresProblemaOI.descriptores = nombresProblema.descriptores;
nombresProblemaOI.clases = nombresProblema.clases(clasesOI);
nombresProblemaOI.simbolos = nombresProblema.simbolos;
descriptores_seleccionados = ["NumEuler"];

save(pathActual + "01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/espacioCcas_CirculoTriangulo_Cuadrado_knn.mat","espacioCcas", 'XoI','YoI', 'nombresProblemaOI')
save(pathActual + "01_KNN_CirculosTriangulos_Cuadrados/DatosGenerados/nombresProblema_knn.mat",'nombresProblemaOI');

rmpath(pathMain + 'DatosGenerados')
rmpath(pathMain + 'Funciones')