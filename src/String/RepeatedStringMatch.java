package String;

/**
 * @Number: #686. Repeated String Match
 * @Descpription: Given two strings A and B, find the minimum number of times A has to be repeated such that B is a
 * substring of it. If no such solution, return -1.
 * @Author: Created by xucheng.
 */
public class RepeatedStringMatch {
    /**
     * Ad Hoc
     * Can not return -1 in the case that A.length >= B.length
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        // q is the least number that makes sb.length > B.length
        int q = 1;
        StringBuilder sb = new StringBuilder(A);
        for (; sb.length() < B.length(); q++) {
            sb.append(A);
        }
        if (sb.indexOf(B) >= 0) return q;
        if (sb.append(A).indexOf(B) >= 0) return q + 1;
        return -1;

    }

    /**
     * Rabin-Karp algorithm
     */
}
