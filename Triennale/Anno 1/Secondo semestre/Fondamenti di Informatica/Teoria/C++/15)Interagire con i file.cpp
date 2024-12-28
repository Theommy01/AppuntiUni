#include <iostream>
#include <fstream> //file stream
#include <string>
#include <vector>
using namespace std;

int main() {
    //output file stream
    ofstream outputFile("prova.txt"); //Manually create file "prova.txt"
    
    if(outputFile.is_open()){
        outputFile << "File created succesfully" << endl;
        outputFile.close();
        outputFile << "File is closed. This will not appear";
    } else{
        cout << "Error creating the file" << endl;
    }
    
    //input file stream
    ifstream inputFile("prova.txt");
    
    //read file content
    if(inputFile.is_open()){
        string line;
        while(getline(inputFile, line)){
            cout << line << endl;
        }
        inputFile.close();
    } else{
        cout << "Error opening the file" << endl;
    }
    
    //delete file
    if(remove("prova.txt") == 0){
        cout << "File deleted succesfully" << endl;
    } else{
        cout << "Error deleting the file" << endl;
    };
    
    // Write with trunc (clears content before writing)
    {
        ofstream outputFile("prova.txt", ios::trunc);
        if (outputFile.is_open()) {
            outputFile << "Writing with trunc..." << endl;
            outputFile.close();
        }
    }

    // Write with out (modifies content)
    {
        ofstream outputFile("prova.txt", ios::out);
        if (outputFile.is_open()) {
            outputFile << "Writing with out..." << endl;
            outputFile.close();
        }
    }

    // Write with app (appends content)
    {
        ofstream outputFile("prova.txt", ios::app);
        if (outputFile.is_open()) {
            outputFile << "Writing with app..." << endl;
            outputFile.close();
        }
    }

    // Read final content
    ifstream finalFile("prova.txt");
    if (finalFile.is_open()) {
        string line;
        cout << "Final file content:" << endl;
        while (getline(finalFile, line)) {
            cout << line << endl;
        }
        finalFile.close();
    }

    return 0;
}
