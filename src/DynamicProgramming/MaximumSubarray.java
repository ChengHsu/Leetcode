package DynamicProgramming;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MaximumSubarray {
    /**
     DP
     time: O(n)
     space: O(1)
     -2  1 -3 4 -1 2 1 -5 4
     c:  -2  1 -2 4  3 5 6  1 5
     m:  -2  1  1 4  4 5 6  6 6
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        // currSum = max(currNum, currSum+currNum)
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println();
        return maxSum;
    }
}
