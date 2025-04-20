package org.hm.problemsolving;

public class BinarySearchNumOfOccurrence {
    private static int search(int[] arr, int x, boolean searchFirst) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                result = mid;
                if (searchFirst) right = mid - 1;
                else left = mid + 1;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int numOfOccurrences(int[] arr, int x) {
        int first = search(arr, x, true);
        if (first == -1) return 0;
        int last = search(arr, x, false);

        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11};
        System.out.println(numOfOccurrences(arr, 5));
        System.out.println(numOfOccurrences(arr, 1));
        System.out.println(numOfOccurrences(arr, 11));
        System.out.println(numOfOccurrences(arr, 2));
    }

}
