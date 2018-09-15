package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * @Number: #141. Linked List Cycle
 * @Descpription: Given a linked list, determine if it has a cycle in it.
 * @Author: Created by xucheng.
 */
public class LinkedListCycle {
//  Go through each node one by one and record each node's reference in hash table.
//  If current node is null, means reached the end of list, return false
//  If current node's reference is in the hash table, return true.
//  Time: O(n)  Space: O(n)
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            }
//            else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

//   Slow pointer moves one step at a time and Fast pointer moves two steps at a time.
//   If there is no cycle, the fast one will eventually reach the end, return false
//   Else the fast one will meet the slow one, return true
//   Time: O(n) Space: O(1)
    public boolean hasCycle(ListNode head) {
       if (head == null || head.next == null)
           return false;
       ListNode slow = head;
       ListNode fast = head.next;
       while (slow != fast) {
           if (fast == null || fast.next == null)
               return false;
           slow = slow.next;
           fast = fast.next.next;
       }
       return true;
    }
}
