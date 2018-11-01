package String;

/**
 * @Number: String Pattern Searching
 * @Descpription: Given string s and pattern string p, return the index of t in the s.
 * @Author: Created by xucheng.
 */
public class KMP {

    int ViolentMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int i = 0;
        int j = 0;
        while (i < slen && j < plen) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            else {
                // i goes back j-1 indices
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == plen)
            return i - j;
        else
            return -1;
    }


}
