package Sort;

import java.util.Arrays;

/**
 * @Number: 242.Valid Anagram
 * @Descpription: Given two strings s and t , write a function to determine if t is an anagram of s.
 * @Author: Created by xucheng.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
//        Sorting
//        If t is an anagram of s, sorting both strings must obtain 2 identical strings
        if (s.length() != t.length())
            return false;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS,charT);
    }
}
