#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct Person{
    string name;
    string surname;
    int age;
};

int main() {
    Person person1;
    person1.name = "Mario";
    person1.surname = "Rossi";
    person1.age = 23;
    
    cout << "Name: " << person1.name << endl;
    cout << "Surname: " << person1.surname << endl;
    cout << "Age: " << person1.age << endl;
    
    Person person2 = {"Mario", "Draghi", 77};
    cout << "Name: " << person2.name << endl;
    cout << "Surname: " << person2.surname << endl;
    cout << "Age: " << person2.age << endl;
    
    vector<Person> persons = {person1, person2};
    
    for(int i = 0; i < persons.size(); i++){
        cout << "Person " << i << " surname: " << persons[i].surname << endl;
    }

    return 0;
}
