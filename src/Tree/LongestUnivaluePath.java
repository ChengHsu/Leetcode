package Tree;

/**
 * @Number: #687 Longest Univalue Path
 * @Descpription: DGiven a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 * The length of path between two nodes is represented by the number of edges between them.
 * @Author: Created by xucheng.
 */
public class LongestUnivaluePath {
    // ????
    private int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        this.ans = 0;
        univaluePath(root);
        return this.ans;
    }

    private int univaluePath(TreeNode root) {
        if (root == null) return 0;
        int l = univaluePath(root.left);
        int r = univaluePath(root.right);
        int pl = 0;
        int pr = 0;
        if (root.left != null && root.val == root.left.val)
            pl = l + 1;
        if(root.right != null && root.val == root.right.val)
            pr = r + 1;
        this.ans = Math.max(this.ans, pl+pr);
        return Math.max(pl,pr);
    }
}
