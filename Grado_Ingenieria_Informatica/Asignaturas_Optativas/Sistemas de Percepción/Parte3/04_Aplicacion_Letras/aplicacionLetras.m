clear, clc, close all

pathMain = "Sistemas de Percepción\Parte3\";
rutaFichero = pathMain + "Imagenes\ImagenesLetras\Test\B3.tif";
addpath("Funciones")

Funcion_Reconoce_Forma_LDA_QDA(rutaFichero)

rmpath("Funciones")