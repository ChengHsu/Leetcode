package LinkedList;

/**
 * @Number: #876. Middle of the Linked List
 * @Descpription: Given a non-empty,singly linked list with head node, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * @Author: Created by xucheng.
 */
public class MiddleOfTheLinkedList {

//    public ListNode middleNode(ListNode head) {
//        // Put every node into an array in order. Return the middle one.
//        ListNode[] listNodes = new ListNode[100];
//        int i = 0;
//        while (head.next != null) {
//            listNodes[i++] = head;
//            head = head.next;
//        }
//        return listNodes[(i+1)/2];
//    }

        public ListNode middleNode(ListNode head) {
        // Use fast and slow pointers. Return the slow pointer.
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
