package Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Number: #559. Maximum Depth of N-ary Tree
 * @Descpription: Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @Author: Created by xucheng.
 */


// Recursion
public class MaximumDepthofNaryTree {

    /**
     *
     * Notice:

     Case1: Time Limited. maxDepth(child) runs twice every interation
     ```
     int maxDepth = 0;
     for (Node child: root.children) {
     if(maxDepth(child) > maxDepth)
     maxDepth = maxDepth(child);
     }
     return maxDepth + 1;
     ```
     Case 2 & 3: Running time 2 longer than 3
     ```
     int maxDepth = 0;
     for (Node child: root.children) {
     int tmpDepth = maxDepth(child);
     if(tmpDepth > maxDepth)
     maxDepth = tmpDepth;
     }
     return maxDepth + 1;
     ```
     ```
     int maxDepth = 0;
     for (Node child: root.children) {
     maxDepth = Math.max(maxDepth(child),maxDepth);
     }
     return maxDepth + 1;
     ```
     */


    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        else if (root.children.isEmpty())
            return 1;
        else {
            int maxDepth = 0;
            for (Node child: root.children) {
                maxDepth = Math.max(maxDepth(child),maxDepth);
            }
            return maxDepth + 1;
        }
    }
}
