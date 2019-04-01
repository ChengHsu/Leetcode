package SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #904. Fruit Into Baskets
 * @Descpription: In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 * @Author: Created by xucheng.
 */
public class FruitIntoBaskets {
    /**
     * Sliding Window
     * Find out the longest length of subarrays with at most 2 different numbers
     * HashMap:<fruit, index>
     *  maintain two pointers, one points to the beginning of window, the other points to the end
     *  keep iterating using the end pointer, when the size of window > 2, remove the smallest idx
     * time: O(n)
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0)
            return 0;

        int start = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < tree.length; end++) {
            // keep tracking the last Index of each fruit
            map.put(tree[end], end);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                start = minIndex + 1;
            }
            // keep tracking the max len
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
