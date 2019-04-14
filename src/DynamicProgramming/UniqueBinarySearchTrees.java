package DynamicProgramming;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number:
 * 96. Unique Binary Search Trees
 * @Descpription: Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * @Author: Created by xucheng.
 */
public class UniqueBinarySearchTrees {
    /**
     * 96
     dp[i]: # unique BST for a sequence of length i
     dp[n] = sum dp[i-1] * dp[n - i]
     dp[i-1]:# unique BST out of its left subtree
     dp[n - i]:# unique BST out of its right subtree
     time: O(n^2)
     space: O(n)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }


        return dp[n];
    }


    /**
     * 95
     Recursion
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start; i <= end; i++) {
            // pick up i as the root
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            // construct tree
            for(TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = l;
                    currRoot.right = r;
                    allTrees.add(currRoot);
                }
            }
        }

        return allTrees;
    }


}
