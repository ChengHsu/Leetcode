package LinkedList;

/**
 * @Number: #203.Remove Linked List Elements
 * @Descpription: Remove all elements from a linked list of integers that have value val.
 * @Author: Created by xucheng.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode PreNode = new ListNode(0);
        PreNode.next = head;
        ListNode curr = PreNode;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return PreNode.next;
    }
}