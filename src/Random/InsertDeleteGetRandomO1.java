package Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @Number: #380. Insert Delete GetRandom O(1)
 * @Descpription: Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 * @Author: Created by xucheng.
 */
public class InsertDeleteGetRandomO1 {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (locs.containsKey(val))
            return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!locs.containsKey(val))
            return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1) {
            // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
