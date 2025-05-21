package org.hm.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Brute Force Approach
    private static int majorityElement1(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int element : nums) {
                if (element == num) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    private static int majorityElement2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) countMap.put(num, countMap.get(num) + 1);
            else countMap.put(num, 1);
        }

        int majorityCount = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > majorityCount) return entry.getKey();
        }
        return -1;
    }

    private static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    private static int majorityElement4(int[] nums) {
        return majorityElement4Rec(nums, 0, nums.length - 1);
    }

    private static int majorityElement4Rec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) / 2 + low;
        int left = majorityElement4Rec(nums, low, mid);
        int right = majorityElement4Rec(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    private static int majorityElement5(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num: nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement1(nums1));
        System.out.println(majorityElement2(nums1));
        System.out.println(majorityElement3(nums1));
        System.out.println(majorityElement4(nums1));
        System.out.println(majorityElement5(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement1(nums2));
        System.out.println(majorityElement2(nums2));
        System.out.println(majorityElement3(nums2));
        System.out.println(majorityElement4(nums2));
        System.out.println(majorityElement5(nums2));


        int[] nums3 = {7, 7, 5, 7, 5, 1 , 5, 7 , 5, 5, 7, 7 , 7, 7, 7, 7};
        System.out.println(majorityElement5(nums3));

        int[] nums4 = {7, 7, 5, 7, 5, 1 , 5, 7 , 5, 5, 7, 7 , 5, 5, 5, 5};
        System.out.println(majorityElement5(nums4));
    }
}
