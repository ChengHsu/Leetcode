package Tree;

import Array.SearchInsertPos;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
//        SearchinaBinarySearchTree searchinaBinarySearchTree = new SearchinaBinarySearchTree();
//        TreeNode root = new TreeNode(4);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(7);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        root.left.left = node3;
//        root.left.right = node4;
//        System.out.println(searchinaBinarySearchTree.searchBST(root,5));

//        SymmetricTree symmetricTree = new SymmetricTree();
//        System.out.println(symmetricTree.isSymmetric(root));

//        TreeNode root1 = new TreeNode(3);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(9);
//        TreeNode node6 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(4);
//
//        TreeNode root2 = new TreeNode(3);
//        root1.left = node1;
//        root1.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
//        leafSimilarTrees.leafSimilar(root1,root2);

//        TreeNode root1 = new TreeNode(4);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(7);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(9);
//
//        root1.left = node1;
//        root1.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
//        invertBinaryTree.invertTree(root1);
//        TreeNode root1 = new TreeNode(5);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(6);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(1);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(9);
//        root1.left = node1;
//        root1.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.right = node5;
//        node5.left = node7;
//        node5.right = node8;
//        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
//        increasingOrderSearchTree.increasingBST(root1);

//        TreeNode s = new TreeNode(3);
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(2);
//        s.left = node1;
//        s.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//
//        TreeNode t = new TreeNode(4);
//        TreeNode node6 = new TreeNode(1);
//        TreeNode node7 = new TreeNode(2);
//        t.left = node6;
//        t.right = node7;
//
//        SubtreeofAnotherTree subtreeofAnotherTree = new SubtreeofAnotherTree();
//        System.out.println(subtreeofAnotherTree.isSubtree(s,t));

        TreeNode root1 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        System.out.println(lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root1,node1,node4).val);

    }
}
