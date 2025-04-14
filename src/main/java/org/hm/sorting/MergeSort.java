package org.hm.sorting;

import java.util.Arrays;

public class MergeSort {
    private static void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < arr.length; i++) right[i - mid] = arr[i];

        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
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
    }
}
