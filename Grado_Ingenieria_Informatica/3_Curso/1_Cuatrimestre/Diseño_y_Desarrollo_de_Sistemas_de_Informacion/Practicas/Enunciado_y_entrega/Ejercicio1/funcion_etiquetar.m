function [IEtiq, N] = funcion_etiquetar(Ib)
% Ib: matriz binaria con dos posibles valores, 0’s y 1’s, puede ser tipo logical
% o double.

% N: número de agrupaciones conexas de 1 s presentes en la Ib, atendiendo a conectividad tipo 4.

% IEtiq: matriz tipo double, de las mismas dimensiones que Ib, con N+1
% posibles valores, 0 para identificar los 0’s de Ib y valores de etiqueta de 1 a N
% (números enteros) para para identificar los píxeles de las agrupaciones conexas 1’s
% detectadas en Ib.
    
    [nf, nc] = size(Ib);
    N = 0;
    IEtiq2 = [zeros(1, nc+2); [zeros(nf, 1), Ib, zeros(nf, 1)]; zeros(1, nc+2)];
    
    % recorre de arriba a abajo
    for fila = 2 : nf+1
        % recorre de izqda a derecha
        for col = 2 : nc+1
            if IEtiq2(fila, col) == 1
                N = N + 1;
                IEtiq2(fila, col) = N;
            end
        end
    end

    % Paso de arriba-abajo
    CAMBIO = true;
    while CAMBIO
        CAMBIO = false;
        for fila = 2 : nf+1
            for col = 2 : nc+1
                if IEtiq2(fila, col) ~= 0
                    % vecinos = [IEtiq2(fila-1, col-1:col+1), IEtiq2(fila, col-1)];
                    vecinos = [IEtiq2(fila-1, col), IEtiq2(fila, col-1)];
                    M = min(vecinos(vecinos >= 1));
                    if M ~= IEtiq2(fila, col)
                        CAMBIO = true;
                        IEtiq2(fila, col) = M;
                    end
                end
            end
        end
    
        % Paso de abajo-arriba
        for fila = nf+1 : -1 : 2
            for col = nc+1 : -1 : 2
                if IEtiq2(fila, col) ~= 0
                    %vecinos = cat(4, IEtiq(fila+1, col-1),IEtiq(fila+1, col),IEtiq(fila+1, col+1), IEtiq(fila, col+1));
                    % Fallo : vecinos = [IEtiq2(fila+1, col-1:col+1), IEtiq2(fila, col+1)];
                    vecinos = [IEtiq2(fila+1, col), IEtiq2(fila, col+1)];
                    M = min(vecinos(vecinos > 0));
                    if M ~= IEtiq2(fila, col)
                        CAMBIO = true;
                        IEtiq2(fila, col) = M;
                    end
                end
            end
        end
    end

    unicas = unique(IEtiq2);
    N = numel(unicas) - 1;
    for i = 2:numel(unicas)
        if unicas(i) ~= i - 1
            IEtiq2(IEtiq2 == unicas(i)) = i - 1;
        end
    end
    IEtiq = IEtiq2(2:nf+1,2:nc+1);
end
