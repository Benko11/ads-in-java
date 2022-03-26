package Array;

// allow duplicates
// insert populates the first null value
// deletion moves the rest of the array

public class ArrayNormal<E> extends Array<E> {
    public ArrayNormal(int capacity) {
        super(capacity);
    }

    public ArrayNormal(E[] objects) {
        super(objects);
    }

    public ArrayNormal(E[] objects, int capacity) {
        super(objects, capacity);
    }

    @Override
    public void insert(E value) throws ArrayFullException, ArrayOutOfRange, UniqueArrayDuplicateException {
        int index = -1;
        for (int i = 0; i < super.capacity; i++) {
            if (getItem(i) == null) {
                index = i;
                break;
            }
        }

        if (index == -1) throw new ArrayFullException();
        setItem(index, value);
    }

    @Override
    public void insert(E[] values) {
        for (var value: values) {
            try {
                insert(value);
            } catch (Exception e) {
                break;
            }
        }
    }

    @Override
    public E getItem(int index) throws ArrayOutOfRange {
        if (index < 0 || index >= super.capacity) throw new ArrayOutOfRange();

        return arr[index];
    }

    @Override
    public void setItem(int index, E value) throws ArrayOutOfRange {
        if (index < 0 || index >= super.capacity) throw new ArrayOutOfRange();

        super.arr[index] = value;
    }

    @Override
    public int search(E value, int skip) throws ArrayOutOfRange {
        if (skip < 0) return -1;

        int matches = 0;

        for (int i = 0; i < super.capacity; i++) {
            if (getItem(i).equals(value)) {
                matches++;

                if (matches - 1 == skip) return i;
            }
        }

        return -1;
    }

    @Override
    public E delete(int index) throws ArrayOutOfRange {
        var value = getItem(index);
        var findIndex = search(value, 0);

        for (int i = findIndex + 1; i < capacity; i++) {
            setItem(i - 1, getItem(i));
        }

        setItem(capacity - 1, null);

        return value;
    }

    @Override
    public Integer[] delete(E value) {
        var values = new Integer[super.capacity];
        int j = 0;
        for (int i = 0; i < capacity; i++) {
            try {
                if (getItem(i).equals(value)) {
                    values[j] = i;
                    j++;
                }
            } catch (Exception e) {
                break;
            }
        }

        int remove = 0;
        for (var v: values) {
            if (v == null) break;

            try {
                delete(v - remove);
                remove++;
            } catch (Exception e) {
                break;
            }
        }

        return values;
    }
}
