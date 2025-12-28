function representa_datos_color_seguimiento_fondo(XColor, XFondo)
    %% REPRESENTA LAS DOS NUBES DE PUNTOS
    datosE = calcula_datos_esfera(XColor, XFondo);
    centroide = datosE(1:3);
    radios = datosE(4:6);

    % Subplot 1: Representación original de los datos azules y otros colores de fondo
    subplot(2, 2, 1);
    plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
    hold on
    plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
    axis([0 255 0 255 0 255]);
    
    legend('Datos Color', 'Datos Fondo');
    xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
    title('Representación original');
    
    % Resto de subplots con las esferas:
    nRadios = length(radios);
    for i = 1:nRadios
        ri = radios(i);
    
        subplot(2, 2, i+1);
        plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
        hold on;
        plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
        representa_esfera(centroide, ri);
        axis([0 255 0 255 0 255]);
        legend('Datos Color', 'Datos Fondo', 'Superficie Esfera');
        xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
        title(['Representacion con esfera R = ', num2str(ri)]);
    end
end

