package Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @Number: #671. Second Minimum Node in a binary tree
 * @Descpription: Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node.
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 * @Author: Created by xucheng.
 */
public class SecondMinimumNodeInABinaryTree {
    // Note: left.val <= root.val <= right.val doesn't apply to this problem
    // root is the smallest
    // use Hashset to eliminate all the duplicate values

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniqueVals = new HashSet<>();
        dfs(root,uniqueVals);
        int lowerBound = root.val;
        long ans = Long.MAX_VALUE;
        for (int val:uniqueVals) {
            if (val > lowerBound && val < ans)
                ans = val;
        }
        return ans < Long.MAX_VALUE? (int)ans: -1;
    }

    private void dfs(TreeNode root, Set<Integer> uniqueVals) {
        if (root != null) {
            uniqueVals.add(root.val);
            dfs(root.left,uniqueVals);
            dfs(root.right,uniqueVals);
        }
    }

    // Another solution: Ad Hoc???
}
