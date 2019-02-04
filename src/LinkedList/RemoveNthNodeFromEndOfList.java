package LinkedList;

/**
 * @Number: 19. Remove Nth Node From End of List
 * @Descpription:Given a linked list, remove the n-th node from the end of list and return its head.
 * @Author: Created by xucheng.
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Two passes
     * 1. first loop: get the length of linkedlist
     * 2. second loop: get the position of the prev node of the given node
     * 3. prev.next = prev.next.next
     * Note: create a dummy node to deal with the special case: only one node in original linkedlist
     * Time: O(len)
     * Space: O(1)
     *
     * @param head
     * @param n
     * @return
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null)
//            return null;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int len = 0;
//        ListNode curr = head;
//        // get the length of linkedlist
//        while (curr != null) {
//            len++;
//            curr = curr.next;
//        }
//        len -= n;
//        curr = dummy;
//        // find the previous node of the node to be deleted (start from dummy node)
//        while (len > 0) {
//            len--;
//            curr = curr.next;
//        }
//        curr.next = curr.next.next;
//        // if original linkedlist is only one node, return head is wrong cuz the head is deleted already
//        return dummy.next;
//    }


    /**
     * one pass
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // advance the first so that the gap between two pots is n nodes
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // advance both 2 pointers so that when the first node reaches the last node the second reaches the node which
        // is n nodes far away from the last node
        while (first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

}
