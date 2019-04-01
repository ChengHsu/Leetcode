package Stack;

import java.util.Stack;

/**
 * @Number: #150. Evaluate Reverse Polish Notation
 * @Descpription: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * The given RPN expression is always valid.
 * That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * @Author: Created by xucheng.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOper(token) && stack.size() > 1) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push( num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        if (num2 != 0)
                        stack.push(num1 / num2);
                        else stack.push(0);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOper(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            return true;
        else return false;
    }
}
