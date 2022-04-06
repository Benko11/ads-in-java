package Sorting;


import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class BubbleSort<E> extends Sort<E> {
    public BubbleSort(E[] arr, int capacity) {
        super(arr, capacity);
    }

    public BubbleSort(E[] arr) {
        super(arr);
    }

    // mutate an array
    public void sort() throws ArrayOutOfRange {
        for (int i = 0; i < arr.length(); i++) {
            for (int j = 0; j < arr.length() - 1 - i; j++) {
                if (arr.getItem(j).hashCode() > arr.getItem(j + 1).hashCode()) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
