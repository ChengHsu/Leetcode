package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Number: #226. Invert Binary Tree
 * @Descpription: Invert a binary tree.
 * @Author: Created by xucheng.
 */
public class InvertBinaryTree {
    // Recursion
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null)
//            return null;
//        System.out.println(" Root:"+root.val);
//        TreeNode right = invertTree(root.right);
//        System.out.println(" time to left ");
//        TreeNode left = invertTree(root.left);
//        System.out.println("Exchange");
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    //iterate
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return root;
    }
}
