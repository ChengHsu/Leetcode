package SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Number: #340. Longest Substring with At Most K Distinct Characters
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * same as Longest Substring with At Most 2 Distinct Characters
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0)
            return 0;

        HashMap<Character, Integer> lastIdx = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            lastIdx.put(ch, end);
            if (lastIdx.size() > k){
                int minIdx = Collections.min(lastIdx.values());
                lastIdx.remove(s.charAt(minIdx));
                start = minIdx + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
