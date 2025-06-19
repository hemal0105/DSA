package org.hm.problemsolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

    // Array modified
    private static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return nums[i];
        }

        return -1;
    }

    // Not using constant space
    private static int findDuplicate2(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num: nums) {
            if (uniqueSet.contains(num)) return num;
            uniqueSet.add(num);
        }

        return -1;
    }

    // Array modified
    private static int findDuplicate3(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num] < 0) {
                duplicate = num;
                break;
            }
            nums[num] *= -1;
        }

        for (int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);

        return duplicate;
    }


    private static int store(int[] nums, int cur) {
        if (cur == nums[cur]) {
            return cur;
        }
        int next = nums[cur];
        nums[cur] = cur;
        return store(nums, next);
    }

    // Array modified
    private static int findDuplicate4(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        return store(newNums, 0);
    }

    // Array modified
    private static int findDuplicate5(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate1(nums1));
        System.out.println(findDuplicate2(nums1));
        System.out.println(findDuplicate3(nums1));
        System.out.println(findDuplicate4(nums1));
        System.out.println(findDuplicate5(nums1));

        System.out.println();
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate1(nums2));
        System.out.println(findDuplicate2(nums2));
        System.out.println(findDuplicate3(nums2));
        System.out.println(findDuplicate4(nums2));
        System.out.println(findDuplicate5(nums2));

        System.out.println();
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println(findDuplicate1(nums3));
        System.out.println(findDuplicate2(nums3));
        System.out.println(findDuplicate3(nums3));
        System.out.println(findDuplicate4(nums3));
        System.out.println(findDuplicate5(nums3));
    }
}
