package Math;

/**
 * @Number: 29. Divide Two Integers
 * @Descpription: Given two integers dividend and divisor,
 * divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * @Author: Created by xucheng.
 */
public class DivideTwoIntegers {
    /**
     * https://www.youtube.com/watch?v=2bNV08KroqQ
     * Several cases needs to be considered:
     * 1. + - : int sign
     * 2. Overflow : use long
     * 3.  = 0
     *
     * Time: O(lgn)
     * Space: O(lgn)
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.

        // case 1
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        // case 2
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long) divisor);

        // case 3
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor) return 0;

        long lans = ldivide(ldividend,ldivisor);

        if (lans > Integer.MAX_VALUE)
            return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        else return (int) (sign * lans);

    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        // if((sum + sum) < ldividend） Space: O(lgn)
        // if((sum + sum) <= ldividend) Space: < O(lgn)
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
