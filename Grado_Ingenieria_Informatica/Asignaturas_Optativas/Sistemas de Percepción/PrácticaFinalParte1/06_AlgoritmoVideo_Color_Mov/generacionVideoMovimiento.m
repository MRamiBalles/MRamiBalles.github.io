
clc, clear, close all
addpath("05_AlgoritmoVideo_SoloColor\Variables Requeridas\")
addpath("03_DisenoClasificador\Funciones\")
load 04_AjusteClasificador_ImgCalib\'Variables Generadas'\datosEsferasClasificador3Agrup.mat
load 04_AjusteClasificador_ImgCalib\'Variables Generadas'\numPix.mat

fichero = 'Ejemplo.avi';
video = VideoReader(fichero);

% Crear un objeto para guardar el video procesado
salida = VideoWriter('Movimiento.mp4', 'MPEG-4');
salida.FrameRate = video.FrameRate
open(salida);

verde = [0 255 0];

% Obtener información del video
get(video);

% Iniciar el video desde el principio y procesar cada frame
video.CurrentTime = 0;

% Establecer umbral de movimiento
umbral_movimiento = 50;

% Guardar el frame anterior para comparar los pixeles con el actual
frameAnt = readFrame(video);
Iintensidad_frameAnt = uint8(mean(frameAnt, 3));

for i=2:video.NumFrames
    % Lee frame actual
    I = readFrame(video);

    % Calcula media de la intensidad de los 3 canales
    Iintensidad = uint8(mean(I,3));

    % Visualiza, aquellos pixeles que se encuentren entre los umbrales
    IbMov = imabsdiff(Iintensidad_frameAnt, Iintensidad) > umbral_movimiento;
    Io = funcion_visualiza(I, IbMov, verde, false);

    imshow(Io);

    writeVideo(salida, Io);

    % Guardar frame anterior para comparar pixeles con el frame presente
    frameAnt = I;
    % Intensidad del frame anterior
    Iintensidad_frameAnt = uint8(mean(frameAnt, 3));

end

% Cierra el objeto de video
close(salida);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%55

fichero = 'Ejemplo.avi';
video = VideoReader(fichero);

% Crear un objeto para guardar el video procesado
salida = VideoWriter('MovimientoEsferas.mp4', 'MPEG-4');
salida.FrameRate = video.FrameRate;
open(salida);
rojo = [255 0 0];
verde = [0 255 0];
amarillo = [255 255 0];

% Obtener información del video
get(video);

% Iniciar el video desde el principio y procesar cada frame
video.CurrentTime = 0;

% Establecer umbral de movimiento
umbral_movimiento = 50;

% Guardar el frame anterior para comparar los pixeles con el actual
frameAnt = readFrame(video);
Iintensidad_frameAnt = uint8(mean(frameAnt, 3));

for i=2:video.NumFrames
    % Lee frame actual
    I = readFrame(video);

    % Calcula media de la intensidad de los 3 canales
    Iintensidad = uint8(mean(I,3));

    % Realiza la detección de las esferas en la imagen actual
    IbEsferas = bwareaopen(calcula_deteccion_multiples_esferas_en_imagen(I, datosEsferasClasificador(:, 4), datosEsferasClasificador(:, 1:3)), round(numPixUmbral));

    % Visualiza, aquellos pixeles que se encuentren entre los umbrales de movimiento
    IbMov = imabsdiff(Iintensidad_frameAnt, Iintensidad) > umbral_movimiento;
    
    % Pixeles en movimiento que no pertenecen a las esferas en verde
    IbMovNoEsfera = IbMov & ~IbEsferas;
    
    % Pixeles en movimiento que pertenecen a las esferas en el color especificado
    IbMovEsfera = IbMov & IbEsferas;
    
    %IbCombinada = IbMovNoEsfera | IbMovEsfera | IbEsferasNoMov;

    % Visualizar la imagen con las detecciones
    Io = funcion_visualiza(I, IbEsferas, rojo, false);
    Io = funcion_visualiza(Io, IbMovNoEsfera, verde, false);
    Io = funcion_visualiza(Io, IbMovEsfera & IbEsferas, amarillo, false);
    
    imshow(Io)

    writeVideo(salida, Io);

    % Guardar frame anterior para comparar pixeles con el frame presente
    frameAnt = I;
    % Intensidad del frame anterior
    Iintensidad_frameAnt = uint8(mean(frameAnt, 3));

end

% Cierra el objeto de video
close(salida);