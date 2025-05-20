package org.hm.problemsolving;

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
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() > majorityCount) return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement1(nums1));
        System.out.println(majorityElement2(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement1(nums2));
        System.out.println(majorityElement2(nums2));
    }
}
