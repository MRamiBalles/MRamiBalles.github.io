clear, close all

load ./02_Extraer_Representar_Datos/VariablesGeneradas/DatosColorSinOutliers.mat
load 02_Extraer_Representar_Datos\VariablesGeneradas\datosEsfera.mat %% Cargar de MULTIPLESESFERAS, no este!!!

representa_datos_multiples_esferas(X,Y)

[N,M,numComp, numImg] = 

criteriosRadio{1} = 
color = [0 255 0]
vector = [] %imagenes que queremos mostrar si no queremos todas!!
for j = 1:length(vector)
    

end

%% Eleccion de radio en base al analisis de las imagenes anteriores
radio = 3
datosMultiplesEsferasClasificador = datos_multiples_esferas(:, [1:3 3+radio]);

% Eliminar agrupaciones con menos cantidad de pixeles que el objeto de
% seguimiento en la posición más alejada!!!
I_objetoLejos = I14
Ib = roipoly(I_objetoLejos);
numPixRef = sum(Ib(:));
numPixAnalisis = round([0.5 0.75 0.9]*numPixRef)

numImg = 14;
cloase all
for i = 1:numImg
    figure(i), set(i, 'Name', ['Imagen de Calibracion numero ', num2str(i)])
    I =imagenes(:,:,:,i);

    Ib_deteccion_por_distancia()
end
close all
numPixMin = numPixAnalisis(2); %% Decidir mejor numero de pixeles minimos que filtrar
save("04_AjusteClasificador_ImgCalib\Variables Generadas\parametros_clasificador.mat","datosMultiplesEsferasClasificador", "numPixMin")


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%% Ultima parte
%% Para cada frame del video
    % calcula_multiples_esferas_en_imagen()
    % filtrar las agrupaciones minimas si se pide
    % si queremos mostrar pixeles -> funcion_visualiza directamente
    % bwlabel(Ib)
    % regionProps('centroid')