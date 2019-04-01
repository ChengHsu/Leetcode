package Trie;

/**
 * @Number: The number of questions
 * @Descpription: Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .
 * . means it can represent any one letter.
 * @Author: Created by xucheng.
 */
public class AddAndSearchWordDataStructureDesign {
    class WordDictionary {
        class TrieNode {
            public TrieNode[] childen;
            public boolean isEnd;

            public TrieNode() {
                childen = new TrieNode[26];
                isEnd = false;
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.childen[index] == null)
                    p.childen[index] = new TrieNode();
                p = p.childen[index];
            }
            p.isEnd = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            TrieNode p = root;
            return find(p, word.toCharArray(), 0);
        }

        /**
         * DFS: if it's a '.', try every child in this level to find a match
         *
         * @param root
         * @param chars
         * @param currIdx
         * @return
         */
        private boolean find(TrieNode root, char[] chars, int currIdx) {
            if (currIdx == chars.length)
                return root != null && root.isEnd;

            if (chars[currIdx] != '.') {
                int index = chars[currIdx] - 'a';
                return root.childen[index] != null && find(root.childen[index], chars, currIdx + 1);
            }
            // iterate every non-null child in this level,try to find a match
            else {
                for (int i = 0; i < root.childen.length; i++) {
                    if (root.childen[i] != null) {
                        if (find(root.childen[i], chars, currIdx + 1))
                            return true;
                    }
                }
            }
            return false;
        }
    }
}
