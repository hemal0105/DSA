package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {

    // Time - O (n ^ 2)
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

    // Time - O (n log n)
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

    // Time - O (n), Space - O (n)
    private static List<Integer> findDuplicates3(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();

        for (int num: nums) {
            if (seen.contains(num)) {
                ans.add(num);
            } else {
                seen.add(num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates1(nums1));
        System.out.println(findDuplicates2(nums1));
        System.out.println(findDuplicates3(nums1));

        int[] nums2 = {1,1,2};
        System.out.println(findDuplicates1(nums2));
        System.out.println(findDuplicates2(nums2));
        System.out.println(findDuplicates3(nums2));

        int[] nums3 = {1};
        System.out.println(findDuplicates1(nums3));
        System.out.println(findDuplicates2(nums3));
        System.out.println(findDuplicates3(nums3));


    }
}
