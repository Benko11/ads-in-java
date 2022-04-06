package Queue;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class Queue<E> {
    private final ArrayNormal<E> arr;
    private int top;

    public Queue(int capacity) {
        arr = new ArrayNormal<E>(capacity);
        top = 0;
    }

    public void enqueue(E value) throws ArrayOutOfRange {
        arr.setItem(top, value);
        top++;
    }

    public E dequeue() throws ArrayOutOfRange {
        var value = arr.getItem(0);
        arr.setItem(0, null);

        for (int i = 1; i < arr.length(); i++) {
            arr.setItem(i - 1, arr.getItem(i));
        }

        arr.setItem(top, null);
        top--;

        return value;
    }

    public int getTop() {
        return top;
    }

    public ArrayNormal<E> getArray() {
        return arr;
    }

    public boolean isFull() {
        return arr.isFull();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        return arr.toString();
    }
}
