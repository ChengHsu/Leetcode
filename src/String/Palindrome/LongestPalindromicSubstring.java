package String.Palindrome;

/**
 * @Number: #5. Longest Palindromic Substring
 * @Descpription: Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * @Author: Created by xucheng.
 */
public class LongestPalindromicSubstring {

    /**
     * Expand around center
     * 对于长度是odd的palindrome,从某个char开始,向两边扩展
     * 对于长度是even的palindrome,从相邻的某两个char开始，向两边扩展
     * time: O(n ^ 2)
     * space: O(1)
     *
     * @param s
     * @return
     */
    String subStr = "";
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        for(int i = 0; i < s.length(); i++){
            expand(i, i, s);
            expand(i, i+1, s);
        }
        return subStr;
    }

    public void expand(int l, int r, String s){
        while(l >= 0 && r < s.length() &&  s.charAt(l)== s.charAt(r)){
            l--;
            r++;
        }
        String tmp = s.substring(l+1, r);
        subStr = (tmp.length() > subStr.length()) ? tmp: subStr;
    }
}
