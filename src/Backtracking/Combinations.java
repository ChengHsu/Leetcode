package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 77. Combinations
 * @Descpription: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Time: O(n!/(n-k)!)
 * @Author: Created by xucheng.
 */
public class Combinations {
    /**
     * backtracking
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k)
            return res;
        combineHelper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void combineHelper(List<List<Integer>> res, ArrayList<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n ; i ++) {
            comb.add(i);
            combineHelper(res, comb,i + 1, n, k -1);
            // remove the last number of current combination
            // so that the previous combination + other number can generate a new combination
            // eg. [1,2] -> [1,3]
            comb.remove(comb.size() - 1);
        }
    }
}
