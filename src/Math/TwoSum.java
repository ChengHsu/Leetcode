package Math;

/**
 * @Descpription: #1. & #167.
 * #1. Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * #167. Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * @Author: Created by xucheng.
 */
public class TwoSum {

    /**
     * 1.
     * Brute Force
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        int len = nums.length;
//        int[] res = new int[2];
//        for(int i = 0; i < len ; i++) {
//            for (int j = i+1; j < len ; j++) {
//                if(nums[i]+nums[j] == target)
//                {
//                    res[0] = i;
//                    res[1] = j;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 1.
     * HashMap: Key: target-nums[i] Value: index of nums[i] i.e. i
     * Check if such a key-value pair exists, if so, means both nums[i] and target=nums[i] are in nums
     * return two indices
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums ,int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i =0 ; i < nums.length; i++) {
//            if (map.get(nums[i]) != null) {
//                int[] res = new int[]{map.get(nums[i]),i};
//                return res;
//            }
//            map.put(target - nums[i],i);
//        }
//        return new int[]{};
//    }


    /**
     * 167
     * Two pointers
     * Time: O(n)
     * Space: O(1)
     * @param numbers
     * @param target
     * @return
     */
//    public int[] twoSum(int[] numbers, int target) {
//        int low = 0;
//        int high = numbers.length - 1;
//        while (low <= high) {
//            if (numbers[low] + numbers[high] == target)
//                return new int[] {low+1,high+1};
//            else if (numbers[low] + numbers[high] > target)
//                high --;
//            else low++;
//        }
//        return new int[]{};
//    }
}
