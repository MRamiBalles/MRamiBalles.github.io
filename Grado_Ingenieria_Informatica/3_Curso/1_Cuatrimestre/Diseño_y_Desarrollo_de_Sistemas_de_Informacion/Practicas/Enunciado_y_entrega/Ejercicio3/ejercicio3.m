%% Ejercicio 3 - Calculo y representacion de datos esferas de agrupaciones

clc, clear, close all
load("Enunciado_y_entrega\Ejercicio3\VariablesRequeridas\conjunto_de_datos.mat")
XColor = X(Y == 1, :);
XFondo = X(Y ~= 1, :);
numEsferas = 5;

datosMultiplesEsferas = calcula_datos_multiples_Esferas(XColor, XFondo, numEsferas);

save("Enunciado_y_entrega\Ejercicio3\datosMultiplesEsferas.mat", "datosMultiplesEsferas")


%% Apartado 2:
representa_datos_multiples_esferas(XColor, XFondo, datosMultiplesEsferas)
