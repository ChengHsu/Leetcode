package String;

import java.util.*;

/**
 * @Number: #884. Uncommon Words from Two Sentences
 * @Descpription: We are given two sentences A and B.  (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.)
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Return a list of all uncommon words.
 * You may return the list in any order.
 * @Author: Created by xucheng.
 */
public class UncommonWordsFromTwoSentences {
    // Record occurrence of each word in two given string
    // return words that only occurred once
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String str : A.split(" "))
            map.put(str,map.getOrDefault(str,0)+1);
        for (String str : B.split(" "))
            map.put(str,map.getOrDefault(str, 0)+1);
        List<String> res = new ArrayList<>();
        for (String key: map.keySet())
            if (map.get(key) == 1)
                res.add(key);
        return res.toArray(new String[res.size()]);
    }
}
