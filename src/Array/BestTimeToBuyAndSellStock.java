package Array;

/**
 * @Descpription: #121. & #122
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * #121: If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * #122: You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * @Author: Created by xucheng.
 */

public class BestTimeToBuyAndSellStock {

//    #121: 遍历数组找最大的差值 prices[sell]-prices[buy],buy<sell
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        if(prices.length == 0)
//            return 0;
//        int buy = prices[0];
//        for(int i = 1; i < prices.length; i++) {
//            if(prices[i] < buy)
//            {
//                buy = prices[i];
//            }
//            else if(maxProfit < prices[i] - buy){
//                maxProfit = prices[i] - buy;
//            }
//        }
//        System.out.println("MAX PROFIT: "+maxProfit);
//        return maxProfit;
//    }

//    #122: if(prices[i+1]>prices[i]) Profit+= prices[i+1]-prices[i];
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        if(prices.length == 0) return 0;
        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] > prices[i])
                totalProfit += prices[i+1] - prices[i];
        }
        return totalProfit;
    }

}
