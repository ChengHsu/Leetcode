package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #270. Closest Binary Search Tree Value
 * @Descpription: Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * #272. Closest Binary Search Tree Value II
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * @Author: Created by xucheng.
 */
public class ClosestBinarySearchTreeValue {

    /**
     * Closest is either the root's value(a) or the closest in the appropriate subtree(b)
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }


    /**
     * 先用 inorder traversal 求出中序遍历
     * 找到第一个 >= target 的位置 index
     * 从 index-1 和 index 出发，设置两根指针一左一右，获得最近的 k 个整数
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();
        if (root == null)
            return values;
        inorder(root, values);

        int i = 0, n = values.size();
        for (; i < n; i++) {
            if (values.get(i) >= target)
                break;
        }

        if (i >= n)
            return values.subList(n - k, n);

        int left = i - 1, right = i;
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            if (left >= 0 && (right >= n || target - values.get(left) < values.get(right) - target)) {
                result.add(values.get(left));
                left--;
            } else {
                result.add(values.get(right));
                right++;
            }
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null)
            return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }


}
