package org.hm.sorting;

import java.util.Arrays;

public class InsertionSort {
    private static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int numOfSwaps = 0;
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int hole = i;
            while (hole > 0 && arr[hole - 1] > val) {
                arr[hole] = arr[hole - 1]; numOfSwaps++;
                hole--;
            }
            arr[hole] = val;
        }
        System.out.println(Arrays.toString(arr) + " " + numOfSwaps);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 4, 1, 5, 3};
        sort(arr1);

        System.out.println();
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        sort(arr2);

        System.out.println();
        int[] arr3 = {6, 5, 4, 3, 2, 1};
        sort(arr3);
    }
}
