package Queue;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class PriorityQueue<E> {
    private final ArrayNormal<E> items;
    private int top;

    public PriorityQueue(int capacity) {
        this.items = new ArrayNormal<E>(capacity);
        this.top = 0;
    }

    public void insert(E value) throws ArrayOutOfRange {
        int insertAt = 0;
        for (int i = 0; i < top; i++) {
            if (items.getItem(i).hashCode() > value.hashCode()) {
                break;
            }

            insertAt++;
        }

        for (int i = top - 1; i >= insertAt; i--) {
            items.setItem(i + 1, items.getItem(i));
        }

        items.setItem(insertAt, value);
        top++;
    }

    public E dequeue() throws ArrayOutOfRange {
        E value = items.getItem(top - 1);
        items.setItem(top - 1, null);
        top--;
        return value;
    }

    public boolean isFull() {
        return items.isFull();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
