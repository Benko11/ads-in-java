package Queue;

import Array.ArrayOutOfRange;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestImplement {
    @Test
    public void test() throws ArrayOutOfRange {
        var x = new Queue<>(10);
        x.enqueue(2);
        x.enqueue(7);
        x.enqueue(true);
        assertTrue(x.getArray().contains(2));
        assertFalse(x.getArray().contains(1));
        assertEquals(x.getTop(), 3);

//        while (!x.isEmpty()) {
//            x.dequeue();
//        }
        assertEquals(x.dequeue(), true);
        System.out.println(x);
    }

    @Test
    public void test2() throws ArrayOutOfRange {
        var x = new Deque<>(10);
        x.insertTop(5);
        x.insertTop(8);
        x.insertTop(7);
        assertTrue(x.getArray().contains(5));
        System.out.println(x);
        x.insertBottom(11);
        System.out.println(x);
        assertTrue(x.getArray().contains(5));

        assertEquals(x.deleteTop(), 7);
        System.out.println(x);
        assertFalse(x.getArray().contains(7));

        assertEquals(x.deleteBottom(), 11);
        System.out.println(x);
        assertFalse(x.getArray().contains(11));
        assertTrue(x.getArray().contains(5));
        assertTrue(x.getArray().contains(8));
    }
}
