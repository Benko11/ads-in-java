package Sorting;


import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class BubbleSort<E> {
    private final ArrayNormal<E> arr;
    public BubbleSort(E[] arr, int capacity) {
        this.arr = new ArrayNormal<>(arr, capacity);
    }

    public void sort() throws ArrayOutOfRange {
        for (int i = 0; i < arr.length(); i++) {
            for (int j = 0; j < arr.length() - 1; j++) {
                if (arr.getItem(j).hashCode() > arr.getItem(j + 1).hashCode()) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void swap(int indexOne, int indexTwo) throws ArrayOutOfRange {
        E temp = arr.getItem(indexOne);
        arr.setItem(indexOne, arr.getItem(indexTwo));
        arr.setItem(indexTwo, temp);
    }

    public String toString() {
        return arr.toString();
    }
}
