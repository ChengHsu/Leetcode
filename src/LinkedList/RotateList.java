package LinkedList;

/**
 * @Number: #61. Rotate List
 * @Descpription: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * @Author: Created by xucheng.
 */
public class RotateList {
    /**
     * Cut the list into 2 parts according to the len-k%len th node
     * Reconnect the 2 parts to a new one
     * Time: O(n)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        // edge casel
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode curr = head;
        ListNode last = head;
        // 1. get length and record the last node for later use
        int len = 0;
        while (curr != null) {
            len++;
            last = curr;
            curr = curr.next;
        }
        // 2. find the prev node of the given node which is k nodes far from the end of list
        k = k % len;
        // if k == 0, nothing's gonna change
        if (k == 0) return head;
        curr = head;
        for (int i = 1; i <= len - k - 1; i++) {
            curr = curr.next;
        }
        // record the new head of the returned list, which is the given node which is k nodes far from the end of list
        ListNode newHead = curr.next;
        // 3. cut the list into two sub lists from this node
        curr.next = null;
        // 4. link the tail of the 2nd part to the original head to make a new list
        last.next = head;
        // return new head
        return newHead;
    }
}
