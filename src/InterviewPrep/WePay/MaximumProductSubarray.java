package InterviewPrep.WePay;

/**
 * @Number: 152. Maximum Product Subarray
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if (max > res)
                res = max;
        }


        return res;
    }
}
