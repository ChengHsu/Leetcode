package LinkedList;

/**
 * @Number: #2. Add Two Numbers
 * @Descpription: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @Author: Created by xucheng.
 */
public class AddTwoNumbers {
    /**
     * Intuition
     * Time:  O(max(m,n)).
     * Space: O(max(m,n)).  The length of the new list is at most max(m,n)+1
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            // Create a new node with the digit value of (sum % 10) and set it to current node's next, then advance current node to next.
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // advance both p and q
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //Check if carry = 1, if so append a new node with digit 1 to the returning list
        if (carry > 0)
            curr.next = new ListNode(1);
        return dummy.next;
    }
}
