package org.hm.interviews;

import java.util.Arrays;

public class ArcServe1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 7, 9, 10, 2};
        System.out.println(findMinPosMissing(arr));
    }

    private static int findMinPosMissing(int[] arr) {
        Arrays.sort(arr);

        findMissingPosRec(arr, 0, arr.length);
        return -1;
    }

    private static int findMissingPosRec(int[] arr, int left, int right) {
        if (right - left < 2) {
            return -1;
        }
        if (right - left == 2) {
            if (arr[0] > -1 && arr[1] > -1 && arr[0] + 1 != arr[1]) {
                return arr[0] + 1;
            } else {
                return -1;
            }
        }

        int mid = (left + right) / 2;
        int leftRes = findMissingPosRec(arr, left, mid);
        if (leftRes != -1) {    
            return leftRes;
        } else {
            return findMissingPosRec(arr, mid + 1, right);
        }
    }

//    private static List<List<Integer>> findSumNums(int[] arr, int target) {
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int sum = 0;
//                Map<Integer, List<List<Integer>>> tempMap = new HashMap<>();
//                List<Integer> temp =
//                for (int k = 0; k < j; j++) {
//                    sum += k;
//                        result.add(temp);
//                        break;
//                    }
//                }
//            }
//
//        }
//        return result;
//    }
}
