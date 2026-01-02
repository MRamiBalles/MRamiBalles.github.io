function pos_outliers = funcion_detecta_outliers_clase_interes(X, Y, posClaseInteres)
    valoresY = unique(Y);
    filasoI = Y == valoresY(posClaseInteres);
    pos_outliers = [];

    for i = 1:3
       color = X(filasoI, i);
       xCompleto = X(:,i);

       % Sin percentiles :
       %colorOrd = sort(color);
       %numVal = length(color);
       %posQ1 = round(0.25*numVal);
       %posQ3 = round(0.75*numVal);
       %Q1 = colorOrd(posQ1)
       %Q3 = colorOrd(posQ3)

       Q1 = prctile(color, 25)
       Q3 = prctile(color, 75)
       
       RangoInter = Q3 - Q1;
       vMinAcept = Q1 - 1.5*RangoInter;
       vMaxAcept = Q3 + 1.5*RangoInter;
      
       %% color = double(color);
       %% media = mean(color);
       %% desv = std(color);
       %% vMinAcept = media - 2.69*desv
       %% vMaxAcept =  media + 2.69*desv

       out = (xCompleto < vMinAcept | xCompleto > vMaxAcept) & Y == 1;
       pos_outliers = [pos_outliers; find(out)];
    end
end