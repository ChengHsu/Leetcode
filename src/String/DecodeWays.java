package String;

/**
 * @Number: #91. Decode Ways
 * @Descpription: A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * @Author: Created by xucheng.
 */
public class DecodeWays {
    /**
     * TO DO
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;

        int[] cnt = new int[26];
        for (int i = 0; i < s.length() - 2; i++) {
            String tmp = s.substring(i, i + 2);
            int twoDigitNum = Integer.parseInt(tmp);
            System.out.println("two: " + twoDigitNum);
            int oneDigitNum1 = twoDigitNum / 10;
            int oneDigitNum2 = twoDigitNum % 10;
            System.out.println(oneDigitNum1 + " " + oneDigitNum2);
            if (twoDigitNum < 26) {
                if (cnt[twoDigitNum] == 0)
                    cnt[twoDigitNum] = 1;
            }
            if (cnt[oneDigitNum1] == 0)
                cnt[oneDigitNum1] = 1;
            if (cnt[oneDigitNum2] == 0)
                cnt[oneDigitNum2] = 1;
        }
        int sum = 0;
        for (int count : cnt)
            if (count == 1)
                sum += 1;
        return sum;
    }
}
