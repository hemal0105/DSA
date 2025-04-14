package org.hm.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int numOfSwaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                numOfSwaps++;
            }
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
