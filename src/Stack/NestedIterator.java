package Stack;

import DFSAndBFS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Number: #341. Flatten Nested List Iterator
 * @Descpription: Given a nested list of integers, implement an iterator to flatten it.
 * @Author: Created by xucheng.
 */
public class NestedIterator implements Iterator<Integer>{

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger())
                return true;
            stack.pop();
            for (int i = curr.getList().size() - 1; i >= 0; i--)
                stack.push(curr.getList().get(i));
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
}
