package Array;

/**
 * @Number: 695. Max Area of Island
 * @Descpription: Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * @Author: Created by xucheng.
 */
public class MaxAreaofIsland {
    // DFS

    int[][] grid;
    boolean[][] seen;

    public int area(int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] == 0)
            return 0;
        seen[i][j] = true;
        return ( 1 + area(i-1, j) + area(i+1, j) + area(i, j-1) + area(i, j+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        this.grid = grid;
        int row = grid.length;
        int column = grid[0].length;
        seen = new boolean[row][column];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maxArea = Math.max(maxArea,area(i, j));
            }
        }
        return maxArea;
    }
}
