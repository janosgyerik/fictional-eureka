#include <cstdlib>
#include <stdio.h>

void print_array(int* arr, int length) {
    for (int i = 0; i < length; i++) {
        printf("%i ", arr[i]);
    }
    printf("\n");
}

void quicksort(int* arr, int left, int right) {
    int size = right - left;
    int temp;
    if (size < 1) {
        return;
    }
    if (size == 1) {
        if (arr[right] < arr[left]) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        return;
    }
    int pivot = arr[right];
    int wall = left;
    for (int i = left; i < right; i++) {
        if (arr[i] < pivot) {
            if (wall != i) {
                temp = arr[i];
                arr[i] = arr[wall];
                arr[wall] = temp;
            }
            wall++;
        }
    }

    arr[right] = arr[wall];
    arr[wall] = pivot;

    quicksort(arr, left, wall - 1);
    quicksort(arr, wall + 1, right);
}

void test_sort(int* arr, int length) {
    printf("Before: ");
    print_array(arr, length);
    printf("\n");
    quicksort(arr, 0, length - 1);
    printf("After:  ");
    print_array(arr, length);
    printf("\n");
}

int main() {
    const int size = 7;
    int arr[] = { 5, 8, 9, 1, 3, 4, 2 };

    test_sort(arr, size);

    for (int j = 0; j < 10; j++) {
        for (int i = 0; i < size; i++) {
            arr[i] = rand() % 11;
        }
        test_sort(arr, size);
    }

    //getchar();
    return 0;
}

