package org.hm.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 5, 3};
        sort(arr);
    }
}
