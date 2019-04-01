package SlidingWindow;

import java.util.HashMap;

/**
 * @Number: #395. Longest Substring with At Least K Repeating Characters
 * @Descpription: Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 * @Author: Created by xucheng.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    /**
     * In each step, just find the infrequent elements (show less than k times) as splits since any of these infrequent elements couldn't be any part of the substring we want.
     * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87738/Java-20-lines-very-easy-solution-7ms-with-explanation
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        System.out.println("s:" + s);
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                System.out.println("s: "+start +" cur: "+cur);
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        // test case: "bbaaacbd" 3
        result = Math.max(result, longestSubstring(s.substring(start), k));
        System.out.println("res: "+result);
        return result;
    }
}
