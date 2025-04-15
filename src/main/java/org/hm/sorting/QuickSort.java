package org.hm.sorting;

import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 4, 1, 5, 3};
        System.out.println(Arrays.toString(arr1));
        sort(arr1);
        System.out.println(Arrays.toString(arr1));


        System.out.println();
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr2));
        sort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println();
        int[] arr3 = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr3));
        sort(arr3);
        System.out.println(Arrays.toString(arr3));

        System.out.println();
        int[] arr4 = {2, 4, 1, 6, 8, 5, 3, 7};
        System.out.println(Arrays.toString(arr4));
        sort(arr4);
        System.out.println(Arrays.toString(arr4));

        System.out.println();
        int[] arr5 = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println(Arrays.toString(arr5));
        sort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}
