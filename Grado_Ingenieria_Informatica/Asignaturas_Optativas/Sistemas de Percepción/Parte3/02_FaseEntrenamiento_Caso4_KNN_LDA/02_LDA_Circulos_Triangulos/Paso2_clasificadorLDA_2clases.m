clear, clc, close all

pathMain = "Sistemas de Percepción\Parte3\";
pathActual = pathMain + "02_FaseEntrenamiento_Caso4_KNN_LDA/";

addpath(pathMain + 'Funciones')

%% Cargamos datos de interes

%% Cargamos el espacio de características obtenido en la etapa de selección de descriptores
nombreFichero = "espacioCcas_Circulo_Triangulo_LDA.mat";
load(pathActual + "02_LDA_Circulos_Triangulos/DatosGenerados/" + nombreFichero);

clear nombreFichero;

%% Calculamos la función de decisión lineal -> Clasificador LDA
[d1, d2, d12, coeficientes_d12] = funcion_calcula_hiperplanoLDA_2Clases_2_3_Dim(XoI, YoI);

%% Representamos muestras y plano del clasificador
close all
funcion_representa_hiperplano_separacion_2_3_Dim(coeficientes_d12, XoI);

% funcion_representa_muestras_clasificacion_binaria_con_frontera(XoI, YoI, nombresProblemasoI, coeficientes_d12)
load(pathActual + "02_LDA_Circulos_Triangulos/DatosGenerados/nombresProblema_LDA.mat");
save(pathActual + "02_LDA_Circulos_Triangulos/DatosGenerados/espacioCcas_LDA_Circulo_Triangulo.mat", "d12", "coeficientes_d12","espacioCcas", 'XoI','YoI', "nombresProblemaOI")

rmpath(pathMain + 'Funciones')