package Math;

/**
 * @Number: #7.Reverse Integer
 * @Descpription: Given a 32-bit signed integer, reverse digits of an integer.
 * @Author: Created by xucheng.
 */
public class ReverseInteger {
    /**
     * Case1: The last digit is 0
     * Case2: might overflow. eg. 32-bit signed integer, the reverse of 1000000003 overflows range: [-2^31 , (2^31-1)]
     * @param n
     * @return
     */
//    public int reverse(int n) {
//        int reversed_n = 0;
//        while (n != 0) {
//            int temp = reversed_n * 10 + n % 10;
//            n = n / 10;
//            // handle overflow
//            if (temp / 10 != reversed_n) {
//                reversed_n = 0;
//                break;
//            }
//            reversed_n = temp;
//        }
//        return reversed_n;
//    }

    /**
     * We want to repeatedly "pop" the last digit off of xx and "push" it to the back of the \text{rev}rev.
     * In the end, \text{rev}rev will be the reverse of the xx.
     * To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.
     * pop operation: pop = x % 10; x /= 10;
     * push operation: temp = rev * 10 + pop; rev = temp;
     * @param n
     * @return
     */
    public int reverse(int n) {
        long reversedN = 0;
        while (n != 0) {
            reversedN  = reversedN * 10 + n % 10;
            n /= 10;
            // handle overflow
            if (reversedN > Integer.MAX_VALUE || reversedN < Integer.MIN_VALUE)
                return 0;
        }
        return (int)reversedN;
    }
}
