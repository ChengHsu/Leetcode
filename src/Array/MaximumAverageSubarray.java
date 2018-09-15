package Array;

/**
 * @Number: #643. Maximum Average Subarray I
 * @Descpription: Given an array consisting of n integers,find the contiguous subarray of given length k that has the maximum average value.
 * And you need to output the maximum average value.
 * @Author: Created by xucheng.
 */
public class MaximumAverageSubarray {
//    https://leetcode.com/problems/maximum-average-subarray-i/solution/

//  Cumulative Sum
//    public double findMaxAverage(int[] nums, int k) {
//        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        for (int i = 1 ; i < sum.length; i++) {
//            sum[i] = sum[i-1] + nums[i];
//        }
//        int tmpSum = sum[k - 1];
//        for (int i = k ; i < sum.length; i++) {
//            tmpSum = Math.max(tmpSum, sum[i] - sum[i-k]);
//        }
//        return tmpSum * 1.0 / k;
//    }

    //Sliding Window
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int tmpSum = sum;
        for (int i = k; i < nums.length; i++) {
            tmpSum += nums[i] - nums[i - k];
            sum = Math.max(sum,tmpSum);
        }
        return sum * 1.0 / k;
    }
}
