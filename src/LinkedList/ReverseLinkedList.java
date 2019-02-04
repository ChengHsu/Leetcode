package LinkedList;

/**
 * @Number:
 * #206. Reverse Linked List
 * @Descpription: Reverse a singly linked list.
 * #92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 *  1 ≤ m ≤ n ≤ length of list.
 * @Author: Created by xucheng.
 */
public class ReverseLinkedList {
    /**
     * 206
     * While Loop:
     * 1.Store the next node as nextTemp.
     * 2.Change the current node's next pointer to point to its previous element.
     * 3.Current node becomes previous element.
     * 4.nextTemp becomes current node.
     * @param head
     * @return
     */
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


    /**
     * 92
     * recursive
     * @param head
     * @param m
     * @param n
     * @return
     */
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {
        // base case
        if (n == 1)
            return;
        // keep moving the right pointer until n = 1
        right = right.next;
        // keep moving the left pointer until reaches the proper node
        if (m > 1)
            this.left = this.left.next;
        // recursive with m and n reduced
        this.recurseAndReverse(right, m - 1, n - 1);
        // In case both the cross each other or become equal, we stop swapping left and right at this point.
        if (this.left == right || right.next == this.left)
            this.stop = true;
        // swap the node
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    /**
     * 1. find two given positions
     * 2. backtrack: swap the values of left the right nodes
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
