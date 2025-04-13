package org.hm.sorting;

import java.util.Arrays;

public class BubbleSort {
    private static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr) + " " + count);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 4, 1, 5, 3};
        sort(arr1);

        System.out.println();
        int[] arr2= {1, 2, 3, 4, 5, 6};
        sort(arr2);
    }

}
