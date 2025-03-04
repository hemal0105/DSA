package org.hm.problemsolving;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedTotal = ( n * (n + 1)) / 2;
        int total = 0;
        for (int num: nums) {
            total += num;
        }
        return expectedTotal - total;
    }
}
