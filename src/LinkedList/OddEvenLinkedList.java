package LinkedList;

/**
 * @Number: #328. Odd Even Linked List
 * @Descpription: Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * The first node is considered odd, the second node even and so on ...
 * @Author: Created by xucheng.
 */
public class OddEvenLinkedList {
    /**
     * intuitive solution:
     * record the head of even list for later use: evenHead
     * put odd nodes in the linkedlist that starts with odd node
     * put the even nodes in the linkedlist that starts with even node
     * point the last node of odd list to evenHead to make a whole list
     * Time: O(n)
     * Space: O(1). All we need is 4 pointers
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // edge case
        if (head == null)
            return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
