package org.hm.problemsolving;

import java.util.Arrays;

public class FindDuplicateNumber {

    // Array modified
    private static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate1(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate1(nums2));

        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println(findDuplicate1(nums3));
    }
}
