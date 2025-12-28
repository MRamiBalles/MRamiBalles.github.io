[Ietiq N] = bwlabel(Ib); %Ib = matriz binaria ;Ietiq = matriz etiquetada
stats = regionprops(Ietiq,'Area','Centroid');

 % stats.Area % contiene información de las áreas de cada objeto
 % stats.Centroid - contiene información de la coordenada x (columna)
 % y la coordenada y (fila) del centroide de cada objeto

areas = cat(1,stats.Area); % vector columna con las áreas de cada objeto
centroides = cat(1,stats.Centroid); % matriz de dos columnas (x,y) y
 % tantas filas como objetos etiquetados distintos de cero haya
MatrizBinaria_ObjetosGrandes = bwareaopen(MatrizBinaria,NumPix); % se eliminan de la MatrizBinaria 
% todos las agrupaciones de píxeles a "1" compuestas por menos de NumPix pixeles.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

clear all
clc
% Función que devuelve una estructura con información del hardware de adquisición de imágenes
% disponible, incluyendo los adaptadores de video instalados
datos=imaqhwinfo;
datos.DeviceInfo(1).SupportedFormats
% InstalledAdaptors: {'coreco' 'demo' 'winvideo'}
% MATLABVersion: '7.4 (R2007a)'
% ToolboxName: 'Image Acquisition Toolbox'
% ToolboxVersion: '2.1 (R2007a)'
% Función que devuelve una estructura con información del dispositivo de video instalado
datos=imaqhwinfo('winvideo');
% DefaultFormat: 'RGB24_352x288'
% DeviceFileSupported: 0
% DeviceName: 'ICatch (VI) PC Camera'
% DeviceID: 1
% ObjectConstructor: 'videoinput('winvideo', 1)'
% SupportedFormats: {1x10 cell}
%
% SupportedFormats
%
% 'I420_160x120' 'I420_176x144' 'I420_320x240' 'I420_352x288' 'I420_640x480'
%
% 'RGB24_160x120' 'RGB24_176x144' 'RGB24_320x240' 'RGB24_352x288' 'RGB24_640x480'
% Funcion para crear el objeto de video que contiene la configuracion del
% dispositivo de adquisición de imagenes (WebCam, cámara...) y
% con el que Matlab se comunicara con
% el dispositivo de adquisicion de imágenes (Webcam, camara,...)
video=videoinput('winvideo',1,'MJPG_320x240'); 
%video=videoinput('winvideo',1,'YUY2_320x240'); 
preview(video)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%% Con el frameGrabInterval se reduce la tasa de frames recogidos por segundo (fps)
%%%%% video.FramesAcquired y video.FramesAvailable
%%%% Con getData vamos rescatando de memoria los frames disponibles!!
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Para acceder a la informacion de este objeto Matlab:
get(video)
imaqhelp videoinput
dim = video.VideoResolution
nF = dim(2)
nC = dim(1)
% General Settings:
% DeviceID = 1
% DiskLogger = []
% DiskLoggerFrameCount = 0
% EventLog = [1x0 struct]
% FrameGrabInterval = 1
% FramesAcquired = 0
% FramesAvailable = 0
% FramesPerTrigger = 10
% Logging = off
% LoggingMode = memory
% Name = RGB24_352x288-winvideo-1
% NumberOfBands = 3
% Previewing = off
% ROIPosition = [0 0 352 288]
% Running = off
% Tag =
% Timeout = 10
% Type = videoinput
% UserData = []
% VideoFormat = RGB24_352x288
% VideoResolution = [352 288]
% Color Space Settings:
% BayerSensorAlignment = grbg
% ReturnedColorSpace = rgb
%
% Callback Function Settings:
% ErrorFcn = @imaqcallback
% FramesAcquiredFcn = []
% FramesAcquiredFcnCount = 0
% StartFcn = []
% StopFcn = []
% TimerFcn = []
% TimerPeriod = 1
% TriggerFcn = []
%
% Trigger Settings:
% InitialTriggerTime = []
% TriggerCondition = none
% TriggerFrameDelay = 0
% TriggerRepeat = 0
% TriggersExecuted = 0
% TriggerSource = none
% TriggerType = immediate
%
% Acquisition Sources:
% SelectedSourceName = input1
% Source = [1x1 videosource]
% Para ver una pequeña descripcion de lo que es cada parametro:
% imaqhelp videoinput
% Todos estos parameros son modificables abriendo el objeto de video. Doble click en el workspace.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Para capturar una imagen independiente (no afecta el número de disparos y frames por disparos):
preview(video)
% se abre una pantalla grafica que muestra lo que visualiza la camara
I = getsnapshot(video);
% captura la imagen que se está visualizando la camara en el momento de la llamada
% Antes de capturar hay que previsualizar (si no se captura una imagen en negro)
imtool(I) % para mostrar la imagen por imtool
% Hay camaras que no ofrecen modelo RGB de salida, sino que ofrecen modelos
% de color basados en luminancia y dos componentes cromaticas YCbCr, YUY,...
% Hay que aplicar alguna función MATLAB que transforme el modelo de color a RGB
% Esta funcion es: ycbcr2rgb.m para modelos YCbCr.
video=videoinput('winvideo',1,'MJPG_320x240'); %
preview(video)
I = getsnapshot(video);
image(I)
Imod=ycbcr2rgb(I);
imshow(Imod)
% Otra opcion es editar el objeto video y seleccionar el modelo de color de
% salida de la imagen - En ReturnedColorSpace
% De esta forma, se hace la conversión de forma automatica, sin necesidad
% de aplicar ninguna funcion.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% VIDEO: Adquisicion de imagenes, frames, continuada. Parametros de interes
video.TriggerRepeat=3; % set(video,'TriggerRepeat',Inf);
% numero de disparos adicionales programados para el dispositivo.
% si tiene un valor 3, se ejecutan 4 disparos
% video.TriggerRepeat=inf; % set(video,'TriggerRepeat',Inf); Con esta configuracion, infinitos disparos
video.FramesPerTrigger=3;
% Numero de imagenes o frames que se capturan por disparo
video.FrameGrabInterval=3;
% Respecto a los frames que la camara puede adquirir a su maxima velocidad
% de captura (tipicamente 30 fps), se almacenan en memoria el primero de cada tres hasta
% un total de (numero de disparos * Frames por Disparos).
% Este parametro es importante porque determina los frames por segundo fps
% a la que se graba en memoria (para que un video se pueda ver de forma
% aceptable se deben mostrar al menos 1 fps).
% Si por ejemplo el dispositivo de video es capaz de capturar 4 fps
% y se fija el FrameGrabInterval a 2,
% las imgenes se han grabado en memoria con una tasa de 2fps.
% LoggingMode = memory;
% el almacenamiento de los frames es en memoria -tambien puede ser en disco
% TriggerType = immediate
% El numero de disparos programado es inmediato, uno detras de otro
% La otra opcion es disparar de forma manual, si lo permite el dispositivo.
% Video.FramesAcquired
% En esta variable se almacena el numero de Frames que se han adquirido
% con getdata. La instruccion getdata permite guardar como variable matlab
% uno o varios frames guardados en memoria.
% Para cambiar estos parametros, puede hacerse como se ha mostrado o
% haciendo doble click en el objeto video en el Workspace y modificar las
% opciones.
% Para comenzar a capturar una secuencia de frames:
start(video) % el dispositivo de video empieza a funcionar con la
% configuración almacenada en el objeto.
% Si el disparo es inmediato y el número de disparos infinito, está
% continuamente capturando fotos hasta que se llame la función stop(video).
% No todos los frames se guardan en memoria
% - sólo los que indica video.FrameGrabInterval
stop(video) % para detener una adquisición de video

