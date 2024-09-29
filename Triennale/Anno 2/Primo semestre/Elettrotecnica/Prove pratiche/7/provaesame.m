syms i;
j = 1i;

R = 3; Zl = (1/2)*j; Zc = -j; Vg = 2; Ig = -3*j;

Za11 = 3; Za12 = 1/2; Za21 = -1; Za22 = 2;
Zb11 = 3; Zb12 = -1; Zb21 = 1/2; Zb22 = 2;

A = [0 -R 0 1 -1 0 0 0;
    0 (2*R+Zl) Zl 0 0 1 0 0;
    Zc Zl (Zl+Zc) 0 0 0 1 0;
    Zc 0 Zc 0 0 0 0 1;
    0 -Za12 0 0 1 0 0 0;
    0 -Za22 0 0 0 1 0 0;
    -Zb12 0 -Zb11 0 0 0 1 0;
    -Zb22 0 -Zb21 0 0 0 0 1]; 

b = [-R*Ig; R*Ig; 0; -Vg; -Za11*Ig; -Za21*Ig; 0; 0];

x = inv(A)*b;

disp('Ix = ')
disp(x(1));