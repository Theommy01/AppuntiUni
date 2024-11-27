% Script MATLAB per animare graficamente una matrice random
% di Simone Fiori (DII-UnivPM)

% Inizializzazione
close all; clc

Mbar = randn(20,10); % Matrice casuale 20 x 10
for t = 0:0.01:5
    M = cos(2*pi*t)*Mbar;
    subplot(1,2,1);bar3(M);zlim([-3,3]);axis off
    subplot(1,2,2);surf(M);zlim([-3,3]);axis off
    pause(0.02)
end