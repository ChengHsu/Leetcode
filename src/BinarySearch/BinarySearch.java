package BinarySearch;

/**
 * @Number: #704. Binary Search
 * @Descpription: Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 * @Author: Created by xucheng.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
        }
        return -1;
    }
}
