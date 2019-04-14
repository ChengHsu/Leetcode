package DynamicProgramming;

/**
 * @Number: 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * @Descpription: TThe robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 *63. Unique Paths II
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * @Author: Created by xucheng.
 */
public class UniquePaths {
    /**
     * Iterative
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // iterative
         int[][] dp = new int[m][n];
         for (int i = 0; i < m; i++) {
             for(int j = 0; j < n; j++) {
                 if(i == 0 || j == 0)
                     dp[i][j] = 1;
                 else
                     dp[i][j] = dp[i][j-1] + dp[i-1][j];
             }
         }
         return dp[m - 1][n - 1];
    }


    /**
     * Recursive
     *
     * @param m
     * @param n
     * @return
     */
    public static int numberOfWays_recursive(int m, int n) {
        return computeNumberOfWaysToXY(m - 1, n - 1, new int[m][n]);
    }

    private static int computeNumberOfWaysToXY(int x, int y, int[][] numberOfWays) {
        System.out.println("x: " + x + " y: " + y);
        if (x == 0 || y == 0)
            return 1;
        if (numberOfWays[x][y] == 0) {
            int waysTop = x == 0 ? 0 : computeNumberOfWaysToXY(x - 1, y, numberOfWays);
            int waysLeft = y == 0 ? 0 : computeNumberOfWaysToXY(x, y - 1, numberOfWays);
            System.out.println("waysTop:" + waysTop + " waysLeft: " + waysLeft);
            numberOfWays[x][y] = waysTop + waysLeft;
        }
        return numberOfWays[x][y];
    }



    /**
     * 63
     time: O(m*n)
     space: O(1)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        // an obstacle in the 1st cell, return 0
        if(obstacleGrid[0][0] == 1)
            return 0;

        obstacleGrid[0][0] = 1;

        for(int i = 1; i < R; i++){
            // if obstacleGrid[i][0] = 1, set it to 0; otherwise set it to the value of previous one
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i-1][0];
        }

        for(int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0: obstacleGrid[0][i-1];
        }
        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                if(obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                else
                    // contains ab obstacle. set it to 0
                    obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[R-1][C-1];
    }





}
