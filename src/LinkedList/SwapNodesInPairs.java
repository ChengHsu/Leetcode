package LinkedList;

/**
 * @Number: #24. Swap Nodes in Pairs
 * @Descpription: Given a linked list, swap every two adjacent nodes and return its head.
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @Author: Created by xucheng.
 */
public class SwapNodesInPairs {
    /**
     * Note: 每次进行交换的pair的前一个node的next需指向pair中的second node
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // edge case
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            // swap
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            // current move forward
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
