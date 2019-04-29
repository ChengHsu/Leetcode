package InterviewPrep.WePay;

import java.util.Stack;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class EvaluateReversePolishNotation {
    /**
     * Use stack to store operand
     * Make sure that there are enough elements in the stack every time we pop 2 elements
     * Divide by Zero Exception
     * time:O(n)
     * space: O(n)
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            throw new IllegalArgumentException("There must be an input value");

        if (tokens.length < 3)
            throw new IllegalArgumentException("There should be at least 3 arguments");

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // It the current element is an operator, then pop the top two elements from the stack,
            // calculate the value, the push it back again to the stack.
            if (isOper(token) && stack.size() > 1) {
                // when do pop from the stack, the first pop is the right operand, the second pop is the left operand
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
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
                        else throw new ArithmeticException("Second operand can't be 0 in division");
                        break;
                }
            }
            // else push it to the stack
            else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw e;
                }
            }
        }
        return stack.pop();
    }

    public boolean isOper(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            return true;
        else
            return false;
    }
}
