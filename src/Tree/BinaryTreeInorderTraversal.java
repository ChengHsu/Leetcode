package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Number: #94.Binary Tree Inorder Traversal
 * @Descpription: Given a binary tree, return the inorder traversal of its nodes' values.
 * @Author: Created by xucheng.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderT(root, res);
        return res;
    }

    /**
     * DFS: left sub-tree first, always keep finding left sub-tree:
     * 1.If curr has left sub-tree, go down to its left sub-tree
     * 2.If curr.left == null:
     *   a) Add its val to res
     *   b) If it has right sub-tree, go down to its right sub-tree.
     *      Else return
     * @param root
     * @param res
     */
    private void inorderT(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.left != null)
            inorderT(root.left,res);
        res.add(root.val);
        if (root.right != null)
            inorderT(root.right,res);
        return;
    }
}

