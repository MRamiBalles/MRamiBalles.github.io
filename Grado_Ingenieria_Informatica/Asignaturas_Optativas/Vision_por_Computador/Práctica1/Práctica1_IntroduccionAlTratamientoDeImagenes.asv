%  Práctica 1: Introduccion al tratamiento de imagenes

% 1. Con la instrucción imfinfo de Matlab obtén la siguiente información de la imagen "P1_1.jpg”: 
% anchura en píxeles, altura en píxeles, tipo de imagen y profundidad de bit.
info = imfinfo('P1_1.jpg')

% 2. Lee la imagen y guárdala en una variable de Matlab de nombre Imagen1.
Imagen1 = imread('P1_1.jpg')

% 3. Visualiza esta imagen con la instrucción imtool y con la instrucción imshow. 
% Familiarízate con los entornos gráficos de salida de cada una de estas instrucciones.
imtool(Imagen1)
imshow(Imagen1)

% 4. Con la instrucción whos obtén la siguiente información de la variable Matlab Imagen1: tipo de dato y rango.
whos Imagen1

% 5. Utilizando la instrucción max, calcula el valor máximo de la variable Imagen1 (máximo nivel de intensidad).
maximo = max(Imagen1(:))
maximo = max(max(max(Imagen1)))

% 6. Calcula en Matlab la imagen complementaria de Imagen1, denominándola Imagen2. 
% Visualiza esta imagen y guárdala en un fichero de imagen del mismo formato que la imagen original empleando la instrucción imwrite.
close all
Imagen2 = 255 - Imagen1, imshow(Imagen2)
imwrite(Imagen2,'fichImagen2.jpg')

% 7. Crea y visualiza una matriz, de nombre Imagen3, con los niveles de rojo de la imagen Imagen1. Notar que esta nueva matriz es una imagen en niveles de gris.
Imagen3 = Imagen1(:,:,1), imshow(Imagen3)

R = Imagen1(:,:,1);
G = Imagen1(:,:,2);
B = Imagen1(:,:,3);

Rc = 255 - R;
Gc = 255 - G;
Bc = 255 - B;

[nf nc nm] = size(Imagen1);
I3 = uint8(zeros(nf, nc, nm));
I3 = cat(3,Rc,Gc,Bc);
imshow(I3)

% 8. Utiliza la función imadjust con la configuración ImagenSalida=imadjust(ImagenEntrada,[],[],gamma) para, 
% mediante la modificación del parámetro gamma, obtener una imagen Imagen4 más clara (asignar gamma=0.5) 
% y una imagen Imagen5 más oscura (asignar gamma=1.5)que Imagen3. Visualiza estas imágenes 
% y representa su histograma mediante la función Matlab imhist. Interpreta cualitativamente los resultados de la operación realizada.
Imagen4 = imadjust(Imagen3, [], [], 0.5)
Imagen5 = imadjust(Imagen3, [], [], 1.5)
subplot(3,2,1), imhist(Imagen3),subplot(3,2,3),imhist(Imagen4),subplot(3,2,5),imhist(Imagen5)
subplot(3,2,2), imshow(Imagen3),subplot(3,2,4),imshow(Imagen4),subplot(3,2,6),imshow(Imagen5)

% 9. Utiliza la función imabsdiff, para crear una nueva imagen Imagen6 que refleje la diferencia absoluta de Imagen4 e Imagen5. Interpreta los resultados. Realiza la misma operación sin utilizar la función imabsdiff y comprueba que obtienes los mismos resultados.
% Para ello, implementa y utiliza la siguiente función que permite saber si el contenido de dos matrices de la misma dimensión es el mismo:
% varLogica = funcion_compara_matrices(M1, M2)
% donde varLogica es una variable lógica indica si M1 y M2 son iguales (valor true) o diferentes (valor false)
Imagen6 = imabsdiff(Imagen4, Imagen5);

close all;
subplot(2,2,1), imshow(Imagen4), title('Imagen4');
subplot(2,2,2), imshow(Imagen5), title('Imagen5');
subplot(2,2,3), imshow(Imagen6), title('Imagen6 (Diferencia 4-5)');
Imagen6 = imabsdiff(Imagen5, Imagen4);
subplot(2,2,4), imshow(Imagen6), title('Imagen6 (Diferencia 5-4)');

I6 = uint8(abs(double(Imagen4) - double(Imagen5)));
I6_2 = uint8(abs(double(Imagen5) - double(Imagen4)));
var1 = funcion_compara_matrices(Imagen6, I6)
var2 = funcion_compara_matrices(Imagen6,I6_2)

% 10. Implementación de histograma de una imagen:
% a. Implementa una función que tenga como objetivo calcular el histograma de una imagen de intensidad I.
% La función debe devolver un vector h con la información numérica del histograma: h = función_histograma(I)
% Deben implementarse dos versiones de la función: la primera, que realiza un recorrido por cada píxel de la imagen para generar el histograma;
% la segunda, que realiza un recorrido por cada posible nivel de gris que puede estar presente en la imagen de entrada.
h1 = funcion_histograma_pixel(Imagen1);
h2 = funcion_histograma_nivel_gris(Imagen1);
h = imhist(Imagen1);

var = funcion_compara_matrices(h1,h2)

% b. Aplica la función anterior para generar y visualizar el histograma de la componente verde de la imagen de la práctica.
G = Imagen1(:,:,2);
subplot(3,1,1), imshow(G),subplot(3,1,2), imshow(funcion_histograma_pixel(G)),subplot(3,1,3), imshow(funcion_histograma_nivel_gris(G))

% c. Comprueba que obtienes los mismos resultados que genera la función Matlab imhist. La comprobación debe realizarse visualmente,
% representando los histogramas en una misma gráfica, y numéricamente, utilizando la función funcion_compara_matrices.
