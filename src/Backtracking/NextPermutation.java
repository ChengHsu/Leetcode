package Backtracking;

/**
 * @Number: #31. Next Permutation
 * @Descpription: Implement next permutation,
 * which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * @Author: Created by xucheng.
 */
public class NextPermutation {
    /**
     * https://leetcode.com/problems/next-permutation/solution/
     * Time: O(n)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // Find a number(called it firstSmall) < its next number, from right
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // if i < 0, it means all numbers r in descending order, just reverse the whole nums
        // else. find a number called firstLarge from right that is just larger than firstSmall,
        //        swap firstLarge and firstSmall
        //        and reverse the part of nums from idx of firstLarge to the end
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
