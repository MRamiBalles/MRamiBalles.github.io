function representa_esfera(centro, radio)
    [R,G,B] = sphere(100);

    % Matrices de puntos de una esfera centrada en el origen de radio unidad
    x = radio*R(:) + centro(1); %radio*R(:)
    y = radio*G(:) + centro(2); 
    z = radio*B(:) + centro(3);

    plot3(x,y,z, '-g')
end