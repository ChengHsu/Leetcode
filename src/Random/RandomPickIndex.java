package Random;

import java.util.*;

/**
 * @Number: #398. Random Pick Index
 * @Descpription: Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * @Author: Created by xucheng.
 */
public class RandomPickIndex {

    int[] nums;
    Random random;
    public RandomPickIndex(int[] nums) {
       this.nums = nums;
       this.random = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i =0 ; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (this.random.nextInt(++count) == 0)
                result = i;
        }
        return result;
    }
}
