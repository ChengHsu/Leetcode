package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Number: #354. Russian Doll Envelopes
 * @Descpription: You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * @Author: Created by xucheng.
 */
public class RussianDollEnvelopes {
    /**
     * DP
     * https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
     * Sort the array. Ascend on width and descend on height if width are same.
     * Find the longest increasing subsequence based on height.
     * Since the width is increasing, we only need to consider height.
     * [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
     * time: O(nlog n)
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope: envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0)
                index = - (index + 1);
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
}
