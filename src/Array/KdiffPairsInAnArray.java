package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Number: #532
 * @Descpription: Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * @Author: Created by xucheng.
 */
public class KdiffPairsInAnArray {

//  O(n^2)
//    public int findPairs(int[] nums, int k) {
//        int numsPair = 0;
//        if (nums.length < 2)
//            return 0;
//
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(Math.abs(nums[i] - nums[j]) == k) {
//                    if(nums[i] < nums[j])
//                        hashMap.put(nums[i], nums[j]);
//                    else {
//                        hashMap.put(nums[j], nums[i]);
//                    }
//                }
//            }
//        }
//        return hashMap.size();
//    }

//    O(n)
//    遍历数组，找满足k-diff关系的，把较小的数存HashSet里,HashSet过滤掉重复元素
    public int findPairs(int[] nums, int k) {
        Set<Integer> uniqs = new HashSet<>();
        Set<Integer> smallOneofPairs = new HashSet<>();
        if(k < 0)
            return 0;
        for (int i = 0 ; i < nums.length; i++) {
            if(uniqs.contains(nums[i] - k)) smallOneofPairs.add(nums[i] - k);
            if(uniqs.contains(nums[i] + k)) smallOneofPairs.add(nums[i]);
            uniqs.add(nums[i]);
        }
        return smallOneofPairs.size();
    }

}


