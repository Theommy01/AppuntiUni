% Programma per la verifica delle proprietà delle matrici

% Verifica che (EF)' = F'E'
E = randn(3); F = randn(3);
disp('Termine (EF)'' '); disp((E*F)')
disp('Termine F''E'' '); disp(F'*E')

% Verifica che S_1S_2 non è simmetrica
simm = @(X) (X + X')/2; % Rende simmetrica ogni matrice quadrata
S1 = simm(randn(4));
S2 = simm(randn(4));
disp('Prodotto S1S2'); disp(S1*S2)