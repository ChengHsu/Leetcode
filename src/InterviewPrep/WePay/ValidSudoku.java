package InterviewPrep.WePay;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ValidSudoku {
    // edge case
    public boolean isValidSudoku(char[][] board) {
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

        // check each col
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

        for (int box = 0; box < 9; box++) {
            boolean[] taken = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
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
