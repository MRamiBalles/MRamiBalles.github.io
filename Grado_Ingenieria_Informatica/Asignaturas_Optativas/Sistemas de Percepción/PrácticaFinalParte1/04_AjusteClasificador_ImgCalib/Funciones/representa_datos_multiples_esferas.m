function representa_datos_multiples_esferas(XColor, XFondo, datosMultiplesEsferas)
    %% REPRESENTA LAS DOS NUBES DE PUNTOS
    
    % Subplot 1: Representación original de los datos azules y otros colores de fondo
    subplot(2, 2, 1);
    plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
    hold on
    plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
    axis([0 255 0 255 0 255]);
    legend('Datos Color', 'Datos Fondo');
    xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
    title('Representación original');
    centroides = datosMultiplesEsferas(:, 1:3);
    rMayor = datosMultiplesEsferas(:, 4);
    rMenor = datosMultiplesEsferas(:, 5);
    rMedio = datosMultiplesEsferas(:, 6);

    % Representación de las esferas para cada grupo
    for i = 1:size(datosMultiplesEsferas, 1)
        % Seleccionar los datos correspondientes a la i-ésima esfera
        centroide_i = centroides(i, :);
        radio_mayor_i = rMayor(i);
        radio_menor_i = rMenor(i);
        radio_medio_i = rMedio(i);
        
        % Subplot para la representación con la i-ésima esfera y el radio mayor
        subplot(2, 2, 2);
        plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
        hold on;
        plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
        representa_esfera(centroide_i, radio_mayor_i);
        axis([0 255 0 255 0 255]);
        legend('Datos Color', 'Datos Fondo', 'Superficie Esfera');
        xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
        title(['Representacion con esferas de radio mayor']);
        
        % Subplot para la representación con la i-ésima esfera y el radio menor
        subplot(2, 2, 3);
        plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
        hold on;
        plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
        representa_esfera(centroide_i, radio_menor_i);
        axis([0 255 0 255 0 255]);
        legend('Datos Color', 'Datos Fondo', 'Superficie Esfera');
        xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
        title(['Representacion con esferas de radio menor']);
        
        % Subplot para la representación con la i-ésima esfera y el radio medio
        subplot(2, 2, 4);
        plot3(XColor(:,1), XColor(:,2), XColor(:,3), '.b');
        hold on;
        plot3(XFondo(:,1), XFondo(:,2), XFondo(:,3), '.r');
        representa_esfera(centroide_i, radio_medio_i);
        axis([0 255 0 255 0 255]);
        legend('Datos Color', 'Datos Fondo', 'Superficie Esfera');
        xlabel('Componente R'), ylabel('Componente G'), zlabel('Componente B');
        title(['Representacion con esferas de radio medio']);
    end
end