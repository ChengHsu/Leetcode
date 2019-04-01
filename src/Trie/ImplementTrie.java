package Trie;

/**
 * @Number: #208. Implement Trie (Prefix Tree)
 * @Descpription: Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * @Author: Created by xucheng.
 */
public class ImplementTrie {
    class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         * time: O(m)
         * space: O(m)
         */
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                // a link doesn't exist, create a new node
                if (p.children[index] == null)
                    p.children[index] = new TrieNode();
                // move down the tree
                p = p.children[index];
            }
            // mark the current word as the last word
            p.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         * time: O(m)
         */
        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        private TrieNode find(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (p.children[index] == null)
                    return null;
                p = p.children[index];
            }
            return p;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         * time: O(m)
         */
        public boolean startsWith(String prefix) {
            TrieNode node = find(prefix);
            return node != null;
        }
    }
}
