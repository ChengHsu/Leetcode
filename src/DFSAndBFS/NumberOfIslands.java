package DFSAndBFS;

/**
 * @Number: #200. Number of Islands
 * @Descpription:Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * @Author: Created by xucheng.
 */
public class NumberOfIslands {

    /**
     * DFS
     * @param grid
     * @return
     */
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
//            return 0;
//
//        int rowLen = grid.length;
//        int colLen = grid[0].length;
//        int nums = 0;
//
//        for (int i = 0; i < rowLen; i++) {
//            for (int j = 0; j < colLen; j++) {
//                if (grid[i][j] == '1') {
//                    nums++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return nums;
//    }
//
//    private void dfs(char[][] grid, int row, int col) {
//        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
//            return;
//
//        grid[row][col] = '0';
//        dfs(grid, row - 1, col);
//        dfs(grid, row + 1, col);
//        dfs(grid, row, col - 1);
//        dfs(grid, row, col + 1);
//    }


    /**
     * Union Find
     * find the number of connected components
     *
     * @param
     * @return
     */

    class UnionFindSet {
        int[] parents;
        int[] sizes;
        int nums;  // # of connected components

        public UnionFindSet(char[][] grid) {
            int rowLen = grid.length;
            int colLen = grid[0].length;
            parents = new int[rowLen * colLen];
            sizes = new int[rowLen * colLen];

            int count = 0;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * colLen + j] = i * colLen + j;
                        nums++;
                    }
                    sizes[i * colLen + j] = 0;
                }
            }
        }


        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return;

            if (sizes[rootV] > sizes[rootU])
                parents[rootU] = rootV;
            else if (sizes[rootV] < sizes[rootU])
                parents[rootV] = rootU;
            else {
                parents[rootV] = rootU;
                sizes[rootU] += 1;
            }

            // after union, nums of components - 1
            nums--;
        }

        private int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        public int getNums() {
            return nums;
        }
    }


    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        UnionFindSet ufs = new UnionFindSet(grid);
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1')
                        ufs.union(i * colLen + j, (i - 1) * colLen + j);
                    if (i + 1 < rowLen && grid[i + 1][j] == '1')
                        ufs.union(i * colLen + j, (i + 1) * colLen + j);
                    if (j - 1 >= 0 && grid[i][j - 1] == '1')
                        ufs.union(i * colLen + j, i * colLen + (j - 1));
                    if (j + 1 < colLen && grid[i][j + 1] == '1')
                        ufs.union(i * colLen + j, i * colLen + (j + 1));
                }
            }
        }
        return ufs.getNums();
    }
}
