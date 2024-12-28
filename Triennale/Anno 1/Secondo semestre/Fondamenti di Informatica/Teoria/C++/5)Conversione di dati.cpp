#include <iostream>
#include <string> 

using namespace std;

int main(){
    //from float to int (implicitly)
    int x = 10.5;
    cout << x << endl;
    
    //from int to float
    x = 10;
    float y = x;
    cout << fixed << x << ", ";
    cout << fixed << y << endl;
    
    //from char to int
    char character = '$';
    int char_int = character;
    cout << char_int << endl; //ASCII position
    
    //from float to int (explicitly)
    float b = 3.9525;
    int B = static_cast<int>(b);
    cout << b << " " << B << endl;
    
    //retrieve ASCII code of a character
    int pos = 61;
    cout << "61 is the position of " << static_cast<char>(pos) << endl;
    
    //retrieve the type of a certain variable
    cout << typeid(x).name() << endl; //int
    cout << typeid(y).name() << endl; //float
    cout << typeid(character).name() << endl; //char
    
    return 0;
}