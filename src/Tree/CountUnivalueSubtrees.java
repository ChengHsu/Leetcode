package Tree;

/**
 * @Number: 250. Count Univalue Subtrees
 * @Descpription: Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * @Author: Created by xucheng.
 */
public class CountUnivalueSubtrees {
    private int sum = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        postOrder(root);
        return sum;
    }

    private boolean postOrder(TreeNode root) {
        if (root == null)
            return true;
        boolean left = postOrder(root.left);
        boolean right = postOrder(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val)
                return false;
            if (root.right != null && root.val != root.right.val)
                return false;
            sum ++;
            return true;
        }
        return false;
    }
}
