function datosEsfera = calcula_datos_esfera(XColor, XFondo)
    %% Se devuelve el centroide de la agrupacion de seguimiento 
    %% junto a los radios mayor, menor y medio:

    % Centroide
    datosEsfera = mean(XColor);

    % obtenemos las distancias a los puntos de seguimiento
    P = datosEsfera';
    NP = XColor';
    vecDistancias = calcula_distancia_punto_a_nube_puntos(P,NP);
    r1 = max(vecDistancias);

    % obtenemos las distancias a los puntos de fondo
    NP = XFondo';
    vecDistancias = calcula_distancia_punto_a_nube_puntos(P,NP);
    r2 = min(vecDistancias);

    % Radio medio:
    r3 = (r1 + r2) / 2;

    datosEsfera(1,4) = r1;
    datosEsfera(1,5) = r2;
    datosEsfera(1,6) = r3;
end