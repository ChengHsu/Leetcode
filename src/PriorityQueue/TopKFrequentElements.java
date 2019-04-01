package PriorityQueue;

import java.util.*;

/**
 * @Number: #347. Top K Frequent Elements
 * @Descpription: Given a non-empty array of integers, return the k most frequent elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @Author: Created by xucheng.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < k)
            return list;

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Integer, Integer> map = new HashMap<>();

        // store every num and its freq into HashMap
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // Add all entries into priority queue
        pq.addAll(map.entrySet());
        // add first k elements in list and return
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
