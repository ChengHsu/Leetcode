package BinarySearch;

/**
 * @Number: #34. Find First and Last Position of Element in Sorted Array
 * @Descpription: Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * @Author: Created by xucheng.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * two scan
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution
     * time: O(n)
     * space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        if(nums == null || nums.length == 0)
            return targetRange;

        targetRange[0] = findLeft(nums, target);
        targetRange[1] = findRight(nums,target);
        return targetRange;
    }

    public int findLeft(int[] nums,int target){
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            // ==target的时候也向左走
            if(nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
            if(nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    public int findRight(int[] nums,int target){
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            // == target的时候也向右走
            if(nums[mid] <= target)
                left= mid + 1;
            else
                right = mid - 1;
            if(nums[mid] == target)
                idx = mid;
        }
        return idx;
    }
}
