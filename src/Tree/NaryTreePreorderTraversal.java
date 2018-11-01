package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #589 N-ary Tree Preorder Traversal
 * @Descpription: Given an n-ary tree, return the preorder traversal of its nodes' values.
 * @Author: Created by xucheng.
 */

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preTraversal(root,res);
        return res;
    }

    private void preTraversal(Node root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        for (Node child: root.children) {
            preTraversal(child,res);
        }
    }
}
