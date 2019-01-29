package String;

/**
 * @Number: #161. One Edit Distance
 * @Descpription: Given two strings s and t, determine if they are both one edit distance apart.
 * @Author: Created by xucheng.
 */
public class OneEditDistance {
    /**
     * naive 分情况讨论
     * @param s
     * @param t
     * @return
     */
//    public boolean isOneEditDistance(String s, String t) {
//        // Edge case
//        if (Math.abs(s.length() - t.length()) > 1)
//            return false;
//        if ((s.length() == 0 && t.length() == 0) || s.equals(t))
//            return false;
//        // Replace
//        if (s.length() == t.length()) {
//            int cnt = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) != t.charAt(i)) {
//                    cnt++;
//                }
//            }
//            if (cnt > 1) return false;
//            else return true;
//        }
//        // Delete
//        else if (s.length() > t.length()) {
//            if (s.length() == 1 || t.length() == 0) {
//                return true;
//            }
//            if (check(s, t))
//                return true;
//            else return false;
//        }
//        // Add
//        else {
//            if (s.length() == 0 || t.length() == 1)
//                return true;
//            if (check(t, s))
//                return true;
//            else return false;
//        }
//    }
//
//    private boolean check(String str1, String str2) {
//        StringBuilder sb = new StringBuilder(str1);
//        for (int i = 0; i < sb.length(); i++) {
//            char tmp = sb.charAt(i);
//            sb.deleteCharAt(i);
//            if (sb.toString().equals(str2))
//                return true;
//            else sb.insert(i, tmp);
//        }
//        return false;
//    }


    /*
 * There're 3 possibilities to satisfy one edit distance apart:
 *
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s:
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */

    /**
     * Simplified
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }
}
