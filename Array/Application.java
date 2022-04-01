package Array;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class Application {
    @Test
    public void test1() throws ArrayOutOfRange, ArrayFullException, UniqueArrayDuplicateException {
        var arr = new ArrayNormal(10);
        arr.insert(new Object[]{1, 7, 4, 3});

        while (!arr.isEmpty()) {
            arr.delete(0);
        }

        assertTrue(arr.isEmpty());

        var arr2 = new ArrayNormal(new Object[]{7, 1, 2, 3, 1, 1, 7, 2, 2, 1, 7, 7, 3});
        arr.insert(2);

        var indices = arr2.delete(new Object[]{7}[0]);
        assertEquals(indices, new Integer[]{0, 6, 10, 11, null, null, null, null, null, null, null, null, null});
        arr2.delete(new Object[]{4}[0]);
        arr2.delete(new Object[]{1}[0]);
        assertEquals(arr2.lengthNotNull(), 5);

        var arr3 = new ArrayNormal(100);
        while (!arr3.isFull()) {
            arr3.insert(Math.random());
        }

        assertTrue(arr3.isFull());

        var arr4 = new ArrayNormal(new Object[]{1, 2, 7, 0, 4}, 10);
        arr4.insert(new Object[]{8, -1, 99});
        assertTrue(arr4.contains(-1));

        while (!arr4.isEmpty()) {
            arr4.delete(0);
        }

        assertFalse(arr4.contains(-1));
        assertTrue(arr4.isEmpty());

        var arr5 = new ArrayNormal(4);
        arr5.insert(new Object[]{1, 1, 3, 1});
        var arr6 = new ArrayNormal(4);
        arr6.insert(new Object[]{1, 1, 3, 1});
        var arr7 = new ArrayNormal(5);
        arr6.insert(new Object[]{1, 1, 3, 1});

        assertEquals(arr5, arr6);
        assertNotEquals(arr5, arr7);

        var arr8 = new ArrayNormal(new Object[]{1, 7, 4, 1, 3, 2, 0, 7, 7, 2});
        assertEquals(arr8.search(2, 1), 9);
        assertEquals(arr8.search(2, 2), -1);
        assertEquals(arr8.search(2, -1), -1);
        assertEquals(arr8.search(7, 2), 8);
    }

    @Test
    public void test2() throws UniqueArrayDuplicateException, ArrayFullException, ArrayOutOfRange {
        var arr1 = new UniqueArray(10);
        arr1.insert(new Object[]{2, 7, 8, 9});
        assertTrue(arr1.contains(2) && arr1.contains(9));

        assertThrows(UniqueArrayDuplicateException.class, () -> {
            arr1.insert(8);
        });

        arr1.delete(new Object[]{8}[0]);
        arr1.delete(2);
        System.out.println(arr1);

        assertTrue(!arr1.contains(8) && !arr1.contains(9));
    }

    @Test
    public void test3() throws ArrayFullException, ArrayOutOfRange {
        var arr1 = new SortedArray(11);
        arr1.insert(new Object[]{31}[0]);
        assertTrue(arr1.contains(31));
        assertEquals(31, arr1.getItem(0));

        arr1.insert(new Object[]{27}[0]);
        assertTrue(arr1.contains(27) && arr1.contains(31));
        assertEquals(27, arr1.getItem(0));

        arr1.insert(new Object[]{16, 98, 13, 15, 60, 76, 9, 11, 13, 17, 18, 19, 20});

        var arr2 = new SortedArray(11);
        arr2.insert(new Object[]{9, 11, 13, 13, 15, 16, 27, 31, 60, 76, 98});
        assertTrue(arr1.equals(arr2));
        assertTrue(arr1.contains(13));
        assertTrue(!arr1.contains(17));

        assertThrows(ArrayFullException.class, () -> {
           arr1.insert(3);
        });
        assertEquals(1, arr1.search(11, 0));
        assertEquals(10, arr1.search(98, 0));
        assertEquals(arr1.search(13, 0), 2);
        assertEquals(arr1.search(13, 1), 3);
        assertEquals(arr1.search(13, 2), -1);
        assertEquals(arr1.search(15, 0), 4);
        assertEquals(arr1.search(15, 1), -1);
        assertEquals(arr1.search(20, 1), -1);
        assertEquals(arr1.search(17, 1), -1);
        assertEquals(arr1.search(9, 0), 0);

        while (!arr1.isEmpty()) {
            arr1.delete(0);
        }

        assertTrue(!arr1.isFull());
        assertTrue(arr1.isEmpty());
        assertEquals(arr2.delete(8), 60);
        assertEquals(arr2.delete(4), 15);
        assertEquals(arr2.delete(10), null);
        assertEquals(arr2.length(), 9);
        var delete = arr2.delete(new Object[]{13}[0]);
        System.out.println(Arrays.toString(delete));
        assertTrue(Arrays.equals(delete, new Integer[]{2, 3}));
        System.out.println(arr2);
    }
}
