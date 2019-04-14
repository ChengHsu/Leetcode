package DynamicProgramming;

/**
 * @Number: 91. Decode Ways
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class DecodeWays {
    /**
     DP
     dp[i]: ways of decoding a substring of size i
     dp[0] = 1: an empty string with one way to decode
     dp[i] = valid(substring(i-1,i)) + valid(substring(i-2,i))
     i:  0 1 2 3 4
     s:  2 2 6 4
     1 1 2 3 3
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if(oneDigit >= 1 && oneDigit <= 9)
                dp[i] = dp[i - 1];
            if(twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
            //System.out.println(oneDigit + " " + twoDigit + " " + dp[i]);
        }
        return dp[n];
    }
}
