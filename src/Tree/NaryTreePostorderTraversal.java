package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #590 N-ary Tree Postorder Traversal
 * @Descpription: Given an n-ary tree, return the postorder traversal of its nodes' values.
 * @Author: Created by xucheng.
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postTraversal(root,res);
        return res;
    }

    private void postTraversal(Node root, List<Integer> res) {
        if (root == null)
            return;
        for (Node child: root.children) {
            postTraversal(child,res);
        }
        res.add(root.val);
    }
}
