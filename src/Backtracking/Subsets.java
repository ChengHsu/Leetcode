package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Number:
 * #78. Subsets
 * @Descpription: Given a set of distinct integers, nums, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets.
 * #90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * @Author: Created by xucheng.
 */
public class Subsets {
    /**
     * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     * 78.
     * [] - 1 - 1,2 - 1,2,3
     *        - 1,3
     *    - 2 - 2,3
     *    - 3
     * @param nums
     * @return
     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        System.out.println(list);
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            System.out.println("before " + i);
//            backtrack(list, tempList, nums, i + 1);
//            System.out.println("after " + i);
//            tempList.remove(tempList.size() - 1);
//        }
//    }


    /**
     * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     * 90
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        System.out.println(list);
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1])
                continue; // skip duplicates
            tempList.add(nums[i]);
            System.out.println("before " + i);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("after " + i);
            tempList.remove(tempList.size() - 1);
        }
    }
}

