syms I i;
j = 1i;

R = 1; Zm = (-1/4)*j; Zl1 = 2*j; Zl2 = 1*j; Zl = (1/2*j); Zc = (-1/2*j);
Ig = sqrt(2)/2 * (1 + j);

A = [1 -1 1 0 0 0; 
    0 -1 0 0 (2*R + Zl) -R;
    0 0 0 0 -R (2*R + Zc);
    0 0 0 1 0 -R;
    0 1 0 0 -Zl1 0;
    0 0 1 0 -Zm 0]; 

b = [-R*(I + Ig); 0; R*Ig; -R*(2*Ig + I); (-Zl1 + Zm)*I; (-Zm + Zl2)*I];

x = inv(A)*b;

disp('V = ')
disp(x(1));

P=((281/337 * 281/337)+(200/337 * 200/337))/(4*(379/674));  %Calcolato dopo aver runnato la prima volta

disp('P= ')
disp(P);