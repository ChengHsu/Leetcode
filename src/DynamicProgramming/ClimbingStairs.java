package DynamicProgramming;

/**
 * @Number: #70. Climbing Stairs
 * @Descpription:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @Author: Created by xucheng.
 */
public class ClimbingStairs {
    /**
     * One dimension, Counting
     * time: O(n)
     * space: O(n)
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        if(n == 1)
//            return 1;
//
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2 ; i <= n; i++) {
//            dp[i] = dp[ i - 1] + dp[i - 2];
//        }
//
//        return dp[n];
//    }

    /**
     * 降维
     * space: O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1)
            return 1;

        int num1 = 1;
        int num2 = 1;
        int res = 0;

        for (int i = 2 ; i <= n; i++) {
           res = num1 + num2;
           num1 = num2;
           num2 = res;
        }

        return res;
    }

}
