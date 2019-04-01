package PriorityQueue;

import java.util.PriorityQueue;

/**
 * @Number: #215. Kth Largest Element in an Array
 * @Descpription: Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @Author: Created by xucheng.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // edge case
        if (nums == null || nums.length < k)
            return 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            System.out.println("head: " + heap.peek());
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}
