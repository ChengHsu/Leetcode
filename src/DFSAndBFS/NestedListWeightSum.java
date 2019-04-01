package DFSAndBFS;

import java.util.List;

/**
 * @Number: #339. Nested List Weight Sum
 * @Descpription: Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * #364. Nested List Weight Sum II
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * @Author: Created by xucheng.
 */
public class NestedListWeightSum {
    /**
     * DFS
     * We go through the list of nested integers one by one, keeping track of the current depth dd. If a nested integer is an integer nn,
     * we calculate its sum as n\times dn×d. If the nested integer is a list, we calculate the sum of this list recursively using the same process but with depth d+1d+1.
     * time: O(n)
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumDFS(nestedList, 1);
    }

    private int depthSumDFS(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger())
                sum += n.getInteger() * depth;
            else
                sum += depthSumDFS(n.getList(), depth + 1);
        }
        return sum;
    }

    /**
     * 2 pass DFS
     *
     * @param nestedList
     * @return
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        return getSum(nestedList, depth);
    }

    private int getSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger())
                sum += n.getInteger() * depth;
            else
                sum += getSum(n.getList(), depth - 1);
        }
        return sum;
    }

    private int getDepth(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0)
            return 0;
        int maxLen = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger())
                maxLen = Math.max(maxLen, 1);
            else
                maxLen = Math.max(getDepth(n.getList())+ 1, maxLen);
        }
        return maxLen;
    }


}
