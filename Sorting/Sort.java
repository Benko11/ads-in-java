package Sorting;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public abstract class Sort<E> {
    protected final ArrayNormal<E> arr;

    public Sort(E[] arr) {
        this.arr = new ArrayNormal<>(arr);
    }

    public Sort(E[] arr, int capacity) {
        this.arr = new ArrayNormal<>(arr, capacity);
    }

    public Sort(int capacity) {
        this.arr = new ArrayNormal<E>(capacity);
    }

    abstract public void sort() throws ArrayOutOfRange;

    public void swap(int indexOne, int indexTwo) throws ArrayOutOfRange {
        var temp = arr.getItem(indexOne);
        arr.setItem(indexOne, arr.getItem(indexTwo));
        arr.setItem(indexTwo, temp);
    }

    public String toString() {
        return arr.toString();
    }
}
