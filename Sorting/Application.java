package Sorting;

import Array.ArrayOutOfRange;

public class Application {
    public static void main(String[] args) throws ArrayOutOfRange {
        var hello = new Integer[20];
        for (int i = 0; i < hello.length; i++) {
            hello[i] = (int) Math.floor(Math.random() * 50 + 1);
        }

        BubbleSort<Integer> arr = new BubbleSort<>(hello);

        System.out.println(arr);
        arr.sort();
        System.out.println(arr);

        var arr2 = new SelectionSort<>(hello);
        arr2.sort();
        System.out.println(arr2);

        var arr3 = new SelectionSort<>(hello);
        arr3.sort();
        System.out.println(arr2);

        var people = new InsertionSort<>(new Object[]{
                new Person("Fiddleford", "McGucket", 66),
                new Person("Benjamin", "Bergstrom", 49),
                new Person("Mabel", "Pines", 12),
                new Person("Mabel", "Pines", 14),
                new Person("Mabel", "Woody", 14),
                new Person("Malloy", "Greenwood", 53),
                new Person("Jonny", "Greenwood", 53)
        });

        System.out.println(people);
        people.sort();
        System.out.println(people);
    }
}
