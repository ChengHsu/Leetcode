package LinkedList;

/**
 * @Number: #203.Remove Linked List Elements
 * @Descpription: Remove all elements from a linked list of integers that have value val.
 * @Author: Created by xucheng.
 */
public class RemoveLinkedListElements {
    /**
     * tuitive solution
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // edge case
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            // if it's the node to be deleted, make its prev node to its next one
            if (curr.val == val)
                prev.next = curr.next;
                // if not, update the prev node
            else
                prev = curr;
            // move forward curr by one anyway
            curr = curr.next;
        }
        return dummy.next;
    }
}