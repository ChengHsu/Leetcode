package InterviewPrep.MSSuzhou;

import LinkedList.ListNode;

import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Given a linked list which is sorted based on absolute values. Sort the list based on actual values.
 * @Author: Created by xucheng.
 */
public class SortAbsOrderedLinkedList {
    //         p  c
    //  1 -2 3 4 -5
//     -2  1 3 4 -5
//     -5 -2 1 3  4
    //  h         c
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
//          if curr < prev,then it must be moved to the head
            if (curr.val < prev.val) {
                // disconnect curr from linkedlist
                prev.next = curr.next;
                // move curr to head
                curr.next = head;
                head = curr;
                // update the curr
                curr = prev;
            }
            else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(-2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(-5);
        n3.next = n4;

        SortAbsOrderedLinkedList sortAbsOrderedLinkedList = new SortAbsOrderedLinkedList();
        head = sortAbsOrderedLinkedList.sortList(head);
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
    }
}
