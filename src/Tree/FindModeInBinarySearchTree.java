package Tree;

import java.util.*;

/**
 * @Number: #501. Find Mode in Binary Search Tree
 * @Descpription: Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * If a tree has more than one mode, you can return them in any order.
 * @Author: Created by xucheng.
 */
public class FindModeInBinarySearchTree {
    // 1. traverse and maintain a map with <element,occurrence of element> pair
    // 2. find the mode and store it or them into a int[]

    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void inorder(TreeNode root, Map<Integer, Integer> map) {
        // check whether left ot right is null is faster than check root is null
        if (root.left != null)
            inorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        if (root.right != null)
            inorder(root.right, map);
    }
}
