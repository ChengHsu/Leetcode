package Random;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #138. Copy List with Random Pointer
 * @Descpription: A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * regular copy:
 * ListNode a = new ListNode(1);
 * ListNode b = a;
 * a -> 1 <- b
 * deep copy:
 * ListNode a = new ListNode(1);
 * ListNode b = new ListNode(1);
 * a -> 1
 * b -> 1
 * @Author: Created by xucheng.
 */
public class CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    /**
     * https://www.youtube.com/watch?v=kGfsMookkzw
     * time: O(n)
     * space: O(n)
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode dummy = new RandomListNode(0);

        RandomListNode cur = dummy; // points to new list

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (head != null) {
            // copy the current node
            if (!map.containsKey(head))
                map.put(head, new RandomListNode(head.label));

            // connect the copied node to the deep copy list
            cur.next = map.get(head);

            // copy the random node that it points to
            if (head.random != null) {
                // if this node haven't been copied, copy this node first
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                // connect the copied node to the random pointer
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
