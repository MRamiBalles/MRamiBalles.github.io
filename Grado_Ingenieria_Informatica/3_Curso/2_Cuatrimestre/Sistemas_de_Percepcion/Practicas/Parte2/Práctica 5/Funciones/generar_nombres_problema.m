function nombresProblema = generar_nombres_problema()
    nombreDescriptores = {'Circularidad', 'Excentricidad', 'Solidez', 'Extension_BBox', 'Extension_BBox_IR', ...
                          'Hu1', 'Hu2', 'Hu3', 'Hu4', 'Hu5', 'Hu6', 'Hu7', ...
                          'DF1', 'DF2', 'DF3', 'DF4', 'DF5', 'DF6', 'DF7', 'DF8', 'DF9', 'DF10', ...
                          'NumEuler'};
    
    nombreClases = {'Clase1', 'Clase2', 'Clase3'}; % Modificar según tus clases
    simbolosClases = {'*r', 'ob', 'sg'}; % Modificar según tus clases y símbolos
    
    nombresProblema = [];
    nombresProblema.descriptores = nombreDescriptores;
    nombresProblema.clases = nombreClases;
    nombresProblema.simbolos = simbolosClases;
end
