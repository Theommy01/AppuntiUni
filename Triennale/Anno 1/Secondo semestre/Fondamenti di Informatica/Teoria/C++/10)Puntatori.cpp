#include <iostream>
#include <string>
using std::string;

void fun(int *ptr){
    *ptr = 50;
}

int main()
{
    int a = 5; //declare an integer
    int *ptr_a = nullptr; //declare a pointer that points to an address where an integer is defined
    ptr_a = &a; //point to the address of a, the previously defined integer
    
    std::cout << a << std::endl;  //outputs 5
    std::cout << ptr_a << std::endl; //outputs a's address
    std::cout << *ptr_a << std::endl; //outputs a's value
    
    std::cout << "Let's change manually a..." << std::endl;
    
   *ptr_a = 3; //change a's value by working with the pointer
   
    std::cout << a << std::endl;  //outputs 5
    std::cout << ptr_a << std::endl; //outputs a's address
    std::cout << *ptr_a << std::endl; //outputs a's value
    
    std::cout << "Pointers and functions" << std::endl;

    fun(&a);
    
    std::cout << a << std::endl;  //outputs 50
}