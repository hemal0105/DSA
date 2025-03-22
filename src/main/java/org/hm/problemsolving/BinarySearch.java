package org.hm.problemsolving;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 2));
    }

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
}
