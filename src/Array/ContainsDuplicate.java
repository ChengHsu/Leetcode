package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Descpription: #217 & #219 & #220
 * #217.220. Contains Duplicate I:
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * #219.Contains Duplicate II:
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * 220. Contains Duplicate III:
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * @Author: Created by xucheng.
 */


public class ContainsDuplicate {
    /**
     * #217
     * Duplicates are not allowed in Hash set.
     *
     * @param nums
     * @return
     */
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


    /**
     * #219:
     * 1. set every elements in the array to be the key, set every index to be the value
     * 2. For loop, if nums[i] is not added to map before, add it and its current index.
     *    Otherwise, judge if the absolute <= k.
     *      If so, return true.
     *      If not, update its index.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Edge case
        if (nums.length < 2)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            // Dummy idea: HashMap stores a list of all indices of every element in order to calculate all absolute difference of all indices.
            // A: It's not necessary cuz the index is in ascending order. Say there are 3 indices of one element, index1, index2, index3.
            //    If index2 - index1 > k, there is no way that index3 - index1 <= k. So if index2 - index1 > k,, we can just discard index1,update
            //    the value to index2.
            else {
                int preVal = map.get(nums[i]);
                if (i - preVal <= k)
                    return true;
                else map.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 220.
     * 1. Brute force
     * Try every elements compare with its next k elements - Sliding Window
     * Time Comlexity: O(n * k)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate_time_limited(int[] nums, int k, int t) {
        // Edge case
        if (nums == null || nums.length == 0 || k <= 0 || t < 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j - i <= k && j < nums.length; j++) {
                if (Math.abs(Long.valueOf(nums[j]) - Long.valueOf(nums[i])) <= t)
                    return true;
            }
        }
        return false;
    }


    /**
     * 220.
     * 2. Tree Set
     * (a. Balanced Binary Search Tree in Java, efficient in searching, inserting and deleting)
     * (b. no duplicates in TreeSet)
     * Record numbers in a Balanced Binary Search Tree, check if the diff between the new number came in and its closest number
     * in the BST is less than t.
     * 对于每个数，求其和最接近的两个数的diff是否<= t
     * Time Complexity: O(n*logK)
     * Space Complexity; O(k)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_tree_set(int[] nums, int k, int t) {
        // Edge case
        if (nums == null || nums.length == 0 || k <= 0 || t < 0)
            return false;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // the smallest number larger than nums[i]
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t)
                return true;

            // the largest number smaller than nums[i]
            Integer floor = set.floor(nums[i]);
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t)
                return true;

            set.add(nums[i]);
            // make sure the size of set is k
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    /**
     * 220.
     * 3. Bucket
     * 在每k个元素中找有没有值相差<=t的元素
     * https://www.youtube.com/watch?v=yc4hCFzNNQc
     * put every number in a corresponding bucket (bucket_idx = (number - min_num)/(t+1)).
     * Return true if we see two numbers in a same bucket or the adjacent bucket has a diff less than t
     *
     * Time Complexity: O(n)
     * Space Complexity: O(bucket_size)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_bucket(int[] nums, int k, int t) {
        // Edge case
        if (nums == null || nums.length == 0 || k <= 0 || t < 0)
            return false;
        // Find min
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
            min = Math.min(min, nums[i]);

        // create bucket. <bucket_idx, nums[i]>
        HashMap<Long, Integer> bucket = new HashMap<>();
        long diff = Long.valueOf(t) + 1; // in case of t = 0
        for (int i = 0; i < nums.length; i++) {
            long index = (Long.valueOf(nums[i]) - Long.valueOf(min)) / diff;
            // Check left adjacent bucket
            Integer left_bucket = bucket.get(index - 1);
            if (left_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(left_bucket)) < diff)
                return true;
            // Check right adjacent bucket
            Integer right_bucket = bucket.get(index + 1);
            if (right_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(right_bucket)) < diff)
                return true;
            // Check current bucket: if in the same bucket, difference must < diff
            Integer curr_bucket = bucket.get(index);
            if (curr_bucket != null)
                return true;
            // none of 3 cases above is true
            bucket.put(index, nums[i]);
            // make sure the size of bucket is k
            if (i >= k)
                bucket.remove((Long.valueOf(nums[i - k]) - Long.valueOf(min)) / diff);

        }
        return false;
    }
}
