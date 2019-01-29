package Tree;

/**
 * @Number: #100 Same Tree
 * @Descpription: Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * @Author: Created by xucheng.
 */
public class SameTree {
    /**
     * 1. 判断两个节点是否为null
     * 2. 判断两个节点的值是否相同
     * 3. 判断两个节点的左节点是否相同，右节点是否相同
     * @param p
     * @param q
     * @return
     */
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
