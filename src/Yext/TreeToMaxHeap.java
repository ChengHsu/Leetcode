package Yext;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class TreeToMaxHeap {
    /**
     * test case:
               9
            /     \
           7       4
         /   \    / \
        10   5  5   2
       / \   /\
      3  19 8 12
     *
     */
    static class Node{
        int val;
        Node left;
        Node right;
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public void buggedReorder(Node node) {
        if(node == null) {
            return;
        }

        Node left = node.getLeft();
        Node right = node.getRight();

        // if values of both left and right child < node.val, then we're good
        if((left == null || left != null && left.getVal() < node.getVal())
                && (right == null || right != null && right.getVal() < node.getVal())
                ) {
            return;
        }

        Node max = left;
        if(left == null) {
            max = right;
            // 1st bug
        } else if( right != null || right.getVal() < left.getVal()) {
            max = right;
        }

        // 2nd bug
        max.setVal(node.getVal());
        node.setVal(max.getVal());

        // 3rd bug
        buggedReorder(left);
        buggedReorder(right);
    }

    // right method
    public void correctReorder(Node node) {
        if(node == null) {
            return;
        }

        Node left = node.getLeft();
        Node right = node.getRight();

        // if values of both left and right child < node.val, then we're good
        if((left == null || left != null && left.getVal() < node.getVal())
                && (right == null || right != null && right.getVal() < node.getVal())
                ) {
            return;
        }

        correctReorder(left);
        correctReorder(right);

        Node max = node.left;
        if(left == null) {
            max = right;
        }else if(right != null && left.val < right.val) {
            max = right;
        }

        int temp = max.getVal();
        max.setVal(node.getVal());
        node.setVal(temp);

        // have to check subtrees again
        correctReorder(left);
        correctReorder(right);
    }
}
