package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #637.Average of Levels in Binary Tree
 * @Descpription: Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * @Author: Created by xucheng.
 */

public class AverageofLevelsinBinaryTree {

/**
 * BFS:https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
 */
//public List<Double> averageOfLevels(TreeNode root) {
//    List<Double> res = new ArrayList<>();
//    if (root == null)
//        return res;
//    Queue<TreeNode> queue = new LinkedList<>();
//    queue.add(root);
//    // Only root.val on its own level so adds it directly to result list
//    res.add((double) root.val);
//    while (!queue.isEmpty()) {
//        double sum = 0;
//        int count = 0;
//        // size: the number of nodes on each level
//        int size = queue.size();
//        // Must have one more loop to sum and count all the sub-nodes on the next level
//        // Otherwise only sub-nodes of one node will be summed and counted.
//        for (int i = 0; i < size; i++) {
//            TreeNode tn = queue.poll();
//            if (tn.left != null) {
//                queue.add(tn.left);
//                sum += tn.left.val;
//                count++;
//            }
//            if (tn.right != null) {
//                queue.add(tn.right);
//                sum += tn.right.val;
//                count++;
//            }
//        }
//        // When reaches the next level of the leaves level , count == 0.  Don't need to do calculation
//        if (count != 0)
//            res.add(sum / count);
//    }
//    return res;
//}

    /**
     * DFS using recursion
     * Instead of sum and count all nodes on each level
     * sum and count the nodes on each level of left side,then the right side.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
    private void average(TreeNode tn, int depth, List<Double> sum, List<Integer> count) {
        //Edge case
        if (tn == null)
            return;
        //Process
        //right side
        if (depth < sum.size()) {
            sum.set(depth, sum.get(depth) + tn.val);
            count.set(depth, count.get(depth) + 1);
        }
        // left side
        else {
            sum.add(tn.val * 1.0);
            count.add(1);
        }
        // Recursion
        average(tn.left, depth + 1, sum, count);
        average(tn.right, depth + 1, sum, count);
    }
}
