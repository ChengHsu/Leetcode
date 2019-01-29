package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Number: 246. Strobogrammatic Number
 * @Descpription: A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * 247. Strobogrammatic Number II
 * Find all strobogrammatic numbers that are of length = n.
 * 248. Strobogrammatic Number III
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * @Author: Created by xucheng.
 */
public class StrobogrammaticNumber {
    /**
     * 246
     * Two pointer
     *
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        HashSet<String> set = new HashSet<>();
        set.add("0");
        set.add("1");
        set.add("8");
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");

        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            if (!set.contains(num.charAt(left) + "" + num.charAt(right)))
                return false;
        }
        return true;
    }


    /**
     * 247
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        System.out.println("n: " + n + " m: " + m);
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }


    /**
     * 248
     * https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67378/Concise-Java-Solution
     * @param low
     * @param high
     * @return
     */

    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] c = new char[len];
            dfs(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            if (left == right && p[0] != p[1]) {
                continue;
            }
            dfs(low, high, c, left + 1, right - 1, count);
        }
    }

}
