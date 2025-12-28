%% Implementacion y visualizacion del algoritmo de seguimiento

clc, clear, close all
addpath("05_AlgoritmoVideo_SoloColor\Variables Requeridas\")
addpath("03_DisenoClasificador\Funciones\")
load 04_AjusteClasificador_ImgCalib\'Variables Generadas'\datosEsferasClasificador3Agrup.mat
load 04_AjusteClasificador_ImgCalib\'Variables Generadas'\numPix.mat

fichero = 'Ejemplo.avi';
video = VideoReader(fichero);
% Obtener informacion del video
get(video);

% Crear un objeto para guardar el video procesado
salida = VideoWriter('DeteccionPixeles.mp4', 'MPEG-4');
salida.FrameRate = video.FrameRate
open(salida);

% Iniciar el video desde el principio y procesar cada frame
video.CurrentTime = 0;
for i = 1:video.NumFrames
    % Leer el frame actual del video
    I = readFrame(video);
    
    % Realizar la detección de las esferas en la imagen
    Ib = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosEsferasClasificador(:, 4), datosEsferasClasificador(:, 1:3)), round(numPixUmbral));
    
    % Visualizar la imagen con las detecciones
    Io = funcion_visualiza(I, Ib, [255 0 0], false);
    imshow(Io);
    
    % Guardar el frame procesado en el archivo de video
    writeVideo(salida, Io);
end

% Cerrar el archivo de video
close(salida);


%%%%%%%%%%%%%%%%%%%%%%%%





%% Detección del centroide mayor

fichero = 'Ejemplo.avi';
video = VideoReader(fichero);
% Obtener informacion del video
get(video);

% Crear un objeto para guardar el video procesado
salida = VideoWriter('DeteccionCentroideMayor.mp4', 'MPEG-4');
salida.FrameRate = video.FrameRate
open(salida);

% Iniciar el video desde el principio y procesar cada frame
video.CurrentTime = 0;
for i=1:video.NumFrames
    % Leer el frame actual del video
    I = readFrame(video);
    
    % Realizar la detección de las esferas en la imagen
    Ib = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosEsferasClasificador(:, 4), datosEsferasClasificador(:, 1:3)), round(numPixUmbral));
    
    % Calcular las propiedades de las regiones detectadas
    stats = regionprops(Ib, 'Area', 'Centroid'); 
    centroids = cat(1, stats.Centroid);
    areas = cat(1, stats.Area);

    % Si se detectó algún objeto, marcamos centroide y visualizamos la imagen
    if(~isempty(centroids))
        % Seleccionamos el objeto con mayor área detectado
        [~, pos] = max(areas);

        % Obtenemos las coordenadas del centroide del objeto seleccionado
        x = round(centroids(pos, 2));
        y = round(centroids(pos, 1));

        % Creamos una imagen binaria del tamaño de la imagen original
        Ibcent = zeros(size(I, 1), size(I, 2));
        % Marcamos una región de 3x3 píxeles centrada en el centroide del objeto
        Ibcent(x-1 : x+1, y-1 : y+1) = 1;
        % Visualizamos la imagen original con el objeto marcado en rojo
        Io = funcion_visualiza(I, Ibcent & Ib, [255 0 0], false);

    % Si no se detectó ningún objeto, marcar un área predefinida y se muestra la imagen
    else
        % Crear una imagen binaria del tamaño de la imagen original
        Ibcent = zeros(size(I, 1), size(I, 2));
        % Marcamos una región predefinida de 3x3 píxeles en la esquina superior izquierda
        Ibcent(1:3, 1:3) = 1;
        % Visualizar la imagen original con el área marcada en rojo
        Io = funcion_visualiza(I, Ibcent & Ib, [255 0 0], false);
    end
    
    % Mostrar la imagen resultante 
    imshow(Io), hold on;
    writeVideo(salida, Io);

end

close(salida);


%% Obtener todos los centroides

fichero = 'Ejemplo.avi';
video = VideoReader(fichero);
% Obtener informacion del video
get(video);

% Crear un objeto para guardar el video procesado
salida = VideoWriter('DeteccionCentroides.mp4', 'MPEG-4');
salida.FrameRate = video.FrameRate;
open(salida);

% Iniciar el video desde el principio y procesar cada frame
video.CurrentTime = 0;
for i = 1:video.NumFrames
    % Leer el frame actual del video
    I = readFrame(video);
    
    Ib = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosEsferasClasificador(:, 4), datosEsferasClasificador(:, 1:3)), round(numPixUmbral));
    
    % Calcular las propiedades de las regiones detectadas
    stats = regionprops(Ib, 'Centroid'); 
    centroids = cat(1, stats.Centroid);

    % Crear una imagen binaria del tamaño de la imagen original
    Ibcent = zeros(size(I, 1), size(I, 2));

    % Iterar sobre todos los centroides detectados y marcarlos en la imagen
    for j = 1:size(centroids, 1)
        % Obtener las coordenadas del centroide
        x = round(centroids(j, 2));
        y = round(centroids(j, 1));
        % Marcar una región de 3x3 píxeles centrada en el centroide
        Ibcent(x-1 : x+1, y-1 : y+1) = 1;
    end
    
    % Visualizar la imagen original con los centroides marcados en rojo
    Io = funcion_visualiza(I, Ibcent & Ib, [255 0 0], false);
    
    % Mostrar la imagen resultante 
    imshow(Io), hold on;
    
    % Guardar el frame procesado en el archivo de video
    writeVideo(salida, Io);
end

% Cerrar el archivo de video
close(salida);










%% Detecta Color En Memoria - tiempo real
% Deshabilita el límite de uso de memoria física
imaqmex('feature','-limitPhysicalMemoryUsage',false);
% Obtiene información sobre la cámara conectada
datos = imaqhwinfo('winvideo');

% Crea un objeto de video con la cámara conectada, especificando los detalles de la configuración
video = videoinput('winvideo',1,'MJPG_320x240');
video.TriggerRepeat = inf;
video.FramesPerTrigger = 3;
video.FrameGrabInterval = 3;

% Inicia la captura de video
start(video);
while(video.FramesAcquired<150)
    % Captura una imagen de la cámara
    I = getdata(video,1);
    % Detecta las esferas en la imagen y las convierte en un mapa binario 
    Ib = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosEsferasClasificador(:, 4), datosEsferasClasificador(:, 1:3)), numPixUmbral);
    
    % Crea una imagen visualizada con los objetos detectados resaltados en rojo
    Io = funcion_visualiza(I,Ib,[255 0 0], false);

    % Muestra la imagen 
    imshow(Io);
end

% Detiene la captura de video y vacía los datos almacenados en el objeto de video
stop(video);
flushdata(video);

% Quita el directorio de funciones del path
rmpath(pathsArchivos + 'Funciones');