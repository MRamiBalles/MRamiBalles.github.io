function centroides = funcion_calcula_centroides(IEtiq, N)

% toma como entrada la matriz de etiquetas Ietiq y el numero total 
% de etiquetas N, y devuelve una matriz que contiene las coordenadas (x,y) 
% del centroide de cada objeto etiquetado.
% 
% La funcion recorre cada etiqueta utilizando un bucle for. Dentro del bucle, 
% utiliza la función find para obtener las coordenadas (fila, columna) de todos 
% los pixeles con la etiqueta actual y utiliza la longitud de estas coordenadas 
% para calcular el numero total de pixeles en la etiqueta.
% 
% A continuacion, se calculan las coordenadas (x,y) del centroide de la etiqueta 
% actual dividiendo la suma de las coordenadas de todos los pixeles por el numero 
% total de pixeles.
% 
% Finalmente, se almacenan las coordenadas del centroide de la etiqueta actual en la 
% matriz centroides. La funcion devuelve la matriz centroides completa una vez que ha 
% recorrido todas las etiquetas.

    centroides = zeros(N, 2);
    for i = 1:N
        [f,c] = find(IEtiq == i);
        numPixeles = length(f);
        
        % Calcula el centroide de la etiqueta actual
        x = sum(c)/numPixeles;
        y = sum(f)/numPixeles;
        
        centroides(i,:) = [x,y];
    end
end