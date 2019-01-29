package Math;

import java.util.Arrays;

/**
 * @Number: 204. Count Primes
 * @Descpription: Count the number of prime numbers less than a non-negative number, n.
 * @Author: Created by xucheng.
 */
public class CountPrimes {
    /**
     * 埃拉托斯特尼筛法
     * https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
     * 1.标出序列中的第一个质数
     * 2.去掉2的倍数
     * 3.如果现在这个序列中最大数小于等于最後一個標出的質數的平方，那么剩下的序列中所有的数都是質数，否则回到第一步
     * Time: O(nloglogn)
     * Space: O(n)
     * @param n
     * @return
     */
    public int countPrimes(int n) {
       int ans = 0;
       boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < n ; i++) {
            // if not prime, skip
            if (!isPrime[i]) continue;
            ans ++;
            // mark its multiple as false
            for (int j = 2 * i; j <n; j+=i)
                isPrime[i] = false;
        }
        return ans;
    }
}
