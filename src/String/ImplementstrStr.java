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
}
