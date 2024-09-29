syms i;
j = 1i;
R = 3; Zc=(-5/2)*j; Zl=4*j; Ig=j; Vg=1; n=3;

A = [(2*R+Zl) 0 -R 0 1 0;
    0 R 0 -R -1 1;
    -R 0 (R+Zc) 0 0 0;
    0 0 0 0 n -1;
    1/n (1-(1/n)) 0 0 0 0;
    0 0 0 -1 0 0];

b = [0; Vg; -Vg; 0; 0; -Ig];

x = inv(A)*b;
disp('I = ')
disp(x(1));