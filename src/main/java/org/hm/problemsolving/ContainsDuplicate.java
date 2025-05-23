package org.hm.problemsolving;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,3,4,3,2,4,2};
        boolean hasDuplicate = containsDuplicate(nums);
        System.out.println(hasDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (elements.contains(nums[i])) {
                return true;
            } else {
                elements.add(nums[i]);
            }
        }
        return false;
    }
}