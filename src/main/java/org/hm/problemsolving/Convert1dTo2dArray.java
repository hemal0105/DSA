package org.hm.problemsolving;

import java.util.Arrays;

public class Convert1dTo2dArray {

    private static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][];
        if (m == 1) {
            int[][] arr = new int[1][];
            arr[0] = original;
            return arr;
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            res[i / n][i % n] = original[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.deepToString(construct2DArray(nums1, 2, 2)));

        int[] nums2 = {1, 2, 3};
        System.out.println(Arrays.deepToString(construct2DArray(nums2, 1, 3)));

        int[] nums3 = {1, 2};
        System.out.println(Arrays.deepToString(construct2DArray(nums3, 1, 1)));
    }
}
