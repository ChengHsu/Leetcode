package Array;

import java.util.Arrays;

/**
 * @Number: #561.Array Partition I
 * @Descpription: Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * @Author: Created by xucheng.
 */
public class ArrayPartition {
//    数值相近的数字作为一对(ai, bi)
    public int arrayPairSum(int[] nums) {
//      merge sort: O(n*log(n))
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
