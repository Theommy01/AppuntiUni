#include <iostream>
#include <string> 

using namespace std;

int main(){
    int positive = 5;
    
    while(positive >= 0){ //it might never enter the loop
        cout << positive << " while iteration" << endl;
        positive--;
    }
    
    positive = 5;
    
    /*
    while(true){
        cout << "Infinite loop" << endl;
    }*/
    
    do{ //Surely, at least an iteration happens
        cout << positive << " do while iteration" << endl;
        positive--;
    } while(positive >= 0);
    
    //classic do-while example
    int number;
    do{ //Surely, at least an iteration happens
        cout << "Write a positive number: " << endl;
        cin >> number;
        if(number <= 0) cout << "Retry..." << endl;
    } while(number <= 0);
    
    for(int counter = 0; counter < number; counter++){
        cout << counter << " for iteration" << endl;
    }
    
    cout << "what if we want to exit a loop earlier? " << endl;
    
    for(int i = 0; i < 10; i++){
        if(i == 5) break;
        cout << i << " for iteration" << endl;
    }
    
    for(int i = 0; i < 10; i++){
        if(i == 5) continue;
        //it doesn't actually exit the loop, it just "skips" i == 5
        cout << i << " for iteration" << endl;
    }
    
    for(int i = 0; i < 10; i++){
        if(i == 5) goto label;
        cout << i << " for iteration" << endl;
    }
    
    label:
    cout << "goto is generally not suggested to use" << endl;
    
    return 0;
}