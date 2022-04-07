package Stack;

import Array.ArrayNormal;
import Array.ArrayOutOfRange;

public class StackX {
    private final ArrayNormal<Character> items;
    private int top;

    public StackX(int capacity) {
        items = new ArrayNormal<Character>(capacity);
        top = 0;
    }

    public void push(Character value) throws ArrayOutOfRange {
        items.setItem(top, value);
        top++;
    }

    public Character pop() throws ArrayOutOfRange {
        var value = peek();
        items.setItem(top - 1, null);
        top--;

        return value;
    }

    public Character peek() throws ArrayOutOfRange {
        return items.getItem(top - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFull() {
        return items.isFull();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