% CREAR UNA SECUENCIA DE 50 FRAMES Y MOSTRARLA:
% 1 OPCION: CAPTURARLOS Y GUARDARLOS EN MEMORIA TODOS, Y DESPUES MOSTRARLOS
% ESTA OPCION NO SE APLICA PERO ES ILUSTRATIVA DEL FUNCIONAMIENTO
video.TriggerRepeat=1 % dos disparos programados para el dispositivo.
video.FramesPerTrigger=25;
% Numero de imagenes o frames que se capturan por disparo
video.FrameGrabInterval=2;
% Con esta configuraciun se graban en memoria uno de cada dos frames
% que el dispositivo es capaz de capturar a su maxima velocidad.
% Se reducen los fps guardados en memoria a la mitad.
% El numero de frames capturados siguen siendo 50, pero estan mas
% espaciados en el tiempo.
start(video)
% Cuando termina, se puede ver un reporte con video: se puede comprobar que
% hay 50 frames disponibles con getdata
% Para mostrarlos:
N=((video.TriggerRepeat+1)*video.FramesPerTrigger);
% N es el número de frames guardados en memoria
% Accedemos a la memoria para ir cogiendo frames de uno en uno y los vamos
% mostrando con imshow
figure, hold on
for i=1:N
 I=getdata(video,1);
 imshow(I)
