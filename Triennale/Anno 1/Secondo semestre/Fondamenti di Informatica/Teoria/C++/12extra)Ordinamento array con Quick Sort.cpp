#include <iostream>
#include <vector>
using namespace std;

// Partition the array w.r.t. its last element
int partition(vector<int>& vec, int low, int high) {
    int pivot = vec[high]; 
    int i = low - 1;

    for (int j = low; j < high; ++j) {
        if (vec[j] <= pivot) {
            ++i;
            int temp = vec[i];
            vec[i] = vec[j];
            vec[j] = temp;
        }
    }

    // Place the pivot in its correct position
    int temp = vec[i + 1];
    vec[i + 1] = vec[high];
    vec[high] = temp;

    return i + 1; // Return pivot position
}

void quickSort(vector<int>& vec, int low, int high) {
    if (low < high) {
        int pi = partition(vec, low, high);

        // Order the elements recursively w.r.t. pivot's left and right
        quickSort(vec, low, pi - 1);
        quickSort(vec, pi + 1, high);
    }
}

int main() {
    vector<int> vec = {1, 7, 5, 6, 3};

    quickSort(vec, 0, vec.size() - 1);

    cout << "Ordered array with Quick Sort: " << endl;
    for (int i = 0; i < vec.size(); ++i) {
        cout << "Element " << i << " : " << vec[i] << endl;
    }

    return 0;
}
