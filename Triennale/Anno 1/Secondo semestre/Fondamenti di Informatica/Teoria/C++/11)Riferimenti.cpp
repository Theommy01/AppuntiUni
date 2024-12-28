#include <iostream>
#include <string>
using std::string;

void fun(int &x){
    x = 50;
}

int& compare(int &x, int &y){
    return (x > y) ? x : y; 
}

int main()
{
    int a = 5; //declare an integer
    int &ref_a = a; //references has to be already referred to a variabile. It can't change
    
    std::cout << a << std::endl;  //outputs 5
    std::cout << ref_a << std::endl; //outputs a's value
    
    std::cout << "When changing a, ref_a changes as well..." << std::endl;
    
    a = 10;
    
    std::cout << a << std::endl;
    std::cout << ref_a << std::endl;
    
    std::cout << "...and viceversa" << std::endl;
    
    ref_a = 2;
    
    std::cout << a << std::endl;  
    std::cout << ref_a << std::endl;
    
    //In conclusion, a and ref_a are the same variable
    
    std::cout << "We can observe that a and ref_a are the same variable, with the same addresses" << std::endl;
    
    int *ptr = nullptr;
    
    ptr = &a;
    std::cout << ptr << std::endl; //outputs a's address
    
    ptr = &ref_a;
    std::cout << ptr << std::endl; //outputs ref_a's address
    
    //Let's see how to exploit references and functions
    fun(a); //function fun takes in input the reference to a

    std::cout << a << std::endl;

    //useful case
    int b = 213, c = 412;
    int &max = compare(b,c);
    std::cout << max << std::endl;
    
    //now, max is referring to c. Let's modify c using max
    max = 219;
    std::cout << c << std::endl;
}