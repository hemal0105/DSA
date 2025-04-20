package org.hm.problemsolving;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            if (target < nums[midIndex]) {
                right = midIndex - 1;
            } else if (target > nums[midIndex]) {
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearchRec(nums, left, mid - 1, target);
        } else {
            return binarySearchRec(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 2));

        System.out.println(binarySearchRec(nums, 0, 6, 9));
        System.out.println(binarySearchRec(nums, 0, 6, 2));
    }
}
