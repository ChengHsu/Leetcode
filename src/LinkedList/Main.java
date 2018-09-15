package LinkedList;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

//        System.out.println(listNode.val+"->"+listNode.next.val+"->"+listNode.next.next.val);
//        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        listNode = reverseLinkedList.reverseList(listNode);
//        System.out.println(listNode.val+"->"+listNode.next.val+"->"+listNode.next.next.val);
//        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
//        listNode = removeLinkedListElements.removeElements(listNode,3);
//        System.out.println(listNode.val+"->"+listNode.next.val);
//        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
//        listNode = removeDuplicatesFromSortedList.deleteDuplicates(listNode);
//        System.out.println(listNode.val+"->"+listNode.next.val+"->"+listNode.next.next.val);
//        MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
//        System.out.println(middleOfTheLinkedList.middleNode(listNode).val);
//        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
//        deleteNodeInALinkedList.deleteNode(listNode1);
//        System.out.println(listNode.val+"->"+listNode.next.val+"->"+listNode.next.next.val);
//        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
//        ListNode head = mergeTwoSortedLists.mergeTwoLists(listNode,listNode3);
//        ListNode curr = head;
//        while (curr.next != null) {
//           System.out.println(curr.val);
//           curr = curr.next;
//       }
//        System.out.println(curr.val);
    }
}