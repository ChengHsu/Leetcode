package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Number: #637.Average of Levels in Binary Tree
 * @Descpription: Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * @Author: Created by xucheng.
 */

public class AverageofLevelsinBinaryTree {

/**
 * BFS:https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
 */
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> res = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            double sum = 0;
//            int count = 0;
//            Queue<TreeNode> tmpQueue = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                TreeNode tn = queue.remove();
//                sum += tn.val;
//                count ++;
//                if (tn.left != null)
//                    tmpQueue.add(tn.left);
//                if (tn.right != null)
//                    tmpQueue.add(tn.right);
//            }
//            queue = tmpQueue;
//            res.add(sum*1.0/count);
//        }
//        return res;
//    }

    /**
     * DFS
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        List<Integer> count = new LinkedList<>();
        average(root, 0, res, count);
        // calculate mean val
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    private void average(TreeNode tn, int depth, List<Double> sum, List<Integer> count) {
        if (tn == null)
            return;
        // Already go through the left side, now r in the right side
        if (depth < sum.size()) {
            sum.set(depth, sum.get(depth) + tn.val);
            count.set(depth, count.get(depth) + 1);
        }
        // Go through the left side
        else {
            sum.add(1.0 * tn.val);
            count.add(1);
        }
        average(tn.left, depth+1, sum, count);
        average(tn.right, depth+1, sum, count);
    }
}
