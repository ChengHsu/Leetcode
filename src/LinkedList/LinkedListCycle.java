package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Number:
 * #141. Linked List Cycle
 * @Descpription: Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * #142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * @Author: Created by xucheng.
 */
public class LinkedListCycle {

    /**
     * HastSet: 如果添加了重复的node说明有cycle
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @return
     */
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<>();
//        ListNode curr = head;
//        while (curr != null) {
//            if (seen.contains(curr))
//                return true;
//            seen.add(curr);
//            curr = curr.next;
//        }
//        return false;
//    }


    /**
     * Floyd's cycle detection
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // find the meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 142.Floyd's cycle detection
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        // find the meeting point
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        // find the start of the cycle
        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else return null;
    }

}
