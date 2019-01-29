package Array;

/**
 * @Descpription: #121. & #122 & #123.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * #121: If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * #122: You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * #123: Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * @Author: Created by xucheng.
 */

public class BestTimeToBuyAndSellStock {

    /**
     * 121.
     * Brute Force
     * Time: O(n^2)
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        if (prices.length == 0)
//            return 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//           for (int j = i + 1; j < prices.length; j++) {
//               maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//           }
//        }
//        return maxProfit;
//    }


    /**
     * 121. Dynamic Programming
     * Keep tacking the min price and the max profit so far
     * minPrice[i] - 到当前为止最小的price
     * maxProfit[i] = max(maxProfit[i-1],prices[i]-minPrice[i])
     * return maxProfit[n-1]
     * Time: O(n)
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        if (prices.length == 0)
//            return 0;
//        int minPrice = prices[0];
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice)
//                minPrice = prices[i];
//            else if (maxProfit < prices[i] - minPrice)
//                maxProfit = prices[i] - minPrice;
//        }
//        return maxProfit;
//    }


    /**
     * 122. Peak Valley Approach
     * Total Profit: Sum (height(peak[i]) - height(valley[i]))
     * The key point is to consider every peak immediately following a valley to maximize the profit.
     * Q: 为什么可以保证每一组相邻的点的高度加起来是max而不用计算不相邻的一个valley和一个peak之间的高度？
     * A: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     * Time: O(n)
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0)
//            return 0;
//        int i = 0;
//        int valley = prices[0];
//        int peak = prices[0];
//        int maxProfit = 0;
//        // Every iteration: Find a peak following with a valley and calculate the profit
//        while (i < prices.length - 1) {
//            // Find the index of a valley
//            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
//                i++;
//            valley = prices[i];
//            // Find the index of a peak
//            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
//                i++;
//            peak = prices[i];
//            maxProfit += peak - valley;
//        }
//        return maxProfit;
//    }


    /**
     * 122. Simple One Pass
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        // Edge case
//        int totalProfit = 0;
//        if (prices.length == 0)
//            return 0;
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i+1] > prices[i])
//                totalProfit += prices[i+1] - prices[i];
//        }
//        return totalProfit;
//    }

    /**
     * 123.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }


    /**
     * 124
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }

}
