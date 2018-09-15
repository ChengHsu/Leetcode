package Array;

/**
 * @Descpription: #53.
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @Author: Created by xucheng.
 */
public class MaxSubarray {

    public static int subSum(int[] nums, int left, int right) {
        if (left == right) {
            if (nums[left] > 0)
                return nums[left];
            else
                return 0;
        }
        int center = (left + right) / 2;
        int maxLeftSum = subSum(nums, left, center);
        int maxRightSum = subSum(nums, center + 1, right);

        int maxLeftBorderSum = Integer.MIN_VALUE, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = Integer.MIN_VALUE, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }

    public int maxSubArray(int[] nums) {
//        int maxSum = Integer.MIN_VALUE;
        //  O(n^3)
//        for(int i = 0; i < nums.length; i++){
//            // head
//            for(int j = i; j < nums.length; j++) {
//                //end
//                int tmpSum = 0;
//                for(int k = i; k <= j; k++) {
//                    tmpSum += nums[k];
//                }
//                if(tmpSum > maxSum)
//                    maxSum = tmpSum;
//            }
//        }

//        O(n^2)
//        for (int i = 0; i < nums.length; i++) {
//            int tmpSum = 0;
//            for (int j = i; j < nums.length; j++) {
//                tmpSum += nums[j];
//                if(tmpSum > maxSum)
//                    maxSum = tmpSum;
//            }
//        }

//        O(nlogN) Divide and Conquer
//        maxSum = subSum(nums,0,nums.length-1);

//        O(n)
        if (nums.length == 0) return Integer.MIN_VALUE;
        int tmpSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmpSum = Math.max(nums[i], tmpSum + nums[i]);
            maxSum = Math.max(tmpSum, maxSum);
        }
        return maxSum;
    }
}
