package BinarySearch;

/**
 * @Number: #35. Search Insert Position
 * @Descpription: Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @Author: Created by xucheng.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            System.out.println("low: " + low + " high: " + high);
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return low;
    }
}
