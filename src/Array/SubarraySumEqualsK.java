package Array;

import java.util.HashMap;

/**
 * @Number: #560. Subarray Sum Equals K
 * @Descpription: Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * @Author: Created by xucheng.
 */
public class SubarraySumEqualsK {

    /**
     * time: O(n^2)
     * space: O(1)
     * @param nums
     * @param k
     * @return
     */
//    public int subarraySum(int[] nums, int k) {
//        int num = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int tmpK = k;
//            for (int j = i; j < nums.length; j++) {
//                tmpK -= nums[j];
//                if (tmpK == 0)
//                    num++;
//            }
//        }
//        return num;
//    }


    /**
     * Use HashMap to record the current accumulative sum and its occurrence
     * for every current sum[j], see if there exists sum[j] such that sum[j] - k = sum[i],
     * which mean the sum of subarray from i to j is k.
     * time: O(n)
     * space: O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
