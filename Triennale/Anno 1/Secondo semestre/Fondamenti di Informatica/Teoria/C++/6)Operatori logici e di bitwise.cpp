#include <iostream>
#include <string> 

using namespace std;

int main(){
    /*Comparing...
    
    <=) less or equal than
    >=) Greater or equal than
    <) Less than
    >) Greater than
    ==) Equal
    !=) Different
    
    */
    
    /*Boolean operators...
    !) Logic not
    &&) Logic and
    ||) Logic or
    
    */
    //BITWISE OPERATORS, that works with integer's bit
    //Useful for low level programming
    
    int a = 3; //0000011
    int b = 7; //0000111
    
    int and_bitwise = a & b; // 00000011 & 00000111 = 00000011
    cout << "3 & 7 = " << and_bitwise << endl; // == 3
    int negative_andb = -a & b; //-3 == 11111101 (negative number in 2 complement)
    cout << "-3 & 7 = " << negative_andb << endl; // = 00000101 == 5
    
    int or_bitwise = a | b; // 00000011 | 00000111 = 00000111
    cout << "3 | 7 = " << or_bitwise << endl; // == 7
    
    int xor_bitwise = a ^ b; // 00000011 & 00000111 = 00000100
    cout << "3 ^ 7 = " << xor_bitwise << endl; // == 4
    
    int not_bitwise_a = ~a; // ~0000011 = 11111100
    cout << "~3 = " << not_bitwise_a << endl; // == -4
    
    const int numshift = 1;
    int left_shift_a = a << numshift; // 0000110
    cout << "3 << 1 = " << left_shift_a << endl; // 6
    
    int right_shift_a = a >> numshift; // 0000001
    cout << "3 >> 1 = " << right_shift_a << endl; // 1
    
    int singlebit_and = 3;
    singlebit_and &= 7; //similar to and bitwise
    cout << "3 &= 7 -> " << singlebit_and << endl;
    
    int singlebit_or = 3;
    singlebit_or |= 7; //similar to or bitwise
    cout << "3 |= 7 -> " << singlebit_or << endl;
    
    int singlebit_xor = 3;
    singlebit_xor ^= 7; //similar to xor bitwise
    cout << "3 ^= 7 -> " << singlebit_xor << endl;
    
    int combinedshift = 3;
    combinedshift <<= numshift;
    cout << "3. Combined left shift -> " << combinedshift << endl;
    combinedshift >>= numshift;
    cout << "6. Combined right shift -> " << combinedshift << endl;
    
    
    return 0;
}