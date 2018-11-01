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
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}
