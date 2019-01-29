package Backtracking;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 254. Factor Combinations
 * @Descpription: Write a function that takes an integer n and return all possible combinations of its factors.
 * Factors should be greater than 1 and less than n
 * @Author: Created by xucheng.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3)
            return res;
        backtrack(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmpList, int remain, int start) {
        if (remain <= 1){
            // 必须大于1，避免input为37输出[37]的情况
            if (tmpList.size() > 1)
                res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = start; i <= remain; i++) {
            // 能够整除
            if (remain % i == 0) {
                tmpList.add(i);
                backtrack(res, tmpList, remain / i, i);
                tmpList.remove(tmpList.size() - 1);
            }

        }
    }
}
