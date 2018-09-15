package TwoPointers;

/**
 * @Number: #344. Reverse String
 * @Descpription: Write a function that takes a string as input and returns the string reversed.
 * @Author: Created by xucheng.
 */
public class ReverseString {
    public String reverseString(String s) {
        int front = 0;
        int end = s.length() - 1;
        char[] str = s.toCharArray();
        while (front < end) {
           char tmp = str[front];
           str[front] = str[end];
           str[end] = tmp;
           front += 1;
           end -= 1;
        }
        return new String(str);
    }
}
