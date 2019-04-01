package DFSAndBFS;

import java.util.*;

/**
 * @Number: #127. Word Ladder
 * @Descpription: Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * @Author: Created by xucheng.
 */
public class WordLadder {
    /**
     * Wrong Version：
     * DFS：find all transformation sequences to get the shortest one
     * test case:  "hot","dog",["hot","dog","dot"] expected: 3
     * hot -> dot -> dog 可以不按照list的顺序寻找
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

//    private int min = Integer.MAX_VALUE;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (wordList == null || wordList.size() == 0)
//            return 0;
//
//        for (int i = 0; i < wordList.size(); i++) {
//            if (isValidTrans(beginWord, wordList.get(i))) {
//                System.out.println("new start with: " + wordList.get(i));
//                dfs(wordList, i, endWord, new ArrayList<String>());
//            }
//        }
//        if (min != Integer.MAX_VALUE)
//            return min + 1;
//        else return 0;
//    }
//
//    private void dfs(List<String> wordList, int currIdx, String endWord, ArrayList<String> transSeq) {
//        String currWord = wordList.get(currIdx);
//        System.out.println("curr: " + currWord);
//        if (currWord.equals(endWord)) {
//            min = Math.min(min, transSeq.size() + 1);
//            System.out.println("min: "+min);
//            return;
//        }
//
//        for (int nextIdx = currIdx + 1; nextIdx < wordList.size(); nextIdx++) {
//            if (isValidTrans(currWord, wordList.get(nextIdx))) {
//                transSeq.add(currWord);
//                dfs(wordList, nextIdx, endWord, transSeq);
//                transSeq.remove(transSeq.size() - 1);
//                System.out.println("return");
//            }
//        }
//
//    }
//
//    private boolean isValidTrans(String beginWord, String nextWord) {
//        char[] beginWordChars = beginWord.toCharArray();
//        char[] nextWordChars = nextWord.toCharArray();
//        int count = 0;
//        for (int i = 0; i < beginWordChars.length; i++) {
//            if (beginWordChars[i] != nextWordChars[i])
//                count++;
//        }
//        if (count != 1)
//            return false;
//        return true;
//    }


    /**
     * https://zxi.mytechroad.com/blog/searching/127-word-ladder/
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        // doesn't contain endWord
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q.isEmpty()) {
            ++steps;
            for (int s = q.size(); s > 0; --s) {
                String w = q.poll();
                char[] chs = w.toCharArray();
                // for every word, replace one char at a time,
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        // found the end word
                        if (t.equals(endWord)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.offer(t);
                    }
                    // recover
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }
}
