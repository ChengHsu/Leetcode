package Matrix;

/**
 * @Number: #79. Word Search
 * @Descpription: Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * @Author: Created by xucheng.
 */
public class WordSearch {
    /**
     * https://www.youtube.com/watch?v=oUeGFKZvoo4
     * DFS: 适合找一个唯一解，空间复杂度比BFS小
     * time: search:  O(4 ^ l), l = len(word)
     * total: O(m * n * 4 ^ l)
     * space: O(m * n + l)
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // edge case
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        // faster than charAt()
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // set a start cell and do DFS searching
                if (dfs(board, i, j, wordChars, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, char[] wordChars, int charIdx) {
        // out of bound
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        // current char and the char in word don't match
        if (board[row][col] != wordChars[charIdx])
            return false;
        // already reach at the last char in word, solution found
        if (charIdx == wordChars.length - 1)
            return true;
        // avoid visiting a visited cell, mark the current one as 0 so it can not match with any chars in word, means it's visited
        char cur = board[row][col];
        board[row][col] = 0;
        // else: current char and the char match, continue searching the next pair to up, down ,left ,right
        boolean found = dfs(board, row - 1, col, wordChars, charIdx + 1) ||
                dfs(board, row + 1, col, wordChars, charIdx + 1) ||
                dfs(board, row, col - 1, wordChars, charIdx + 1) ||
                dfs(board, row, col + 1, wordChars, charIdx + 1);
        // recover the value
        board[row][col] = cur;

        return found;
    }
}
