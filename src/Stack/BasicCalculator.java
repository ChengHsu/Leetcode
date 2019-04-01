package Stack;

import java.util.Stack;

/**
 * @Number: #224. Basic Calculator
 * @Descpription: Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces
 * 227. Basic Calculator II
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * @Author: Created by xucheng.
 */
public class BasicCalculator {
    /**
     * 224
     * time: O(n)
     * space: O(n)
     * @param s
     * @return
     */
//    public int calculate(String s) {
//        s = s.replaceAll("\\s","");
//        if (s == null || s.length() == 0)
//            return 0;
//
//        Stack<Integer> stack = new Stack<>();
//        int sign = 1;
//        int res =0;
//
//        for (int idx = 0; idx < s.length(); idx++) {
//            char ch = s.charAt(idx);
//            if (Character.isDigit(ch)){
//                int num = ch - '0';
//                while (idx + 1 < s.length() && Character.isDigit(s.charAt(idx+1))){
//                    num = num * 10 + s.charAt(idx+1) - '0';
//                    idx++;
//                }
//                res += num * sign;
//            }
//            else if (ch == '+')
//                sign = 1;
//            else if (ch == '-')
//                sign = -1;
//            // start of new expression, push the current result, have to calculate the value of new expr first
//            else if (ch == '(') {
//                stack.push(res);
//                stack.push(sign);
//                res = 0;
//                sign = 1;
//            }
//            // pop prev sign and previous result, + them with current result
//            else if (ch == ')') {
//                res = res * stack.pop() + stack.pop();
//            }
//        }
//        return res;
//    }


    /**
     * time: O(n)
     * space: O(n)
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        int num = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            // 遇到一个op或者当前ch是最后一个
            // 用之前的op进行运算，因为要保证op两边的运算数都得到再进行运算，运算完后再把sign赋值为当前的op
            // 不能else if，idx == len - 1时满足两个if block
            if ((!Character.isDigit(ch) && ch != ' ') || idx == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = ch;
                num = 0;
            }
        }
        for (int val : stack)
            res += val;
        return res;
    }
}
