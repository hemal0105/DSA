package org.hm.problemsolving;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class StockMaxProfit {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit(prices2));

        int[] prices3 = {2,4,1};
        System.out.println(maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
