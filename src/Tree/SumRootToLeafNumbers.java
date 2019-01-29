package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #129. Sum Root to Leaf Numbers
 * @Descpription: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * @Author: Created by xucheng.
 */
public class SumRootToLeafNumbers {

    /**
     * Slow version
     * Keep recording all the paths to a list
     * Turn every string number into int and calculate the sum when iterating
     * @param root
     * @return
     */
//    public int sumNumbers(TreeNode root) {
//        if (root == null)
//            return 0;
//        String path = "" + root.val;
//        List<String> paths = new ArrayList<>();
//        preorder(root, path, paths);
//        int sum = 0;
//        for (String pathStr : paths) {
//            sum += Integer.parseInt(pathStr);
//        }
//        return sum;
//    }
//
//    private void preorder(TreeNode root, String path, List<String> paths) {
//        if (root.left == null && root.right == null) {
//            paths.add(path);
//            return;
//        }
//        if (root.left != null)
//            preorder(root.left, path + root.left.val, paths);
//        if (root.right != null)
//            preorder(root.right, path + root.right.val, paths);
//    }


    /**
     * Calculate the sum during traversal
     * maintain a variable sum to record the sum of numbers
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int path = root.val;
        int sum = 0;
        return preorder(root, path, sum);

    }

    private int preorder(TreeNode root, int path, int sum) {
        if (root.left == null && root.right == null) {
            sum += path;
            return sum;
        }
        if (root.left != null)
            sum = preorder(root.left, path * 10 + root.left.val, sum);
        if (root.right != null)
            sum = preorder(root.right, path * 10 + root.right.val, sum);
        return sum;
    }
}
