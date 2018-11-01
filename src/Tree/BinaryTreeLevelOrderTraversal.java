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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> tmpQ = new LinkedList<>();
            List<Integer> tmpList = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode tn = q.remove();
                tmpList.add(tn.val);
                if (tn.left != null)
                    tmpQ.add(tn.left);
                if (tn.right != null)
                    tmpQ.add(tn.right);
            }
            q = tmpQ;
            res.add(tmpList);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                tmpList.add(tn.val);
                if (tn.left != null)
                    queue.offer(tn.left);
                if (tn.right != null)
                    queue.offer(tn.right);
            }
            res.add(tmpList);
        }
        Collections.reverse(res);
        return res;
    }
}
