clear, clc, close all

pathMain = "Sistemas de Percepción/Parte3/";
rutaFicheroImagen = pathMain + "Imagenes/ImagenesFiguras/Test/Test1.JPG";
addpath(pathMain + 'Funciones')

%funcion_Reconoce_Forma_LDA(rutaFicheroImagen)
%funcion_Reconoce_Forma_QDA(rutaFicheroImagen)
funcion_Reconoce_Forma_KNN(rutaFicheroImagen)
%funcion_Reconoce_Forma_LDA_KNN(rutaFicheroImagen)
%funcion_Reconoce_Forma_LDA_KNN_Mod(rutaFicheroImagen)

addpath(pathMain + 'Funciones')