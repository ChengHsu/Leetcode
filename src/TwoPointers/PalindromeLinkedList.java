package TwoPointers;

import java.util.Stack;

/**
 * @Number: #234. Palindrome Linked List
 * @Descpription: Given a singly linked list, determine if it is a palindrome.
 * 链表不能根据坐标来访问，只能从头开始遍历。判断回文需要找到链表的中点，需用快慢指针实现。
 * 设置fast和slow两个指针，slow走一步，fast走两步。fast走到终点时，slow的位置就是中点位置。
 * 每次slow走的时候将值存入栈中，等达到中点时，链表的前半段都存入栈中了，由于栈后进先出，
 * 可以和后半段链表比较是否一致。
 * @Author: Created by xucheng.
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        if (fast == null || fast.next == null)//0个节点或是1个节点
            return true;

        stack.push(slow);
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow);
        }
        if (fast.next != null)//链表长度为偶数
            slow = slow.next;

        ListNode cur = slow;
        while (cur != null) {
            if (cur.val != stack.pop().val)
                return false;
            cur = cur.next;
        }
        return true;

    }
}


