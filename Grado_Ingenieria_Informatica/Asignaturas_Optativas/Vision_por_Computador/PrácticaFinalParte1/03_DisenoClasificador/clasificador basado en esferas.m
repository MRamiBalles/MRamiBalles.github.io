% XFondo = X(Y == 1) 
valoresY = unique(Y);
FoI = Y == valoresY(2); % Filas de la clase de interes
XColor = X(FoI, :);

numAgrup = 5;
idx = funcion_kmeans(XColor, numAgrup);
% idxM = kmeans(XColor, numAgrup)
% Representar
close all,
representa_datos_color_seguimiento_fondo(X,years)
figure
XColor_1 = XColor(idx == 2, :);
calcula_datos_esfera()

datosMultiplesEsferas = zeros(numAgrup, 6);
XFondo = X(FoI, :);
for i = 1:numAgrup
    XColor_i = XColor(idx == i, :)
    calcula_datos_esfera(XColor_i, XFondo)
end

% funcion calcula_deteccion_1esfera_en_imagen para multiples esferas:
datos = multiples_esferas()
numAg = size(datos,1);
c_r1 = datos(:,[1:3 4])
c_r2 = datos(:,[1:3 5])
c_r3 = datos(:,[1:3 6])

for i = 1 : numAg
    
    
end

hayCambio = true;
while hayCambio
    hayCambio = false;
    C = calcula_centroide(X, idx_ini);

    close all
    representa_datos_por_agrupacion(X, idx_ini)
    hold on
    plot(C(:,1), C(:,2), '*k')
     idx = genera_nueva_agrupacion(X,C)
     var = funcion_compara_matrices(idx, idx_ini)
     hayCambio = not(var)
     if hayCambio
         idx = idx_ini;
     end
end

