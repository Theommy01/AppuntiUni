#include <iostream>
#include <string> 

using namespace std;

int global = 10;

void procedure(string name){
    cout << "This is a procedure" << endl;
    cout << "Hello, " << name << " ;-)" << endl;
}

int max(int a, int b){
    if (a >= b){
        return a;
    } else {
        return b;
    }
}

string function(); /*Another possibility is to declare all the
                   functions before the main...*/
int main(){
    cout << global << " is a global variable" << endl;
    
    string name = "Mario";
    int x, y;
    
    procedure(name);
    
    cout << "Write x: ";
    cin >> x;
    cout << "Write y: ";
    cin >> y;
    
    cout << "The maximum between the numbers is " << max(x, y) << endl;
    //CAREFUL: FUNCTIONS MUST BE DECLARED BEFORE IT IS CALLED
    cout << function() << endl;
    
    return 0;
}

string function(){ //... and develop them later
    return "Function";
}