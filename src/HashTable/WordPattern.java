package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #290. Word Pattern
 * @Descpription: Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * @Author: Created by xucheng.
 */
public class WordPattern {
    /**
     * bijection - HashMap
     * Comapre the char in pattern and the word in str in parallel
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;
        for (int i = 0 ; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(words[i]))
                    return false;
                map.put(c,words[i]);
            }
            else {
                if (!words[i].equals(map.get(c)))
                    return false;
            }
        }
        return true;
    }
}
