package Math;

/**
 * @Number: 69.Sqrt(x)
 * @Descpription: Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * @Author: Created by xucheng.
 */
public class Sqrt {
    /**
     * Brute Force
     * Time: O(sqrt(x)) (做sqrt(x)+1次循环)
     * @param x
     * @return
     */
    public int mySqrt_BF(int x) {
        // Edge case
        if (x <= 1)
            return x;
        for (long s = 1; s <= x; s++) {
            if (s * s > x)
                return (int)(s - 1);
        }
        return -1;
    }

    /**
     * Binary Search
     * @param x
     * @return
     */
    public int mySqrt_BS(int x) {
        // Edge case
        if (x <= 1)
            return x;

       int l = 1;
       int r = x;
       while (l <= r) {
           int m = ( l + r) / 2;
           // 当前 m^2 > x, discard the right half
           if (m > x / m)
               r = m - 1;
           // otherwise discard the left half
           else l = m + 1;
       }
       return r;
    }
}
