package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 366. Find Leaves of Binary Tree
 * @Descpription: Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 * repeat until the tree is empty.
 * @Author: Created by xucheng.
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        while (root != null){
            if (isLeave(root,leaves)) root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<>();
        }
        return leavesList;
    }

    private boolean isLeave(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
//       remove visited left leaf
        if (node.left != null) {
            if (isLeave(node.left,leaves)) node.left = null;
        }
//        remove visited right leaf
        if (node.right != null) {
            if (isLeave(node.right,leaves)) node.right = null;
        }
        return false;
    }

}
