function [Ib, IEtiq] = vecinos(Ib, IEtiq, fila, col, N)

    [nf, nc] = size(IEtiq);
    
    % si el pixel tiene valor = 1, hay que etiquetarlo
    if Ib(fila, col) == 1
        Ib(fila, col) = 0; % marcar la casilla que vamos a marcar a 0
        IEtiq(fila, col) = N;

        % para vecindad 8, incluir 4 nuevos ifs paar hacer lo
        % mismo con las esquinas (ej, para fila izq arriba habria que hacer
        % fila-1, col-1...

        if(fila > 1)
            % comprueba vecinos
            [Ib, IEtiq] = vecinos(Ib, IEtiq, fila-1, col, N);
        end

        if(fila < nf)
            [Ib, IEtiq] = vecinos(Ib, IEtiq, fila+1, col, N);
        end

        if(col > 1)
            [Ib, IEtiq] = vecinos(Ib, IEtiq, fila, col-1, N);
        end

        if(col < nc)
            [Ib, IEtiq] = vecinos(Ib, IEtiq, fila, col+1, N);
        end
    end
end