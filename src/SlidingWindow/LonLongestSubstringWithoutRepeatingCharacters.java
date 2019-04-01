package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Number: #3. Longest Substring Without Repeating Characters
 * @Descpription: Given a string, find the length of the longest substring without repeating characters.
 * @Author: Created by xucheng.
 */
public class LonLongestSubstringWithoutRepeatingCharacters {
    /**
     * Own solution: similar to sliding window
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (!map.containsKey(ch)) {
                // keep tracking the last index of the char
                map.put(ch, end);
            } else {
                int prevIdx = map.get(ch);
                map.put(ch, end);
                // start can't be smaller after updating
                // case: abba
                start = Math.max(start, prevIdx + 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
