package Array;

/**
 * @Number: #55. Jump Game
 * @Descpription: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * # 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * @Author: Created by xucheng.
 */


enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {

    Index[] memo;

    /**
     * # 55
     * Dynamic Programming - Top-down
     * @param nums
     * @return
     */
    public boolean canJump_TopDown(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        System.out.println("Pos: "+position);
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        System.out.println("Fur Jump: "+furthestJump);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            System.out.println("Next Pos: "+ nextPosition);
            if (canJumpFromPosition(nextPosition, nums)) {
                System.out.println("position: "+position+" Good");
                memo[position] = Index.GOOD;
                return true;
            }
        }
        System.out.println("position: "+position+" Bad");
        memo[position] = Index.BAD;
        return false;
    }


    /**
     * Dynamic Programming - Bottom-Up
     * Time: O(n^2)
     * @param nums
     * @return
     */
    public boolean canJump_BottomUp(int[] nums) {
        Index[] memo = new Index[nums.length];

        // Initially, all elements of the memo table are UNKNOWN,
        // except for the last one, which is (trivially) GOOD (it can reach itself)
        for (int i = 0; i < nums.length; i++)
            memo[i] = Index.UNKNOWN;
        memo[nums.length - 1] = Index.GOOD;

        // Start from the end, every time we query a position to the right of the current position,
        // that position has already be determined as being GOOD or BAD and be stored in the memo
        // This means we don't need to recurse anymore, as we will always hit the memo table.
        for (int i = nums.length - 2; i >= 0; i--) {
            int furtherJump = Math.min( i + nums[i], nums.length-1);
            for (int j = i + 1; j <= furtherJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    /**
     * Dynamic Programming - Greedy
     * Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index
     * (currPosition + nums[currPosition] >= leftmostGoodIndex).
     * If we can reach a GOOD index, then our position is itself GOOD.
     * Also, this new GOOD position will be the new leftmost GOOD index.
     * Iteration continues until the beginning of the array.
     * If first position is a GOOD index then we can reach the last index from the first position.
     * Time: O(n)
     * @param nums
     * @return
     */
    public boolean canJump_greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            if (i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }


    /**
     * # 45
     * 确定当前最远能覆盖的节点，放入curr。然后继续扫描，直到当前的路程超过了上一次算出的覆盖范围，那么更新覆盖范围，同时更新步数
     * https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // Edge case
        if (nums == null || nums.length < 2)
            return 0;

        int res = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = curr;
                res++;
            }
            curr = Math.max(curr,i + nums[i]);
        }
        return res;
    }

    /**
     * https://www.jiuzhang.com/solution/jump-game-ii/
     * @param nums
     * @return
     */
    public int jump2(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}
