package Tree;

/**
 * @Number: #538. Convert BST to Greater Tree
 * @Descpription: Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 * @Author: Created by xucheng.
 */
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // idea: BST property: left < root < right
        // iterate right sub tree -> root (sum) -> left sub tree (sum)
        if (root!= null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
