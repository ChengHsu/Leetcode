package Math;

import java.util.Arrays;

/**
 * @Number: 259. 3Sum Smaller
 * @Descpription: Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target
 * @Author: Created by xucheng.
 */
public class ThreeSumSmaller {
    /**
     * Binary Search
     * Think a Two Sum problem: nums[i] + nums[j] < target -> nums[j] < target - nums[i]
     * For every nums[i], find the largest nums[j] that could satisfy nums[j] < target - nums[i].
     * Then with i fixed there are (j - i) pairs that could satisfy nums[j] < target - nums[i].
     * For Three Sum problem, we can transfer it to nums[j] + nums[k] < target - nums[i]
     * like wrapping an extra for loop outside out of two sum
     * Time: O(n^2logn). The binarySearch function takes O(logn) time
     * therefore the twoSumSmaller takes O(nlogn) time.
     * The threeSumSmaller wraps with another for-loop, and therefore is (n^2 log n)
     * @param nums
     * @param target
     * @return
     */
//    public int threeSumSmaller(int[] nums, int target) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for (int i = 0; i < nums.length - 2; i++) {
//            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
//        }
//        return sum;
//    }
//
//    private int twoSumSmaller(int[] nums, int startIndex, int target) {
//        int sum = 0;
//        for (int j = startIndex; j < nums.length - 1; j++) {
//            int k = binarySearch(nums, j, target - nums[j]);
//            sum += k - j;
//        }
//        return sum;
//    }
//
//    private int binarySearch(int[] nums, int startIndex, int target) {
//        int left = startIndex + 1;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return right;
//    }


    /**
     * Two pointers
     * Calculate the diff of indices of two pointers when nums[left] + nums[right] < target
     * Time: O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        int sum = 0;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else right--;
        }
        return sum;
    }

}
