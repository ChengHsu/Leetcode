package LinkedList;

/**
 * @Number: #86. Partition List
 * @Descpription: Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @Author: Created by xucheng.
 */
public class PartitionList {
    /**
     * Two pointers solution
     * Time: O(n)
     * Space: O(1)
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode before_head = new ListNode(0);
        ListNode before_curr = before_head;
        ListNode after_head = new ListNode(0);
        ;
        ListNode after_curr = after_head;

        while (head != null) {
            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before_curr.next = head;
                before_curr = before_curr.next;
            }
            // If the original list node is greater or equal to the given x,
            // assign it to the after list.
            else {
                after_curr.next = head;
                after_curr = after_curr.next;
            }
            // move ahead in the original list
            head = head.next;
        }
        // the last node should point to null
        after_curr.next = null;
        // the tail of before list should point to the head of after list
        before_curr.next = after_head.next;
        return before_head.next;
    }
}
