package Array;

import static org.junit.Assert.*;
import org.junit.Test;

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
}
