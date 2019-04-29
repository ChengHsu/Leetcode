package InterviewPrep.WePay;

/**
 * @Number: #53. Maximum Subarray
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MaximumSubarray {

    /**
     * Brute force: computes each sub-array sum, n*(n+1)/2 sub-arrays in total
     * calculate the sum in between
     * time: O(n^3)
     */
    public int maxSubArrayV1(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                    if (sum > max)
                        max = sum;
                }
            }
        }
        return max;
    }

    /**
     * Brute force: computes each sub-array sum, n*(n+1)/2 sub-arrays in total
     * calculate the running sums
     * time: O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }

        return max;
    }


    /**
     * DP
     * if current sum + nums[i] < nums[i], then start calculating the current sum at nums[i], set current sum to nums[i].
     * else keep accumulating the current sum.
     * time: O(n)
     * maintain a max to keep track of the max current sum
     *      -2, 1, -3, 4, -1, 2, 1, -5, 4
     *curr: -2  1  -2  4  3   5  6  1   5
     *max:  -2  1   1  4  4   5  6  6   6
     * @param nums
     * @return
     */
    public int maxSubArrayV3(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int currSum = nums[0];
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            //currSum = Math.max(nums[i], currSum + nums[i]);
            if (nums[i] > currSum + nums[i]) {
                start = i;
                currSum = nums[i];
            }
            else
                currSum += nums[i];

            //maxSum = Math.max(maxSum, currSum);
            if (currSum > maxSum) {
                end = i;
                maxSum = currSum;
            }
        }

        System.out.println("[" + start + ":" + end + "]");
        return maxSum;
    }

    /**
     * DP:
     * Iterating through the array:
     *  for each index j, the max subarray sum ending at j is equal to S[j] - min sum so far
     * During the iteration, we track the min sum we have seen so far and compute the max subarray sum for each index.
     * time: O(n)
     * @param nums
     * @return
     */
    public int maxSubArrayV4(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int minSum = 0;
        int currSum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum < minSum) {
                start = i + 1;
                minSum = currSum;
            }

            if (currSum - minSum > maxSum) {
                end = i;
                maxSum = currSum - minSum;
            }
        }

        System.out.println("[" + start + ":" + end + "]");
        return maxSum;
    }

}
