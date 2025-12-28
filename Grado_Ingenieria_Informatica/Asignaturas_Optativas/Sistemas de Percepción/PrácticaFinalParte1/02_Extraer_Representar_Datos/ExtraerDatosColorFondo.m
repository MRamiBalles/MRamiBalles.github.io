clear
addpath('./Funciones')

%% Lectura de imagenes y extraccion de datos
ruta = './01_GeneracionMaterial/MaterialGenerado/'

imagenes = load([ruta 'ImagenesCalibracion.mat'])
for i = 1:14 
    sentencia = ['imagen = imagenes.I' num2str(i) ';'];
    eval(sentencia)
    Icalib(:,:,:,i) = imagen;
end
[F, C, NumComp, NumImg] = size(Icalib);

for i = 1:NumImg
    imshow(Icalib(:,:,:,i)), title(num2str(i)) %% Ultima imagen con el objeto en la posicion mas alejada
    pause
end


%% Presentacion :
 I = imread(I1)
 ROI = roipoly(I);
 datos = [R(ROI) G(ROI) B(ROI)];

 %% Datos RGB de los pixeles de interes extraidos de varias regiones
 numRegiones = 2;
 NumImg = 14;
 datos = [];
 for i = 1:NumImg
    I = Icalib(:,:,:,i);
    R = I(:,:,1);
    G = I(:,:,2);
    B = I(:,:,3);

    % Mostrar la imagen actual
    figure;
    imshow(I);
    title(['Imagen ' num2str(i)]);

    for j = 1:numRegiones
        ROI = roipoly(I);
        numPix = sum(ROI(:));
        datos = [datos; i*ones(numPix,1) R(ROI) G(ROI) B(ROI)]
    end
 end

 datosAzul = datos; 
 YAzul = ones(size(datosAzul,1),1);
 datosOtrosColores = datos;
 YOtrosColores = zeros(size(datosOtrosColores,1),1);

 X = [datosAzul(:,2:4) ; datosOtrosColores(:,2:4)];
 Y = [YAzul; YOtrosColores];

 %% Representacion:
 figure, plot3(datosAzul(:,1),datosAzul(:,2),datosAzul(:,3),'*b')
 hold on
 plot3(datosOtrosColores(:,1),datosOtrosColores(:,2),datosOtrosColores(:,3),'*r')

 axis([0 255 0 255 0 255])
 legend('Datos azules', 'Datos otros colores')
 xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B')
 
 save('./VariablesGeneradas/DatosColor.mat', 'X', 'Y')

 %% Cargar Datos X e Y:
 addpath('./VariablesGeneradas/')
 load DatosColor.mat

  %% Representacion 2.2:
 datosAzul = X(Y == 1,:);
 datosOtrosColores = X(Y ~= 1,:);
 figure, plot3(datosAzul(:,1), datosAzul(:,2),datosAzul(:,3),'*b')
 hold on
 plot3(datosOtrosColores(:,1),datosOtrosColores(:,2),datosOtrosColores(:,3),'*r')
 axis([0 255 0 255 0 255])
 legend('Datos azules', 'Datos otros colores')
 xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B')