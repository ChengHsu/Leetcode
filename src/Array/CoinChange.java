package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Number: #322. Coin Change
 * @Descpription: You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * @Author: Created by xucheng.
 */
public class CoinChange {
    /**
     * TO DO
     * DP
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0)
            return 0;

        //Arrays.sort(coins, Collections.reverseOrder());
        int num = 0;
        for (int i = 0; i < coins.length; i++){
            if (amount >= coins[i]){
                num += amount / coins[i];
                amount = amount % coins[i];
            }
        }
        return (num == 0)? -1: num;
    }
}
