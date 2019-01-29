package Array;

/**
 * @Number: #277. Find the Celebrity
 * @Descpription: Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * @Author: Created by xucheng.
 */


/**
 * Brute Force: O(n^2)
 * For each person a, go through all the other ppl b:
 *      check !knows(a,b) && check knows(b,a)
 */

/**
 * Optimized Solution: O(n)
 * 1. Find a candidate by one pass (candidate - one who is likely to be the celebrity)
 *      By comparing a pair (i,j), we r able to discard one of them (make sure one of them is not celebrity)
 *      if knows (i,j)
 *          means i knows j, then i is not the celebrity (One pass之后candidate之前的人满足此种情况)
 *      Otherwise
 *          i doesn't know j, then j is not the celebrity (One pass之后candidate之后的人满足此种情况)
 * 2. Make sure the candidate is a celebrity by one pass
 *      确定candidate是否不认识其前面的人，确定candidate后面的人是否都认识candidate
 */
public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        // Edge case
        if (n < 2)
            return -1;

        for (int i = 1; i < n ;i++) {
            if (knows(candidate,i))
                candidate = i;
        }

        for (int i = 0; i < n ; i++) {
            if (i == candidate)
                continue;
            if (!knows(i,candidate) || knows(candidate,i)) {
                return -1;
            }
        }

        return candidate;
    }

    private boolean knows(int candidate, int i) {
        return true;
    }


}
