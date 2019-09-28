package String;

/**
 * @Number: 14. Longest Common Prefix
 * @Descpription: Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * @Author: Created by xucheng.
 */
public class LongestCommonPrefix {

    /**
     * Scanning
     * 遍历字符串，判断第一个字符串是否存在于其他各字符串中，若存在则继续判断下一个，若不存在则第一个字符串长度减1看是否存在
     * Time: O(S), where S is the sum of all characters in all strings.
     * In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings [S_2...S_n]
     * There are S character comparisons, where S is the sum of all characters in the input array.
     * Space: O(1)
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0)
//            return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//        // prefix不是前缀
//            while (strs[i].indexOf(prefix) != 0)
//            {
//                prefix = prefix.substring(0,prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        }
//        return prefix;
//    }


    /**
     * Divide and Conquer
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0)
//            return "";
//        return findLCP(strs, 0, strs.length - 1);
//    }
//
//    private String findLCP(String[] strs, int l, int r) {
//        if (l == r)
//            return strs[l];
//        else {
//            int mid = (l + r) / 2;
//            String leftLCP = findLCP(strs, l, mid);
//            String rightLCP = findLCP(strs, mid + 1, r);
//            return LCP (leftLCP,rightLCP);
//        }
//    }
//
//    private String LCP(String leftLCP, String rightLCP) {
//        int min = Math.min(leftLCP.length(), rightLCP.length());
//        for (int i = 0; i < min; i++) {
//            if (leftLCP.charAt(i) != rightLCP.charAt(i))
//                return leftLCP.substring(0,i);
//        }
//        return leftLCP.substring(0,min);
//    }




    /**
     * Binary Search :
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        // Find the minimum string length
        for (int i = 0 ; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int low = 1;
        int high = minLen;
        while (low < high) {
            int mid = (low + high)/ 2;
            // if the substring of the 1st word is a common prefix of all words.
            // then discard the left part, means to add the len of substring by 1 and repeat
            // Because we try to find the longer common prefix
            if (isCommomPrefix(strs,mid))
                low = mid + 1;
            // Discard the right part
            else
                high = mid - 1;
        }

        return strs[0].substring(0,(low + high)/2);
    }

    private boolean isCommomPrefix(String[] strs, int len) {
        // check if the substring of the 1st word is a common prefix of all words
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1))
                return false;
        }
        return true;
    }


    /**
     * Follow up: Given a set of keys S = [S1,S2...Sn], find the longest common prefix among a string q and S.
     * This LCP query will be called frequently.
     * @param q
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String q, String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        Trie trie = new Trie();
        for (int i = 1; i < strs.length ; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }


    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private int size;

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getLinks() {
            return size;
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if(node.containsKey(curLetter) && node.getLinks() == 1 && !node.isEnd()) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                } else {
                    return prefix.toString();
                }
            }

            return prefix.toString();
        }

        public void insert(String str) {
        }
    }

}
