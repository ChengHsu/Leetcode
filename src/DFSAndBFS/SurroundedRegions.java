package DFSAndBFS;

/**
 * @Number: #130. Surrounded Regions
 * @Descpription: Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * @Author: Created by xucheng.
 */
public class SurroundedRegions {
    /**
     * DFS
     * Run through the boundaries and perform dfs when you come across a 'O' .
     * Switch all adjoining 'O' to another character. (I have chosen to switch them to 'Y').
     * This way all th e'O's that are not surrounded completely by 'X' are switched to 'Y's .
     * After simply run through the matrix again and switch all 'Y' to 'O' and all 'O' to 'X'.
     *
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int row = board.length;
        int col = board[0].length;

        //check first and last col
        for (int i = 0; i < row; i++) {
            //
            if (board[i][0] == 'O') getEmAll(board, i, 1);
            if (board[i][col - 1] == 'O') getEmAll(board, i, col - 2);
        }

        //check first and last  row
        for (int i = 0; i < col; i++) {

            if (board[0][i] == 'O') getEmAll(board, 1, i);
            if (board[row - 1][i] == 'O') getEmAll(board, row - 2, i);
        }


        //Switch all 'O's to 'X's and 'Y's to 'O's
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++)
                if (board[i][j] == 'Y') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
        }
    }

    public void getEmAll(char[][] board, int row, int col) {

        if (row >= board.length - 1 || row <= 0 || col >= board[0].length - 1 || col <= 0) return;

        if (board[row][col] == 'X' || board[row][col] == 'Y') return;
        if (board[row][col] == 'O') board[row][col] = 'Y';

        getEmAll(board, row + 1, col);
        getEmAll(board, row, col + 1);
        getEmAll(board, row - 1, col);
        getEmAll(board, row, col - 1);

    }
}
