package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 199. Binary Tree Right Side View
 * @Descpription: Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * @Author: Created by xucheng.
 */
public class BinaryTreeRightSideView {
    /**
     * case:[1,2,3,4] 没过，没考虑左子数长度大于右子树的情况，长出的部分rightmost节点也可以被看见
     * @param root
     * @return
     */
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null)
//            return res;
//        traversal(root,res);
//        return res;
//    }
//
//    private void traversal(TreeNode root, List<Integer> res) {
//        res.add(root.val);
//        if (root.left == null && root.right == null)
//            return;
//        if (root.right != null)
//            traversal(root.right,res);
//        if (root.right == null && root.left != null)
//            traversal(root.left,res);
//    }

    /**
     * 1. Each depth of the tree only select one node.
     * 2. View depth is current size of result list.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
