package BinarySearch;

/**
 * @Number: #33. Search in Rotated Sorted Array
 * @Descpription: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * # 81.Search in Rotated Sorted Array II
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * @Author: Created by xucheng.
 */
public class SearchInRotatedSortedArray {
    /**
     * 33
     * https://leetcode.windliang.cc/leetCode-33-Search-in-Rotated-Sorted-Array.html
     * 数组二分，不存在target的那段所有数字可以看作正无穷大或负无穷大，这样整个数组就可以看作有序的数组进行binary search了
     * time：O(log n)
     * space: O(1)
     * @param nums
     * @param target
     * @return
     */
//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return -1;
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            int num = nums[mid];
//            // 因为rotate把数组分成了2部分，如果target和mid在同一部分：
//            // [ 4 5 6 7 1 2 3] , target = 5
//            // 数组可以看作 [ 4 5 6 7 inf inf inf ]
//            // mid位置的数字不变
//            // 判断：把 nums[mid] 和 target 同时与 nums[0] 比较，如果它俩都大于 nums[0] 或者都小于 nums[0]，那么就代表它俩在同一部分
//            // 如果都大于，以下判断条件都为true；如果都小于，以下判断条件都为false
//            if (((nums[mid] < nums[0]) == (target < nums[0])))
//                num = nums[mid];
//            // nums[mid]和target不在同一部分：
//            // [ 4 5 6 7 1 2 3] , target = 2
//            // 数组可以看作  [ - inf - inf - inf - inf 1 2 3]
//            // [ 6 7 1 2 3 4 5] , target = 7
//            // 数组可以看作  [ 6 7 inf inf inf inf inf]
//            // mid位置的数字看情况变为 -inf或者inf
//            else
//                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            // normal binary search
//            if (num < target)
//                low = mid + 1;
//            else if (num > target)
//                high = mid - 1;
//            else return mid;
//        }
//        return -1;
//    }

    /**
     * 33
     * https://www.youtube.com/watch?v=KSZfO65J6hg
     * 算法基于一个事实，数组从任意位置劈开后，至少有一半是有序的
     * 我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。
     *
     * @param nums
     * @param target
     * @return
     */
//    public int search(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (target == nums[mid]) {
//                return mid;
//            }
//            //左半段是有序的
//            if (nums[start] <= nums[mid]) {
//                //target 在这段里
//                if (target >= nums[start] && target < nums[mid]) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//                //右半段是有序的
//            } else {
//                if (target > nums[mid] && target <= nums[end]) {
//                    start = mid + 1;
//                } else {
//                    end = mid - 1;
//                }
//            }
//
//        }
//        return -1;
//    }


    /**
     * 81.
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[start] == nums[end])
                start += 1;
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return true;
            }
            //左半段是有序的
            if (nums[start] <= nums[mid]) {
                //target 在这段里
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //右半段是有序的
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }

}
