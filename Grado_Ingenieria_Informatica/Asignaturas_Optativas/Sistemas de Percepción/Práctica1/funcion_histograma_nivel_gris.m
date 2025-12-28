function h = funcion_histograma_nivel_gris(I)
    % Obtener los valores únicos de nivel de gris presentes en la imagen
    niveles_gris = unique(I(:));
    
    % Inicializar el vector del histograma con ceros
    h = zeros(256, 1);
    
    % Recorrer cada nivel de gris y contar su frecuencia
    for k = 1:256
        %Ib = I == k;
        %h(k+1) = sum(Ib(:));
        nivel_actual = niveles_gris(k);
        h(k) = sum(I(:) == nivel_actual);
    end
end