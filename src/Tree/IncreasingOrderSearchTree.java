package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #897 Increasing Order Search Tree
 * @Descpription: Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * @Author: Created by xucheng.
 */
public class IncreasingOrderSearchTree {
    // create another tree will cause memory use problems, so use a list to store values
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode curr = newRoot;
        for (int i = 1; i < list.size(); i++) {
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }
        return newRoot;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
