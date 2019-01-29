package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Number: 39. Combination Sum && 40.Combination Sum II && 216.Combination Sum III && 377.Combination Sum IV
 * @Descpription: 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * 40.Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The solution set must not contain duplicate combinations.
 * 216.Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 377. Combination Sum IV
 * Given an integer array with all positive numbers and no duplicates,
 *  find the number of possible combinations that add up to a positive integer target.
 * @Author: Created by xucheng.
 */
public class CombinationSum {

    /**
     * 39
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        Arrays.sort(candidates);
        backtrack(combinations, new ArrayList<>(), candidates, target, 0);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain < 0)
            return;
        // 写 combinations.add(tmpList) 加不进去元素
        // we want a shallow/deep copy instead of (repeatedly) adding a pointer to a list in memory that will continue to change.
        else if (remain == 0) combinations.add(new ArrayList<>(tmpList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                // start不+1，保证可以减重复元素
                backtrack(combinations, tmpList, candidates, remain - candidates[i], i);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }


    /**
     * 40
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        Arrays.sort(candidates);
        backtrack2(combinations, new ArrayList<>(), candidates, target, 0);

        return combinations;
    }

    private void backtrack2(List<List<Integer>> combinations, List<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain < 0)
            return;
        //we want a shallow/deep copy instead of (repeatedly) adding a pointer to a list in memory that will continue to change.
        if (remain == 0)
            combinations.add(new ArrayList<>(tmpList));
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            tmpList.add(candidates[i]);
            backtrack2(combinations, tmpList, candidates, remain - candidates[i], i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    /**
     * 216
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k)
            return res;
        backtrack3(res, new ArrayList<>(), k , n, 1);
        return res;
    }

    private void backtrack3(List<List<Integer>> res, List<Integer> tmpList, int k, int remain, int start) {
        if (tmpList.size() == k && remain ==0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        if (tmpList.size() == k || remain < 0)
            return;
        // i <= 9 必须是1-9之间的
        for (int i = start; i <= 9; i++) {
            tmpList.add(i);
            backtrack3(res, tmpList, k, remain - i, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    /**
     * 377
     * Dynamic Programming
     * @param nums
     * @param target
     * @return
     */

    /**
     * Slow Recursion: Time Limited
     * @param nums
     * @param target
     * @return
     */
//    public int combinationSum4(int[] nums, int target) {
//        if (target == 0)
//            return 1;
//        int res = 0;
//        for (int i = 0 ; i < nums.length ; i++) {
//            if (target >= nums[i]) {
//                res += combinationSum4(nums,target - nums[i]);
//            }
//        }
//        return res;
//    }

    /**
     * fast version: Dynamic Programming
     */
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}
