package org.hm.problemsolving;

public class BinarySearchFirstOrLastOccurrence {

    private static int firstOccurrence(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                result = mid;
                right = mid - 1;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int lastOccurrence(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                result = mid;
                left = mid + 1;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        System.out.println(firstOccurrence(arr, 10));
        System.out.println(firstOccurrence(arr, 20));
        System.out.println(lastOccurrence(arr, 10));
        System.out.println(lastOccurrence(arr, 20));
    }

}
