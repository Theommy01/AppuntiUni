#include <iostream>
#include <string> 

using namespace std;

int main(){
    int a = 15;
    int b = -1;
    
    cout << "Let's see how if works" << endl;
    
    if (a>=15) {
        cout << a << " is a greater or equal than 15" << endl;
    }
    
    cout << "Let's see how if ... else works" << endl;
    
    if (b>0) {
        cout << b << " is a positive number" << endl;
    } else {
        cout << b << " is a negative number" << endl;
    }
    
    if (b>0) {
        cout << b << " is a positive number" << endl;
    } else if (b < 0) {
        cout << b << " is a negative number" << endl;
    }
    
    cout << "When we have different if ... else statements, use switch" << endl;
    
    int day;
    cout << "Write a number between 1 and 7: " << endl;
    cin >> day;
    
    switch(day){
        case 1: {
            cout << "Today is monday" << endl;
            break;
        }
        case 2: {
            cout << "Today is tuesday" << endl;
            break;
        }
        case 3: {
            cout << "Today is wednesday" << endl;
            break;
        }
        case 4: {
            cout << "Today is thursday" << endl;
            break;
        }
        case 5: {
            cout << "Today is friday" << endl;
            break;
        }
        case 6: {
            cout << "Today is saturday" << endl;
            break;
        }
        case 7: {
            cout << "Today is sunday" << endl;
            break;
        }
        default: {
            cout << "Invalid number" << endl;
            break;
        }
    }    
        
        switch(day){
        case 1:
        case 2:
        case 3:
        case 4:
        case 5: {
            cout << "Weekday" << endl;
            break;
        }
        case 6:
        case 7: {
            cout << "Weekend" << endl;
            break;
        }
        default: {
            cout << "Invalid number" << endl;
            break;
        }
    }

    //faster way to write if ... else with ternary operators
    
    int number = 71;
    string type_number = (number % 2 == 0) ? "even" : "odd";
    // if number is divisible by 2, type_number = even, else type_number = odd
    cout << number << " is " << type_number << endl;
    
    //it can concatenate lots of if else
    string sign = (number < 0) ? "negative" : (number == 0) ? "zero" : "positive";
    cout << number << " is " << sign << endl;
    
    /* this can be used only for assigning values based on conditions
       or for managing some cout's */
    
    return 0;
}