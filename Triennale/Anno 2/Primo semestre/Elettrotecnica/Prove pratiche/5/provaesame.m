syms I i;
j = 1i;

R = 3; Zl = 6j; Zc = -j; Vg = -3*j; Ig = 1;

Y11 = 1; Y12 = 0; Y21 = -1/4; Y22 = 1/2;

A = [0 R 0 0 1 -1;
    0 0 Zl 1 1 0;
    Zc 0 (R+Zl+Zc) 0 0 1;
    (R+Zl+Zc) 0 Zc 0 0 0;
    0 1 0 0 -Y11 -Y12;
    0 -1 1 0 -Y21 -Y22]; 

b = [0; -(Zl+Zc)*Ig; -Zl*Ig; -Vg; -Ig; 0];

x = inv(A)*b;

I = x(1);

disp('I = ')
disp(I);

P=(1/2)*Vg*(I');

disp('P = ');
disp(P);