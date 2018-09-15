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


    Stack<Node> s = null;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        int min=0;
        if(s.isEmpty())  min = x;
        else  {
            min = s.peek().min>x?x:s.peek().min;
        }
        s.push(new Node(x,min));
    }

    public void pop() {
        s.pop();

    }

    public int top() {
        return s.peek().val;

    }

    public int getMin() {
        return s.peek().min;
    }
}
