clear, close all, clc

pathMain = "Prueba3_ConvI_SP_23_24\";
path = pathMain + "01_GeneracionDatos\";
addpath('DatosGenerados')
addpath('Funciones')

load(path + "DatosGenerados\ConjuntoDatosXY.mat")
load(path + "DatosGenerados\nombresProblema.mat")

% Variables del problema
[numMuestras, numDescriptores] = size(X);
codifClases = unique(Y);
numClases = length(codifClases);

%% Estandarización
medias = mean(X);
desviaciones = std(X);
medias(end) = 0; % el ultimo descriptor (euler) no se toca
desviaciones(end) = 1;


Z = X;

for i=1:numDescriptores-1
    Z(:,i) = (X(:,i)-medias(i))/(desviaciones(i)+eps);
end

save(path + 'DatosGenerados/conjunto_datos_estandarizados','Z','Y');
save(path + 'DatosGenerados/datos_estandarizados','medias','desviaciones');

rmpath('DatosGenerados')
rmpath('Funciones')