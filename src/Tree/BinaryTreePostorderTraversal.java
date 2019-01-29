package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Number: 145. Binary Tree Postorder Traversal
 * @Descpription: Given a binary tree, return the postorder traversal of its nodes' values.
 * @Author: Created by xucheng.
 */
public class BinaryTreePostorderTraversal {
    /**
     * Recursive
     * @param root
     * @return
//     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null)
//            return res;
//        postorder(root, res);
//        return res;
//    }
//
//    private void postorder(TreeNode root, List<Integer> res) {
//        if (root == null)
//            return;
//        if (root.left != null)
//            postorder(root.left, res);
//        if (root.right != null)
//            postorder(root.right, res);
//        res.add(root.val);
//    }

    /**
     * Iterative
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }


}
