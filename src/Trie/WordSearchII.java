package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #212. Word Search II
 * @Descpription: Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * @Author: Created by xucheng.
 */
public class WordSearchII {
    /**
     * DFS: failed: 34/37 test cases
     */
//    Map<Character, List<int[]>> dict = new HashMap<>();
//
//    public List<String> findWords(char[][] board, String[] words) {
//        Set<String> set = new HashSet<>();
//        List<String> result = new ArrayList<>();
//        if (board.length == 0 || board[0].length == 0 || words.length == 0)
//            return result;
//
//        // build the map key : char , value: list of coordinate pairs of each kind of char
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                char ch = board[i][j];
//                if (!dict.containsKey(ch))
//                    dict.put(ch, new ArrayList<>());
//                dict.get(ch).add(new int[]{i, j});
//            }
//        }
//
//        for (String word : words) {
//            char[] chars = word.toCharArray();
//            if (!dict.containsKey(chars[0]))
//                continue;
//            else {
//                for (int[] pos : dict.get(chars[0])) {
//                    int x = pos[0];
//                    int y = pos[1];
//                    Map<Integer, List<Integer>> visited = new HashMap<>();
//                    if (!visited.containsKey(x))
//                        visited.put(x,new ArrayList<>());
//                    visited.get(x).add(y);
//                    if (find(chars, x, y, 0, visited)) {
//                        set.add(word);
//                        break;
//                    }
//                }
//            }
//        }
//        result.addAll(set);
//        return result;
//    }
//
//    private boolean find(char[] chars, int x, int y, int idx, Map<Integer, List<Integer>> visited) {
//        if (idx == chars.length - 1)
//            return true;
//
//        if (!dict.containsKey(chars[idx + 1]))
//            return false;
//        if (!visited.containsKey(x))
//            visited.put(x, new ArrayList<>());
//        visited.get(x).add(y);
//        for (int[] pos : dict.get(chars[idx + 1])) {
//            int nx = pos[0];
//            int ny = pos[1];
//            if (((nx == x - 1 || nx == x + 1) && (ny == y)) || ((nx == x) && (ny == y - 1 || ny == y + 1))) {
//                if (!visited.containsKey(nx) || !visited.get(nx).contains(ny)) {
//                    if (find(chars, nx, ny, idx + 1, visited))
//                        return true;
//                }
//            }
//        }
//        return false;
//    }


    /**
     * Trie + backtracking
     * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
     *
     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            // insert every word, starting from root
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (p.children[index] == null)
                    p.children[index] = new TrieNode();
                p = p.children[index];
            }
            p.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0)
            return result;

        TrieNode root = buildTree(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
        char ch = board[i][j];
        if (ch == '#' || p.children[ch - 'a'] == null)
            return;

        p = p.children[ch - 'a'];
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if (i - 1 >= 0)
            dfs(board, i - 1, j, p, result);
        if (i + 1 < board.length)
            dfs(board, i + 1, j, p, result);
        if (j - 1 >= 0)
            dfs(board, i, j - 1, p, result);
        if (j + 1 < board[0].length)
            dfs(board, i, j + 1, p, result);
        board[i][j] = ch;
    }
}

