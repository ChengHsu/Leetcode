package Array;

/**
 * @Number: 724. Find Pivot Index
 * @Descpription: Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * @Author: Created by xucheng.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
//  Prefix Sum: Assume S is sum of total numbers,leftSum = S - pivot index - leftSum.
        int S = 0;
        for (int num :nums) {
            S += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == S - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
