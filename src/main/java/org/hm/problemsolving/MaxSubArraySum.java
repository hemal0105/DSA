package org.hm.problemsolving;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        System.out.println(maxOfSubArraySum(nums));
    }

    public static int maxOfSubArraySum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int subArrSize = 1; subArrSize < nums.length; subArrSize++) {
                if (start + subArrSize > nums.length) {
                    break;
                }
                sum += nums[start + subArrSize - 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
