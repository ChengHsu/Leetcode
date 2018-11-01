package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #144. Binary Tree Preorder Traversal
 * @Descpription:Given a binary tree, return the preorder traversal of its nodes' values.
 * @Author: Created by xucheng.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        if (root.left != null)
            preorder(root.left,res);
        if (root.right != null)
            preorder(root.right,res);
    }
}
