package Queue;

import Array.Array;
import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class Deque<E> {
    private final ArrayNormal<E> arr;
    private int top;

    public Deque(int capacity) {
        arr = new ArrayNormal<E>(capacity);
        top = 0;
    }

    public void insertTop(E value) throws ArrayOutOfRange {
        arr.setItem(top, value);
        top++;
    }

    public void insertBottom(E value) throws ArrayOutOfRange {
        for (int i = top - 1; i >= 0; i--) {
            arr.setItem(i + 1, arr.getItem(i));
        }

        arr.setItem(0, value);
        top++;
    }

    public E deleteTop() throws ArrayOutOfRange {
        E value = arr.getItem(top - 1);
        arr.setItem(top - 1, null);
        top--;
        return value;
    }

    public E deleteBottom() throws ArrayOutOfRange {
        var value = arr.getItem(0);
        arr.setItem(0, null);

        for (int i = 1; i < arr.length(); i++) {
            arr.setItem(i - 1, arr.getItem(i));
        }

        arr.setItem(top, null);
        top--;

        return value;
    }

    @Override
    public String toString() {
        return arr.toString();
    }

    public ArrayNormal<E> getArray() {
        return arr;
    }
}
