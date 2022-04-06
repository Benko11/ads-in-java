package Sorting;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class InsertionSort<E> extends Sort<E> {
    public InsertionSort(E[] arr, int capacity) {
        super(arr, capacity);
    }

    public InsertionSort(E[] arr) {
        super(arr);
    }

    public InsertionSort(int capacity) {
        super(capacity);
    }

    @Override
    public void sort() throws ArrayOutOfRange {
        for (int i = 1; i < arr.length(); i++) {
            E temp = arr.getItem(i);
            int index = i;

            while (index > 0 && arr.getItem(index - 1).hashCode() >= temp.hashCode()) {
                arr.setItem(index, arr.getItem(index - 1));
                index--;
            }
        }
    }
}
