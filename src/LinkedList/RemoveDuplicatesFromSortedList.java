package LinkedList;

/**
 * @Number:
 * #83.Remove Duplicate From Sorted List
 * @Descpription: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * #82. Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * @Author: Created by xucheng.
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * 83. Intuitive solution
     * @param head
     * @return
     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null)
//            return null;
//
//        ListNode curr = head;
//        while (curr != null && curr.next != null) {
//            // if current one equals to next one, delete the next one
//            if (curr.val == curr.next.val) {
//                curr.next = curr.next.next;
//            }
//            // otherwise, move forward by one node
//            else curr = curr.next;
//        }
//        return head;
//    }

    /**
     * 82. TLE solution:
     * External loop: searching for duplicates
     * Internal loop: find the end of current duplicate sequence
     * Make the prev of start node of current duplicate sequence point to the next node of the last node of current duplicate sequence
     * prev updating: when meet with a distinct node, update the prev node
     * @param head
     * @return
     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null)
//            return null;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prev = dummy;
//        ListNode curr = head;
//        while (curr != null && curr.next != null) {
//            if (curr.val == curr.next.val) {
//                while (curr.val == curr.next.val)
//                    curr = curr.next;
//                curr = curr.next;
//                prev.next = curr;
//            }
//            else prev = curr;
//        }
//        return dummy.next;
//    }

    /**
     * 82. Accepted solution: similar idea
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            // find the end of current duplicate sequence
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // distinct node, didn't enter the above loop, update the prev node
            if (prev.next == curr)
                prev = prev.next;
            // duplicate, Make the prev of start node of the duplicate sequence point to the next node of the end of the duplicate sequence
            else
                prev.next = curr.next;
            // move forward curr pointer to the start of the rest nodes
            curr = curr.next;
        }
        return dummy.next;
    }
}
