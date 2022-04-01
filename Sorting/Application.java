package Sorting;

import Array.ArrayOutOfRange;

public class Application {
    public static void main(String[] args) throws ArrayOutOfRange {
        var arr = new BubbleSort<>(new Object[]{7, 13, 11, 16}, 4);
        System.out.println(arr);
        arr.sort();
        System.out.println(arr);
    }
}
