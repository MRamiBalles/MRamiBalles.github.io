function IbFilt = funcion_filtra_objetos(Ib,numPix)
% Funcion que recibe una imagen binaria y el numero de pixeles y devuelve
% otra imagen binaria que muestre solo agrupaciones de 1 con una cantidad
% de pixeles mayor que numPix

%% bwareaopen -> Equivalente de matlab

    [Ie,N] = funcion_etiquetar(Ib);
    areas = funcion_calcula_areas(Ie,N);
    IbFilt = Ib;
    posEliminar = find(areas < numPix);
    for i = 1:length(posEliminar)
        etiqIO = posEliminar(i);
        IbFilt(Ie == etiqIO) = false;
    end
end