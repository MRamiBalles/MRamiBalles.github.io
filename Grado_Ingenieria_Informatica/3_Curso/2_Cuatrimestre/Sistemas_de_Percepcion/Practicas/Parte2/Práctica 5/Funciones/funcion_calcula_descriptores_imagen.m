function XImagen = funcion_calcula_descriptores_imagen(Ietiq, N)
    % Inicializar la matriz de descriptores
    XImagen = zeros(N, 23);

    % Calcular descriptores para cada región etiquetada
    for i = 1:N
        % Extraer la región i-ésima
        region = (Ietiq == i);
        
        % Propiedades básicas de la región
        stats = regionprops(region, 'Area', 'Perimeter', 'Eccentricity', 'Solidity', 'BoundingBox', 'EulerNumber');
        
        % Circularidad
        area = stats.Area;
        perimeter = stats.Perimeter;
        circularidad = 4 * pi * area / (perimeter^2);
        XImagen(i, 1) = circularidad;

        % Excentricidad
        excentricidad = stats.Eccentricity;
        XImagen(i, 2) = excentricidad;

        % Solidez
        solidez = stats.Solidity;
        XImagen(i, 3) = solidez;

        % Extensión del Bounding Box
        boundingBox = stats.BoundingBox;
        bboxArea = boundingBox(3) * boundingBox(4);
        extent = area / bboxArea;
        XImagen(i, 4) = extent;

        % Extensión del Bounding Box Invariante a Rotación
        extentIR = Funcion_Calcula_Extent(region);
        XImagen(i, 5) = extentIR;

        % Momentos de Hu
        huMoments = Funcion_Calcula_Hu(region);
        XImagen(i, 6:12) = huMoments;

        % Descriptores de Fourier
        fourierDescriptors = Funcion_Calcula_DF(region, 10);
        XImagen(i, 13:22) = fourierDescriptors;

        % Número de Euler
        numEuler = stats.EulerNumber;
        XImagen(i, 23) = numEuler;
    end
end
