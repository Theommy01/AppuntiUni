syms I i;
j = 1i;

R = 3/4; Zl = (2/3)*j; Zc = (-1/4)*j; Zm = (1/2)*j; Zl1 = 4j; Zl2 = 6j;
Vg = 2; Ig = -4*j;

Y11 = 1; Y12 = 1/2; Y21 = -1/2; Y22 = 2;

A = [0 1 0 0 -1 1 0;
    0 0 1 0 0 0 Zl;
    -1 0 0 1 0 0 0;
    0 0 Y11 Y12 0 0 1;
    0 0 Y21 Y22 0 0 0;
    0 0 0 0 1 0 0;
    0 0 0 0 0 1 0];

b = [-R*Ig; Vg; (Vg-(Zc*I)); 0; I; (Zm-Zl1)*Ig; (Zl2-Zm)*Ig];

x = inv(A)*b;
disp('V = ')
disp(x(1));

P = (((42/25)*(42/25))+((6/25)*(6/25)))/(8*(12/25))