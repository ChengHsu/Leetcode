package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number:
 * #112. Path Sum
 * #113. Path Sum II
 * #437. Path Sum III
 * @Descpription: #112: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given sum.
 * #437: You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * @Author: Created by xucheng.
 */
public class PathSum {
    // #112. Path Sum
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null)
//            return false;
//        // initial total should be the value of root
//        return preorder(root, sum, root.val, false);
//    }
//
//    private boolean preorder(TreeNode root, int target, int total, boolean isFind) {
//        if (total == target && root.left == null && root.right == null) {
//            isFind = true;
//            return isFind;
//        }
//        if (root.left != null) {
//            isFind = preorder(root.left, target, total + root.left.val, isFind);
//        }
//        if (root.right != null) {
//            isFind = preorder(root.right, target, total + root.right.val, isFind);
//        }
//        return isFind;
//    }

    /**
     * 113. Path Sum II
     *
     * @param root
     * @param sum
     * @return
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null)
            return paths;
        preorder(root, sum, path, paths);
        return paths;
    }

    private void preorder(TreeNode root, int target, List<Integer> path, List<List<Integer>> paths) {
        path.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            //Since ArrayList is parse by reference, if you do not make a copy of the "result"
            // (in another way to say if you don't use result.add(new ArrayList(path) ) then,
            // the currentResult will be override in the following steps so when the recursion steps finishes,
            // the currentResult will be reset to it original -- a brand new empty LinkedList and in your "paths"
            // it references to the currentResult so all you got is empty.
            // You need to de-reference it by calling result.add(new ArrayList(...))
            paths.add(new ArrayList<>(path));
            // remove the last integer
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null)
            preorder(root.left, target - root.val, path, paths);
        if (root.right != null)
            preorder(root.right, target - root.val, path, paths);
//        remove the last integer
        path.remove(path.size() - 1);
    }


    // #437. Path Sum III
    // Double recursion
    // ?????
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null)
//            return 0;
//        dfs(root, sum);
//        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    private int dfs(TreeNode root, int sum) {
//        int count = 0;
//        if (root == null)
//            return 0;
//        if (root.val == sum)
//            count += 1;
//        count += dfs(root.left, sum - root.val);
//        count += dfs(root.right, sum - root.val);
//        return count;
//    }
}
