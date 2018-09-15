package LinkedList;

import java.util.HashSet;

/**
 * @Number: #160. Intersection of Two Linked Lists
 * @Descpription: Write a program to find the node at which the intersection of two singly linked lists begins.
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure
 *
 * @Author: Created by xucheng.
 */
public class IntersectionOfTwoLinkedLists {
    // Get length of two lists and calculate lenA-lenB / lenB-lenA
    // 因为两个链表从交汇点开始到最后一定是完全相同的，所以如果两个链表不一样长，较长的链表前面多出的节点一定是多余的
    // Traverse the length of (lenA-lenB or lenB-lenA) nodes of the longer list till two lists have the same length
    // Compare the rest of longer list with the other one and find the first same node.
    // Return it.
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//       if (headA == null || headB == null)
//           return null;
//       int lenA = getLength(headA);
//       int lenB = getLength(headB);
//       if (lenA > lenB) {
//           for (int i = 0; i < lenA - lenB; i++)
//               headA = headA.next;
//       }
//       else {
//           for (int i = 0; i < lenB - lenA; i++)
//               headB = headB.next;
//       }
//       while (headA != null && headB != null && headA != headB){
//           headA = headA.next;
//           headB = headB.next;
//       }
//       return  (headA != null && headB != null)? headA : null;
//    }
//
//    public int getLength(ListNode head) {
//        int len = 0;
//        while (head != null) {
//            len ++;
//            head = head.next;
//        }
//        System.out.println(len);
//        return len;
//    }

    //Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
    //When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
    //If at any point pA meets pB, then pA/pB is the intersection node.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA != null)? pA.next : headB;
            pB = (pB != null)? pB.next : headA;
        }
        return pA;
    }

}
