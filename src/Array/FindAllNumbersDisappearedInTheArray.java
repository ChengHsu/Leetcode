package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #448
 * @Descpription: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * do it without extra space and in O(n) runtime. You may assume the returned list does not count as extra space.
 * @Author: Created by xucheng.
 */
public class FindAllNumbersDisappearedInTheArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> disappearedNums = new ArrayList<>();
        boolean[] flag = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n+1)
                flag[nums[i]] = true;
        }
        for (int i = 1; i < n+1; i++) {
            if(flag[i] == false) {
                disappearedNums.add(i);
            }
        }
        return disappearedNums;
    }
}
