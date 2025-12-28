%% Práctica final:
clear
video=videoinput('winvideo', 1,'MJPG_320x240'); 
preview(video)
% I14 = getsnapshot(video);
imagenes = [I1 I2 I3 I4 I5 I6 I7 I8 I9 I10 I11 I12 I13 I14];
save('ImagenesCalibracion.mat', 'I1', 'I2', 'I3', 'I4', 'I5', 'I6', 'I7', 'I8', 'I9', 'I10', 'I11', 'I12', 'I13', 'I14');

%% Configurar video:
video.ReturnedColorSpace = 'rgb';
video.TriggerRepeat = inf;
video.FrameGrabInterval = 3;
fpsMax = 30;
fpsTrabajo = round(fpsMax/video.FrameGrabInterval)

%% Generar secuencia de video:
aviobj = VideoWriter('Ejemplo2.avi'); %  VideoWriter('Ejemplo.avi', 'Grayscale AVI');
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