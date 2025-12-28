% Probabilidades conocidas
P_A = 0.3;
P_B_given_A = 0.6;
P_B = 0.5;

% Aplicar el Teorema de Bayes
P_A_given_B = (P_B_given_A * P_A) / P_B;

% Mostrar el resultado
disp(P_A_given_B);
clear, clc
% Cargar un conjunto de datos de ejemplo
load fisheriris % Cargar el conjunto de datos Iris

% Usar las primeras dos características y las etiquetas
X = meas(:, 1:2);
Y = species;

% Entrenar el clasificador Naive Bayes
Mdl = fitcnb(X, Y);
X1 = [5 4]
% Hacer predicciones en los datos de entrenamiento
predicted_labels = predict(Mdl, X1);

% Calcular la precisión
accuracy = sum(strcmp(predicted_labels, Y)) / length(Y);
disp(['Accuracy: ', num2str(accuracy)]);

% Ejercicios preparacion segundo parcial

%% Ejercicio 1: A partir de los datos de la tabla, construir un Clasificador de Mínima Distancia Euclídea:

xC1 = [1 3; 2 1; 2 2; 2 3; 2 4; 3 2; 3 3; 4 3; 5 2; 1 2];
xC2 = [4 5; 5 5; 5 6; 4 7; 6 5; 6 6; 6 7; 7 6; 4 6; 8 7];

% - Funciones de decision de cada clase expresadas en funcion de una instancia X generica 
% definida por x1 y x2. Se deben presentar las expresiones teóricas de forma matricial 
% sin desarrollar, presentando los valores de las variables que intervienen.


x1 = sym('x1', 'real');
x2 = sym('x2', 'real');

X = [x1; x2];
%cov(xC1)
%cov(xC2)
mu1 = mean(xC1)';
mu2 = mean(xC2)';

