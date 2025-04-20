package org.hm.problemsolving;

public class Spiral2dArrayPrint {
    private static void printSpiral(int[][] arr) {
        int top = 0, bottom = arr.length - 1;
        int left = 0, right = arr[0].length - 1;

        int dir = 0;
        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0:
                    for (int i = left; i <= right; i++) System.out.print(arr[top][i] + " ");
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++) System.out.print(arr[i][right] + " ");
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--) System.out.print(arr[bottom][i] + " ");
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--) System.out.print(arr[i][left] + " ");
                    left++;
                    break;
            }
            dir = (dir + 1) % 4;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 4, 6, 8},
                {5, 9, 12, 16},
                {2, 11, 5, 9},
                {3, 2, 1, 8},
        };
        printSpiral(arr);
    }
}
