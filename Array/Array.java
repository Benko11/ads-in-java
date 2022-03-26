package Array;

import java.util.Arrays;
import java.util.Objects;

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

    abstract public void insert(E value) throws ArrayFullException, ArrayOutOfRange, UniqueArrayDuplicateException;
    abstract public void insert(E[] values);
    abstract public E getItem(int index) throws ArrayOutOfRange;
    abstract public void setItem(int index, E value) throws ArrayOutOfRange;
    abstract public int search(E value, int skip) throws ArrayOutOfRange;
    abstract public E delete(int index) throws ArrayOutOfRange;
    abstract public Integer[] delete(E value);

    public String toString() {
        return Arrays.toString(arr);
    }

    public int length() {
        return capacity;
    }

    public int lengthNotNull() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (arr[i] != null) count++;
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<?> array = (Array<?>) o;
        return capacity == array.capacity && Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    public boolean contains(E value) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == null) continue;
            if (arr[i].equals(value)) return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < capacity; i++) {
            try {
                if (getItem(i) == null) return false;
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public boolean isEmpty() {
        for (int i = 0; i < capacity; i++) {
            try {
                if (getItem(i) != null) return false;
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }
}
