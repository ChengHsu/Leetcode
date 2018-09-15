package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Descpription: #217 & #219
 * #217.Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * #219.Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * @Author: Created by xucheng.
 */


public class ContainsDuplicate {
// Duplicates are not allowed in Hash set.
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) {
            return false;
        }
        boolean hasDup = false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                hasDup = true;
                break;
            }
        }
        return hasDup;
    }

//  set every elements in the array to be the key, set every indices to be the value
//  For loop, if nums[i] not be added into map before, add. Else judge if the difference <= k.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2 || k < 1)
            return false;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if(!map.containsKey(nums[i])) {
               map.put(nums[i],i);
           }
           else {
               int preVal = map.get(nums[i]);
               if(i - preVal <= k)
                   return true;
               map.put(nums[i],i);
           }
        }
        return false;
    }
}
