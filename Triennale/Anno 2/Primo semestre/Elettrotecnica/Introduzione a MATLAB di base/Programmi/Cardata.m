% Script MATLAB per leggere e rappresentare un dataset
% di Simone Fiori (DII-UnivPM)

% Inizializzazione
close all; clc

% Lettura del file di dati
load car_data.txt
miles_per_gallon = car_data(:,1);
horse_power = car_data(:,2);

% Rappresentazione dei dati
scatter(horse_power,miles_per_gallon)
xlabel('Potenza del motore [hp]')
ylabel('Efficenza del motore [miglia/gallone]')
