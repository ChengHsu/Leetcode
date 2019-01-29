package String;

import java.util.*;

/**
 * @Number: #387. First Unique Character in a String
 * @Descpription: Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * @Author: Created by xucheng.
 */
public class FirstUniqueCharacterinaString {
    // 1. Get the frequency of each character
    // 2. Find the first character whose frequency is 1.
//    public int firstUniqChar(String s) {
//        int[] charFreq = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            charFreq[s.charAt(i) - 'a'] ++;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (charFreq[s.charAt(i) - 'a'] == 1)
//                return i;
//        }
//        return -1;
//    }

    /**
     * Use an array to store char's frequency
     * Note: it hard to return corresponding index if use HashMap to store the frequency
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        // Edge case
        if (s == null || s.length() == 0)
            return -1;
        // Store frequency of each char
        for (int i  =0; i < s.length(); i++)
            charFreq[s.charAt(i) - 'a'] ++;
        // Check if any frequency = 1, return its index.
        for (int i = 0; i < s.length(); i++)
            if ( charFreq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
