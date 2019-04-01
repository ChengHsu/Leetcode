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
     * bit operation
     * https://www.jiuzhang.com/solution/divide-two-integers/
     * basic idea: 利用减法, 看看被除数可以减去多少次除数.
     * optimize: 使用倍增的思想优化, 可以将减法的次数优化到对数时间复杂度.将除数左移一位(或者让它加上自己), 即得到了二倍的除数, 这时一次减法相当于减去了2个除数. 不断倍增
     * 与此同时还需要一个变量记录此时的除数是最初的除数的多少倍, 每次减法后都加到结果上即可.
     * time: O(log n)
     */
    public int divide(int dividend, int divisor) {

        if (divisor == 0)
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        if (dividend == 0)
            return 0;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        int result = 0;
        while (ldividend >= ldivisor) {
            int shift = 0;
            while (ldividend >= (ldivisor << shift)) {
                shift++;
            }
            ldividend -= ldivisor << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative ? -result : result;
    }
}
