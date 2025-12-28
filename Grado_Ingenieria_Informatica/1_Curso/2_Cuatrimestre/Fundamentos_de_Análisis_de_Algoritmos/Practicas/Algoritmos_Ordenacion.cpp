#include <iostream>
#include <vector>
#include <chrono>
#include <algorithm>
#include <random>

/**
 * @file Algoritmos_Ordenacion.cpp
 * @brief Implementación y medición empírica de algoritmos de ordenación.
 * Base para la recuperación de prácticas de FAA (Fundamentos de Análisis de Algoritmos).
 */

using namespace std;
using namespace std::chrono;

// --- Algoritmos de Ordenación ---

// 1. Quicksort
int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// 2. Mergesort
void merge(vector<int>& arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    vector<int> L(n1), R(n2);
    for (int i = 0; i < n1; i++) L[i] = arr[l + i];
    for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) { arr[k] = L[i]; i++; }
        else { arr[k] = R[j]; j++; }
        k++;
    }
    while (i < n1) { arr[k] = L[i]; i++; k++; }
    while (j < n2) { arr[k] = R[j]; j++; k++; }
}

void mergeSort(vector<int>& arr, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

// 3. Bubble Sort (O(n^2) para comparación)
void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1])
                swap(arr[j], arr[j + 1]);
}

// --- Utilidades de Medición ---

void testAlgorithm(string name, void (*func)(vector<int>&), vector<int> data) {
    auto start = high_resolution_clock::now();
    func(data);
    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);
    cout << "[INFO] " << name << " tardó: " << duration.count() << " microsegundos." << endl;
}

// Wrapper para algoritmos con parámetros extra
void quickSortWrapper(vector<int>& arr) { quickSort(arr, 0, arr.size() - 1); }
void mergeSortWrapper(vector<int>& arr) { mergeSort(arr, 0, arr.size() - 1); }

int main() {
    const int N = 5000;
    cout << "--- Estudio Empírico de Ordenación (N=" << N << ") ---" << endl;

    // Generar datos aleatorios
    vector<int> original(N);
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dis(1, 10000);
    for(int i=0; i<N; ++i) original[i] = dis(gen);

    testAlgorithm("Bubble Sort (O(n^2)) ", bubbleSort, original);
    testAlgorithm("QuickSort   (O(n log n))", quickSortWrapper, original);
    testAlgorithm("MergeSort   (O(n log n))", mergeSortWrapper, original);

    return 0;
}
