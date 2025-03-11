package org.hm.problemsolving;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: n = 3
 * Output: 3
 *
 * Ways:
 * 1 step + 1 step + 1 step
 * 1 step + 2 steps
 * 2 steps + 1 step
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsWithFib(5));
    }

    public static int climbStairsWithMemo(int n) {
        int memo[] = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    public static int climbStairs(int currStepNum, int n, int memo[]) {
        if (currStepNum > n) {
            return 0;
        }
        if (currStepNum == n) {
            return 1;
        }
        if (memo[currStepNum] > 0) {
            return memo[currStepNum];
        }
        memo[currStepNum] = climbStairs(currStepNum + 1, n, memo) + climbStairs(currStepNum + 2, n, memo);
        return memo[currStepNum];
    }

    public static int climbStairsWithFib(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
