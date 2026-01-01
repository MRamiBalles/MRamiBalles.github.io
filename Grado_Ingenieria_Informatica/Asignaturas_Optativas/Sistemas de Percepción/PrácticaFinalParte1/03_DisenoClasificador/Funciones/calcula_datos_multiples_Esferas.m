function datosMultiplesEsferas = calcula_datos_multiples_Esferas(XColor, XFondo, numAgrup)
    %XColor = double(XColor); 
    %XFondo = double(XFondo); 

    [idx, centroides] = funcion_kmeans(XColor, numAgrup);
    datosMultiplesEsferas = zeros(numAgrup, 6);

    for i = 1:numAgrup
        centroide = centroides(i,:);
        puntosColor = XColor(idx == i, :);
        
        vecDistanciasSeguimiento = calcula_distancia_punto_a_nube_puntos(centroide', puntosColor');
        r1 = max(vecDistanciasSeguimiento);
        
        % Calcular distancias de fondo
        vecDistanciasFondo = calcula_distancia_punto_a_nube_puntos(centroide', XFondo');
        r2 = min(vecDistanciasFondo);
        
        % Calcular radio medio
        r3 = (r1 + r2) / 2;
    
        % Almacenar los datos en la matriz datosMultiplesEsferas
        datosMultiplesEsferas(i, :) = [centroide, r1, r2, r3];
    end
end
