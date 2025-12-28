function vecDistancias = calcula_distancia_punto_a_nube_puntos(centroide, puntos)
    numDatos = size(puntos, 2);
    % vecDistancias = zeros(1, numDatos);
    puntos = double(puntos);
    CentroideAmp = repmat(centroide, 1, numDatos);

    %disp(size(CentroideAmp));
    %disp(size(puntos));

    vecDistancias = sqrt(sum((CentroideAmp - puntos).^2));
    %disp(size(vecDistancias));
end