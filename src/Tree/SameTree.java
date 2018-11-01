package Tree;

/**
 * @Number: #100 Same Tree
 * @Descpription: Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * @Author: Created by xucheng.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
