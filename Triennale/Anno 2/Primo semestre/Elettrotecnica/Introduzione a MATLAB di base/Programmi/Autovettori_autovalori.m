% Calcolo degli autovettori e degli autovalori di una matrice simmetrica

simm = @(X) (X + X')/2; % Rende simmetrica ogni matrice quadrata
S = simm(randn(4));

% U = matrice degli autovettori, D = matrice (diagonale) degli autovalori
[U,D] = eig(S)

disp('Verifica')
disp('========')
disp('Prodotto UDU'' '); disp(U*D*U')
disp('Matrice S'); disp(S)