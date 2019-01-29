package Math;

/**
 * @Number: 50. Pow(x, n)
 * @Descpription: Implement pow(x, n), which calculates x raised to the power n (xn).
 * @Author: Created by xucheng.
 */
public class Pow {
    /**
     * Brute Force: multiply x for n times
     * Note: n < 0, substitute x with 1/x, n with -n
     * Time: O(n)
     * Space: O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow_BF(double x, int n) {
        // edge case
        if (n == 0)
            return (double) 1;
        if (n == 1)
            return x;

        long N = n;
        if (N < 0) {
            x = (double) 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans *= x;
        }
        return ans;
    }


    /**
     * Fast Power Algorithm Recursive
     * Assume we have got the result of x ^ {n / 2}, and now we want to get the result of x ^ n.
     * Let A be result of x ^ {n / 2}, we can talk about x ^ n based on the parity of n respectively.
     * If n is even, we can use the formula (x ^ n) ^ 2 = x ^ {2 * n} to get x ^ n = A * A
     * If n is odd, then A * A = x ^ {n - 1}. Intuitively, We need to multiply another xto the result, so 
     * x ^ n = A * A * x
     * Time:  O(log(n))
     * Space: O(log(n)) For each computation, we need to store the result of x ^ {n / 2}
     * @param x
     * @param n
     * @return
     */
    public double myPow_FP(double x, int n) {
      long N = n;
        if (N < 0) {
            x = (double) 1 / x;
            N = -N;
        }
        return fastPow(x,N);
    }

    private double fastPow(double x, long n) {
//        ??? 为啥不能写成:
//        if(n == 1)
//            return x;
        if (n == 0)
            return 1.0;
        double half = fastPow(x, n /2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    /**
     * Fast Power Algorithm Iterative
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            System.out.println(i);
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
            System.out.println("P: "+current_product);
        }
        return ans;
    }

}
