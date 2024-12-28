#include <iostream>
#include <string>

using namespace std;

int main(){
    //String definition
    string name = "mario";
    name[0] = 'M'; //acceed and modify a specific string character
    
    cout << name << endl;
    
    int lenght = name.length();
    cout << name << " has " << lenght << " characters" << endl;
    
    //string concatenation
    string surname = " Rossi";
    name += surname;
    name += " 18"; //careful: name += 18 is an error, as compiler will read "int + string"
    cout << name << endl;
    
    //print last character of a string
    cout << "Last character: " << name[name.length() - 1] << endl;
    
    //append some information
    name.append(" years");
    cout << name << endl;
    
    //clear a variable
    name.clear();
    cout << "After clear: " << name << endl;
    
    //is a string empty?
    name.empty(); //returns 1 if it is empty, 0 if it has at least a character
    cout << name.empty() << endl;
    name = "Mario";
    cout << name.empty() << endl;
    
    //find a specific character. Remember indexes start from 0
    cout << "r in position " << name.find('r') << endl; //returns index
    
    //substring from index 2 to 15
    string divinacommedia = "Nel mezzo del cammin di nostra vita";
    cout << divinacommedia.substr(2, 15) << endl;
    
    //replace from index 2 to 15 with "***"
    cout << divinacommedia.replace(2, 15, "***") << endl;
    
    //from string to int
    string string_num = "1";
    int int_num = std::stoi(string_num); //"string to int". Similarly, stod is "string to double"
    
    
    //From lower case to upper case
    char lower = 'b'; //Notice that it must be 'b'; "b" will not be valid
    char upper = toupper(lower); 
    cout << upper << endl;
    
    //From upper case to lower case
    lower = tolower(upper);
    cout << lower << endl;
    
    //Other possibility based on the ASCII position of the letters
    char upper2 = lower + 32; 
    cout << upper << endl;
    char lower2 = upper2 - 32;
    cout << lower << endl;
    
    //We can apply this in a string
    string test = "my nAme is Mario";
    test[0] = toupper(test[0]);
    test[4] = tolower(test[4]);
    cout << test << endl;
    
    return 0;
}