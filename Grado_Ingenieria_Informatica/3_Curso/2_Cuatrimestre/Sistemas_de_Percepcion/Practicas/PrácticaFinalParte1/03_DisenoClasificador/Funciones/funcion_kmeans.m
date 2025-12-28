function  [idx,centroides] = funcion_kmeans(XColor,numAgrup)
    posSemilla = randsample(size(XColor, 1), numAgrup);
    centroidesSemilla = zeros(numAgrup, 3);
    for i=1:numAgrup
        centroidesSemilla(i,:) = XColor(posSemilla(i), :);
    end
   
    idxSemilla = funcion_calcula_agrupacion(XColor, centroidesSemilla);
    
    idxAct = idxSemilla;
    idxAnt = zeros(size(idxAct));
    
    while(~funcion_compara_matrices(idxAnt, idxAct))
        idxAnt = idxAct;
        centroides = funcion_calcula_centroides_idx(XColor, idxAnt);
        idxAct = funcion_calcula_agrupacion(XColor, centroides);
    end

    idx = idxAct;

end