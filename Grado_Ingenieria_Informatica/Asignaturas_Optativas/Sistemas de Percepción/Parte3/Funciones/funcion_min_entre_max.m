function T = funcion_min_entre_max(I)
    h = imhist(uint8(I));
    [hMax, g1] = max(h);
    metrica = zeros(256,1);
    
    % histogramas bimodales y desbalanceados
    for g=1:256
        metrica(g) = h(g)*((g - g1)^2); % Niveles de gris con muchos píxeles
                                        % y mas alejados del primer máximo
    end
    
    [~, g2] = max(metrica);
    
    hmod = h;
    aux = g1;
    
    if (g1 > g2) 
        g1 = g2;
        g2 = aux;
    end
    
    % g1 es el menor y g2 es el mayor.
    hmod(1 : g1) = hMax;
    hmod(g2 : 256) = hMax;
    
    %Devuelve el valor minimo entre las dos contribuciones.
    [~, T] = min(hmod);  
    T = T - 1;
end