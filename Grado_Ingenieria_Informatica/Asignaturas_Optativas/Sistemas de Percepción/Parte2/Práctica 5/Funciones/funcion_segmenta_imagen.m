function [Ietiq, N] = funcion_segmenta_imagen(I)
    % Leer la imagen
    % Si la imagen es RGB, convertirla a escala de grises
        if size(I, 3) == 3
            I = rgb2gray(I);
        end

    % Calcular el histograma de la imagen
    h = imhist(I);

    % Mostrar el histograma
    figure;
    bar(h);
    title('Histograma de la imagen');
    xlabel('Nivel de gris');
    ylabel('Frecuencia');

    % Calcular el umbral utilizando el método de Otsu
    T = funcion_otsu(I);

    % Binarizar la imagen usando el umbral calculado
    Ibin = I > T;

    % Mostrar la imagen binarizada
    figure;
    imshow(Ibin);
    title('Imagen binarizada utilizando el umbral de Otsu');

    % Etiquetar las regiones conectadas en la imagen binarizada
    [Ietiq, N] = bwlabel(Ibin);

    % Mostrar la imagen etiquetada
    figure;
    imshow(label2rgb(Ietiq));
    title(['Imagen etiquetada con ', num2str(N), ' regiones conectadas']);
end