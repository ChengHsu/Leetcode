package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class TreeDemo {
    // BFS Implementation using Queue
    public List<Integer> BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        int currLevelNum = 1;
        int nextLevelNum = 0;
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            res.add(tn.val);
            currLevelNum --;
            if (tn.left != null) {
                queue.add(tn.left);
                nextLevelNum ++;
            }
            if (tn.right != null) {
                queue.add(tn.right);
                nextLevelNum ++;
            }
            if (currLevelNum == 0) {
                currLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }

        }
        return res;
    }

    // DFS Implementation using stack


}
