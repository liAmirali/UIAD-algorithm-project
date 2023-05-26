import algorithms.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 3, 5, 5, 2, 6, 8, 4, 3, 7, 6, 8, 25, 3};
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
