package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #76. Minimum Window Substring
 * @Descpription: Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * If there is no such window in S that covers all characters in T, return the empty string ""
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * @Author: Created by xucheng.
 */
public class MinimumWindowSubstring {
    /**
     * Sliding Window
     * We keep expanding the window by moving the right pointer.
     * When the window has all the desired characters, we contract (if possible) and save the smallest window till now.
     * https://leetcode.com/problems/minimum-window-substring/solution/
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        // record the unique characters and its occurrence in t
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0; // the left pointer of the current window
        int minLeft = 0; // the left pointer of the min size window so far
        int minLen = Integer.MAX_VALUE;
        int count = t.length(); // total amount of elements required
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                // must make sure the occurrence of each char in t are reduced to 0 so that all the required elements are met
                // case: s: "bba" t: "ab"
                // if no this condition 【map.get(s.charAt(right)) >= 0】:
                // count will become 0 after meeting with 2 bs and jump into the while loop, which is not correct
                if (map.get(s.charAt(right)) >= 0) {
                    count--;
                }
                // when met with all required elements, update min len and move the left pointer to contract the window(if possible)
                while (count == 0) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    // use left pointer to contract the window
                    // case 1: s.charAt(left) is not a char in t, we can definitely discard it, move left pointer by 1
                    // case 2: s.charAt(left) is a char in t, if its occurrence so far > its occurrence in t, then we
                    //         can also discard it. (eg. t:"ABC"; substring in s so far: "AABC") move the left pointer by 1
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count++;
                        }
                    }
                    left++;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
