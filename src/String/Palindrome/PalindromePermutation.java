package String.Palindrome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Number: #266. Palindrome Permutation
 * @Descpription: Given a string, determine if a permutation of the string could form a palindrome.
 * #267. Palindrome Permutation II
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * @Author: Created by xucheng.
 */
public class PalindromePermutation {
    /**
     * 266
     * A valid string can only has at most one odd occurrence of each type of char
     * time: O(n)
     * space: O(n)
     * @param s
     * @return
     */
//    public boolean canPermutePalindrome(String s) {
//        if (s.length() == 0)
//            return true;
//        Map<Character, Integer> freq = new HashMap<>();
//        for (char ch: s.toCharArray())
//            freq.put(ch, freq.getOrDefault(ch, 0)+1);
//
//        int cnt = 0;
//        for (int freqChar: freq.values()) {
//            if (freqChar % 2 != 0)
//                cnt++;
//        }
//        if (cnt > 1)
//            return false;
//        return true;
//    }

    /**
     * 266
     * Use array instead of HashMap to reduce space complexity
     * time: O(n)
     * space: O(1). Constant extra space is used for mapmap of size 128
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0)
            return true;

        int[] freq = new int[128];
        for (char ch : s.toCharArray())
            freq[ch]++;

        int cnt = 0;
        for (int freqChar : freq) {
            if (freqChar % 2 != 0)
                cnt++;
        }
        return cnt <= 1;
    }


    /**
     * 267
     * brute force solution (TLE)
     * to generate all permutations of a string
     * https://www.youtube.com/watch?v=AfxHGNRtFac
     * time: O(n!) -> n steps for each :T(n) = O(1) + O(1) + T(n - 1) -> n * n-1 * n-2 * ... * 1
     *                                         swap    swap   permute
     *
     * @param s
     * @return
     */
//    Set<String> set = new HashSet<>();
//
//    public List<String> generatePalindromes(String s) {
//        if (!canPermutePalindrome(s))
//            return new ArrayList<>();
//
//        permute(s.toCharArray(), 0);
//        return new ArrayList<>(set);
//    }
//
//    private void permute(char[] chars, int left) {
//        if (left == chars.length) {
//            if (isPalindrome(chars))
//                set.add(new String(chars));
//        } else {
//            for (int i = left; i < chars.length; i++) {
//                // "ABCD"
//                swap(chars, left, i); // "BACD"
//                permute(chars, left + 1); // "BAXX" -> "BACD" "BADC"
//                swap(chars, left, i); // backtrack to original order "ABCD"
//            }
//        }
//    }
//
//    private boolean isPalindrome(char[] chars) {
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != chars[chars.length - i - 1])
//                return false;
//        }
//        return true;
//    }
//
//    private void swap(char[] chars, int left, int i) {
//        char tmp = chars[left];
//        chars[left] = chars[i];
//        chars[i] = tmp;
//    }


    /**
     * 267
     * https://leetcode.com/problems/palindrome-permutation-ii/solution/
     * Generate all the permutations of the half of s and append the reverse of this permuted string to itself to create the palindromic permutations of s
     * time:  O((n / 2 + 1)!)
     *
     * @param s
     * @return
     */
    Set<String> set = new HashSet<>();

    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0)
            return result;
        if (s.length() == 1) {
            result.add(s);
            return result;
        }

        int[] map = new int[128];
        char[] half = new char[s.length() / 2];
        // check if s is palindrome
        if (!canPermutePalindrome(s, map))
            return result;

        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            // record the ch which has an odd number of occurrence
            if (map[i] % 2 == 1)
                ch = (char) i;
            for (int j = 0; j < map[i] / 2; j++) {
                half[k++] = (char) i;
            }
        }
        permute(half, 0, ch);
        return new ArrayList<>(set);
    }

    public boolean canPermutePalindrome(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0)
                count++;
        }
        return count <= 1;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            // combine two halves
            set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i); // backtrack
                }
            }
        }
    }

}
