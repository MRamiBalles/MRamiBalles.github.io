I = imread('Func.jpg')

imhist(I)
Ib = I < 125;
[IEt N] = bwlabel(Ib);

%% Ilustrar area-perimetro del primer objeto
i = 1;
Ib_obj = IEt == i;
% imshow(Ib_obj)
Area = sum(Ib_obj(:));

close all
Ib_ord = 
Ib_ordDil =
figure
subplot(1,2,1), imshow(Ib_ord)
subplot(1,2,2), funcion_visualiza(I, logical(Ib_ordDil), [255 0 0])

%% Calculo compacticidad excentricidad del objeto de ejemplo

stats = regionprops(Ib_obj, 'Area', 'Perimeter', 'Eccentricity');

Areas = cat(1, stats.Area)
Perimetros = cat(1, stats.Perimeter)
PerCuad = Perimetros.^2;
Compacticidad = PerCuad./Areas;
Exc = cat(1, stats.Eccentricity);


%% Extraccion de datos entrenamiento
clear, close all


X = [X; Compacticidad Exc];
Y = [Y; i*ones(N,1)];

simbolos{1}

%% 

I = uint8([0 1 5 0; 2 2 2 5])
h = imhist(I)
stem(0:5, h(1:6), '.r'),  grid on

ValorGrisMedio = mean(I(:))
% Nivel de gris 0 en h(1)

%% Para calcularlo: -> (i-1) es el nivel de gris
numPix = sum(h)

conteo = 0;
for i = 1 : 256
    conteo = conteo + h(i)*(i - 1);
end

valorMedio = conteo/numPix

%% Varianza:
var(double(I(:)), 1)
conteo = 0;
for i = 1 : 256
    conteo = conteo + h(i)*((i - 1) - valorMedio)^2;
end

varianza = conteo/numPix


%% Imagenes reales:
I = imread(...);
valorIni = 101; % vI = gIni + 1;
valorFin = 151; % vF = gFin + 1;
numPix = sum(h(valorIni : valorFin));
if numPix > 0
    conteo = 0;
    for i = valorIni : valorFin
        conteo = conteo + h(i)*i;
    end
    nivelGrisMedio = conteo/numPix %% Para el nivel de gris medio real hay que restar 1
    % gMedio = nivelGrisMedio - 1;
else
    nivelGrisMedio = [];
    % gMedio = [];
end

[valorMedio, numPix] = funcion_calcula_valor_medio_histograma(h, valorIni, valorFin)


%% Obtener umbral de forma automatica:
I = double(I);
T = mean(I(:));
Ib = I < T;
figure
subplot(1,2,1), 
subplot(1,2,2), 

numCaracteres = 7;
[Ietiq, N] = bwlabel(Ib);
stats = regionprops(Ietiq, 'Area');
areas_ord = sort(stats);
stats = regionprops(Ietiq, '')

%% La media es un buen método para clases bimodales balanceados
%% Otros métodos:
% Minimo entre maximos
[g_MinEntreMax, gMax1, gMax2] = funcion_MinEntreMax(I)

%% Programamos como si los nuveles de grises fueran de 1-256:
h = imhist(uint8(I));
[numPixMax, gMax] = max(h); %% ValorMax - 1 es el nivel de gris real!!!!
metrica = zeros(size(h));
for g = 2 : 255
    metrica(g) = h(g) * (g - gMax)^2;

end
[numPixMax2, gMax2] = max(metrica);

if gMax > gMax2
    gMax1 = gMax2;
    gMax2 = gMax;
else
    gMax1 = gMax;
end

    h(1:gMax1) = numPixMax;
    h(gMax2:256) = numPixMax;
    [valorMinEntreMax, gMin] = min(h);

    gMinEntreMax = gMin -1;
    gMax1 = gMax1 - 1;
    gMax2 = gMax2 - 1;

Ib = I < g_MinEntreMax
figure,
subplot(3,1,1), imshow(uint8(I))
subplot(3,1,2), imhist(I)
subplot(3,1,3), imshow(uint8(I<Ib))



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

numDatos = 1000;
% Datos clase 1:
media1 = 2;
desv1 = 5;
xC1 = media1 + desv1 * randn(numDatos, 1);
boxplot(xC1), figure, hist(xC1)

% Datos clase 2:
media2 = 5;
desv2 = 10;
xC2 = media2 + desv2 * randn(numDatos, 1);
close all, boxplot(xC2), figure, hist(xC2)

close all, boxplot([xC1 xC2])

X = [xC1; xC2]; Y = [ones(numDatos, 1); 2*ones(numDatos, 1)];

%% Evaluar los datos para las distintas funciones gaussianas de cada clase


media = mean(xC1); desv = std(xC1);
distNormal1_Real = (1/(desv*sqrt(2*pi))) * exp(-(x - media)/2*desv^2);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
ndatos = 100;
mu = [0 0];
sigma = [0.5 0.02; 0.02 0.5];

funcion_representa_gaussiana(mu, sigma, )
R1 = mvrnd(mu, sigma, ndatos);
plot(R1(:,1), R1(:,2), '*b')
close all, boxplot(xC2), figure, hist(xC2)

