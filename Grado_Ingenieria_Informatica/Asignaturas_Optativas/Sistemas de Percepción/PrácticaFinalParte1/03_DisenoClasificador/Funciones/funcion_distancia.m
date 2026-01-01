function vecDistancias = calcula_distancia(centroide, puntos)
    numDatos = size(puntos, 1);
    centroide = double(centroide);  
    puntos = double(puntos);  
    CentroideAmp = repmat(centroide, numDatos, 1);
    
    vecDistancias = sqrt(sum((CentroideAmp - puntos).^2, 2));
end