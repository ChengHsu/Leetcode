package String;

/**
 * @Number: #606. Construct String from Binary Tree
 * @Descpription: You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * @Author: Created by xucheng.
 */
public class ConstructStringFromBinaryTree {
    // 递归二叉树前序遍历
    // 右子树为空的去除括号
    // 左子树为空不能去除括号 和左右子树均不为空归为一类处理
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return t.val+"";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
