package LinkedList;

/**
 * @Number: #148. Sort List
 * @Descpription: Sort a linked list in O(n log n) time using constant space complexity.
 * @Author: Created by xucheng.
 */
public class SortList {
    /**
     * https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
     * Merge sort
     * Time: O(n log n)
     * Space: O(1)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1. cut the list to 2 halves
        // prev is the tail of 1st half
        // slow is the head of 2nd half
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 3. merge l1 and l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // always point to the smaller one
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // point to the rest of the longer list
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;

        return dummy.next;
    }
}
