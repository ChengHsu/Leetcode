package Array;

import java.util.Arrays;

/**
 * @Number: #274. H-Index
 * @Descpription: Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * #275. H-Index II
 *  Same solution with I
 * @Author: Created by xucheng.
 */
public class HIndex {
    /**
     * h-index: find h numbers in the array, each one >= h and (N-h) numbers in the array, each one <= h
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        // 遍历,从后往前(从大往小)取值 bc we were supposed to make a descending order
        // Descending Order: if citations[i]>i, then papers 0 to i all have at least i + 1 citations
        // Ascending Order: if citations[citations.length - 1 - i] > i, then papers citations.length - 1 to citations.length - 1 - i
        // all have at least i+1 citations.
        for (; i < citations.length; i++) {
            if (citations[citations.length - 1 - i] > i)
                continue;
            else break;
        }
        return i;
    }

}
