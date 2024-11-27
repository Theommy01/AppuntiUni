% Programma per rappresentare funzioni sinusoidali
clc; close all;
x = -6*pi : 0.01 : 6*pi;
ys = sin(x);
yc = cos(x);

plot(x,ys,'b-'); hold on;
plot(x,yc,'r-');
legend('sin(x)','cos(x)')
xlabel('Variabile x')
ylabel('sin(x) e cos(x)')