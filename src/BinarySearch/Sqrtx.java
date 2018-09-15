package BinarySearch;

/**
 * @Number: #69. Sqrt(x)
 * @Descpription: Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * @Author: Created by xucheng.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x>0 && x < 4) return 1;
        int low = 1;
        int high = x / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x / mid == mid) return mid;
            else if (x / mid > mid) low = mid + 1;
            else if (x / mid < mid) high = mid - 1;
        }
        return high;
    }
}
