package LinkedList;

/**
 * @Number: #147. Insertion Sort List
 * @Descpription: Sort a linked list using insertion sort.
 * @Author: Created by xucheng.
 */
public class InsertionSortList {
    /**
     * Intuition
     * Time: O(n^2)
     * Space:O(1)
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy; // prev node of the node that will be inserted every time in the sorted part
        ListNode curr = head; // curr node in the unsorted part
        ListNode next = null; // record the next node of current node in advance for later use

        while (curr != null) {
            next = curr.next;
            // find the right prev node of the node to be inserted
            while (pre.next != null && pre.next.val < curr.val)
                pre = pre.next;
            // insert between pre and pre.next
            curr.next = pre.next;
            pre.next = curr;
            // reset pre to the beginning
            pre = dummy;
            // set curr to the next in the unsorted part
            curr = next;
        }
        return dummy.next;
    }
}
