package Tree;

/**
 * @Number: #110.Balanced Binary Tree
 * @Descpription: Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @Author: Created by xucheng.
 */
public class BalancedBinaryTree {

    // 先递归判断较大的子树是否平衡，再递归判断较小的子树是否平衡. O(nlogn)
//    public boolean isBalanced(TreeNode root) {
//        if (root == null)
//            return true;
//        int leftHeight = getHeight(root.left);
//        int rightHeight = getHeight(root.right);
//        return ((Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int getHeight(TreeNode root) {
//        if (root == null)
//            return 0;
//        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
//
//    }


    // 在求解每个子树的高度的时候就比较左右子树是否平衡，不平衡立刻告诉根节点退出. O(n)
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        getHeight(root);
        return isBalanced;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        System.out.println(root.val);
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            System.out.println("f");
            isBalanced = false;
            return -1;
        }
        else return Math.max(leftHeight,rightHeight) + 1;
    }
}
