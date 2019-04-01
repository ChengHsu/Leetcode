package Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Number: #528. Random Pick with Weight
 * @Descpription: Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 * @Author: Created by xucheng.
 */
public class RandomPickWithWeight {

    /**
     * Prefix Sum and Binary Search
     * for some index i, all integers v between prefixSum[i]-w[i] and prefixSum[i] map to this index
     * so the larger the value of weight, the more possible its corresponding index will be picked
     */
    List<Integer> prefixSum;
    int sum;
    Random rand;

    /**
     * calculate prefix sum
     * time: O(N)
     *
     * @param w
     */
    public RandomPickWithWeight(int[] w) {
        prefixSum = new ArrayList<>();
        sum = 0;
        rand = new Random();
        for (int x : w) {
            sum += x;
            prefixSum.add(sum);
        }
    }

    /**
     * Find the index x where x is the lowest index such that target < prefixSum[x]
     * time: O(log N)
     *
     * @return
     */
    public int pickIndex() {
        int target = rand.nextInt(sum);

        int low = 0;
        int high = prefixSum.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target >= prefixSum.get(mid))
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
