package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Number: 449. Serialize and Deserialize BST
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    // 1,2,3,None,None,4,None,None,5,None,None,
    public String serialize(TreeNode root) {
        return preorderSerialize(root, "");
    }

    private String preorderSerialize(TreeNode root, String str) {
        if (root == null)
            str += "null,";
        else {
            str += String.valueOf(root.val) + ",";
            str = preorderSerialize(root.left, str);
            str = preorderSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return preorderDeserialize(list);
    }

    private TreeNode preorderDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = preorderDeserialize(list);
        root.right = preorderDeserialize(list);
        return root;
    }
}
