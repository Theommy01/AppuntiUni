#include <iostream>
#include <limits>  

using namespace std;

int main(){
    //VARIABLE TYPES IN C++
    
    //1) Int. Integer values
    int min_int = numeric_limits<int>::min();
    int max_int = numeric_limits<int>::max();
    int default_int; //0
    cout << "Min integer: " << min_int << endl;
    cout << "Max integer: " << max_int << endl;
    cout << "Default integer: " << default_int << endl;
    
    //In case we assign a real number to an integer, it is approcimated to the nearest integer
    int a = 3.4252;
    cout << "Example of what happens when assigning a real number to an int: " << a << endl;
    
    //attention to what happens when calling short, long and long long
    
    short int min_short_int = numeric_limits<short int>::min();
    short int max_short_int = numeric_limits<short int>::max();
    short int default_short_int; //0
    cout << "Min short integer: " << min_short_int << endl;
    cout << "Max short integer: " << max_short_int << endl;
    cout << "Default short integer: " << default_short_int << endl;
    
    long int min_long_int = numeric_limits<long int>::min();
    long int max_long_int = numeric_limits<long int>::max();
    long int default_long_int; //0
    cout << "Min long integer: " << min_long_int << endl;
    cout << "Max long integer: " << max_long_int << endl;
    cout << "Default long integer: " << default_long_int << endl;
    
    //2) Float. Real numbers
    float min_float = numeric_limits<float>::min();
    float max_float = numeric_limits<float>::max();
    float default_float; //0
    cout << "Min float: " << min_float << endl;
    cout << "Max float: " << max_float << endl;
    cout << "Default float: " << default_float << endl;
    
    //3) Double. Real numbers with higher decimal representation
    double min_double = numeric_limits<double>::min();
    double max_double = numeric_limits<double>::max();
    double default_double; //0
    cout << "Min double: " << min_double << endl;
    cout << "Max double: " << max_double << endl;
    cout << "Default double: " << default_double << endl;
    
    //Notice that max_double < max_float and min_double > min_float
    
    //In fact, float weights 4 bytes while doubles 8
    
    //4) Char. Characters as we saw in lesson 1
    char b = 'Y';
    // char a = "HFHOHO"; This will produce an error. Notice that,
    // as we saw in lesson 1, a user input can be longer and
    // no errors occur. It can result in some software bugs
    char default_char; //null
    cout << "Default char: " << default_char << endl;
    
    //5) Boolean
    bool condition = false;
    bool default_bool; //false, or 0
    cout << "Default boolean: " << default_bool << endl;
    
    //Extra: random variables in C++
    
    // Get a different random number each time the program runs
    srand(time(0));
    
    cout << rand() << endl;
    
    // Generate a random number between 0 and 100
    int randomNum = rand() % 101;
    cout << "Random number between 0 and 100: " << randomNum << endl;
    
    //Let's see how to "switch" between data types
    
    return 0;   
}