d1 = expand((X - mu1)' * (X - mu1))
d2 = expand((X - mu2)' * (X - mu2))

% - Función discriminante entre clases expresadas en función de una 
% instancia X genérica definida por x1 y x2.

discriminante = d1 - d2

% - Establecer la regla de decisión del clasificador para predecir la clase 
% de una instancia X* dada por x1* y x2*.


% 6x1 + 7x2 - 215/4 = 0
% x2 cuando x1 = 0
x2_intercept = 215 / (4 * 7); % (0, x2_intercept) ≈ (0, 7.68)

% x1 cuando x2 = 0
x1_intercept = 215 / (4 * 6); % (x1_intercept, 0) ≈ (8.96, 0)

% Puntos para la línea de decisión
p1 = [0, x2_intercept];
p2 = [x1_intercept, 0];
% - En el espacio de características definido por x1 y x2, representar 
% el conjunto de instancias de cada clase y la frontera lineal de separación entre clases
% del clasificador. ¿Qué significado tienen los puntos de esta frontera lineal?

% Representación de los datos
figure;
plot(xC1(:,1), xC1(:,2), '*b'); % Corregido a (columnas)
hold on;
plot(xC2(:,1), xC2(:,2), '*r'); % Corregido a (columnas)


% Graficar la línea de decisión
plot([p1(1), p1(2)], [p2(1), p2(2)], '-g');

% Ajustar los ejes
axis([0, 10, 0, 10]);

% Añadir etiquetas y leyenda
xlabel('x1');
ylabel('x2');
legend('Clase C1', 'Clase C2', 'Frontera de decisión');
title('Representación de los datos y la frontera de decisión');
hold off;

%% Los puntos estan a la misma distancia euclidea del promedio de ambas clases



%% Ejercicio 2 : Teniendo en cuenta la muestra de la tabla, diseñar un Clasificador de Mínima Distancia Mahalanobis:

xC1 = [2 1; 3 2; 3 3; 4 2];
xC2 = [6 1; 5 2; 7 3];

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');
X = [x1; x2];

mu1 = mean(xC1)';
mu2 = mean(xC2)';


mCov1 = sym(cov(xC1));
mCov2 = symcov(xC2));

mCov = 1/5 * ((size(xC1, 1) - 1) * mCov1 +  (size(xC2, 1) - 1) * mCov2)

% DM =  - (X - Mk)' * pinv(mCov) * (X - Mk);

d1 =  expand(- (X - mu1)' * pinv(mCov) * (X - mu1))
d2 =  expand(- (X - mu2)' * pinv(mCov) * (X - mu2))

d12 = d1 - d2

x2_intercept = -35/5; % (0, x2_intercept) ≈ (0, 7.68)

x1_intercept = 35/10; % (x1_intercept, 0) ≈ (8.96, 0)

% Puntos para la línea de decisión
p1 = [0, x2_intercept];
p2 = [x1_intercept, 0];

% Representación de los datos:
figure
plot(xC1(:,1), xC1(:,2),'*r'), hold on
plot(xC2(:,1), xC2(:,2), '*b'),

% Graficar la línea de decisión
%plot([p1(1), p1(2)], [p2(1), p2(2)], '-g');
plot([0, 10],[-7,13], '-g') % Representa la línea dada por los puntos 
                     % (0,-7) y (10,13)
plot(p1, p2); 
axis([0,10,0,10])

%% Ejercicio 3 : Diseñar un Clasificador de Mínima Distancia Mahalanobis suponiendo 
%% 3 clases de patrones, cada uno de ellos representados por 2 características, y los siguientes datos:
% 𝑋= [𝑥1𝑥2] ; 𝑃(𝐶1)= 𝑃(𝐶2)= 𝑃(𝐶3)
% 𝑉𝑒𝑐𝑡𝑜𝑟𝑒𝑠 𝑃𝑟𝑜𝑚𝑒𝑑𝑖𝑜 𝑑𝑒 𝑐𝑎𝑑𝑎 𝑐𝑙𝑎𝑠𝑒: 𝑀1= [03] ; 𝑀2= [52] ; 𝑀3= [10]
% 𝑀𝑎𝑡𝑟𝑖𝑐𝑒𝑠 𝐶𝑜𝑣𝑎𝑟𝑖𝑎𝑧𝑎 𝑑𝑒 𝑐𝑎𝑑𝑎 𝑐𝑙𝑎𝑠𝑒: 𝐶1=𝐶2=𝐶3=𝐶=[1/2 0; 0 1/4]; 𝐶−1=[2 0; 0 4]
% El diseño del clasificador implica la obtención de las siguientes funciones de x1 y x2:
% - Funciones de decisión de cada clase
% - Funciones discriminantes entre las muestras de las clases dos a dos.
% - Establecer la regla de decisión del clasificador a partir 
% de las funciones discriminantes anteriores.

x1 = sym('x1', 'real');
x2 = sym('x2', 'real');

X = [x1; x2];

m1 = [0; 3];
m2 = [5; 2];
m3 = [1; 0];

COV = sym([1/2 0; 0 1/4])
COVI = inv(COV)

d1 = expand(sym(-(X - m1)'*COVI*(X - m1)))
d2 = expand(sym(-(X - m2)'*COVI*(X - m2)))
d3 = expand(sym(-(X - m3)'*COVI*(X - m3)))


d12 = d1 - d2
d13 = d1 - d3
d23 = d2 - d3

% b) Aplicar el clasificador diseñado para predecir la clase 
% de las instancias dadas por (2, 4), (2,0) y (6,2)

instancias = [2 4; 2 0; 6 2];


for i = 1:size(instancias, 1)
    x1 = instancias(i, 1);
    x2 = instancias(i, 2);
    
    g1 = eval(d1);
    g2 = eval(d2);
    g3 = eval(d3);
    
    fprintf('Instancia (%d, %d):\n', x1, x2);
    fprintf('d1: %f\n', g1);
    fprintf('d2: %f\n', g2);
    fprintf('d3: %f\n', g3);

    [~, clase] = max([g1, g2, g3]);
    fprintf('Clase predicha: %d\n\n', clase);
end

for i = 1:size(instancias, 1)
    x1 = instancias(i, 1);
    x2 = instancias(i, 2);
    
    diff12 = eval(d12);
    diff13 = eval(d13);
    diff23 = eval(d23);
    
    fprintf('Instancia (%d, %d):\n', x1, x2);
    fprintf('d1 - d2: %f\n', diff12);
    fprintf('d1 - d3: %f\n', diff13);
    fprintf('d2 - d3: %f\n', diff23);
end


%% Ejercicio 4: 

clc, clear, close all


%% Representa para cada experimento los datos de los diferentes biomarcadores, 
% distinguiendo en la representación aquellas muestras que se corresponden a 
% personas sanas de aquellas tomadas a personas afectadas por la enfermedad.

% Carga de datos 1
addpath("../Desktop/Sistemas de Percepción/Prueba2/Datos/datos_ejercicio4/")
load("../../../Prueba2/Datos/datos_ejercicio4/datos_biomarcadores_exp1.mat")
clases = unique(Y);
E1_clase1 = X(Y(:) == 1, :)
E1_clase2 = X(Y(:) == 2, :)

datos_E1 = [E1_clase1; E1_clase2]
% Representar
figure
plot(E1_clase1(:,1),E1_clase1(:,2),'*b'), hold on
plot(E1_clase2(:,1),E1_clase2(:,2), '*r'), grid on

% Carga de datos 2
load("../../../Prueba2/Datos/datos_ejercicio4/datos_biomarcadores_exp2.mat")

E2_clase1 = X(Y(:) == 1, :)
E2_clase2 = X(Y(:) == 2, :)

datos_E2 = [E2_clase1; E2_clase2]

figure
plot3(E2_clase1(:, 1), E2_clase1(:, 2), E2_clase1(:, 3), '*r'), hold on
plot3(E2_clase2(:, 1), E2_clase2(:, 2), E2_clase2(:, 3), '*b'),

% Representar
figure, plot3(E2_clase1(:,1),E2_clase1(:,2), E2_clase1(:,3),'*b'), hold on
plot3(E2_clase2(:,1),E2_clase2(:,2), E2_clase2(:,3), '*r'), grid on


%% Clasificador LDA
% Diseña un clasificador LDA que permita predecir la enfermedad en un 
% paciente a partir de los biomarcadores utilizados en los experimentos 
% 1 y 2. Evalúa la tasa de acierto del clasificador en el conjunto de 
% muestras disponibles de cada experimento

% LDA = -1/2(x-mu)'* inv(E) * x(mu) * log(pik)
% Datos equiprobables
% LDA = -(x-mu)'* inv(E) * x(mu)

m11 = mean(E1_clase1)'
m12 = mean(E1_clase2)'

m21 = mean(E2_clase1)'
m22 = mean(E2_clase2)'

cov11 = cov(E1_clase1)
cov12 = cov(E1_clase2)

cov21 = cov(E2_clase1)
cov22 = cov(E2_clase2)

%% Min dist euclidea??
mCov_E1 = ((size(E1_clase1,1) - 1) * cov11 +  ((size(E1_clase2, 1) - 1)) * cov12)/(size(datos_E1, 1) - 2)
mCov_E2 = ((size(E2_clase1,1) - 1) * cov21 +  ((size(E2_clase2, 1) - 1)) * cov22)/(size(datos_E2, 1) - 2)

x1 = sym('x1', 'real')
x2 = sym('x2', 'real')
x3 = sym('x3', 'real')

X_1 = [x1; x2]
X_2 = [x1; x2; x3]

M_covi = pinv(mCov_E1)

d1_E1 = expand(-((X_1 - m11)' * M_covi * (X_1 - m11)))
d2_E1 = expand(-((X_1 - m12)' * M_covi * (X_1 - m12)))

d12_E1 = d1_E1 - d2_E1

% Cálculo de la frontera
x1 = -2;
x2 = sym('x2','real');
x2 = solve(eval(d12_E1) == 0);

punto1 = [x1 x2];

x1 = 2;
x2 = sym('x2','real');
x2 = solve(eval(d12_E1) == 0);

punto2 = [x1 x2];

% Representa los datos Experimento 1:
plot(E1_clase1(:,1),E1_clase1(:,2), '*r'), hold on
plot(E1_clase2(:,1),E1_clase2(:,2), '*b'), hold on
plot([punto1(1,1), punto2(1,1)],[punto1(1,2), punto2(1,2)]), grid on

% Tasa de acierto

x11 = datos_E1(:,1);
x12 = datos_E1(:,2);
valores = eval(d12_E1);
valores(valores>0) = 1; valores(valores<0) = 2;

error = valores - clases;
numAciertos = sum(error == 0);
tasaAcierto = numAciertos/size(datos_E1,1);

% Exp 2
mCov_E2 = ((size(E2_clase1, 1) - 1) * cov21 +  ((size(E2_clase2, 1) - 1)) * cov22)/(size(datos_E2, 1) - 2)

mat1 = ((size(E2_clase1,1))*cov(E2_clase1))
mat2 = ((size(E2_clase2,1))*cov(E2_clase2))
div = (size(datos_E2,1)) - 2
M_cov = ( mat1 + mat2) / div

M_covi = pinv(mCov_E2)

d1_E2 = expand(-((X_2 - m21)' * M_covi * (X_2 -m21)))
d2_E2 = expand(-((X_2 - m22)' * M_covi * (X_2 - m22)))

d12_E2 = d1_E2 - d2_E2

% Cálculo de la frontera
% x1 = 0;
% x2 = 0;
% x3 = sym('x3','real');
% x3 = solve(eval(d12_E2) == 0);
% 
% punto1 = [x1 x2 x3];
% 
% x1 = 0;
% x3 = 0;
% x2 = sym('x2','real');
% x2 = solve(eval(d12_E2) == 0);
% Ax21 + Bx22 + Cx23 + D == 0
x1 = 0; x2 = 0; x3 = 0; D = eval(d12_E2);
x1 = 0; x2 = 0; x3 = 1; C = eval(d12_E2)-D;
x1 = 0; x2 = 1; x3 = 0; B = eval(d12_E2)-D;
x1 = 1; x2 = 0; x3 = 0; A = eval(d12_E2)-D;

[x1Plano, x2Plano] = meshgrid(-2:2,-2:2);
x3Plano = -(A*x1Plano + B*x2Plano + D) / (C + eps);

% Representa los datos Experimento 1:
figure, plot3(E2_clase1(:,1),E2_clase1(:,2), E2_clase1(:,3), '*r'), hold on
plot3(E2_clase2(:,1),E2_clase2(:,2), E2_clase2(:,3), '*b'), hold on
surf(x1Plano, x2Plano, x3Plano)

% Tasa de acierto
x1 = datos_E2(:,1);
x2 = datos_E2(:,2);
x3 = datos_E2(:,3);
valores = eval(d12);
valores(valores>0) = 1; valores(valores<0) = 2;

error = valores - size(clases);
numAciertos = sum(error == 0);
tasaAcierto = numAciertos/size(datos_E2,1);

%% Ejercicio 5: 

close all, clear, clc
addpath("../Desktop/Sistemas de Percepción/Prueba2/Datos/")
load("datos_ejercicio5.mat")
% 1.-  Divide el conjunto completo en dos subconjuntos: entrenamiento (70% de los datos seleccionados de forma aleatoria) y test (30% de los datos restantes). Para ello, utiliza el siguiente código:
numDatos = size(X,1);
porcentajeTrain = 0.7;
numDatosTrain = round(porcentajeTrain*numDatos);
numerosMuestrasTrain = randsample(numDatos,numDatosTrain);
numerosMuestrasTest = find(not(ismember(1:numDatos,numerosMuestrasTrain)));
% Conjunto de Train
XTrain = X(numerosMuestrasTrain,:);
YTrain = Y(numerosMuestrasTrain);
% Conjunto de Test
XTest = X(numerosMuestrasTest,:);
YTest = Y(numerosMuestrasTest);

% 2.- Representa en dos gráficas independientes las muestras de
% entrenamiento y de test en el espacio de características.

subplot(1, 2, 1);
scatter3(XTrain(:, 1), XTrain(:, 2), XTrain(:, 3), 50, YTrain, 'filled');
title('Conjunto de Entrenamiento');
xlabel('x1');
ylabel('x2');
zlabel('x3');
grid on;

subplot(1, 2, 2);
scatter3(XTest(:, 1), XTest(:, 2), XTest(:, 3), 50, YTest, 'filled');
title('Conjunto de Test');
xlabel('x1');
ylabel('x2');
zlabel('x3');
grid on;

% 3.- Utilizando el conjunto de entrenamiento, diseña un 
% clasificador LDA y QDA, obteniendo las variables simbólicas
% d1(X), d2(X) y d12(X) = d1(X)-d2(X), donde X es un vector columna dato por x1, x2 y x3.

% 3.- Utilizando el conjunto de entrenamiento, diseña un clasificador LDA y QDA

% LDA
ldaModel = fitcdiscr(XTrain, YTrain, 'DiscrimType', 'linear');
mu1_lda = ldaModel.Mu(1, :)';
mu2_lda = ldaModel.Mu(2, :)';
Sigma_lda = ldaModel.Sigma;

% QDA
qdaModel = fitcdiscr(XTrain, YTrain, 'DiscrimType', 'quadratic');
mu1_qda = qdaModel.Mu(1, :)';
mu2_qda = qdaModel.Mu(2, :)';
Sigma1_qda = qdaModel.Sigma(:,:,1);
Sigma2_qda = qdaModel.Sigma(:,:,2);

% Variables simbólicas
syms x1 x2 x3 real;
X_sym = [x1; x2; x3];

% Funciones discriminantes para LDA
d1_lda = -0.5 * (X_sym - mu1_lda)' * inv(Sigma_lda) * (X_sym - mu1_lda);
d2_lda = -0.5 * (X_sym - mu2_lda)' * inv(Sigma_lda) * (X_sym - mu2_lda);
d12_lda = d1_lda - d2_lda;

% Funciones discriminantes para QDA
d1_qda = -0.5 * (X_sym - mu1_qda)' * inv(Sigma1_qda) * (X_sym - mu1_qda) - 0.5 * log(det(Sigma1_qda));
d2_qda = -0.5 * (X_sym - mu2_qda)' * inv(Sigma2_qda) * (X_sym - mu2_qda) - 0.5 * log(det(Sigma2_qda));
d12_qda = d1_qda - d2_qda;

% 4.- Incorpora a la representación del punto 2, la frontera de separación
% lineal que utiliza el clasificador diseñado para particionar el 
% espacio de características. Para ello utiliza la función de Matlab fimplicit3(d12).

% 4.- Incorpora a la representación del punto 2, la frontera de separación lineal que utiliza el clasificador diseñado para particionar el espacio de características.
figure;
subplot(1, 2, 1);
scatter3(XTrain(:, 1), XTrain(:, 2), XTrain(:, 3), 50, YTrain, 'filled');
title('Conjunto de Entrenamiento con Frontera LDA');
xlabel('x1');
ylabel('x2');
zlabel('x3');
grid on;
hold on;

% Frontera LDA
fimplicit3(matlabFunction(d12_lda, 'vars', [x1, x2, x3]), [min(XTrain(:, 1)), max(XTrain(:, 1)), min(XTrain(:, 2)), max(XTrain(:, 2)), min(XTrain(:, 3)), max(XTrain(:, 3))]);

subplot(1, 2, 2);
scatter3(XTest(:, 1), XTest(:, 2), XTest(:, 3), 50, YTest, 'filled');
title('Conjunto de Test con Frontera LDA');
xlabel('x1');
ylabel('x2');
zlabel('x3');
grid on;
hold on;

% Frontera LDA
fimplicit3(matlabFunction(d12_lda, 'vars', [x1, x2, x3]), [min(XTest(:, 1)), max(XTest(:, 1)), min(XTest(:, 2)), max(XTest(:, 2)), min(XTest(:, 3)), max(XTest(:, 3))]);

% 5.- Determine la tasa de acierto de los clasificadores en el conjunto 
% de observaciones de test. En el caso de LDA, se debe utilizar 
% la función d12(X), mientras que en el caso del clasificador QDA, 
% deben utilizarse las funciones d1(X) y d2(X).


% Clasificación usando LDA
predictedLabels_LDA = predict(ldaModel, XTest);
accuracy_LDA = sum(predictedLabels_LDA == YTest) / length(YTest);
fprintf('Tasa de acierto para LDA: %.2f%%\n', accuracy_LDA * 100);

% Clasificación usando QDA
predictedLabels_QDA = predict(qdaModel, XTest);
accuracy_QDA = sum(predictedLabels_QDA == YTest) / length(YTest);
fprintf('Tasa de acierto para QDA: %.2f%%\n', accuracy_QDA * 100);

%% Ejercicio 6: 

close all, clear, clc
 addpath("../Desktop/Sistemas de Percepción/Prueba2/Datos/")
load("..\..\..\Prueba2\Datos\datos_ejercicio6.mat")

clear, clc, close all



% 1.- Utilizando el conjunto de datos de entrenamiento, 
% diseña un clasificador LDA y representa su hiperplano de separación.

unique(YTrain);

XTrain_clase1 = XTrain(YTrain == 1,:);
XTrain_clase2 = XTrain(YTrain == 2,:);

XTest_clase1 = XTrain(YTest == 1,:);
XTest_clase2 = XTrain(YTest == 2,:);

XTrain_total = [XTrain_clase1; XTrain_clase2];

% LDA: -1/2 * (X - muk)' * inv(M) * (X - muk) + log(pik)

balanceado = size(XTrain_clase1, 1) == size(XTrain_clase2, 1)

x1 = sym("x1", "real");
x2 = sym("x2", "real");
x3 = sym("x3", "real");

X = [x1; x2];

mu1 = mean(XTrain_clase1)';
mu2 = mean(XTrain_clase2)';

pi1 = size(XTrain_clase1, 1) / size(XTrain_total, 1);
pi2 = size(XTrain_clase2, 1) / size(XTrain_total, 1);

parte1 = cov(XTrain_clase1) * size(XTrain_clase1, 1);
parte2 = cov(XTrain_clase2) * size(XTrain_clase2, 1);
div = size(XTrain_total, 1);
M = (parte1 + parte2) / div;

  

d1_lda = expand(-0.5 * (X - mu1)' * pinv(M) * (X - mu1) + log(pi1));
d2_lda = expand(-0.5 * (X - mu2)' * pinv(M) * (X - mu2) + log(pi2));

d12_lda = d1_lda - d2_lda;

x1 = 0; x2 = 0; x3 = 0; D = eval(d12_lda);
x1 = 1; x2 = 0; x3 = 0; A = eval(d12_lda) - D;
x1 = 0; x2 = 1; x3 = 0; B = eval(d12_lda) - D;
x1 = 0; x2 = 0; x3 = 1; C = eval(d12_lda) - D;

[x1Plano, x2Plano] = meshgrid(-4:4,-4:4);
x3Plano = -(A*x1Plano + B*x2Plano + D) / (C);

% Representar 

figure,
subplot(1,2,1)
plot3(XTrain_clase1(:,1), XTrain_clase1(:,2), XTrain_clase1(:,3), "*r"), hold on
plot3(XTrain_clase2(:,1), XTrain_clase2(:,2), XTrain_clase2(:,3), "*b"), hold on
surf(x1Plano, x2Plano, x3Plano)
subplot(1,2,2)
plot3(XTest_clase1(:,1), XTest_clase1(:,2), XTest_clase1(:,3), "*r"), hold on
plot3(XTest_clase2(:,1), XTest_clase2(:,2), XTest_clase2(:,3), "*b"), hold on
surf(x1Plano, x2Plano, x3Plano)

%% QDA

% Matrices covarianza

M1 = cov(XTrain_clase1);
M2 = cov(XTrain_clase2);

d1_qda = expand(-0.5 * (X - mu1)' * pinv(M) * (X - mu1) - log(det(M1)) + log(pi1));
d2_qda = expand(-0.5 * (X - mu2)' * pinv(M) * (X - mu2) - log(det(M2)) + log(pi2));

d12_qda = d1_qda - d2_qda;

%% Accuracy
x1 = XTest(:,1);
x2 = XTest(:,2);
x3 = XTest(:,3);

valores = eval(d12_lda);

Yp = zeros(size(YTest,1),1);
Yp(valores > 0) = 1;
Yp(valores < 0) = 2;

error = YTest - Yp;
nAciertos = sum(error == 0);
TasaAcierto_lda = nAciertos / size(YTest,1);


valores = eval(d12_qda);

Yp = zeros(size(YTest,1),1);
Yp(valores > 0) = 1;
Yp(valores < 0) = 2;

error = YTest - Yp;
nAciertos = sum(error == 0);
TasaAcierto_qda = nAciertos / size(YTest,1);