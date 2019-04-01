package Stack;

import java.util.Stack;

/**
 * @Number: #155. Min Stack
 * @Descpription: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * @Author: Created by xucheng.
 */
public class MinStack {
    /** initialize your data structure here. */
    class Node{
        int val;
        int min;
        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    // compare min with x to update min and store it to the peek node
    public void push(int x) {
        int min = 0;

        if (stack.isEmpty()) min = x;
        else
            min = Math.min(stack.peek().min, x);
        stack.push(new Node(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
