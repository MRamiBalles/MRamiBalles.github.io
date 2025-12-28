%% Ejercicio 1 : Clasificador Minima Distancia Euclidea

%% Clases : 
xC1 = [1 3; 2 1; 2 2; 2 3; 2 4; 3 2; 3 3; 4 3; 5 2; 1 2];
xC2 = [4 5; 5 5; 5 6; 4 7; 6 5; 6 6; 6 7; 7 6; 4 6; 8 7];

[nC1 atribC1] = size(xC1);
[nC2 atribC2] = size(xC2);

mu1 = mean(xC1)';
mu2 = mean(xC2)';

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');
X = [x1; x2];

%% Funciones de Decision : 
d1 = expand(-(X - mu1)'*(X - mu1));
d2 = expand(-(X - mu2)'*(X - mu2));
vpa(d1)
vpa(d2)

%% Funcion Discriminante : 
d12 = d1 - d2;
vpa(d12, 3)
%% Por tanto el criterio es :
%%     x € C1  si  d12(x) > 0  ,  es decir : d1(x) > d2(x)
%%     x € C2  si  d12(x) < 0




%% Ejercicio 2 : Clasificador de Minima Distancia Mahalanobis
clear, clc
xC1 = [2 1; 3 2; 3 3; 4 2];
xC2 = [6 1; 5 2; 7 3];
nC1 = 4;
nC2 = 3;

mu1 = mean(xC1)';
mu2 = mean(xC2)';
covC1 = cov(xC1);
covC2 = cov(xC2);
mCov = ((3*covC1) + (2*covC2)) / 5;  % 5 = (nC1 + nC2 - nClases)

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');
X = [x1; x2];

%% Funciones de Decision :
d1 = expand(-(X - mu1)'*pinv(mCov)*(X - mu1));
d2 = expand(-(X - mu2)'*pinv(mCov)*(X - mu2));
vpa(d1, 3)
vpa(d2, 3)
%% Funcion Discriminante : 
d12 = d1 - d2;
vpa(d12, 3)

%% Por tanto el criterio es :
%%     x € C1  si  d12(x) > 0  ,  es decir : d1(x) > d2(x)
%%     x € C2  si  d12(x) < 0


%% Ejercicio 3 :
%% Clasificador Minima Distancia Mahalanobis suponiendo 3 clases de patrones:
mu1 = [0 3]';
mu2 = [5 2]';
mu3 = [1 0]';
mCovInv = [2 0; 0 4];

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');
X = [x1; x2];

d1 = expand(-(X - mu1)'*mCovInv*(X - mu1))
d2 = expand(-(X - mu2)'*mCovInv*(X - mu2))
d3 = expand(-(X - mu3)'*mCovInv*(X - mu3))

d12 = d1 - d2
d13 = d1 - d3
d23 = d2 - d3

%% Criterio de clasificacion :
%%     x € C1  si  d12(x) > 0  Y  d13(x) > 0  ,  es decir : d1(x) > d2(x) y d1(x) > d3(x)
%%     x € C2  si  d12(x) < 0  Y  d23(x) > 0
%%     x € C3  si  d13(x) < 0  Y  d23(x) < 0

%% Ejercicio Extra resuelto:
%% Comparar valores segun clasificador de mínima distancia Euclidea y Mahalanobis
%% entre los puntos A-O y B-O, con O el punto medio
%% A = (3,5) y B = (6,7)
clear, clc
datos = [1 1; 2 2.5; 3 3.5; 4 5; 5 6];
O = mean(datos)';

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');
X = [x1; x2];

DE2 = expand((X - O)'*(X - O));

mCov = cov(datos);
DM2 = expand((X - O)'*pinv(mCov)*(X - O));

% Obteniendo las distancias:
x1 = 3; x2 = 5; 
DE_OA = sqrt(eval(DE2))
DM_OA = sqrt(eval(DM2))

x1 = 6; x2 = 7; 
DE_OB = sqrt(eval(DE2))
DM_OB = sqrt(eval(DM2))