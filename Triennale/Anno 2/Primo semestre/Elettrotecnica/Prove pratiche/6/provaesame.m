syms I i;
j = 1i;

R = 9; Zl = j; Zc = -j; Vg = 1/2; n = 3/4; k = 2/3;

A = [1 0 -1 0 R 0 0 0;
    0 0 -1 1 0 R 0 R;
    0 1 0 0 0 R 0 (2*R);
    0 1 0 0 0 0 Zl 0;
    0 0 -n 1 0 0 0 0;
    0 0 0 0 (-1/n) (-1/n) 0 0;
    -k 1 0 0 0 0 0 0;
    1 0 0 0 -Zc 0 0 0];
 
 b = [Vg; 0; 0; Vg; 0; 0; 0; 0];

x = inv(A)*b;

disp('Vc = ')
disp(x(1));