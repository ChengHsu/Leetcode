package Matrix;

/**
 * @Number: #361. Bomb Enemy
 * @Descpription: Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 * @Author: Created by xucheng.
 */
public class BombEnemy {
    /**
     * 不能用DFS,只有放炸弹的地方需要向四个方向延伸搜索，不是这四个方向上的每一个点都向其周围四个方向再延伸搜索
     * 对于每一个0，向其所在的左半行、右半行、左半列和右半列分别搜索，统计可kill的enemy个数
     * time: O(m*n*(m+n))
     *
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {
        // edge case
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int max = 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == '0') {
                    int count = 0;
                    // to left of current row
                    if (col != 0) {
                        for (int i = col; i >= 0; i--) {
                            if (grid[row][i] == 'W')
                                break;
                            if (grid[row][i] == 'E')
                                count++;
                            else continue;
                        }
                    }
                    // to right of current row
                    if (col != colLen - 1) {
                        // to right of current row
                        for (int i = col; i < colLen; i++) {
                            if (grid[row][i] == 'W')
                                break;
                            if (grid[row][i] == 'E')
                                count++;
                            else continue;
                        }
                    }
                    // to up of current column
                    if (row != 0) {
                        for (int i = row; i >= 0; i--) {
                            if (grid[i][col] == 'W')
                                break;
                            if (grid[i][col] == 'E')
                                count++;
                            else continue;
                        }
                    }
                    // to down of current column
                    if (row != rowLen - 1) {
                        for (int i = row; i < rowLen; i++) {
                            if (grid[i][col] == 'W')
                                break;
                            if (grid[i][col] == 'E')
                                count++;
                            else continue;
                        }

                    }
                    if (count > max)
                        max = count;
                }
            }
        }
        return max;
    }
}



