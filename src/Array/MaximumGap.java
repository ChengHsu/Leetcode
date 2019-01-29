package Array;

import java.util.Arrays;

/**
 * @Number: #164. Maximum Gap
 * @Descpription: Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 * @Author: Created by xucheng.
 */


public class MaximumGap {
    /**
     * Comparison Sorting
     * Time Complexity:  O(nlog(n)) (sort array:O(nlog(n)) linear iteration: O(n))
     */
    public int maximumGap(int[] nums) {
        // Edge case
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }
        return maxGap;
    }


    /**
     * Bucket
     * @param x
     * @return
     */
    public long mul(long x, long y){
        return x * y;
    }
    public int maximumGap_bucket(int[] nums) {
        int len = nums.length;
        int n = len;
        if(len < 2){
            return 0;
        }
        int mini = nums[0];
        int maxi = nums[0];
        for(int i = 0; i < len; i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        if(mini == maxi){
            return 0;
        }
        boolean[] empty = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++){
            empty[i] = true;
        }
        int[] pmax = new int[n + 1];
        int[] pmin = new int[n + 1];

        for(int i = 0; i < n; i++){
            int idx = (int)(mul(nums[i] - mini, n + 1) / (maxi - mini));
            if(idx > n){
                idx = n;
            }
            if(empty[idx]){
                empty[idx] = false;
                pmax[idx] = nums[i];
                pmin[idx] = nums[i];
            }else{
                pmax[idx] = Math.max(pmax[idx], nums[i]);
                pmin[idx] = Math.min(pmin[idx], nums[i]);
            }
        }
        int res = 0;
        int last = -1;
        for(int i = 0; i < n + 1; i++){
            if(!empty[i]){
                if(last < 0){
                    last = pmax[i];
                }else{
                    res = Math.max(res, pmin[i] - last);
                    last = pmax[i];
                }
            }
        }
        return res;
    }
}



