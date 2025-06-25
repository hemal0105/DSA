package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {

    private static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    ans.add(nums[i]);
                    break;
                }
            }
        }

        return ans;
    }

    private static List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans.add(nums[i]);
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates1(nums1));
        System.out.println(findDuplicates2(nums1));

        int[] nums2 = {1,1,2};
        System.out.println(findDuplicates1(nums2));
        System.out.println(findDuplicates2(nums2));

        int[] nums3 = {1};
        System.out.println(findDuplicates1(nums3));
        System.out.println(findDuplicates2(nums3));


    }
}
