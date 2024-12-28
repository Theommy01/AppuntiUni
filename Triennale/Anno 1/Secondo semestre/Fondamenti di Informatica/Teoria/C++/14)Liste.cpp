#include <iostream>
using namespace std;

struct student { 
	char name[12];
	int grade;
	student* next; //pointer to the next node in the list
};

typedef student* list; //Alias for the pointer to a student

void add_beginning(list& beginning, student elem){
	list newNode = new student; //Create a new node
	*newNode = elem; //Copy the student's data in the new node
	newNode->next = beginning; //Point the new node to the first element of the list
	beginning = newNode; //Update the pointer to include the new student
}

bool delete_beginning(list& beginning, student& elem){
	list deleteNode = beginning;
	if (deleteNode == 0) return false; //empty list
	elem = *deleteNode; //Copy the student's data in the new node
	beginning = deleteNode->next; //Shift pointer position to the next element
	delete deleteNode;
	return true;
}

void add_end(list& beginning, student elem){
	list newNode, currentNode;
	
	//Look for the last node in the list
	for (currentNode = beginning; currentNode != 0; currentNode = currentNode->next){
	    newNode = currentNode;
	}
	
	currentNode = new student;
	*currentNode = elem;
	currentNode->next = 0; //Last node points to 0
	
	if (beginning == 0){ //If empty list, new node is the beginning
	    beginning = currentNode;
	}else { //Otherwise, attach the last node to the new node
	    newNode->next = currentNode;
	}
}

bool delete_end(list& beginning, student& elem){
    list beforeLastNode = 0, lastNode;
    if (beginning == 0) return false;
    
    for (lastNode = beginning; lastNode->next != 0; lastNode = lastNode->next){
        beforeLastNode = lastNode;
    }
    
    elem = *lastNode; 
    
    if (lastNode == beginning){ // se si estrae il primo elemento
        beginning = 0;
    }else {
        beforeLastNode->next = 0;
    }
    
    delete lastNode;
    return true;
}

//Add a new element, ordering w.r.t. grade
void add_ordered(list& beginning, student elem) {
    list previousNode, currentNode, newNode;
    for (currentNode = beginning; currentNode != 0 && currentNode->grade < elem.grade; currentNode = currentNode->next){
        previousNode = currentNode;
    }
    newNode = new student;
    *newNode = elem; 
    newNode->next = currentNode;
    
    if (currentNode == beginning){
        beginning = newNode;
    }else {
        previousNode->next = newNode;
    }
}

bool equal(char string1[], char string2[]){
    int i = 0;
    
    while (string1[i] != '\0'){ 
	 if (string1[i] == string2[i]){
	     i++;
	 }else {
	     return false;
	 }
    }
    
    return true; 
}

bool delete_specific(list& beginning, student& elem){
    list previousNode = 0, currentNode;
    for (currentNode = beginning; currentNode != 0 && !equal(currentNode->name, elem.name); currentNode = currentNode->next){
        previousNode = currentNode;
    }
    if(currentNode == 0){ //The required element has not been found
        return false;
    }  
    
    if(currentNode == beginning){ //The required element is the first
        beginning = currentNode->next;
    }else {
        previousNode->next = currentNode->next;
    }
    
    elem = *currentNode;
    delete currentNode;
    return true;
}

void print_list(list p) {
    if (p == nullptr) {
        cout << "Empty list..." << endl;
        return;
    }
    while (p != nullptr) {
        cout << "Name: " << p->name << ", Grade: " << p->grade << endl;
        p = p->next; // Passa al nodo successivo
    }
}

int main() {
	char choice;
	list current_list = 0;
	student input;
	do {
		cout << endl << "Menu: " << endl;
		cout << "i: Add a new student at the beginning of the list " << endl;
		cout << "c: Add a new student at the end of the list " << endl;
		cout << "o: Add a new student ordered w.r.t. its grade " << endl;
		cout << "t: Delete the first student from the list " << endl;
		cout << "e: Delete the last student from the list " << endl;
		cout << "f: Delete a student of choice " << endl;
		cout << "s: Print the full list of students " << endl;
		cout << "Other characters: PROGRAM GETS CLOSED" << endl;
		cout << "Your choice: " << endl;
		cin >> choice;
		switch (choice) {
			case 'i': {
			    cout << "Write student's name: ";
			    cin >> input.name;
			    cout << "Write student's grade: ";
			    cin >> input.grade;
				add_beginning(current_list, input);
			}; break;
			
			case 'c': {
			    cout << "Write student's name: ";
			    cin >> input.name;
			    cout << "Write student's grade: ";
			    cin >> input.grade;
				add_end(current_list, input);
			}; break;
			
			case 'o': {
			    cout << "Write student's name: ";
			    cin >> input.name;
			    cout << "Write student's grade: ";
			    cin >> input.grade;
				add_ordered(current_list, input);
			}; break;
			
			case 't': {
			    delete_beginning(current_list, input); 
				cout << "I deleted " << input.name 
                     << " whose grade was " << input.grade << endl;
			}; break;
			
            case 'e': {
                delete_end(current_list, input);
				cout << "I deleted " << input.name 
                     << " whose grade was " << input.grade << endl;
            }; break;
            
            case 'f': {
                cout << "Write the name of the student to delete: ";
                cin >> input.name;
				if(delete_specific(current_list, input))
					cout << "I deleted " << input.name 
                     << " whose grade was " << input.grade << endl;
                else cout << "This student is not in the list" << endl;
            } break;
            
            case 's':
                print_list(current_list); break;
    }
  }
 while (choice == 'i' || choice == 'c' || choice == 'o' || choice == 't' || choice == 'e' || choice == 'f' || choice == 's');
}
