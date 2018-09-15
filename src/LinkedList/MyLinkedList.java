package LinkedList;

/**
 * @Number: #707. Design Linked List
 * @Descpription: Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * Implement these functions in your linked list class:get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 */
// Again
public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode head;
    public ListNode tail;
    public int len;
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        ListNode head = new ListNode(0);
        tail = head;
        len = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= len || index <= 0)
            return -1;
        ListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head.next;
        head.next = tmp;
        len++;
        return;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        tail = head;
        while (tail.next != null)
            tail = tail.next;
        ListNode tmp = new ListNode(val);
        tail.next = tmp;
        tmp.next = null;
        len++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > len) return;
        ListNode tmp = new ListNode(val);
        ListNode curr = head;
        for (int i = 0; i < index; i ++) {
            curr = curr.next;
        }
        tmp.next = curr.next;
        curr.next = tmp;
        len++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > len) return;
        ListNode curr = head;
        for (int i = 0; i < index; i ++) {
            curr = curr.next;
        }
        ListNode deleteNode = curr.next;
        curr.next = deleteNode.next;
        deleteNode.next = null;
        len--;
    }
}
