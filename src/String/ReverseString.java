package String;

/**
 * @Number: #344. Reverse String
 * 541. Reverse String II
 * @Descpription: 344: Write a function that takes a string as input and returns the string reversed.
 * 541: Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * @Author: Created by xucheng.
 */
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    //    public String reverseStr(String s, int k) {
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < s.length(); i += 2 * k) {
//            // > 2k
//            if (s.length() - i >= 2 * k) {
//                res.append(new StringBuilder(s.substring(i, i + k)).reverse());
//                res.append(s.substring(i + k, i + 2 * k));
//            }
//            // < 2k but >= k, reverse first k chars and remain the left unchanged
//            else if (s.length() - i >= k) {
//                res.append(new StringBuilder(s.substring(i, i + k)).reverse());
//                res.append(s.substring(i + k));
//            }
//            // < k chars, reverse all
//            else
//                res.append(new StringBuilder(s.substring(i)).reverse());
//        }
//        return res.toString();
//    }
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2*k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

}
