function Centroides = funcion_calcula_centroides_idx(X, idx)
    numAgrup = max(idx);
    numDim = size(X);
    Centroides = zeros(numAgrup, numDim(2));
    
    for i = 1:numAgrup
        Xi = X(idx == i, :);
        Centroides(i, :) = mean(Xi);
    end
end

