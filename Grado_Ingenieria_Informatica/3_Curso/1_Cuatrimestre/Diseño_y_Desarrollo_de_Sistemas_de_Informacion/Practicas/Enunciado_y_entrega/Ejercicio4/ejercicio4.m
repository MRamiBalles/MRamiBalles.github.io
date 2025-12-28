%% Ejercicio 3 - Calculo y representacion de datos esferas de agrupaciones


load("Enunciado_y_entrega\Ejercicio4\VariablesRequeridas\ImTrain.jpg")
load("Enunciado_y_entrega\Ejercicio4\VariablesRequeridas\datos_multiples_esferas.mat")
radios = datosMultiplesEsferas(4:6);
centroides = datosMultiplesEsferas(1:3);
 I = imread("ImTrain.jpg");
%  imshow(I)
    % Calcula la detección de la esfera en la imagen
    Ib1 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 1), centroides);
    Ib2 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 2), centroides);
    Ib3 = calcula_deteccion_multiples_esferas_en_imagen(I, radios(:, 3), centroides);
    
    % Muestra la imagen original con los centroides resaltados
    figure;
    subplot(2,2,1)
    imshow(I);
    hold on;
    title('Imagen original');
    
    % Resto de subplots con los pixeles que quedan dentro de las esferas:
    subplot(2, 2, 2);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib1);
    plot(cols, rows, 'y.');
    legend('Puntos dentro de la esfera grande');
    title('Imagen con esfera grande');

    subplot(2, 2, 3);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib2);
    plot(cols, rows, 'y.');
    legend('Puntos dentro de la esfera pequeña');
    title('Imagen con esfera pequeña');

    subplot(2, 2, 4);
    imshow(I);
    hold on;
    [rows, cols] = find(Ib3);
    plot(cols, rows, 'y.');
    legend('Puntos dentro de la esfera mediana');
    title('Imagen con esfera mediana');

    %% Escogemos el radio de compromiso
    datosEsferasClasificador = [centroides, radios(:, 1)];
    save("Enunciado_y_entrega\Ejercicio4\VariablesGeneradas\datosMultiplesEsferas_clasificador.mat", "datosEsferasClasificador")

    %%%%%%%%%%%%%%%%%%
    % Apartado 2
    ROI = roipoly(I);
    numPix = sum(ROI(:));
    save("Enunciado_y_entrega\Ejercicio4\VariablesGeneradas\numPix.mat", "numPix")

