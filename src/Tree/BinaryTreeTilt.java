package Tree;

/**
 * @Number: #563 Binary Tree Tilt
 * @Descpription:  Given a binary tree, return the tilt of the whole tree.
 * @Author: Created by xucheng.
 */
public class BinaryTreeTilt {
    int tilt= 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        // get the sum of all node values of the left sub-tree of current node
        int left=traverse(root.left);
        // get the sum of all node values of the right sub-tree of current node
        int right=traverse(root.right);
        // calculate the sum of all node's tilt so far
        tilt+=Math.abs(left-right);
        // return sum of all node values plus value of current node
        return left+right+root.val;
    }
}