end
start(video)
% Accedemos de golpe a toda la informacion de la memoria y la mostramos
I=getdata(video,N);
[Filas Columnas Bandas Imagenes]=size(I);
% Primera imagen: I(:,:,1,1)
% Ultima imagen: I(:,:,1,N)
for i=1:N
 imagen=I(:,:,1,i);
 figure,imshow(imagen) % se abren N imagenes pero podemos ver lo grabado
end

% SEGUNDA OPCIÓN QUE ES LA QUE SE UTILIZA:
% Se programan infinitos disparos y el video termina cuando se han
% adquirido de la memoria un número determinado de frames
video.TriggerRepeat=inf; % disparos continuados
video.FramesPerTrigger=1;
% Número de imágenes o frames que se capturan por disparo
video.FrameGrabInterval=1; % Hacer para un valor 10 y 20;
start(video)
while (video.FramesAcquired<50)
I=getdata(video,1); % captura un frame guardado en memoria. A medida que se va llamando
% a esta funcion se van capturando los frames en el mismo orden cronologico
% en que fueron guardados
% Ver la ayuda de esta función: admite guardar simultanemente un numero mayor de frames, en cuyo
% caso se almacena en I un vector de frames.
imshow(255-I) % para ir mostrando la secuencia de frames - en este caso se muestra la imagen
complemtaria
end
stop(video)
% Para ver el reporte de los frames que se han capturado con getdata
% y los que quedan por capturar guardados en memoria:
video
% SELECCION DE video.FrameGrabInterval
% La funcion getdata permite guardar informacion temporal
% de cuando se han tomado los frames. Esto es importante porque, fijando
% video.FrameGrabInterval a 1 (es decir se guardan los frames a la maxima
% velocidad de captura en memoria), permite tener una idea de los fps
% que nuestro dispositivo de video es capaz de capturar.
% En base a ello podemos fijar
% el numero de frames por segundo que queremos que
% se graben en memoria a traves del parametro video.FrameGrabInterval, para
% que la secuencia de video registrada se visualice con un minimo de 1fps.
% Un Ejemplo seria:
video.FrameGrabInterval=1;
start(video)
TIEMPO=[];
while (video.FramesAcquired<100)
 % Como ahora se graban todos los frames a la velocidad de captura de la
 % camara, varios frames por segundo,
 % para que la secuencia dure un poco más de tiempo hay que programar un
 % mayor numero de frames adquiridos con getdata
[I TIME]=getdata(video,1);
TIEMPO=[TIEMPO ; TIME];
gamma=1.5;
I=imadjust(I,[],[],gamma);
imshow(I) % para ir mostrando la secuencia de frames - en este caso se muestra una secuencia mas "clara"
end
stop(video)
video
% En este ejemplo se ha guardado en la variable TIEMPO los instantes de
% tiempo, contados desde el primer disparo, en los que secapturan los frames que se graban

