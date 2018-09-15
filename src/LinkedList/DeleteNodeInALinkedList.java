package LinkedList;

/**
 * @Number: #237. Delete Node in a Linked List
 * @Descpription: Write a function to delete a node(except the tail) in a singly linked list, given only access to that node.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and will always be a valid node of the linked list.
 * @Author: Created by xucheng.
 */
public class DeleteNodeInALinkedList {
    // Given the reference of previous node:
    // Modify the next pointer if the previous node to point to the node after the current node.
    // Without the reference of the previous node:
    // Replace the given node with the following node and make the next pointer of given node to point to the next
    // of next of given node. ( = make given node the next node, then delete the next node)
    // Because the given node is always a valid node instead of the tail, this method will work.
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
