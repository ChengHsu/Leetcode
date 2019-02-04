package LinkedList;

/**
 * @Number: #143. Reorder List
 * @Descpription: Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @Author: Created by xucheng.
 */
public class ReorderList {
    /**
     * 1. Find the middle
     * 2. Reverse the second half
     * 3. Reorder one by one
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);
        // step 3. merge the two halves
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // return the head of reversed list
        return prev;
    }

    // 1 -> 2 -> 3
    // 6 -> 5 -> 4
    // merge:
    // 1  2  3
    // | /| /|
    // 6  5  4
    void merge(ListNode curr1, ListNode curr2) {
        while (curr1 != null) {
            ListNode next1 = curr1.next, next2 = curr2.next;
            curr1.next = curr2;
            if (next1 == null)
                break;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }
}
