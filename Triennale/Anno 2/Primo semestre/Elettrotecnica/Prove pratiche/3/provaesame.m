syms I;
j = 1i;

R = 1; Vg = j; Zl = j; Zc = (-2/3)*j; n=3;

A = [0 1 0 (R+Zl) 0 0 0;
    1 0 0 0 Zc 0 0;
    0 1 -1 0 0 R R;
    1 0 0 0 0 R 2*R;
    0 -n -1 0 0 0 0;
    0 0 0 1/n 0 (-1+(1/n)) 0;
    0 0 0 0 -1 0 -1];

b = [-Vg; -Vg; 0; 0; 0; 0; I];

x = inv(A)*b;
disp('V = ')
disp(x(1));

%Calcolo di P dopo aver determinato V

P=((1886/4877 * 1886/4877)+(4649/4877 * 4649/4877))/(8*(932/4877));  
disp('P= ')
disp(P);