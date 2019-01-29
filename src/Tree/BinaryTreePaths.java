package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #257. Binary Tree Paths
 * @Descpription: Given a binary tree, return all root-to-leaf paths.
 * @Author: Created by xucheng.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        traversal(root,"",paths);
        return paths;
    }

    private void traversal(TreeNode root, String currPath, List<String> paths) {
        currPath += root.val;
        System.out.println("root curr: "+currPath);
        // return condition: meet leaf node
        if (root.left == null && root.right == null) {
            paths.add(currPath);
            return;
        }
        if (root.left != null) {
            traversal(root.left, currPath +"->",paths);
        }
        // After recursive left sub tree ,currPath :"1"
        if (root.right != null) {
            traversal(root.right,currPath +"->",paths);
        }
    }
}
