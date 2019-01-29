package DynamicProgramming;

/**
 * @Number: All Possible Paths from Top-left to Bottom-right of 2D Array
 * @Descpription: The problem is to count all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 * <<Elements of Programming >> Page 70
 * @Author: Created by xucheng.
 */
public class AllPathsFromTopLeftToBottomRightOf2DArray {
    /**
     * Iterative
     *
     * @param m
     * @param n
     * @return
     */
    public static int numberOfWays_iterative(int m, int n) {
        int[][] numberOfWays = new int[m][n];
        for (int i = 0; i < n; i++)
            numberOfWays[i][0] = 1;

        for (int j = 0; j < m; j++)
            numberOfWays[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                numberOfWays[i][j] = numberOfWays[i - 1][j] + numberOfWays[i][j - 1];
            }
        }
        return numberOfWays[m - 1][n - 1];
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

}
