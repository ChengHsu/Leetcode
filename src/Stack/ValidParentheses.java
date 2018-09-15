package Stack;

import java.util.Stack;

/**
 * @Number: 20. Valid Parentheses
 * @Descpription: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if: 1.Open brackets must be closed by the same type of brackets. 2.Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * @Author: Created by xucheng.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                st.push(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (!st.empty()) {
                    char c = st.pop();
                    if (chars[i] == ')' && c == '(') return true;
                    if (chars[i] == '}' && c == '{') return true;
                    if (chars[i] == ']' && c == '[') return true;
                }
                else return false;
            }
        }
        return false;
    }
}
