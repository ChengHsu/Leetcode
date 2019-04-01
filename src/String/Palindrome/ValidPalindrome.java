package String.Palindrome;

import javax.xml.stream.events.EndDocument;

/**
 * @Number:
 * #125. Valid Palindrome
 * @Descpription: Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * #680. Valid Palindrome II
 * @Descpription: Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 */
public class ValidPalindrome {
    /**
     * 125.
     * Two pointers
     * @param s
     * @return
     */
//    public boolean isPalindrome(String s) {
//        if (s.length() == 0)
//            return true;
//
//        char[] charArr = s.toLowerCase().toCharArray();
//        int start = 0;
//        int end = charArr.length - 1;
//        while (start < end) {
//            if (!Character.isLetterOrDigit(charArr[start]) && !Character.isLetterOrDigit(charArr[end])) {
//                start++;
//                end--;
//            } else if (!Character.isLetterOrDigit(charArr[start]))
//                start++;
//            else if (!Character.isLetterOrDigit(charArr[end]))
//                end--;
//            else {
//                if (charArr[start] != charArr[end])
//                    return false;
//                start++;
//                end--;
//            }
//        }
//        return true;
//    }


    /**
     * 680
     * naive solution: iterative: delete one char at a time to see if it's valid palindrome
     * TLE
     *
     * Divide & Conquer
     * 遇到两边对应字符不同的时候，不知道delete哪个字符,两边都试一下
     * 判断去除左边(l)之后剩下的（l+1,r）是否是palindrome
     * 判断去除右边(r)之后剩下的(l,r-1) 是否是palindrome
     */
    public boolean validPalindrome(String s) {
        if (s.length() == 0)
            return true;

        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                // 最多只有一个char是多余的
                return (isPalindrome(s,l+1, r) || isPalindrome(s, l, r - 1));
            }
            else {
                l++;
                r--;
            }
        }
        return true;
    }


    /**
     * Only applies to a string which only contains letters
     * @param
     * @return
     */
    public boolean isPalindrome(String s, int l , int r) {
        while (l < r){
            if (s.charAt(l) != s.charAt(r))
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }


}
