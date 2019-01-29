package Math;

/**
 * @Number: 367. Valid Perfect Square
 * @Descpription: Given a positive integer num,
 * write a function which returns True if num is a perfect square else False.
 * @Author: Created by xucheng.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // edge case
        if (num <= 0)
            return false;
        int low = 1, high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > num / mid)
                high = mid - 1;
            else if(mid < num / mid)
                low = mid + 1;
            else return num % mid == 0;
        }
        return false;
    }
}
