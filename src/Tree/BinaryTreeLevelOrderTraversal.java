package Tree;

import java.util.*;

/**
 * @Number:
 * #102 BinaryTreeLevelOrderTraversal
 * #107 BinaryTreeLevelOrderTraversal II
 * @Descpription:
 * 1.Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 2.Given a binary tree, return the bottom-up level order traversal of its nodes' values.(ie, from left to right, level by level from leaf to root).
 * @Author: Created by xucheng.
 */
public class BinaryTreeLevelOrderTraversal {


    /**
     * 102.
     * BFS using Queue
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                level.add(tn.val);
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
            }
            res.add(level);
        }
        return res;
    }


    /**
     * 107.
     * BFS using Queue
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Do a reverse of result list
        // the rest r Same as BinaryTreeLevelOrderTraversal
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                level.add(tn.val);
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }

}
