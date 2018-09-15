package Stack;

import java.util.Stack;

/**
 * @Number: #844. Backspace String Compare
 * @Descpription: Given two strings S and T,
 * return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * @Author: Created by xucheng.
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> stack_s = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack_s.push(c);
            } else if (!stack_s.empty())
                stack_s.pop();
        }
        return String.valueOf(stack_s);
    }
}
