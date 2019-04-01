package BitManipulation;

/**
 * @Number: #289. Game of Life
 * @Descpription: Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * Follow Up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * @Author: Created by xucheng.
 */
public class GameOfLife {
    /**
     * Bit operation:
     * Use 2 bits to store next state and current state
     * [2nd bit, 1st bit] = [next state, current state]
     * - 00 dead(next) <- dead(curr)
     * - 01 dead(next) <- live(curr)
     * - 10 live(next) <- dead(curr)
     * - 11 live(next) <- live(curr)
     * <p>
     * For every point:
     * 1. count # of neighbors from 1st state
     * 2. set 2nd state bit.
     * 3. repeat step 1 and 2 until every point is visited
     * 3. In the end, delete every cell's 1st state by >> 1 (右移1bit to shift the next state to the position of curr state)
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int liveNeighbor = liveNeighbors(board, M, N, i, j);
                // set 2nd state to 1
                if (board[i][j] == 1 && liveNeighbor >= 2 && liveNeighbor <= 3)
                    board[i][j] = 3; //  10 -> 11
                if (board[i][j] == 0 && liveNeighbor == 3)
                    board[i][j] = 2; // 01 -> 10
            }
        }
        // shift the 2nd state to the position of 1st state
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                board[i][j] >>= 1;
    }

    // scan 3*3 block including board[i][j] itself
    private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                // use & 01 to filter the 2nd state and get only the 1st state
                lives += board[x][y] & 1;
            }
        }
        // subtract itself to get the # of its neighbors
        lives -= board[i][j] & 1;
        return lives;
    }


}
