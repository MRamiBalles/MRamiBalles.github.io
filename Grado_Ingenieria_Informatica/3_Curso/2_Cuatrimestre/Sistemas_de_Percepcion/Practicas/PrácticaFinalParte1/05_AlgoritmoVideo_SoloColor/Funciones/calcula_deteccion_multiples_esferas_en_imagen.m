function Ib = calcula_deteccion_multiples_esferas_en_imagen(I, radios, centroides)
%     Ibfinal = Ib1 OR ib2 OR ib3;
    %num_esferas = min(size(radios, 1), size(centroides, 1)); % Determina el número de esferas para iterar
    
    Ib = calcula_deteccion_1esfera_en_imagen(I, [centroides(1, :), radios(1)]);
    for i = 2 : size(radios, 1)
        Ib = (Ib | calcula_deteccion_1esfera_en_imagen(I, [centroides(i,:), radios(i)]));   
    end
end