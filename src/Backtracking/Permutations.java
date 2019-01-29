package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 46. Permutations
 * @Descpription: Given a collection of distinct integers, return all possible permutations.
 * @Author: Created by xucheng.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length ==0)
            return res;
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length ; i ++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
