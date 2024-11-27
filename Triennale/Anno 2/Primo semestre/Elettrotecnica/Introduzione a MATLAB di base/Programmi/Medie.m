% Script MATLAB per calcolare il valore medio di un insieme di numeri positivi
% di Simone Fiori (DII-UnivPM

% Inizializzazione
close all; clear all; clc

% Inserimento valori %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
v = [1 2 3.4 6 2.1 2.2 3.5 4];
%%%%%%%%%%%% L'utente può cambiare solo questa linea %

% Determinazione del numero di valori immessi
n = length(v); 
% Calcolo della media aritmetica
somma = 0; % Accumulatore per la somma
for i = 1:n
    somma = somma + v(i);
end

media_aritmetica = somma/n;
disp('La media aritmetica è:'); disp(media_aritmetica)
disp('La media aritmetica è sempre:'); disp(sum(v)/length(v))

% Calcolo della media geometrica
prodotto = 1; % Accumulatore per il prodotto
for i = 1:n
    prodotto = prodotto*v(i);
end

media_geometrica = prodotto^(1/n);
disp('La media geometrica è:');disp(media_geometrica)
disp('La media geometrica è sempre:');disp(prod(v)^(1/length(v)))

% Calcolo della media armonica
somma_reciproci = 0; % Accumulatore per la somma dei reciproci
for i = 1:n
    somma_reciproci = somma_reciproci + 1/v(i);
end

media_armonica = 1/(somma_reciproci/n);
disp('La media armonica è:');disp(media_armonica)
disp('La media armonica è sempre:');disp( 1/(sum(1./v)/length(v)) )

% Calcolo delle medie in altro modo
nuova_media_aritmetica = mean(v)
nuova_media_geometrica = exp(mean(log(v)))
nuova_media_armonica = 1/mean(1./v)

