package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Descpription: #26.
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 * @Author: Created by xucheng.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        for( int i = 0, len = nums.length; i < len ; i++) {
            if(set.add(nums[i])) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
