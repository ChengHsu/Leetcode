package String;

/**
 * @Number: 87. Scramble String
 * @Descpription: Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * @Author: Created by xucheng.
 */
public class ScrambleString {
    /**
     * https://www.youtube.com/watch?v=Lq3Kr7-qXGI
     * Divide and Conquer
     * case 1: left part matches left part, right part matches right part
     * gr       gr
     * / \      / \
     * g  r     g  r
     * case 2: left part matches right part, right part matches left part
     * eat      tae
     * / \      / \
     * e  at    ta e
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if (s1.length() == 1 && s1.equals(s2)) return true;

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (letters[i] != 0) return false;

        for (int i = 1; i < s1.length(); i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            if ((isScramble(s1Left, s2.substring(0,i)) && isScramble(s1Right, s2.substring(i)))
                    || (isScramble(s1Left, s2.substring(s2.length()-i)) && isScramble(s1Right, s2.substring(0,s2.length()-i))))
                return true;
        }
        return false;
    }
}
