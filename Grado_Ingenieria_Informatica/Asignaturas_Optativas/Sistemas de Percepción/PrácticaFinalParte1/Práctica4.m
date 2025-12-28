%% Práctica final:
clear
video=videoinput('winvideo', 1,'MJPG_320x240'); 
preview(video)
I14 = getsnapshot(video);
video.ReturnedColorSpace = 'rgb';
video.TriggerRepeat = inf;
video.FrameGrabInterval = 3;
fpsMax = 30;
fpsTrabajo = round(fpsMax/video.FrameGrabInterval)

%% Generar video:
aviobj = VideoWriter('Ejemplo.avi'); %  VideoWriter('Ejemplo.avi', 'Grayscale AVI');
aviobj
aviobj.FrameRate = fpsTrabajo;
duracionVideo = 15;
numFramesVideo = duracionVideo* aviobj.FrameRate;
open(aviobj)
start(video)
for i = 1:numFramesVideo
    %% Si la resolución no es la necesaria de 320x240
    %I = imresize(getdata(video,1), 0.5);
    I = getdata(video,1);
    imshow(I)
    writeVideo(aviobj, I)
end
stop(video)
close(aviobj)

%% Guardar auto la secuencia de entrada
aviobjI = VideoWriter('SecienciaEntrada.avi')
aviobjI =

set()

%% Modificacion de ejercicios:
clear
aviobjI = VideoReader('Ejemplo.avi');
get(aviobjI)
NumeroFrames = aviobjI.Duration*aviobjI.FrameRate;
NumFilas = aviobjI.Height;
NumCol = aviobjI.Width;

W = 15;
vMin = 1+floor(W/2);
vMAx = NumCol;
valoresX = round(vMin + (vMax-vMin))
aviobjI.CurrentTime = 0;
for i = 1:numFramesVideo
    I = readFrame(aviobjI);
    x = valoresX(i,1);
    y = valoresY(i,1);
    
    I(y - floor(W/2) : y + floor(W/2), x, 1) = 255;
    I(y, x - floor(W/2) : y + floor(W/2), x, 1) = 255;
    I(y - floor(W/2) : y + floor(W/2), x, 2:3) = 0;
    I(y, x - floor(W/2) : y + floor(W/2), x, 2:3) = 0;
end














fps = aviobjI.FrameRate;

% Lectura de un frame especifico: .currentTime +0.1 al ir a 10fps
I1 = readFrame(aviobjI);
aviobjI
I2 = readFrame(aviobjI)
aviobjI

NFrame = 10;
IN = (NFrame-1)/aviobjI.FrameRate;

%%%%%
%% Completar problema de reconocimiento de frutas: Clasificación (Aprendizaje Supervisado)
addpath('DirImagenes')
directorio = dir("DirImagenes\"+.jpg)
numImagenes = length(directorio);
X = zeros(numImagenes,2)
uExc = 0.55;
for i = 1:numImagenes
    nombreImagen = directorio(i)
    % nombreImagen = 'fresa.jpg';
    I = rgb2gray(imread(nombreImagen));
    Ib = I < 255^graythresh(I);
    [Ietiq, N] = bwlabel(Ib);
    if N > 1
        stats = regionprops(Ietiq, 'Area');
        areas = cat(1,stats.Area);
        areaMayor = max(areas);
        Ib = bwareaopen(Ib, areaMayor);
    end
    stats = regionprops(Ib, 'Eccentricity');
    exc = cat(1,stats.Eccentricity);
     % Ampliamos clasificador :
    if e > uExc

    else

    end
end

X_Strawberry = X;
rmpath('Strawberry')

figure, plot(X_Redcurrant(:,1), X_Redcurrant(:,2))