package Tree;

import java.util.HashMap;

/**
 * @Number: 337. House Robber III
 * @Descpription: The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * @Author: Created by xucheng.
 */
public class HouseRobber {

    /**
     * https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
     * Slow version
     * From the point of view of the tree root, there are only two scenarios at the end:
     * root is robbed or is not.
     * If it is, due to the constraint that "we cannot rob any two directly-linked houses",
     * the next level of subtrees that are available would be the four "grandchild-subtrees"
     * (root.left.left, root.left.right, root.right.left, root.right.right).
     * However if root is not robbed,
     * the next level of available subtrees would just be the two "child-subtrees"
     * (root.left, root.right).
     * We only need to choose the scenario which yields the larger amount of money.
     *
     * @param root
     * @return
     */
//    public int rob(TreeNode root) {
//        if (root == null)
//            return 0;
//        int val = 0;
//        if (root.left != null)
//            val += rob(root.left.left) + rob(root.left.right);
//        if (root.right != null)
//            val += rob(root.right.left) + rob(root.right.right);
//        return Math.max(val + root.val, rob(root.left) + rob(root.right));
//    }


    /**
     * improved version
     * For example, to obtain rob(root),
     * we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right);
     * but to get rob(root.left),
     * we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right).
     * The naive solution above computed these subproblems repeatedly, which resulted in bad time performance.
     * use a hash map to record the results for visited subtrees
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null)
            val += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            val += rob(root.right.left) + rob(root.right.right);
        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
    }
}
