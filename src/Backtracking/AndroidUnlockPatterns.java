package Backtracking;

/**
 * @Number: #351. Android Unlock Patterns
 * @Descpription: Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * @Author: Created by xucheng.
 */
public class AndroidUnlockPatterns {
    /**
     * http://www.cnblogs.com/grandyang/p/5541012.html
     * https://leetcode.com/problems/android-unlock-patterns/discuss/82463/java-dfs-solution-with-clear-explanations-and-optimization-beats-9761-12ms
     * 首先1不能直接到3，必须经过2，同理的有4到6，7到9，1到7，2到8，3到9，还有就是对角线必须经过5，例如1到9，3到7等。
     * 我们建立一个二维数组jumps，用来记录两个数字键之间是否有中间键，然后再用一个一位数组visited来记录某个键是否被访问过，
     * 然后我们用递归来解，我们先对1调用递归函数，在递归函数中，我们遍历1到9每个数字next，然后找他们之间是否有jump数字，
     * 如果next没被访问过，并且jump为0，或者jump被访问过，我们对next调用递归函数。数字1的模式个数算出来后，由于1,3,7,9是对称的，
     * 所以我们乘4即可，然后再对数字2调用递归函数，2,4,6,9也是对称的，再乘4，最后单独对5调用一次，然后把所有的加起来就是最终结果了
     * @param m
     * @param n
     * @return
     */
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        boolean[] visited = new boolean[10];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[2][8] = jump[8][2] = 5;
        jump[4][6] = jump[6][4] = 5;
        jump[1][9] = jump[9][1] = 5;
        jump[3][7] = jump[7][3] = 5;

        for (int i = m; i <= n; i++) {
            res += dfs(visited, jump, 1, i - 1) * 4;
            res += dfs(visited, jump, 2, i - 1) * 4;
            res += dfs(visited, jump, 5, i - 1);
        }
        return res;
    }

    private int dfs(boolean[] visited, int[][] jump, int curr, int remain) {
        if (remain < 0)
            return 0;
        if (remain == 0)
            return 1;
        visited[curr] = true;
        int rest = 0;
        for (int i = 1; i <=9; i++) {
            if (!visited[i] && (jump[curr][i] == 0 || visited[jump[curr][i]]))
                rest += dfs(visited, jump, i, remain- 1);
        }
        visited[curr] = false;
        return rest;
    }
}
