%% Practica 5:
% Ejercicio 1:
xC1 = [1 3; 2 1; 2 2; 2 3; 2 4; 3 2; 3 3; 4 3; 5 2; 1 2];
xC2 = [4 5; 5 5; 5 6; 4 7; 6 5; 6 6; 6 7; 7 6; 4 6; 8 7];

media1 = mean(xC1);
media2 = mean(xC2);
x1 = sym('x1', 'real')
x2 = sym('x2', 'real')

X = [x1; x2];
media1; media2;

d1 = expand(-(X-media1)'*(X-media1)); vpa(d1,3);
d2 = expand(-(X-media2)'*(X-media2)); vpa(d2,3);

% Ejercicio 2:

xC1 = [2 1; 3 2; 3 3; 4 2];
xC2 = [6 1; 5 2; 7 3];

nDatosC1 = 4;
nDatosC2 = 3;
media1 = mean(xC1)';
media2 = mean(xC2)';
cov1 = cov(xC1);
cov2 = cov(xC2);
mCov = ((nDatosC1 - 1)*cov1 + (nDatosC2 - 1)*cov2) / (nDatosC2+nDatosC1 - 2)

x1 = sym('x1', 'real')
x2 = sym('x2', 'real')

X = [x1;x2]

d1 = expand(-(X-media1)'*pinv(mCov)*(X-media1)); vpa(d1,3);
d2 = expand(-(X-media2)'*pinv(mCov)*(X-media2)); vpa(d2,3);
d12 = d1 - d2

% Evaluacion:
x1 = 4; x2 = 3; eval(d12);

% Ejercicio 3:

media1 = [0; 3];
media2 = [5; 2];
media3 = [1; 0];

x1 = sym('x1', 'real')
x2 = sym('x2', 'real')

X = [x1;x2]

d1 = expand(-(X-media1)'*pinv(mCov)*(X-media1)); vpa(d1,3)
d2 = expand(-(X-media2)'*pinv(mCov)*(X-media2)); vpa(d2,3);
d3 = expand(-(X-media3)'*pinv(mCov)*(X-media3)); vpa(d3,3);
d12 = d1 - d2;
d13 = d1 - d3;
d23 = d2 - d3;

close all, figure(1), hold on
x1min = -3; x1max = 14;% Verlos
x2min = -5; x2max = 10;
axis()
xlabel
ylabel

x1R = -3:0.1:14;
x2R = -(w0 + w1*x1R)/w2;
plot(x1R, x2R);

% Evaluacion:
x1 = 4; x2 = 3; eval(d12); eval(d13); eval(d23)

%% Un enfoque basado en la teoria de la decision implica calcular unas funciones de 
%% decision que se evaluan para decidir la clase de una muestra desconocida

% Teorema de bayes -> clasificador probabilistico que calcula la
% probabilidad de que una caracteristica dada para una clase k a partir de
% la probabilidad de que la instancia sea de la clase k dado su valor (distancia a la nube de puntos)

% Que gaussiana es la mejor? -> Media y desviacion tipica de cada descriptor
%% Independencia estadística entre los atributos:
% Ejemplo : 
XC1 = [2 1;
       3 2;
       3 3;
       4 2];
XC2 = [6 1;
       5 2;
       7 3];
[nDatosC1, nAtribC1]  = size(XC1);  % = 4;
[nDatosC2, nAtribC2]  = size(XC2);  % = 3;
mu1 = mean(XC1)';
mu2 = mean(XC2)';
mcov1 = cov(XC1); % -> Significa la varianza de XC1: ((2 valor-3 media)^2 + (4-3)^2) / 3
mcov2 = cov(XC2); % -> coeficiente de correlacion: (2-3)... Importante!!
mCov = ((nDatosC1 - 1)*mcov1 + (nDatosC2 - 1)*mcov2) / (nDatosC2+nDatosC1 - 2);
% el 0.4 viene de : ((2-3)*(1-2) + (7-6)*(3-2))/5 -> Covarianza de x1 y x2

% QDA : Analisis discriminante cuadratico (fronteras)
d1 = -1/2*(X-mu1)'*pinv(mCov)*(X-)
d2 = 
d12 = d1 - d2; % = w1*x1 + w2*d2 + ... + wn*xn + w0

% LDA : Análisis discriminante lineal : Misma matriz de covarianza para
% todas las clases