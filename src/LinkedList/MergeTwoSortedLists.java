package LinkedList;

/**
 * @Number: #21. Merge Two Sorted Lists
 * @Descpription: Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @Author: Created by xucheng.
 */
public class MergeTwoSortedLists {
    // Recursion
    // Again
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
