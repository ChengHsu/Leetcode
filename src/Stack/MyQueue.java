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

//    private Stack<Integer> stack1;
//    private Stack<Integer> stack2;
//    private int front;
//
//    /** Initialize */
//    public MyQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        if (stack1.isEmpty())
//            front = x;
//        while (!stack1.isEmpty())
//            stack2.push(stack1.pop());
//        stack2.push(x);
//        while (!stack2.isEmpty())
//            stack1.push(stack2.pop());
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//       int ele = stack1.pop();
//       if (!stack1.isEmpty())
//           front = stack1.peek();
//       return ele;
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        return front;
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack1.isEmpty();
//    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.empty())
            front = x;
        stack1.push(x);
    }

    /**
     * We have to remove element in front of the queue.
     * This is the first inserted element in the stack s1 and it is positioned at the bottom of the stack because of stack's LIFO (last in - first out) policy.
     * To remove the bottom element from s1, we have to pop all elements from s1 and to push them on to an additional stack s2, which helps us to store the elements of s1 in reversed order.
     * This way the bottom element of s1 will be positioned on top of s2 and we can simply pop it from stack s2.
     * Once s2 is empty, the algorithm transfer data from s1 to s2 again.
     */
    public void pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the front element.
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }
}
