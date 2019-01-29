package String;

/**
 * @Number: #28. Implement strStr()
 * @Descpription: Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @Author: Created by xucheng.
 */
public class ImplementstrStr {
//  brute force: assume len of haystack is n, len of needle is m.
//  for every m-len substring of haystack, judge if it equals to the needle.
//    public int strStr(String haystack, String needle) {
//        if (haystack == null || needle == null || needle.length() == 0)
//            return 0;
//        if (needle.length() > haystack.length())
//            return -1;
//        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//            boolean successFlag = true;
//            for (int j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j))
//                {
//                    successFlag = false;
//                    break;
//                }
//            }
//            if (successFlag)
//                return i;
//        }
//        return -1;
//    }

    //  two pointers
//    public int strStr(String haystack, String needle) {
//        if (haystack == null || needle == null || needle.length() == 0)
//            return 0;
//        if (needle.length() > haystack.length())
//            return -1;
//        int i = 0;
//        while (i < haystack.length() - needle.length() + 1) {
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                int j = 0;
//                while (j < needle.length()) {
//                    if (haystack.charAt(i + j) != needle.charAt(j))
//                        break;
//                    else j += 1;
//                }
//                if (j == needle.length())
//                    return i;
//            }
//            i += 1;
//        }
//        return -1;
//    }


    /**
     * Brute Force
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int h_len = haystack.length();
        int n_len = needle.length();
        // edge case
        if (haystack == null || needle == null || n_len == 0)
            return 0;
        if (n_len > h_len)
            return -1;
        if (h_len == n_len) {
            if (haystack.equals(needle))
                return 0;
            else return -1;
        }

        // Scan
        for (int i = 0; i <= h_len - n_len; i++) {
            boolean flag = true;
            // compare the characters one by one, if there is one pair of chars doesn't match, break
            for (int j = 0; j < n_len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                return i;
        }
        return -1;
    }

    /**
     * Brute Force Using substring
     * @param haystack
     * @param needle
     * @return
     */
//    public int strStr(String haystack, String needle) {
//        int h_len = haystack.length();
//        int n_len = needle.length();
//        // edge case
//        if (haystack == null || needle == null || n_len == 0)
//            return 0;
//        if (n_len > h_len)
//            return -1;
//        if (h_len == n_len) {
//            if (haystack.equals(needle))
//                return 0;
//            else return -1;
//        }
//
//        // Scan
//        for (int i = 0; i <= h_len - n_len; i++) {
//            if (haystack.substring(i, i + n_len).equals(needle))
//                return i;
//        }
//        return -1;
//    }
}
