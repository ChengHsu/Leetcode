package BinarySearch;

/**
 * @Number:
 * #153. Find Minimum in Rotated Sorted Array
 * @Descpription: Find the minimum element.
 * #154. Find Minimum in Rotated Sorted Array II
 * The array may contain duplicates.
 * @Author: Created by xucheng.
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * 153
     * Fact:
     * all the elements to the right of the inflection point > first element of the array
     * all the elements to the left of the inflection point < first element of the array
     * mid
     * 1  2  4  5  6  7  0 nums[mid] > nums[0]
     * 2  4  5  6  7  0  1 nums[mid] > nums[0]
     * 4  5  6  7  0  1  2 nums[mid] > nums[0]
     * 5  6  7  0  1  2  4 nums[mid] < nums[0]
     * 6  7  0  1  2  4  5 nums[mid] < nums[0]
     * 7  0  1  2  4  5  6 nums[mid] < nums[0]
     *
     * Time: O(log n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length - 1;
        // sorted array, no rotation
        if (nums[high] > nums[0])
            return nums[0];
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // the whole array increases except at the inflection point
            // nums[mid+1] is the inflection point
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            // nums[mid] is the inflection point
            if (nums[mid - 1] > nums[mid])
                return nums[mid];
            // inflection point is on the right side
            if (nums[mid] > nums[0])
                low = mid + 1;
            // inflection point is on the left side
            if (nums[mid] < nums[0])
                high = mid - 1;
        }
        return -1;
    }

    /**
     * 154
     *      mid
     * 1  2  2  2  0
     * 2  2  2  0  1
     * 2  2  0  1  2
     * 2  0  1  2  2
     * time: worst: O(n)
     * space: O(1)
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // on the right side
            if (nums[mid] > nums[high])
                low = mid + 1;
            // on the left side
            else if (nums[mid] < nums[high])
                high = mid;
            // nums[mid] == nums[high], don't know to go left or right, just reduce high by one
            else high--;
        }
        return nums[low];
    }
}
