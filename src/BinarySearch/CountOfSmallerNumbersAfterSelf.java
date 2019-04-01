package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #315. Count of Smaller Numbers After Self
 * @Descpription: You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * @Author: Created by xucheng.
 */
public class CountOfSmallerNumbersAfterSelf {
    /**
     * brute force
     * time: O(n^2)
     * space: O(n)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> counts = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return counts;
        for (int curr = 0; curr < nums.length - 1; curr++) {
            int count = 0;
            for (int countIdx = curr + 1; countIdx < nums.length; countIdx++) {
                if (nums[countIdx] < nums[curr])
                    count++;
            }
            counts.add(curr, count);
        }
        counts.add(0);
        return counts;
    }

}
