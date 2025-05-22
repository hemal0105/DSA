package org.hm.problemsolving;

import java.util.Arrays;

public class MoveZeroes {
    private static void moveZeroes1(int[] nums) {
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

    private static void moveZeroes2(int[] nums) {
        for (int lastNonZeroFoundAt = 0, curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[curr];
                nums[curr] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes1(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0};
        moveZeroes1(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {0, 0, 0, 0, 0, 1};
        moveZeroes1(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {0, 1, 0, 3, 12};
        moveZeroes2(nums4);
        System.out.println(Arrays.toString(nums4));

        int[] nums5= {0, 0, 0, 0, 0, 1};
        moveZeroes2(nums5);
        System.out.println(Arrays.toString(nums5));
    }
}
