package algorithms.sorts.quicksort;

import java.util.Arrays;

import static algorithms.sorts.quicksort.QuickSort.quickSort;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray);

        System.out.println( Arrays.toString( myArray ) );

    }
}