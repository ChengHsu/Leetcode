package Math;

import java.util.Arrays;

/**
 * @Number: The number of questions
 * @Descpription: Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * @Author: Created by xucheng.
 */
public class ThreeSumClosest {
    /**
     * Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element.
     * If the sum is less than target, it means we have to add a larger element so next element move to the next.
     * If the sum is greater, it means we have to add a smaller element so last element move to the second last element.
     * Keep doing this until the end.
     * Each time compare the difference between sum and target, if it is less than minimum difference so far,
     * then replace result with it, otherwise keep iterating.
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
       for (int i = 0; i < nums.length - 2; i++) {
           // start can't be numbers previous i, otherwise there will be duplicate iterating
           int start = i+1, end = nums.length - 1;
           while (start < end) {
               int sum = nums[i] + nums[start] + nums[end];
               if (sum > target)
                   end--;
               else if (sum < target)
                   start ++;
               if (Math.abs(sum - target) < Math.abs(min - target))
                   min = sum;
           }
       }
        return min;
    }
}
