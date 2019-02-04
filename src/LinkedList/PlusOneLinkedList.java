package LinkedList;

/**
 * @Number: #369. Plus One Linked List
 * @Descpription: Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @Author: Created by xucheng.
 */
public class PlusOneLinkedList {
    /**
     * Recursive: in order to add value reversely, use recursive
     *
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        // 最高位进位为0，直接返回head
        if (dfs(head) == 0)
            return head;
        // 否则再加一位最高位
        else {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            return dummy;
        }
    }

    private int dfs(ListNode head) {
        // 最后一位加1，return 1
        if (head == null) return 1;
        int carry = dfs(head.next);
        if (carry == 0 )
            return 0;
        int val =  head.val + carry;
        head.val = val % 10;
        return val/ 10;
    }
}
