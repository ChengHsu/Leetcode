package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Number: 291. Word Pattern II
 * @Descpription: Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * @Author: Created by xucheng.
 */
public class WordPatternII {
    /**
     * https://jogchat.com/uber/291.%20Word%20Pattern%20II%20(Uber%20Hard).php
     * Pattern length:m  String length:n
     * Time: O (n^m)
     * Space: O (m+ n)  m 为map大小（char对应的value的个数），第二个n为set worst case element个数。
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0)
            return true;
        if (pattern.length() == 0 || str.length() == 0)
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(pattern, 0, str, 0, map, set);
    }

    private boolean isMatch(String pattern, int patIdx, String str, int strIdx, Map<Character, String> map, Set<String> set) {
        if (patIdx == pattern.length() && strIdx == str.length()) return true;
        if (patIdx == pattern.length() || strIdx == str.length()) return false;
        // get the current pattern char
        char c = pattern.charAt(patIdx);
        // check if it's the same with that one stored in the map
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, strIdx))
                return false;
            // if it can match, great, continue to match the rest
            return isMatch(pattern, patIdx + 1, str, strIdx + s.length(), map, set);
        }
        // pattern character does not exist in the map
        for (int k = strIdx; k < str.length(); k++) {
            String p = str.substring(strIdx, k + 1);
            if (set.contains(p))
                continue;
            // create or update it
            map.put(c, p);
            set.add(p);
            // continue to match the rest
            if (isMatch(pattern, patIdx + 1, str, k + 1, map, set))
                return true;
            // backtracking
            map.remove(c);
            set.remove(p);
        }
        // we've tried our best but still no luck
        return false;
    }
}
