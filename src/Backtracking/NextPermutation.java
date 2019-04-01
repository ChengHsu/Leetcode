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
     * Time: O(n). In the worst case, we scan the whole nums and find out all the elements are in descending order.
     * And then we reverse it. So 2 scans in total -> O(n)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        // for any given subsquence in descending order, no larger permutation is possible. e.g. [6,1] in [1,3,2,4,6,1]
        // so we need to find a nums[i-1]  from the right such that nums[i-1] < num[i]. e.g. 4 before [6,1]
        int idx = nums.length - 2;
        while(idx >= 0 && nums[idx+1] <= nums[idx]){
            idx--;
        }
        // now nums[i-1] is nums[idx]
        // to create a permutation just larger than the current one, we need to replace nums[i-1] with a number which is just larger than itself among numbers lying to its right.
        if(idx >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[idx])
                j--;
            swap(nums,idx,j);
        }
        // case 1: idx == -1, all elements are in descending order, just reverse it

        // case 2: after replacing nums[i-1] with a number just larger than itself, reverse the subsequence from i to the end.(this subsequence is already in descending order and replace didn't change the order)
        reverse(nums,idx + 1);
    }

    public void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}
