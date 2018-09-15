package LinkedList;

import java.util.HashSet;

/**
 * @Number: #83.Remove Duplicate From Sorted List
 * @Descpription: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @Author: Created by xucheng.
 */
public class RemoveDuplicatesFromSortedList {
    // To submit
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}
