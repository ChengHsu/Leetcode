package Tree;

import java.util.Stack;

/**
 * @Number: #173. Binary Search Tree Iterator
 * @Descpription: Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * @Author: Created by xucheng.
 */
public class BSTIterator {

    /**
     * Inorder traversal
     */
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null)
                cur = cur.left;
            else
                break;
        }
    }


    /**
     * When the current TreeNode has a right branch
     * (It cannot have left branch, remember we traversal to the left most),
     * we need to jump to its right child first and then traversal to its right child's left most TreeNode.
     * When the current TreeNode doesn't have a right branch,
     * it means there cannot be a node with value smaller than itself father node, point the pointer at its father node.
     * @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
//        traversal right branch
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null){
                stack.push(cur);
                if (cur.left != null)
                    cur = cur.left;
                else break;
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
