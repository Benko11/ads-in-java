package Array;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws ArrayOutOfRange {
        var arr = new ArrayNormal(10);
        arr.insert(new Object[]{1, 7, 4, 3});

        while (!arr.isEmpty()) {
            arr.delete(0);
        }

        System.out.println(arr);
        var arr2 = new ArrayNormal(new Object[]{7, 1, 2, 3, 1, 1, 7, 2, 2, 1, 7, 7, 3});
        System.out.println(arr2);
        try {
            arr2.insert(2);
        } catch (ArrayFullException e) {
            System.out.println("full, bruh");
        }

        arr2.delete(new Object[]{7}[0]);
        arr2.delete(new Object[]{4}[0]);
        arr2.delete(new Object[]{1}[0]);

        System.out.println(arr2);

        var arr3 = new ArrayNormal(100);
        while (!arr3.isFull()) {
            try {
                arr3.insert(Math.random());
            } catch (ArrayFullException e) {
                break;
            }
        }

        System.out.println(arr3);

        var arr4 = new ArrayNormal(new Object[]{1, 2, 7, 0, 4}, 10);
        arr4.insert(new Object[]{8, -1, 99});

        System.out.println(arr4);

        while (!arr4.isEmpty()) {
            arr4.delete(0);
        }
    }
}
