package DynamicProgramming;

import java.util.Collections;
import java.util.Comparator;

/**
 * @Number:
 * @Descpription: len of Longest common subsequence
 * @Author: Created by xucheng.
 */
public class LCS {

    public String LCS(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        System.out.println(LCSLength(dp, s, s.length(), t, t.length()));

        return findLCS(dp, s, s.length(), t, t.length());
    }

    private int LCSLength(int[][] dp, String s, int m, String t, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != 0)
            return dp[m][n];

        int result = 0;
        if (s.charAt(m - 1) == t.charAt(n - 1))
            result = 1 + LCSLength(dp, s, m - 1, t, n - 1);
        else
            result = Math.max(LCSLength(dp, s, m - 1, t, n), LCSLength(dp, s, m, t, n - 1));

        dp[m][n] = result;
        return result;
    }

    public String findLCS(int[][] dp, String s, int m, String t, int n) {

        if (m == 0 || n == 0)
            return new String();

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            System.out.println("-1");
            return findLCS(dp, s, m - 1, t, n - 1) + s.charAt(m - 1);
        }

        if (dp[m - 1][n] > dp[m][n - 1]) {
            return findLCS(dp, s, m - 1, t, n);
        }
        else
            return findLCS(dp, s, m, t, n - 1);
    }


}
