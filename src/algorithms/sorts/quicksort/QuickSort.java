package algorithms.sorts.quicksort;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex; //swap and pivot both on index 0 or first index of chunk
        for (int i = pivotIndex + 1; i <= endIndex; i++) { // note this is <= endIndex not < as with length
            if (array[i] < array[pivotIndex]) {
                swapIndex++;// first lets consider edge case where the first value at index 'i' is less than
                // pivot such that pivot = index 0, 'i' started and remains at index 1, and now swap is
                // incremented from index 0 to 1 so now = index 'i'. the values of 'i' and 'swap' are swapped
                // but nothing changes and i continues to increment. then supposing index 2 is higher and is
                // passed but index 3 is lower, swap increments from 1 to 2, and 'i' at index 3 is swapped with
                // 'swap' value at index 2, so from now on swap and 'i' will be at different indexes
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex); //supposing edge case first where the list is already
        // in correct order for pivot pointer value, since pivotIndex = swapIndex as the for loop
        // never ran and incremented swap, then pivot and swap and swapped so nothing changes.
        // Note that while swap is called again, this time outside of the for loop and swaps not 'swap' and 'i'
        // but pivot and swap. 'i' is now at end of collection. pivot swapped out of first index in chunk
        // into correct index and is now sorted

        return swapIndex; //return swapIndex not the array since pivot will still be on first index
        // of the array or first index of the chunk and swapIndex will be the divide between
        // subsequent recursive case chunks since swap always ends up being defined as correct value
        // at correct index for ordering of the array
    } // returns an index
    // and also mutates the array


    private static void quickSortHelper(int[] array, int left, int right) { // left and right are
        // passed as the first index and last index in the original array or of a chunk
        if (left < right) { // left must be less than right since these are the index bounds to be used
            // in the pivot method
            int pivotIndex = pivot(array, left, right); // pivot index returrned as well as having mutated
            // the original array or array chunk so that the pivot is correctly placed with all items
            // of lesser value on left and all items of greater value in right
            quickSortHelper(array, left, pivotIndex - 1); //recursive call for left chunk, pivot non-inclusive
            // since this is recursive for left chunk, all items to left of the original sorted pivot index/value
            // will be sorted with base case achieved and the pivot and mutated chunk returned from pivot call
            quickSortHelper(array, pivotIndex + 1, right); // same for right
            // then all the right base cases reached and mutations occur

        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        // this makes it so the user doesn't have to input original start and end indexes of array to be sorted and its
        // hard coded instead
    }


}