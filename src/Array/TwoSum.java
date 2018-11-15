package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

//    #1
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

// HashMap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] res = new int[] {map.get(nums[i]),i};
                return res;
            }
            map.put(target-nums[i],i);
        }
        return new int[] {};
    }

    //    #167
//    public int[] twoSum(int[] numbers, int target) {
//        int[] idx = new int[2];
//        for(int i = 0; i < numbers.length; i++) {
//            if(numbers[i] > target) break;
//            for(int j = i+1; j < numbers.length; j++) {
//                if(numbers[i]+numbers[j] == target)
//                {
//                    idx[0] = i+1;
//                    idx[1] = j+1;
//                }
//            }
//        }
//        return idx;
//    }

//    public int[] twoSum(int[] numbers, int target) {
//        int low = 0, high = numbers.length - 1;
//        int[] re = new int[2];
//        while (low < high) {
//            int sum = numbers[low] + numbers[high];
//            if (sum > target) high--;
//            else if (sum < target) low++;
//            else {
//                re[0] = low + 1;
//                re[1] = high + 1;
//                break;
//            }
//        }
//        return re;
//    }
}
