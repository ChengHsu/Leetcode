package Yext;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class BlowUpMineField {

    static int[][] mine;
    static int N;
    static void init() {
        N = 3;
//      test cases:
//        mine = new int[][] {
//                {0, 0, 0},
//                {1, 1, 0},
//                {0, 1, 0},
//        };
//        mine = new int[][] {
//                {0, 0, 0},
//                {1, 0, 0},
//                {0, 1, 0}
//        };
        mine = new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
    }

    static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int res;
    static int numOfDestroyedFields(int[][] mine, int N, int rowIndex, int colIndex) {
        if(mine == null || mine.length == 0 || mine[0] == null || mine[0].length == 0) return 0;
        boolean[][] visited = new boolean[N][N];
        res = mine[rowIndex][colIndex] == 1 ? 1: 0;
        dfs(mine, visited, N , rowIndex, colIndex);
        return res;
    }

    static void dfs(int[][] mine, boolean[][] visited, int N, int rowIndex, int colIndex) {
        if(rowIndex < 0 || rowIndex >= N || colIndex < 0 || colIndex >= N || visited[rowIndex][colIndex])
            return;
        visited[rowIndex][colIndex] = true;
        if(mine[rowIndex][colIndex] == 0)
            res++;
        else {
            for(int[] dir: dirs) {
                int nRowIdx = rowIndex + dir[0];
                int nColIdx = colIndex + dir[1];
                dfs(mine, visited, N, nRowIdx, nColIdx);
            }
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(numOfDestroyedFields(mine, N, 1,1));
    }
}
