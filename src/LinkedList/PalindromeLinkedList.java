package LinkedList;

/**
 * @Number: #234. Palindrome Linked List
 * @Descpription: Given a singly linked list, determine if it is a palindrome.
 * @Author: Created by xucheng.
 */
public class PalindromeLinkedList {
    /**
     * recursive:
     * 1. find the middle and the end
     * 2. reverse the second half
     * 3. compare two halves
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // slow finds the middle fast finds the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // for odd nodes, make the right half smaller
        if (fast != null)
            slow = slow.next;

        // reverse the second half
        slow = reverse(slow);
        // another half
        fast = head;

        // compare
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTmp = head.next;
            head.next = prev;
            prev = head;
            head = nextTmp;
        }
        return prev;
    }
}
