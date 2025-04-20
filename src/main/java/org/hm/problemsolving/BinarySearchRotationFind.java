package org.hm.problemsolving;

public class BinarySearchRotationFind {

    // Works for distinct elements in array. For duplicate, need to perform linear search
    private static int rotatedArraySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid]) return mid; // case1: found
            else if (arr[mid] <= arr[high]) { // case2: right half is sorted
                if (x > arr[mid] && x <= arr[high]) {
                    low = mid + 1; // search in sorted right half
                } else {
                    high = mid - 1; // left half could be sorted or unsorted
                }
            } else if (arr[mid] >= arr[low]) { // case3: left half is sorted
                if (x < arr[mid] && x >= arr[low]) {
                    high = mid - 1; // search in sorted left half
                } else {
                    low = mid + 1; // right half could be sorted or unsorted
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 18, 21, 3, 6, 8, 9};
        System.out.println(rotatedArraySearch(arr, 8));
        System.out.println(rotatedArraySearch(arr, 14));
        System.out.println(rotatedArraySearch(arr, 1));
    }
}
