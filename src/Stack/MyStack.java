package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Number: 225. Implement Stack using Queues
 * @Descpription: Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * @Author: Created by xucheng.
 */

public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public MyStack() {
       queue1 = new LinkedList<>();
       queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        Integer ele = queue1.remove();
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        return ele;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
