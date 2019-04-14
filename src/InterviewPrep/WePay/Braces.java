package InterviewPrep.WePay;

import java.util.Stack;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Braces {

    public String[] balancedBrace(String[] braces) {
        String[] res = new String[braces.length];
        if (braces == null || braces.length == 0)
            return res;
        for (int i = 0; i < braces.length; i++) {
            res[i] = isValid(braces[i]) ? "YES" : "NO";
        }
        return res;
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                char prev = stack.pop();
                if (ch == ')' && prev != '(')
                    return false;
                if (ch == ']' && prev != '[')
                    return false;
                if (ch == '}' && prev != '{')
                    return false;
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}
