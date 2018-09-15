package Array;

/**
 * @Number: #674.Longest Continuous Increasing Subsequence
 * @Descpription: Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * @Author: Created by xucheng.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                curLen++;
                if (curLen > maxLen)
                    maxLen = curLen;
            }
            else {
                curLen = 1;
            }
        }
        return maxLen;
    }
}
