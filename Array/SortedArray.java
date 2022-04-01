package Array;

import java.util.Arrays;

public class SortedArray<E> extends Array<E> {
    public SortedArray(E[] arr, int capacity) {
        super(arr, capacity);
    }

    public SortedArray(E[] arr) {
        super(arr);
    }

    public SortedArray(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(E value) throws ArrayFullException, ArrayOutOfRange {
        int insertAt = 0;
        int firstNull = 0;

        for (var item: arr) {
            if (item != null) {
                if (item.hashCode() < value.hashCode()) {
                    insertAt++;
                } else break;
            }
        }

        for (var item: arr) {
            if (item != null) {
                firstNull++;
                continue;
            }

            break;
        }

        if (firstNull == capacity) throw new ArrayFullException();

        for (int i = firstNull; i > insertAt; i--) {
            setItem(i, getItem(i - 1));
        }

        setItem(insertAt, value);
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
        if (index >= capacity || index < 0) throw new ArrayOutOfRange();

        return arr[index];
    }

    @Override
    public void setItem(int index, E value) throws ArrayOutOfRange {
        arr[index] = value;
    }

    @Override
    public int search(E value, int skip) throws ArrayOutOfRange {
        int low = 0;
        int high = -1;

        for (int i = 0; i < arr.length; i++) {
            if (getItem(i) != null) {
                high++;
            }
        }

        int mid = (low + high) / 2;
        if (high == -1) throw new ArrayOutOfRange();

        while (!getItem(mid).equals(value)) {
            mid = (low + high) / 2;

            if (low > high)
                return -1;

            if (getItem(mid).hashCode() < value.hashCode()) {
                low = mid + 1;
                continue;
            }

            if (getItem(mid).hashCode() > value.hashCode()) {
                high = mid - 1;
            }
        }

        if (skip + 1 <= occurrences(value)) return mid + skip;
        return -1;
    }

    @Override
    public E delete(int index) throws ArrayOutOfRange {
        if (index >= capacity || index < 0) throw new ArrayOutOfRange();

        var length = length();
        var value = getItem(index);
        if (value == null) return null;

        setItem(index, null);
        for (int i = index + 1; i < capacity; i++) {
            setItem(i - 1, getItem(i));
        }

        for (int i = length - 1; i < capacity; i++) {
            setItem(i, null);
        }
        return value;
    }

    @Override
    public Integer[] delete(E value) {
        var a = new Integer[occurrences(value)];
        int i = 0;
        int index = Arrays.asList(arr).indexOf(value);
        while (index != -1) {
            try {
                a[i] = index + i;
                i++;
                delete(index);
            } catch (ArrayOutOfRange e) {
                return null;
            }

            index = Arrays.asList(arr).indexOf(value);
        }
        return a;
    }

    public int occurrences(E value) {
        int count = 0;
        for (var item: arr) {
            if (item == null) break;
            if (item.equals(value)) count++;
        }
        return count;
    }

    public int length() {
        for (int i = 0; i < capacity; i++) {
            try {
                if (getItem(i) == null) return i;
            } catch (ArrayOutOfRange e) {
                return -1;
            }
        }

        return capacity;
    }
}
