package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        ArrayList<Integer> dNums = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                dNums.add(j + 1);
            }
        }
        return dNums;
    }
}
