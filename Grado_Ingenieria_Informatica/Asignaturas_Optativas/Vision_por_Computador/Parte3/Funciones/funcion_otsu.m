function T = funcion_otsu(I)
    %% En matlab 255*graythres(I)
    h = imhist(I);
    
    % Número total de píxeles
    numPix = sum(h);
    
    % Valor de gris medio global
    valoresGris = 0:255;
    gMedio = sum(valoresGris .* h') / numPix;
    
    varianzas = zeros(256, 1);

    for T = 1:255
        varianzas(T) = calcula_varianza_entre_clases(T, h, numPix, gMedio);
    end

    % Encontrar el umbral que maximiza la varianza entre clases
    [~, T] = max(varianzas);
    T = T - 1; % Ajustar el índice para que sea un valor de gris válido (0-255)
end