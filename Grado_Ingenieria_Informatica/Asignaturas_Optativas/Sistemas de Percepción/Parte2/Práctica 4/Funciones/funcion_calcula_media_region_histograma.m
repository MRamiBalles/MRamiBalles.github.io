function [gMedio, numPix] = funcion_calcula_media_region_histograma(h, gIni, gFin)
    numPix = sum(h(gIni : gFin))

    if(numPix > 0)
        conteo = 0;
        for g = gIni:gFin
            conteo = conteo + g*h(g);
        end 
        %gMedio = conteo / numPix; %% Restar uno tras usar la funcion
        gMedio = conteo / numPix;
    else 
        gMedio = [];
    end
    
end