package Array;

/**
 * @Descpription: #27.
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @Author: Created by xucheng.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val ) {
                nums[idx++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return idx;
    }
}


