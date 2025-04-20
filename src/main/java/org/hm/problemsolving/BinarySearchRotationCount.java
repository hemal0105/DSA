package org.hm.problemsolving;

public class BinarySearchRotationCount {
    private static int rotationCount(int[] arr) {
        int n = arr.length - 1;
        int low = 0, high = n;
        while (low <= high) {
            if (arr[low] <= arr[high]) return low;

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) return mid;
            else if (arr[mid] <= arr[high]) high = mid - 1;
            else if (arr[mid] >= arr[low]) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12};
        System.out.println(rotationCount(arr1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(rotationCount(arr2));
    }
}
