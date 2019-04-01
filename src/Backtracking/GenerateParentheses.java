package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #22. Generate Parentheses
 * @Descpription: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @Author: Created by xucheng.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        backtrack(ans, "",0 , 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String curr, int left, int right, int n) {
        if (curr.length() == n * 2) {
            ans.add(curr);
            return;
        }
        // add ( when its number < n
        if (left < n)
            backtrack(ans, curr + "(",left + 1, right, n);
        // change to ) when backtracking
        if (right < left)
            backtrack(ans,curr + ")", left, right + 1, n);

    }
}
