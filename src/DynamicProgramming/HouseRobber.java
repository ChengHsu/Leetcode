package DynamicProgramming;

/**
 * @Number: 198. House Robber
 * @Descpription: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @Author: Created by xucheng.
 */
public class HouseRobber {
    /**
     * time: O(n)
     * space: O(n)
     * dp[i] = max(dp(i - 2) + nums[i], dp[i - 1])
     * @param nums
     * @return
     */
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//
//        for (int i = 2; i <= nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
//        }
//
//        return dp[nums.length];
//    }

    /**
     * time: O(n)
     * space: O(1)
     * dp[i] = max(dp(i - 2) + nums[i], dp[i - 1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;

       for (int num : nums) {
           int tmp = currMax;
           currMax = Math.max(prevMax + num, currMax);
           prevMax = tmp;
       }

       return currMax;
    }


}
