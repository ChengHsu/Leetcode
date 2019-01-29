package Tree;

import java.util.*;

/**
 * @Number: #103. Binary Tree Zig Zag Level Order Traversal
 * @Descpription: Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * @Author: Created by xucheng.
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    /**
     * BFS using queue
     * The nodes on even level should be added left->right
     * The nodes on odd level should be added right->left
     * At the beginning of each level, Must use a Deque to poll first and last node alternately.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // The nodes on even level should be added left->right
        // The nodes on odd level should be added right->left
        // At the beginning of each level, Must use a Deque to poll first and last node alternately.
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean dir = true;
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            System.out.println("level");
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (dir) {
                    TreeNode tn = deque.pollFirst();
                    System.out.println("dir: "+ tn.val);
                    level.add(tn.val);
                    if (tn.left != null)
                        deque.addLast(tn.left);
                    if (tn.right != null)
                        deque.addLast(tn.right);
                }
                else {
                    TreeNode tn = deque.pollLast();
                    System.out.println("!dir: "+ tn.val);
                    level.add(tn.val);
                    if (tn.right != null)
                        deque.addFirst(tn.right);
                    if (tn.left != null)
                        deque.addFirst(tn.left);
                }
            }
            dir = !dir;
            res.add(level);
        }
        return res;
    }


}
