package String;

import java.util.HashMap;

/**
 * @Number: 205. Isomorphic Strings
 * @Descpription: Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * @Author: Created by xucheng.
 */
public class IsomorphicStrings {
    /**
     * HashMap: 由于两个字符串相同位置的字符是一一对应关系，所以用HashMap存一对字符
     * 由于HashMap的Value不保证无重复，所以遍历check两遍，一次使s中字符为Key，一次使t中字符为k
     * @param s
     * @param t
     * @return
     */
//    public boolean isIsomorphic(String s, String t) {
//        // edge case
//        if (s.length() == 0 || t.length() == 0)
//            return true;
//        if (traverse(s, t) && traverse(t, s))
//            return true;
//        else return false;
//    }
//
//    private boolean traverse(String str1, String str2) {
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < str1.length(); i++) {
//            if (!map.containsKey(str1.charAt(i))) {
//                map.put(str1.charAt(i), str2.charAt(i));
//            } else {
//                if (map.get(str1.charAt(i)) != str2.charAt(i))
//                    return false;
//            }
//        }
//        return true;
//    }

    /**
     * Simplified HashMap:
     * https://leetcode.com/problems/isomorphic-strings/discuss/57802/Java-solution-using-HashMap
     * 一次遍历解决HashMap不保证Value无重复的问题：如果a,b一一对应,若 !map.containsKey(a) 则check if map.ContainsValue(b)
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1)
            return true;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b)
                    return false;
            }
            else {
                if (!map.containsValue(b))
                    map.put(a,b);
                else return false;
            }
        }
        return true;
    }
}
