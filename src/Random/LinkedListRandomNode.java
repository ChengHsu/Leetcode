package Random;


import LinkedList.ListNode;

import java.util.Random;

/**
 * @Number: #382. Linked List Random Node
 * @Descpription: Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * @Author: Created by xucheng.
 */
public class LinkedListRandomNode {

    /**
     * https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
     * problem:
     * Choose k entries from n numbers. Make sure each number is selected with the probability of k/n
     * basic idea:
     * 1. Choose 1,2,3,..,k first and put them into the reservoir.
     * 2. For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
     * 3. For k+i, pick it with a probability of k/(k+i), and randomly rep
     * 4. Repeat until k+i reaches n
     * Proof:
     * For k+i, the probability that it is selected and will replace a number in the reservoir is k/(k+i)
     * For a number in the reservoir before (let's say X), the probability that it keeps staying in the reservoir is
     * P(X was in the reservoir last time) × P(X is not replaced by k+i)
     * = P(X was in the reservoir last time) × (1 - P(k+i is selected and replaces X))
     * = k/(k+i-1) × （1 - k/(k+i) × 1/k）
     * = k/(k+i)
     * When k+i reaches n, the probability of each number staying in the reservoir is k/n
     * Example
     * Choose 3 numbers from [111, 222, 333, 444]. Make sure each number is selected with a probability of 3/4
     * First, choose [111, 222, 333] as the initial reservior
     * Then choose 444 with a probability of 3/4
     * For 111, it stays with a probability of
     * P(444 is not selected) + P(444 is selected but it replaces 222 or 333)
     * = 1/4 + 3/4*2/3
     * = 3/4
     * The same case with 222 and 333
     * Now all the numbers have the probability of 3/4 to be picked
     *
     * 当链表长度为1时，random.randint(0, 0)恒等于0，因此抽到第1个元素的概率为1
     * 假设抽取前n个元素的概率相等，均为1/n
     * 当抽取第n+1个元素时：
     * 若random.randint(0, n)等于0，则返回值替换为第n+1个元素，其概率为1/(n+1)；
     * 否则，抽取的依然是前n个元素，其概率为1/n * n/(n+1) = 1/(n+1)
     */

    //先让返回值res等于head的节点值，然后让cur指向head的下一个节点，若cur不为空我们开始循环，我们在[0, i - 1]中取一个随机数，
    // 如果取出来0，那么我们更新res为当前的cur的节点值，然后此时i自增一，cur指向其下一个位置，
    // 这里其实相当于我们维护了一个大小为1的水塘，然后我们随机数生成为0的话，我们交换水塘中的值和当前遍历到的值，这样可以保证每个数字的概率相等
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

//    ListNode head;
//    Random random;
//
//    public LinkedListRandomNode(ListNode head) {
//        this.head = head;
//        random = new Random();
//    }
//
//    /** Returns a random node's value. */
//    public int getRandom() {
//        ListNode result = head;
//        ListNode cur = head;
//        int size = 1;
//        while (cur != null) {
//            if (random.nextInt(size) == 0){
//                result = cur;
//            }
//            size++;
//            cur = cur.next;
//        }
//        return result.val;
//    }
}
