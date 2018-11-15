package String;

/**
 * @Number: Valid Palindrome II
 * @Descpription: Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 * @Author: Created by xucheng.
 */
public class ValidPalindromeII {
    // brute force: For each char in the given string, remove it and check if the left string is a palindrome
//    public boolean validPalindrome(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        for (int i = 0; i < s.length(); i++) {
//            char c = sb.charAt(i);
//            sb.deleteCharAt(i);
//            if (isPalindrome(sb))
//                return true;
//            sb.insert(i,c);
//        }
//        return isPalindrome(s);
//    }

    // String, StringBuilder inherited from CharSequence
//    private boolean isPalindrome(CharSequence s) {
//        for (int i = 0 ; i < s.length()/2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
//                return false;
//        }
//        return true;
//    }

    // Greedy
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return isPalindromeRange(s, i+1, j) || isPalindromeRange(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i , int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i))
                return false;
        }
        return true;
    }
}
