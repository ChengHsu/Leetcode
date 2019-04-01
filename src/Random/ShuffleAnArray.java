package Random;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Number: #384. Shuffle an Array
 * @Descpription: Shuffle a set of numbers without duplicates.
 *
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 *
 * @Author: Created by xucheng.
 */
public class ShuffleAnArray {

    private int[] original;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.original = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
       int[] arrCopy = Arrays.copyOf(original, original.length);
       for (int i = 0; i < original.length; i++) {
           // choose an index at random
           int index = random.nextInt(i+1);
           int tmp = arrCopy[index];
           arrCopy[index] = arrCopy[i];
           arrCopy[i] = tmp;
       }
       return arrCopy;
    }

}
