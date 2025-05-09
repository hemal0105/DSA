package org.hm.problemsolving;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int num;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                num = nums[right];
                right--;
            } else {
                num = nums[left];
                left++;
            }
            res[i] = num * num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums2)));

    }
}
