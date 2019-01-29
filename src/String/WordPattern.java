package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: 290. Word Pattern
 * @Descpription: Given a pattern and a string str, find if str follows the same pattern.
 * @Author: Created by xucheng.
 */
public class WordPattern {
    /**
     * HashMap: similar idea with Isomorphic Strings
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        // edge cse
        if (pattern.length() != words.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!words[i].equals(map.get(c)))
                    return false;
            } else {
                if (map.containsValue(words[i]))
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
