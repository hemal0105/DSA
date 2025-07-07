package org.hm.interviews;


public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, -1, 5, -3, 1, -2};
        System.out.println(maxSubArr(arr));

        int[] arr2 = {4, -6, 5, -1, 3, -2, 2};
        System.out.println(maxSubArr(arr2));
    }

    private static int maxSubArr(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        int tempSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Integer.max(maxSum, tempSum);
            tempSum += arr[i];
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return maxSum;
    }
}