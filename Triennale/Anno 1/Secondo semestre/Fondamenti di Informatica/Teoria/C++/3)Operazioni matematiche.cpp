#include <iostream>
#include <cmath> //Import mathematic function

using namespace std;

int main(){
    //Operations
    
    //1) operations between 2 integer
    int x = 5;
    int y = 3;
    
    int int_sum = x + y;
    int int_diff = x - y;
    int int_mul = x * y;
    int int_div = x / y;
    int int_mod = x % y;
    
    cout << "Sum between 2 integers: " << int_sum << endl;
    cout << "Difference between 2 integers: " << int_diff << endl;
    cout << "Multiplication between 2 integers: " << int_mul << endl;
    cout << "Division between 2 integers: " << int_div << endl;
    cout << "Division remainder between 2 integers: " << int_mod << endl;

    cout << "Expressions are same as in the basic math\n";
    cout << "Example: (2+4)*4+52-5/(78-41) = " << (2+4)*4+52-5/(78-41) << endl;
    //Same operations are valid in the other numeric data types, but careful on the conversions
    cout << "Real result: " << (2.0+4.0)*4.0+52.0-5.0/(78.0-41.0) << endl;
    
    //Auto-increment and auto-decrement
    int counter;
    cout << "counter = " << counter << endl;
    counter++;
    cout << "counter = " << counter << endl;
    counter--;
    cout << "counter = " << counter << endl;
    
    //We can also perform the auto-increment/decremenet inside the cout
    cout << "counter1 = " << counter << " counter2 = "<< ++counter << " counter3 = " << --counter << endl;
    //In this case, careful on performing the auto-increment/decremenet. Let'ss see below
    cout << "counter1 = " << counter << " counter2 = "<< counter++ << " counter3 = " << counter-- << endl;

    //Fast sum
    int a = 5, b=7;
    a += b; //CAREFUL THAT a ITSELF IS UPDATED AS a+b. This is as a = a + b
    cout << "5+7 = " << a << endl;
    
    //Division between a float and an int
    cout << "3/5 = " << 3 / 5.0 <<endl; //Result in float
    
    //Examples of mah functions
    cout << "5^3 = " << pow(5, 3) << endl;
    cout << "sqrt(18) = " << sqrt(18) << endl;
    
    return 0;
}