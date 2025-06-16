package org.hm.problemsolving;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Time - O(n)
    // Space - O(n)
    private static int[] productExceptSelf1(int[] nums) {
        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];

        int[] ans = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // Time - O(n)
    // Space - O(1)
    private static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;

        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf1(nums1)));
        System.out.println(Arrays.toString(productExceptSelf2(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf1(nums2)));
        System.out.println(Arrays.toString(productExceptSelf2(nums2)));
    }
}
