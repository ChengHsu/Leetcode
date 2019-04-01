package SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Number: #159. Longest Substring with At Most Two Distinct Characters
 * @Descpription: Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * @Author: Created by xucheng.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    /**
     * same with Fruit Into Baskets
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0)
            return 0;

        HashMap<Character, Integer> lastIdx = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            lastIdx.put(ch, end);
            if (lastIdx.size() > 2){
                int minIdx = Collections.min(lastIdx.values());
                lastIdx.remove(s.charAt(minIdx));
                start = minIdx + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
