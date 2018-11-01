package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #872 Leaf Similar Trees
 * @Descpription: Consider all the leaves of a binary tree.
 * From left to right order, the values of those leaves form a leaf value sequence.
 * @Author: Created by xucheng.
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>();
        List<Integer> leafSeq2 = new ArrayList<>();
        traversal(root1,leafSeq1);
        traversal(root2,leafSeq2);
        return leafSeq1.equals(leafSeq2);
    }

    private void traversal(TreeNode root, List<Integer> leafSeq) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            leafSeq.add(root.val);
        traversal(root.left,leafSeq);
        traversal(root.right,leafSeq);
    }
}
