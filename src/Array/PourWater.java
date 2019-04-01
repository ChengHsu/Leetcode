package Array;

/**
 * @Number: #755. Pour Water
 * @Descpription: We are given an elevation map, heights[i] representing the height of the terrain at that index.
 * The width at each index is 1. After V units of water fall at index K, how much water is at each index?
 * Water first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:
 * If the droplet would eventually fall by moving left, then move left.
 * Otherwise, if the droplet would eventually fall by moving right, then move right.
 * Otherwise, rise at it's current position.
 * Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction.
 * Also, "level" means the height of the terrain plus any water in that column.
 * We can assume there's infinitely high terrain on the two sides out of bounds of the array.
 * Also, there could not be partial water being spread out evenly on more than 1 grid block - each unit of water has to be in exactly one block.
 * @Author: Created by xucheng.
 */
public class PourWater {
    /**
     * https://www.youtube.com/watch?v=sgDdhNTByLQ
     * Simulation
     * 共V滴水,滴落的初始位置是K,先向左走，如果可以填满一个位置(局部最低的点)，则继续下一滴;如果不能,则向右寻找局部最低点，如果都没有，则在初始位置不动
     * time: O(nK)
     * space: O(1)
     *
     * @param heights
     * @param V
     * @param K
     * @return
     */
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights.length == 0 || V == 0)
            return heights;
        // V units of water
        while (V > 0) {
            drop(heights, K);
            V--;
        }
        return heights;
    }

    private void drop(int[] heights, int k) {
        // The eventually fall position for this current unit of water, initial value is k
        int bestPos = k;
        // when d == -1, move left
        // when d == 1, move right
        for (int d = -1; d <= 1; d += 2) {
            // pointer: if d == -1, move left by 1 every time; if d == 1, move right by 1 every time
            int i = k + d;
            // if not out of bound && the heights is in descending order, keep moving forward
            while (i >= 0 && i < heights.length && heights[i] <= heights[i - d]) {
                if (heights[i] < heights[bestPos])
                    bestPos = i;
                i += d;
            }
            // if find a local optimal other than initial position, break immediately
            if (bestPos != k)
                break;
        }
        // the height of the best position that found += 1
        ++heights[bestPos];
    }
}