%% EJEMPLO:
% 1.- Visualizar una secuencia de video que muestre el seguimiento de una determinada zona de la escena. 
% Esta zona sera proporcionada al proceso mediante una imagen almacenada en el ordenador. 
% Utilizaremos la correlacion normalizada para realizar el seguimiento.
clear all
clc
datos=imaqhwinfo('winvideo');
video=videoinput('winvideo',1,'MJPG_320x240'); %
video.ReturnedColorSpace='grayscale';
% CAPTURAMOS UNA IMAGEN PARA EXTRAER LA PLANTILLA
preview(video) % se abra una pantalla grafica que muestra lo que visualiza la camara (1fps)
I = getsnapshot(video);

numFrames = 100;
wh = video.VideoResolution
numFilas = wh(2); numCol = wh(1);
W = 5; vMin = 1+ floor(W/2);
vMax = numFilas - floor(W/2)
valoresX = vMin + 

for i = 1:numFrames
    I = getdata(video,1);
    x = valoresX(i);
    y = valoresY(i);

    subplot(2,1,1),

end


%% Intentar con la funcion visualiza donde la Ib sea la region de interes!!!!

% De forma manual
imtool(I) % para mostrar la imagen por imtool y sacar las coordenadas de la plantilla
imtool close all
fila1=50; fila2=75; columna1=155; columna2=180;
Plantilla=I(fila1:fila2,columna1:columna2);
imshow(Plantilla)
% De forma automatizada utilizamos la instrucción roipoly para seleccionar un area de interes
% Pinchamos cuatro veces crear el poligono de interes y doble click.
roi = roipoly(I); % Matriz lógica, donde a 1 se marcan los pixeles de interes



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% EJERCICIOS:
% 1.- Utilizando la función de Matlab subplot, muestre en una misma ventana tipo figure la
% imagen capturada y 3 imágenes que resalten, sobre la imagen original, aquellos píxeles cuya
% intensidad sea mayor que un determinado umbral (asigne para esas 3 imágenes, valores de
% umbral: 70, 140 y 210, respectivamente). La intensidad de un píxel se calculará como la
% media de los niveles de gris de las componentes roja, verde y azul.

video=videoinput('winvideo',1,'MJPG_320x240'); 
preview(video)
I = getsnapshot(video);
imshow(I)
R = double(I(:,:,1)); G = double(I(:,:,2)); B = double(I(:,:,3)); %Para no desbordar al sumar mas de 255
umbral = [70,140,210];
Iint = (R + G + B) / 3; %uint8((R + G + B) / 3);
Iint2 = rgb2gray(I)

Ib1 = Iint > umbral(1);
Ib2 = Iint > umbral(2);
Ib3 = Iint > umbral(3);

% Mostrar las imágenes en una misma ventana
figure;
subplot(2, 2, 1);
imshow(uint8(I));
title('Imagen original');

subplot(2, 2, 2);
imshow(Ib1);
title(['Umbral: ', num2str(umbral(1))]);

subplot(2, 2, 3);
imshow(Ib2);
title(['Umbral: ', num2str(umbral(2))]);

subplot(2, 2, 4);
imshow(Ib3);
title(['Umbral: ', num2str(umbral(3))]);

% 2.- Para cada una de las imágenes generadas en el apartado anterior:
% - Visualice sobre la imagen original las 5 agrupaciones mayores de píxeles conectados.
% - Localice a través de su centroide las agrupaciones anteriores y, en otro color, el
% centroide de la mayor agrupación para distinguirla.

[Ietiq, N] = funcion_etiquetar(Ib2); % [Ietiq, N] = bwlabel(Ib);
nAgrupaciones = 5;
imshow(Ietiq)
areas = funcion_calcula_areas(Ietiq, N);
centros = funcion_calcula_centroides(Ietiq,N);
[aOrd,indices] = sort(areas, 'descend')
indInt = indices(1:5);
cInt = centros(indInt(:),:);

