package Array;

import java.util.Arrays;

class ArrayFullException extends Exception {}
class ArrayOutOfRange extends Exception {}

public abstract class Array<E> {
    protected int capacity;
    protected E[] arr;

    public Array(E[] arr, int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];

        for (int i = 0; i < arr.length; i++) {
            if (i - 1 == capacity) break;

            this.arr[i] = arr[i];
        }
    }

    public Array(E[] arr) {
        this.capacity = arr.length;
        this.arr = arr.clone();
    }

    public Array(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
    }

    abstract public void insert(E value) throws ArrayFullException, ArrayOutOfRange;
    abstract public void insert(E[] values);
    abstract public E getItem(int index) throws ArrayOutOfRange;
    abstract public void setItem(int index, E value) throws ArrayOutOfRange;
    abstract public int search(E value, int skip) throws ArrayOutOfRange;
    abstract public E delete(int index) throws ArrayOutOfRange;
    abstract public Integer[] delete(E value);
    abstract public boolean isEmpty();
    abstract public boolean isFull();

    public String toString() {
        return Arrays.toString(arr);
    }
}
