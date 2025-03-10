package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of integers nums, every element appears
 * twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and
 * use only constant extra space.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberXor(nums));
    }

    public static int singleNumberXor(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                list.remove(Integer.valueOf(i));
            }
        }
        return list.getFirst();
    }
}
