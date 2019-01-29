package Tree;

/**
 * @Number: 285. Inorder Successor in BST
 * @Descpription: Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * @Author: Created by xucheng.
 */
public class InorderSuccessorInBST {
    /**
     * Iterative
     * case 1: root.val > p.val, root could be an answer, so store the root as res firstly.
     *          however, don't know if there is anymore node on root'd left that is larger than p.val.
     *          so go to its left to find out
     * case 2:  root.val <= p.val, root cannot be p's inorder successor, neither can root's left child.
     *          So we only need to consider root's right child, thus we move root to its right and check again.
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }


    /**
     * Recursive to find successor
     * @param root
     * @param p
     * @return
     */
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    /**
     * recursive to find predecessor
     * @param root
     * @param p
     * @return
     */
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }

}
