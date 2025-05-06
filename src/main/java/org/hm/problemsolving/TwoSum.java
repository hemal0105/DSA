package org.hm.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr1, 9)));

        int[] arr2 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(arr2, 6)));

        int[] arr3 = {3, 3};
        System.out.println(Arrays.toString(twoSum(arr3, 6)));
    }
}
