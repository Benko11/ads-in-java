package Sorting;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class SelectionSort<E> extends Sort<E> {
    public SelectionSort(E[] arr, int capacity) {
        super(arr, capacity);
    }

    public SelectionSort(E[] arr) {
        super(arr);
    }

    public SelectionSort(int capacity) {
        super(capacity);
    }

    public void sort() throws ArrayOutOfRange {
        int min;
        for (int i = 0; i < arr.length(); i++) {
            min = i;

            for (int j = min + 1; j < arr.length(); j++) {
                if (arr.getItem(min).hashCode() > arr.getItem(j).hashCode()) {
                    swap(j, min);
                }
            }
        }
    }

    public String toString() {
        return arr.toString();
    }
}
