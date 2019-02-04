package LinkedList;

/**
 * @Number: #21. Merge Two Sorted Lists
 * @Descpription: Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @Author: Created by xucheng.
 */
public class MergeTwoSortedLists {

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/solution/
     * Recursion
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            System.out.println("l1: "+l1.val);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            System.out.println("l2: "+l2.val);
            return l2;
        }
    }
}
