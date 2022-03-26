package Array;

class UniqueArrayDuplicateException extends Exception {}

public class UniqueArray<E> extends ArrayNormal<E> {
    public UniqueArray(E[] arr, int capacity) {
        super(arr, capacity);
    }

    public UniqueArray(E[] arr) {
        super(arr);
    }

    public UniqueArray(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(E value) throws ArrayFullException, ArrayOutOfRange, UniqueArrayDuplicateException {
        int index = -1;
        for (int i = 0; i < super.capacity; i++) {
            if (getItem(i) != null) {
                if (getItem(i).equals(value))
                    throw new UniqueArrayDuplicateException();
            }

            if (getItem(i) == null) {
                index = i;
                break;
            }
        }

        if (index == -1) throw new ArrayFullException();
        setItem(index, value);
    }

    @Override
    public int search(E value, int skip) throws ArrayOutOfRange {
        if (skip != 0) return -1;

        for (int i = 0; i < super.capacity; i++) {
            if (getItem(i) != null) {
                if (getItem(i).equals(value)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public Integer[] delete(E value) {
        try {
            var index = search(value, 0);
            delete(index);
            return new Integer[]{index};
        } catch (Exception e) {
            return null;
        }
    }
}
