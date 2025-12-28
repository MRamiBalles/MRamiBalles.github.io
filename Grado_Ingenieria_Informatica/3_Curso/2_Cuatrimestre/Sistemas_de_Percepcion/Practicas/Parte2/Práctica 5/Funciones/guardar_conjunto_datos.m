function guardar_conjunto_datos(XImagen, Yimagen, nombresProblema)
    save('DatosGenerados/conjunto_datos.mat', 'XImagen', 'Yimagen', 'nombresProblema');
end
