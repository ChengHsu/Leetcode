package Matrix;

/**
 * @Number: #370. Range Addition
 * @Descpription: Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex]
 * (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * @Author: Created by xucheng.
 */
public class RangeAddition {
    /**
     * naive
     * time: O(n * k)
     * space: O(1)
     * @param length
     * @param updates
     * @return
     */
//    public int[] getModifiedArray(int length, int[][] updates) {
//        // edge case
//        if (length < 1)
//            return new int[0];
//
//        int[] arr = new int[length];
//
//        for (int i = 0; i < updates.length; i++) {
//            int startIdx = updates[i][0];
//            int endIdx = updates[i][1];
//            int inc = updates[i][2];
//            for (int j = startIdx; j <= endIdx; j++) {
//                arr[j] += inc;
//            }
//        }
//        return arr;
//    }


    /**
     * range caching
     * https://leetcode.com/problems/range-addition/discuss/84225/Detailed-explanation-if-you-don't-understand-especially-%22put-negative-inc-at-endIndex%2B1%22
     * if you have only one update operation, suppose input is (n = 5, updates = { {1, 3, 2} }), what does the O(n + k) solution do?
     * Initialize the result array as length of n + 1, because we will operate on endIndex + 1:
     * result = [0, 0, 0, 0, 0, 0]
     * Then marks index 1 as 2 and marks index 3+1 as -2:
     * result = [0, 2, 0, 0, -2, 0]
     * Next, iterate through result, and accumulates previous sum to current position
     * result = [0, 0 + 2, 0 + 2, 0 + 2, 2 + (-2), 0] = [0, 2, 2, 2, 0, 0]
     * Finally, trivial work to discard the last element because we don't need it:
     * result = [0, 2, 2, 2, 0], which is the final result.
     * time: O(n + k)
     * space: O(1)
     *
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // edge case
        if (length < 1)
            return new int[0];

        int[] arr = new int[length];
        // O(k) mark
        for (int i = 0; i < updates.length; i++) {
            int startIdx = updates[i][0];
            int endIdx = updates[i][1];
            int inc = updates[i][2];

            arr[startIdx] += inc;
            if (endIdx < length - 1)
                arr[endIdx + 1] -= inc;
        }

        // O(n) every independent "mark" + "sum" operation can be divided into all "mark" operations firstly
        // and all "sum" operations at last
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
    }

}
