package Tree;

import java.util.List;

/**
 * @Number: 298. Binary Tree Longest Consecutive Sequence
 * @Descpription: Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * @Author: Created by xucheng.
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * Top DFS
     * Time: O(n).The time complexity is the same as an pre-order traversal of a binary tree with nn nodes.
     * Space: O(n). The extra space comes from implicit stack space due to recursion. For a skewed binary tree, the recursion could go up to nn levels deep.
     */
    private int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
       return dfs(root,null,0);
    }

    private int dfs(TreeNode root, TreeNode parent, int len) {
        if (root == null)
            return len;
        len = (parent != null && root.val == parent.val + 1)? len + 1: 1;
        return Math.max(maxLen, Math.max(dfs(root.left,root,len), dfs(root.right,root,len)));
    }
}
