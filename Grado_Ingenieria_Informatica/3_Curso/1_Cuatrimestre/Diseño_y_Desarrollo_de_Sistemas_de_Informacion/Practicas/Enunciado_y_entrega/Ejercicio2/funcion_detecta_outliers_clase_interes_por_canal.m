function pos_outliers = funcion_detecta_outliers_clase_interes_por_canal(X, Y, posClaseInteres, canal)
    pos_outliers = [];
    
    xCompleto = X(:, canal);
      
    vMinAcept = 120;

    out = (xCompleto < vMinAcept) & Y == 1;
    pos_outliers = [pos_outliers; find(out)];
end
