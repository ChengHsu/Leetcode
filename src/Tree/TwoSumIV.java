package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Number: #653 Two Sum IV - Input is BST
 * @Descpription: Given a Binary Search Tree and a target number, return true if there exist two elements in the BST
 * such that their sum is equal to the given target.
 * @Author: Created by xucheng.
 */
public class TwoSumIV {
    // See if (k - root) exists
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        return find(root, k, set);
//
//    }
//    private boolean find(TreeNode root, int k, Set<Integer> set) {
//        if (root == null)
//            return false;
//        if (set.contains(k - root.val))
//            return true;
//        set.add(root.val);
//        return find(root.left, k, set) || find(root.right, k ,set);
//
//    }

//    Inorder traversal gets an ascending ordered list
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if(sum == k)
                return true;
            if(sum < k)
                l ++;
            if(sum > k)
                r--;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right,list);
    }
}

