package String;

import java.util.*;

/**
 * @Number: 49.Group Anagrams
 * @Descpription: Given an array of strings, group anagrams together.
 * @Author: Created by xucheng.
 */
public class GroupAnagrams {
    /**
     * Categorize by Sorted String: inspired from Valid Anagram
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = String.valueOf(strChar);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            // Also make sure the str that's used to generate key is added
            map.get(key).add(str);
        }

        // make return array
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
