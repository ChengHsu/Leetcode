package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Number: #429. N-ary Tree Level Order Traversal
 * @Descpription: Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @Author: Created by xucheng.
 */
public class NaryTreeLevelOrderTraversal {
    // BFS using queue
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0 ; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                for (Node chid: node.children) {
                    queue.offer(chid);
                }
            }
            res.add(level);
        }
        return res;
    }
}