if N > 0
    stats = regionprops(Ietiq, 'Area', 'Centroid');
    a = cat(1,stats.Area);
    c = cat(1,stats.Centroid);
    [aOrd, indInt] = sort(a,'descend');
    if N < nAgrupaciones
        nAgrupaciones = N;
    end

    cOI = c(ind(1:nAgrupaciones),:);
    centX = cOI(:,2);
    centY = cOI(:,1);
    
    numPix = aOrd(nAgrupaciones);
    Ib = bwareaopen(Ib,numPix); % funcion_filtra_objetos
    Io = funcion_visualiza(I, Ib, [255 255 0], false);
else 
    Io = I;
    centX = 1;
    centY = 1;
end

imshow(Io), % imshow(Ib1), 
hold on, plot(cInt(1,1), cInt(1,2), '*r'),
plot(cInt(2:5,1), cInt(2:5,2), '*b'); 

%% Segunda Parte. - Visualice una secuencia de video que muestre:
% 3.- La escena inicialmente oscurecida y aclarándose progresivamente (utilizar la instrucción
% imadjust y valores de gamma entre 0 y 4 con pasos de 0.05).
video=videoinput('winvideo',1,'MJPG_320x240'); 
preview(video)
video.ReturnedColorSpace = 'rgb';
video.TriggerRepeat = inf;
video.FrameGrabInterval = 3;
gamma = 4:-0.05:0 % gamma mayor que 1 oscurece
start(video)
for i = 1:length(gamma)
    I = getdata(video,1);
    If = imadjust(I,[],[],gamma(i));
    imshow(If)
end
stop(video)

% 4.- Todos los píxeles que tengan una intensidad mayor que un determinado umbral. Asignar
% inicialmente el valor 0 a este umbral e ir aumentándolo progresivamente con pasos de unidad
% hasta el 255.
close all
video=videoinput('winvideo', 1,'MJPG_320x240'); 
preview(video)
video.ReturnedColorSpace = 'grayscale';
video.TriggerRepeat = inf;
video.FrameGrabInterval = 3;
umbral = 0:255;
start(video)
for i = 1:length(umbral)
    I = getdata(video,1);
    Ib = I < umbral(i);
    If = funcion_visualiza(I,Ib,[255,0,0]);
    imshow(If)
end
stop(video)

% 5.1.- Las diferencias que se producen entre los distintos frames de intensidad que captura la
% webcam (utilizar la instrucción imabsdiff para hacer la diferencia entre el frame actual y el
% adquirido previamente).
start(video)
frame_ant = getdata(video,1); 
while video.FramesAcquired < 200
    frame_act = getdata(video,1);
    dif = imabsdiff(frame_act,frame_ant);
    imshow(dif)
    frame_ant = frame_act;
end
stop(video)


% 5.2.- Los píxeles cuyas diferencias de intensidad son significativas (considerar un umbral de
% 100 para establecer de diferencias de intensidad significativas).
umbral = 100;
start(video)
frame_ant = getdata(video,1); 
while video.FramesAcquired < 200
    frame_act = getdata(video,1)
    dif = imabsdiff(frame_act,frame_ant);
    Ib = dif > umbral;
    imshow(Ib)
    frame_ant = frame_act;
end
stop(video)

% 5.3.- El seguimiento de la agrupación mayor de píxeles que presenta una diferencia de
% intensidad significativa. El seguimiento debe visualizarse a través de un punto rojo situado en
% el centroide de la agrupación.
umbral = 100;
start(video)
frame_ant = getdata(video,1); 
while video.FramesAcquired < 100
    frame_act = getdata(video,1);
    dif = imabsdiff(frame_act,frame_ant);
    Ib = dif > umbral;
    frame_ant = frame_act;
    N = bwlabel(Ib);

    if N ~= 0
        stats = regionprops(N, 'Area', 'Centroid');
        [~, id] = max([stats.Area]);
        centroide = stats(id).Centroid;
        
    else
        centroide = [1,1];
    end

    imshow(Ib);
    hold on, plot(centroide(1), centroide(2), '*r');
end
stop(video)


%%%%%%%%%%%%%%%%

I = imread('WhatsApp Image 2024-03-24 at 14.49.37.jpeg');
imshow(I)
Ib = rgb2gray(I);
subplot(1,2,1), imshow(I), subplot(1,2,2), imtool(Ib);