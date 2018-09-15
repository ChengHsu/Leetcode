package Array;

/**
 * @Descpription: #283
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * @Author: Created by xucheng.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for(int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
