package Stack;

import java.util.Arrays;
import java.util.Objects;

class StackFullException extends Exception {}
class StackEmptyException extends Exception {}

public class Stack<A> {
    private A[] arr;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.arr = (A[]) new Object[capacity];
        top = 0;
        this.capacity = capacity;
    }

    public void push(A value) throws StackFullException {
        if (isFull()) throw new StackFullException();

        arr[top] = value;
        top++;
    }

    public void push(A[] values) throws StackFullException {
        for (var value: values) {
            if (isFull()) break;
            push(value);
        }
    }

    public A pop() throws StackEmptyException {
        if (isEmpty()) throw new StackEmptyException();

        var popped = arr[top - 1];
        top--;
        return popped;
    }

    public A peek() {
        return arr[top - 1];
    }

    public boolean isFull() {
        return top == capacity;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return top == stack.top && capacity == stack.capacity && Arrays.equals(arr, stack.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(top, capacity);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
