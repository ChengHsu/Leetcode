package Tree;

/**
 * @Number: 116. Populating Next Right Pointers in Each Node
 * @Descpription: Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * 117. Populating Next Right Pointers in Each Node II
 * @Author: Created by xucheng.
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     * [0,1,2,3,4,5,6] 中 4.next没有指向5
     */
//    public void connect(TreeLinkNode root) {
//        if (root == null)
//            return;
//        Queue<TreeLinkNode> queue = new LinkedList<>();
//        queue.add(root);
//        root.next = null;
//        while (!queue.isEmpty()) {
//            int size =  queue.size();
//            System.out.println("level");
//            for (int i = 0; i < size; i++) {
//                TreeLinkNode tn = queue.poll();
//                System.out.println(tn.val);
//                if (tn .left != null && tn.right != null) {
//                    queue.offer(tn.left);
//                    queue.offer(tn.right);
//                    tn.left.next = tn.right;
//                    tn.right.next = null;
//                }
//                else if (tn.left != null) {
//                    queue.offer(tn.left);
//                    tn.left.next = null;
//                }
//                else if (tn.right != null) {
//                    queue.offer(tn.right);
//                    tn.right.next = null;
//                }
//                else continue;
//            }
//        }
//    }

    /**
     * 116
     * Time: O(n)
     * Space: O(1)
     *
     * @param root
     */
//    public void connect(TreeLinkNode root) {
//        if (root == null)
//            return;
//        TreeLinkNode curr = root;
//        TreeLinkNode nextLeftMost = null;
//        while (curr.left != null) {
//            nextLeftMost = curr.left;
//            while (curr != null) {
//                if (curr.left != null)
//                    curr.left.next = curr.right == null ? null : curr.right;
//                if (curr.right != null)
//                    curr.right.next = curr.next == null ? null : curr.next.left;
//                curr = curr.next;
//            }
//            curr = nextLeftMost;
//        }
//    }


    /**
     * 117
     * @param root
     */
    public void connect(TreeLinkNode root) {

        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}

