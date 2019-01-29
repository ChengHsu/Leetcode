package String;

/**
 * @Number: #459. Repeated Substring Pattern
 * @Descpription: Given a non-empty string check if it can be constructed by taking a substring of it and appending
 * multiple copies of the substring together. You may assume the given string consists of lowercase English letters
 * only and its length will not exceed 10000.
 * @Author: Created by xucheng.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // the length of substring is at most s.length/2
        for (int i = len/2; i >= 1; i--) {
            if (len % i == 0) {
                // i = len of substring
                // len / i = nums of substring
                int nums = len / i;
                String subStr = s.substring(0,i);
                int j;
                for (j = 1; j < nums; j++) {
                    System.out.println(j*i+" "+j*i+i);
                    if (!subStr.equals(s.substring(j*i, j*i + i)))
                        break;
                }
                if (j == nums)
                    return true;
            }
        }
        return false;
    }
}
