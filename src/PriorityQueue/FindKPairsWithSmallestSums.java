package PriorityQueue;

import java.util.*;

/**
 * @Number: #373. Find K Pairs with Smallest Sums
 * @Descpription: You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * @Author: Created by xucheng.
 */
public class FindKPairsWithSmallestSums {

    /**
     * time: O(k log K)
     */
    private class entry {
        int[] key;
        int sum;

        entry(int[] key, int sum) {
            this.key = key;
            this.sum = sum;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return res;
        // 降序排列，poll的时候留下sum较小的
        PriorityQueue<entry> pq = new PriorityQueue<>((e1, e2) -> e2.sum - e1.sum);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] key = new int[2];
                key[0] = nums1[i];
                key[1] = nums2[j];
                pq.add(new entry(key, key[0] + key[1]));
                if (pq.size() > k)
                    pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().key);
        }

        // res中entry按照sum降序排列,need to sort
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o2[0] - o1[1] - o2[1];
            }
        });
        return res;
    }
}
