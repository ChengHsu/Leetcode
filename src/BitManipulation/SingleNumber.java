package BitManipulation;

/**
 * @Number: #136. Single Number
 * @Descpription: Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @Author: Created by xucheng.
 */
public class SingleNumber {
    /**
     * same with Find the difference
     * time: O(n)
     * space: O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
