package Array;

import java.util.Arrays;

/**
 * @Number: #628.Maximum Product of Three Numbers
 * @Descpription: Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * @Author: Created by xucheng.
 */
public class MaximumProductOfThreeNumbers {
    // Sort the array and compare the product of 1st,2nd,last(given the case of 2 negative numbers) and the product of the last three.
    // O(n*logn)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    // No need to use sort. Jut find the min1, min2, max1,max2,max3 and compare.
//    O(n)
//    public int maximumProduct(int[] nums) {
//        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//        for (int n: nums) {
//            if (n <= min1) {
//                min2 = min1;
//                min1 = n;
//            } else if (n <= min2) {     // n lies between min1 and min2
//                min2 = n;
//            }
//            if (n >= max1) {            // n is greater than max1, max2 and max3
//                max3 = max2;
//                max2 = max1;
//                max1 = n;
//            } else if (n >= max2) {     // n lies betweeen max1 and max2
//                max3 = max2;
//                max2 = n;
//            } else if (n >= max3) {     // n lies betwen max2 and max3
//                max3 = n;
//            }
//        }
//        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
//    }
}
