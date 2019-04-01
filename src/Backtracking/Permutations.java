package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Number:
 * 46. Permutations && 47. Permutations II
 * @Descpription:
 * 46.
 * Given a collection of distinct integers, return all possible permutations.
 * 47.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * @Author: Created by xucheng.
 */
public class Permutations {

    /**
     * 46. Permutations
     * @param nums
     * @return
     */
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length ==0)
//            return res;
//        List<Integer> list = new ArrayList<>();
//        backtrack(nums, list, res);
//        return res;
//    }
//
//    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
//        if (list.size() == nums.length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length ; i ++) {
//            if (list.contains(nums[i]))
//                continue;
//            list.add(nums[i]);
//            backtrack(nums, list, res);
//            list.remove(list.size() - 1);
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> currPer = new ArrayList<>();
        for(int num: nums)
            currPer.add(num);
        backtrack(res, nums, currPer, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> currPer, int start) {
        if(start == nums.length) {
            res.add(new ArrayList<>(currPer));
            return;
        }
        for(int i= start; i < nums.length; i++){
            Collections.swap(currPer,i, start);
            backtrack(res, nums, currPer, i+1);
            Collections.swap(currPer,i, start);
        }

    }


    /**
     *
     * @param nums
     * @return
     */
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0)
//            return res;
//        Arrays.sort(nums);
//        boolean[] used = new boolean[nums.length];
//        List<Integer> list = new ArrayList<>();
//        backtrack2(nums, res,  list, used );
//        return res;
//    }
//
//    private void backtrack2(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
//        if (list.size() == nums.length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length ; i++) {
//            if (used[i]) continue;
//            //相等的时候则前面的数必须使用了，自己才能使用，这样就不会产生重复的排列了
//            if (i > 0 && nums[i] == nums[i -1] && !used[i-1])
//                continue;
//            used[i] = true;
//            list.add(nums[i]);
//            backtrack2(nums, res, list, used);
//            used[i] = false;
//            list.remove(list.size() - 1);
//        }
//    }

}
