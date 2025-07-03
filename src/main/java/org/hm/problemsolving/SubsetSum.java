package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    private static void calculateSum(int i, int len, int[] arr, int target, List<Integer> result) {

        if (target == 0) {
            System.out.println(result);
            return;
        }

        if (i == len) {
            return;
        }

        calculateSum(i + 1, len, arr, target, result);

        if (arr[i] <= target) {
            result.add(arr[i]);

            calculateSum(i + 1, len, arr, target - arr[i], result);

            result.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] set1 = { 1, 2, 1 };
        int sum1 = 3;
        int n1 = set1.length;
        List<Integer> subset1 = new ArrayList<>();
        System.out.println("Output 1:");
        calculateSum(0, n1, set1, sum1, subset1);


        int[] set2 = { 3, 34, 4, 12, 5, 9 };
        int sum2 = 30;
        int n2 = set2.length;
        List<Integer> subset2 = new ArrayList<>();
        System.out.println("Output 2:");
        calculateSum(0, n2, set2, sum2, subset2);
    }


}
