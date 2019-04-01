package Array;

/**
 * @Number: #238. Product of Array Except Self
 * @Descpription: Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * @Author: Created by xucheng.
 */
public class ProductOfArrayExceptSelf {
    /**
     * Two passes
     * 1st pass:
     * for every number k:
     * calculate the the product of all the numbers to the left of k
     * for every number k :
     * calculate the the product of all the numbers to the right of k
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return new int[0];
        if (nums.length == 1)
            return new int[]{1};

        int[] product = new int[nums.length];
        // assume the product of all the numbers to the left of the first number is 1
        product[0] = 1;
        for (int i = 1; i < product.length; i++) {
            //第i个数左边所有数的乘积 = 第i-1个数左边所有数的乘积 * 第i-1个数
            product[i] = product[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] *= right;
            right *= nums[i];
        }

        return product;
    }
}
