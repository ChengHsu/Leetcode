package LinkedList;

/**
 * @Number: #206. Reverse Linked List
 * @Descpription: Reverse a singly linked list.
 * @Author: Created by xucheng.
 */
public class ReverseLinkedList {
    /**
     * While Loop:
     * 1.Store the next node as nextTemp.
     * 2.Change the current node's next pointer to point to its previous element.
     * 3.Current node becomes previous element.
     * 4.nextTemp becomes current node.
     * @param head
     * @return
     */
    // To submit
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
