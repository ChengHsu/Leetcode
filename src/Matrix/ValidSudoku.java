package Matrix;

/**
 * @Number: #36. Valid Sudoku
 * @Descpription: Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * @Author: Created by xucheng.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // edge case
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return true;

        // check every row
        for (int row = 0; row < 9; row++) {
            boolean[] taken = new boolean[9];
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '1';
                    if (taken[num] == true)
                        return false;
                    taken[num] = true;
                }
            }
        }

        // check every column
        for (int col = 0; col < 9; col++) {
            boolean[] taken = new boolean[9];
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '1';
                    if (taken[num] == true)
                        return false;
                    taken[num] = true;
                }
            }
        }

        // check every 3*3 square
        for (int box = 0; box < 9; box++) {
            boolean[] taken = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // i: row num of 3*3 square, 3 * (box / 3): row num of 9*9 square
                    if (board[i + 3 * (box / 3)][j + 3 * (box % 3)] != '.') {
                        int num = board[i + 3 * (box / 3)][j + 3 * (box % 3)] - '1';
                        if (taken[num] == true)
                            return false;
                        taken[num] = true;
                    }

                }
            }
        }
        return true;
    }
}
