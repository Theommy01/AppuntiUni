#include <iostream> 
#include <string> // Include string class
#include <limits>

int main(){
    //Let's see how to initialize a variable
    
    //In general, <typevar> <namevar> = <assignedvar>
    /* !!!
    1) <typevar> <namevar> is acceptable. The variable will be associated to a
       default value, like 0 for numbers, False for booleans etc.
       In that case, we are just declaring a variable and assign a value somewhere else in the code
    2)    
    */
    int integer = 3;
    char character = '1';
    bool boolean = 'T'; //T (True) or F (False), also represented as 1 or 0 respectively
    
    std::cout << "Output a variable: " << boolean << std::endl;
    
    std::cout << "Take an input char: " ;
    std::cin >> character;
    /*Prevent unexpected behavour. char returns one character onlu
    but if user input is longer than it the remaining will remain
    in the buffer. Nothing happens if the user writes one letter only,
    but this command prevents unexpected behaviours*/
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    std::cout << character << std::endl;
    
    //Notice char behaviour. If we want to take a whole word or sentence, we need another type of variable
    //We'll call String objects. Objects will be more clear when studying OOP, for now take everything for granted
    std::string userinput;
    std::cout << "Take a user input: " ;
    std::cin >> userinput;
    std::cout << "\nYour input: " << userinput << std::endl;
    
    //Let's see what happens in case we do not make that prevention+
    std::cout << "Take an input char: " ;
    std::cin >> character;
    std::cout << character << std::endl;
    std::cout << "Take a user input: " ;
    std::cin >> userinput;
    std::cout << "\nYour input: " << userinput << std::endl;
    
    //Let's declare a constant, i.e. values that never changes
    //The declaration is: const <typevar> <namevar> = <assignedvar>
    const float e = 2.7183; //IT CAN'T BE DECLARED AND ASSIGNED SECONDLY
    
    return 0;                  //end program
}