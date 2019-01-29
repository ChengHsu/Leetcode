package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 109. Convert Sorted List to Binary Search Tree
 * @Descpription: Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @Author: Created by xucheng.
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * Binary search using slow and fast pointers
     * Once we have the middle element of the linked list,
     * we disconnect the portion of the list to the left of the middle element.
     * Time: O(NlogN)
     * Space: O(logN)
     * @param head
     * @return
     */
//    private ListNode findMiddleElement(ListNode head) {
//        // The pointer used to disconnect the left half from the mid node.
//        ListNode prevPtr = null;
//        ListNode slowPtr = head;
//        ListNode fastPtr = head;
//        // Iterate until fastPr doesn't reach the end of the linked list.
//        while (fastPtr != null && fastPtr.next != null) {
//            prevPtr = slowPtr;
//            slowPtr = slowPtr.next;
//            fastPtr = fastPtr.next.next;
//        }
//        // Handling the case when slowPtr was equal to head.
//        if (prevPtr != null) {
//            prevPtr.next = null;
//        }
//        return slowPtr;
//    }
//
//    public TreeNode sortedListToBST(ListNode head) {
//        // If the head doesn't exist, then the linked list is empty
//        if (head == null) {
//            return null;
//        }
//        // Find the middle element for the list.
//        ListNode mid = findMiddleElement(head);
//        // The mid becomes the root of the BST.
//        TreeNode node = new TreeNode(mid.val);
//        // Base case when there is just one element in the linked list
//        if (head == mid) {
//            return node;
//        }
//        // Recursively form balanced BSTs using the left and right halves of the original list.
//        node.left = sortedListToBST(head);
//        node.right = sortedListToBST(mid.next);
//        return node;
//    }

    /**
     * Recursion + Binary Search + conversion to Array
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @return
     */
    List<Integer> values = new ArrayList<>();
    private void mapListToValues(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
    }

   private TreeNode convertListToBST(int left, int right) {
        if (left > right)
            return null;
        int mid= (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        if (left == right)
            return node;
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    private TreeNode sortedListToBST(ListNode head) {
        mapListToValues(head);
        return convertListToBST(0, values.size() - 1);
    }

}
