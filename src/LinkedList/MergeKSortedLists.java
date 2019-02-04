package LinkedList;

import java.util.PriorityQueue;

/**
 * @Number: #23. Merge k Sorted Lists
 * @Descpription: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @Author: Created by xucheng.
 */
public class MergeKSortedLists {
    /**
     * Brute force
     * Time: O(nlogn). step 1:O(n) / step 2:O(nlogn) / step 3:O(n)
     * Space: O(n). Both sorting and creating new list cost O(n) space
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        // edge case
//        if (lists == null || lists.length == 0) return null;
//        // 1. traverse all the lists and collect the values of all nodes into an array
//        List<Integer> values = new ArrayList<>();
//        // count null heads, deal with special case like [[]]
//        int cnt = 0;
//        for (ListNode head: lists) {
//            if (head == null)
//            {
//                cnt++;
//                continue;
//            }
//            while (head != null) {
//                values.add(head.val);
//                head = head.next;
//            }
//        }
//        // all nulls return null
//        if (cnt == lists.length)
//            return null;
//        // 2. sort the array
//        Collections.sort(values);
//        // 3. generate a new list to extend it with the new nodes
//        ListNode head = new ListNode(values.get(0));
//        ListNode curr = head;
//        for (int i = 1;i < values.size(); i++) {
//            ListNode tmp = new ListNode(values.get(i));
//            curr.next = tmp;
//            curr = curr.next;
//        }
//        return head;
//    }

    /**
     * Divide and Conquer
     * Time: O(nlogk) k is the number of linked lists
     * Space: O(n)
     *
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        return sort(lists, 0, lists.length - 1);
//    }
//
//    private ListNode sort(ListNode[] lists, int low, int high) {
//        if (low >= high)
//            return lists[low];
//
//        // (low + high) / 2 -> may overflows
//        int mid = (high - low) / 2 + low;
//
//        ListNode l1 = sort(lists, low, mid);
//        ListNode l2 = sort(lists, mid + 1, high);
//        return merge(l1, l2);
//    }
//
//    private ListNode merge(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val < l2.val) {
//            l1.next = merge(l1.next, l2);
//            return l1;
//        }
//        else {
//            l2.next = merge(l1, l2.next);
//            return l2;
//        }
//    }


    /**
     * Priority Queue
     * eg. Input:
     *      1 2 3
     *      7 8 9
     *      4 5
     * Time: O(nlogk)
     * Space: O(n)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // overwrite compare function
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);
        }
        // so far:
        // 1 2 3
        // 4 5
        // 7 8 9
        while (!queue.isEmpty()) {
            // link one node in one list every time
            // eg. 1st time: 1 is polled
            // 0 -> 1
            curr.next = queue.poll();
            curr = curr.next;
            // if there are other nodes after 1, in this case is : 2 3
            // put them back
            if (curr.next != null)
                queue.add(curr.next);
        }
        return dummy.next;
    }
}
