package Array;

import java.util.Arrays;

/**
 * @Number: #581.Shortest Unsorted Continuous Subarray
 * @Descpription: Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * @Author: Created by xucheng.
 */
public class ShortestUnsortedContinuousSubarray {
//  Copy nums[] and sort it. Compare the original one and sorted one to determine the leftmost element and rightmost element.
    public int findUnsortedSubarray(int[] nums) {
       int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortNums[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        if(end - start > 0) return end-start+1;
        else return 0;
    }
}
