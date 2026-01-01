function Ib = calcula_1esfera_por_distancia(I, centroide_radio)
    centroide = centroide_radio(1:3);
    radio = centroide_radio(4);
    R = double(I(:,:,1));
    G = double(I(:,:,2));
    B = double(I(:,:,3));

    MD = sqrt((R-centroide(1)).^2 + (G-centroide(2)).^2 + (B-centroide(3)).^2);
    Ib = MD < radio;
end

