package BinarySearch;

/**
 * @Number: #374. Guess Number Higher or Lower
 * @Descpription: We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * @Author: Created by xucheng.
 */
public class GuessNumberHigherOrLower {
    /**
     * time: O(log n)
     * space: O(1)
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int res = guess(mid);
            if (res == 0)
                return mid;
            // mid is greater
            if (res == -1)
                high = mid - 1;
            // mid is smaller
            else
                low = mid + 1;
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
