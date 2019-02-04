package LinkedList;

/**
 * @Number: #25. Reverse Nodes in k-Group
 * @Descpription: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * @Author: Created by xucheng.
 */
public class ReverseNodesInKGroup {
    /**
     * Recursive
     * input:
     * 1   2   3   4   5
     *       curr
     *        3   4   5
     *               curr
     *                5   null
     *                    curr
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // edge case
        if (head == null || head.next == null) return head;

        int count = 0;
        ListNode curr = head;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        // 1   2   3   4   5
        //       curr
        if (count == k) {
            curr = reverseKGroup(curr, k);
            // reverse
            while (count -- > 0){
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
