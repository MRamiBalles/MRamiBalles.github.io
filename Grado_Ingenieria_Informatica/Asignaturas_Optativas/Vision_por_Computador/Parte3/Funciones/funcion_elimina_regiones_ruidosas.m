function [IbinFilt] = funcion_elimina_regiones_ruidosas(Ibin)
    % La función funcion_elimina_regiones_ruidosas elimina las agrupaciones
    % conexas con una cantidad de píxeles igual al 0.1% del número total de
    % píxeles de la imagen o con un número de píxeles menor al área del objeto
    % más grande dividido por 5.

    [N, M] = size(Ibin); % Obtener el tamaño de la imagen
    minPixCount = round(0.001 * N * M); % 0.1% del total de píxeles (NxM)

    % Primer paso: Eliminar componentes menores al 0.1% del total de píxeles
    Ibin2 = bwareaopen(Ibin, minPixCount);

    % Si hay agrupaciones en la imagen resultante
    if sum(Ibin2(:) > 0)
        Ietiq = bwlabel(Ibin2); % Etiquetar las regiones
        stats = regionprops(Ietiq, 'Area'); % Calcular las áreas de los objetos
        areas = cat(1, stats.Area);
        
        % Ordenar las áreas de mayor a menor
        areasOrd = sort(areas, 'descend');
        
        % Calcular el número de píxeles del objeto de mayor área dividido entre 5
        maxArea = areasOrd(1);
        numPix = floor(maxArea / 5);
        
        % Crear una máscara para filtrar regiones basadas en ambas condiciones
        mask = false(size(Ietiq));
        for k = 1:numel(areas)
            if areas(k) >= minPixCount || areas(k) >= numPix
                mask = mask | (Ietiq == k);
            end
        end
        
        IbinFilt = mask;
    else
        IbinFilt = Ibin2;
    end
end
