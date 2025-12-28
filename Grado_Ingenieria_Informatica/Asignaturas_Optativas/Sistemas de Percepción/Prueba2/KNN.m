function Ytest = funcion_KNN(Xtrain, Ytrain, Xtest, K)
% Generar Xtrain, Ytrain, Xtest
valoresClases = unique(Ytrain);
numClases = length(valoresClases);
[nTrain, ~] = size(Xtrain);
[nTest, ~] = size(Xtest);
K = 10;

YtestKNN = zeros(nTest, 1);
NP = Xtrain';
for i = 1 : nTest
    P = Xtest(i, :)';
    P_Amp = repmat(P, 1, nTrain);
    d = sqrt(sum((P_Amp - NP).^2));
    [dOrd, ind] = sort(d); % Por defecto de menor a mayor
    indOI = ind(1 : K);
    clasesOI = Ytrain(indOI); % Clases ordenadas
    valoresClasesOI = unique(clasesOI);
    numClasesOI = length(valoresClasesOI);

    if numClasesOI == 1
        YtestKNN(i) = valoresClasesOI;
    else
        conteoClasesOI = zeros(1, numClasesOI);
        for j = 1 : numClasesOI
            conteoClasesOI = sum(clasesOI == valoresClasesOI(j));
        end
        posClasesOI = find(conteoClasesOI == max(conteoClasesOI)); % Encontrar las posiciones donde se alcanza el valor maximo
        
        if length(posClasesOI) == 1
            YtestKNN(i) = valoresClasesOI(posClasesOI);
        else
            for w = 1 : K % Recorremos las clases mas cercanas
                clasesKNN = valoresClasesOI(posClasesOI);
                if ismember(clasesOI(w), clasesKNN)
                    break;
                end
            end
            YtestKNN(i) = clasesOI(w);
        end
    end
end