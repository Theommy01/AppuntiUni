#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(){
    const int array_dim = 5;
    vector<int> grades = {1, 3, 6, 7, 5};
    // grades[0] = 1, grades[1] = 3 ...
    grades[3] = 7;
    
    int emptyarray[array_dim];
    
    for(int i = 0; i < sizeof(emptyarray) / sizeof(int); i++){
        cout << "Write element " << i << " : ";
        cin >> emptyarray[i];
    }
    
    grades.clear();
    cout << grades[0] << " grades elements have been deleted" << endl;
    grades = {1, 3, 6, 7, 5};
    
    cout << "\nAddress where the array is saved: " << emptyarray << endl;
    
    //Delete last element only
    grades.pop_back();
    for(unsigned i = 0; i < sizeof(grades) / sizeof(int); i++){
        cout << "Element " << i << " : " << grades[i] << endl;
    }
    
    //Add a new element at the end
    grades.push_back(5);
    for(unsigned i = 0; i < sizeof(grades) / sizeof(int); i++){
        cout << "Element " << i << " : " << grades[i] << endl;
    }
    
    //Add a new element wherever you want
    int desiderpos = 1;
    grades.insert(grades.begin() + desiderpos, -3);
    for(unsigned i = 0; i < sizeof(grades) / sizeof(int); i++){
        cout << "Element " << i << " : " << grades[i] << endl;
    }
    
    //Delete an element of a chosen position
    grades.erase(grades.begin() + desiderpos);
    for(unsigned i = 0; i < sizeof(grades) / sizeof(int); i++){
        cout << "Element " << i << " : " << grades[i] << endl;
    }
    
    //How to define matrixes? We can see them as array of array
    
    const int num_rows = 2, num_columns = 4;
    string matrix[num_rows][num_columns] = {
        {"A1", "B1", "C1", "D1"},
        {"A2", "B2", "C2", "D2"}
    };
    
    cout << matrix[1][2] << endl; //C2
    
    //Algorithm to order arrays
    
    vector<int> vec = {1, 7, 5, 6, 3};

    //Bubble Sort
    int temp;
    int n = vec.size();
    for (int i = 0; i < n-1; i++){
        for (int j = 0; j < n-i-1; j++){
            if(vec[j] > vec[j+1]){
                temp = vec[j];
                vec[j] = vec[j+1];
                vec[j+1] = temp;
            }
        }
    }
    
    cout << "Ordered array with Bubble Sort: " << endl;
    for(unsigned i = 0; i < n; i++){
        cout << "Element " << i << " : " << vec[i] << endl;
    }
    
    vec = {1, 7, 5, 6, 3};
    
    //Selection Sort
    for (int i = 0; i < n - 1; ++i) {
        int minIndex = i;
        for (int j = i + 1; j < n; ++j) {
            if (vec[j] < vec[minIndex]) {
                minIndex = j;
            }
        }

        if (minIndex != i) {
            int temp = vec[i];
            vec[i] = vec[minIndex];
            vec[minIndex] = temp;
        }
    }

    cout << "Ordered array with Selection Sort: " << endl;
    for (int i = 0; i < n; ++i) {
        cout << "Element " << i << " : " << vec[i] << endl;
    }
    
    vec = {1, 7, 5, 6, 3};
    
    //Insertion Sort
    for (int i = 1; i < n; ++i) {
        int key = vec[i];
        int j = i - 1;

        // Shift the elements greater than "key" on their right
        while (j >= 0 && vec[j] > key) {
            vec[j + 1] = vec[j];
            --j;
        }

        // Put "key" in his right position
        vec[j + 1] = key;
    }

    cout << "Ordered array with Insertion Sort: " << endl;
    for (int i = 0; i < n; ++i) {
        cout << "Element " << i << " : " << vec[i] << endl;
    }
    
    return 0;
}