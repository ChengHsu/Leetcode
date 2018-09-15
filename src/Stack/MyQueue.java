package Stack;

import java.util.Stack;

/**
 * @Number: #232. Implement Queue using Stacks
 * @Descpription: Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * @Author: Created by xucheng.
 */

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    /** Initialize */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty())
            front = x;
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack2.push(x);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       int ele = stack1.pop();
       if (!stack1.isEmpty())
           front = stack1.peek();
       return ele;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
