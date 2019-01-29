package Backtracking;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum4(nums,4));
    }
}
