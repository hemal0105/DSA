package org.hm.problemsolving;

import java.util.Arrays;

public class MoveZeroes {
    private static void moveZeroes(int[] nums) {
        int writer = 0;
        for (int reader = 0; reader < nums.length; reader++) {
            if (nums[reader] != 0) {
                nums[writer++] = nums[reader];
            }
        }

        for (int i = writer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
