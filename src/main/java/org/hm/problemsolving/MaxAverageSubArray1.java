package org.hm.problemsolving;

public class MaxAverageSubArray1 {

    private static double findMaxAverage1(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }

        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }

    private static double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];

        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage1(nums1, 4));
        System.out.println(findMaxAverage2(nums1, 4));

        int[] nums2 = {5};
        System.out.println(findMaxAverage1(nums2, 1));
        System.out.println(findMaxAverage2(nums2, 1));
    }
}
