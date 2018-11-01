package Tree;

/**
 * @Number: #572. Subtree of another tree
 * @Descpription: Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node
 * values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 * @Author: Created by xucheng.
 */
public class SubtreeofAnotherTree {
    // Preorder traversal of both s and t
    // Get preorder traversal string of s and t
    // Check whether string of t is a substring of s
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        String preS = preorder(s, "");
        String preT = preorder(t, "");
        // Use substring will cause indexOutOfBound exception cuz the char of endIndex will not be included in the return string
        return preS.indexOf(preT) >= 0;
    }

    private String preorder(TreeNode root, String traversalSequence) {
        traversalSequence += "#" + root.val + " ";
        if (root.left == null && root.right == null) {
            traversalSequence += "null null ";
            return traversalSequence;
        }
        if (root.left != null)
            traversalSequence = preorder(root.left, traversalSequence);
        else traversalSequence += "null ";

        if (root.right != null)
            traversalSequence = preorder(root.right, traversalSequence);
        else traversalSequence += "null ";
        return traversalSequence;
    }
}

