package Backtracking;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Number:
 * #139. word Break
 * #140. Word Break II
 * @Descpription: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * @Author: Created by xucheng.
 */
public class WordBreak {
    /**
     * slow version
     * Memorization recursive
     * @param s
     * @param wordDict
     * @return
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Map<String,Boolean> mem = new HashMap<>();
//        return wordBreakHelper(s, mem, wordDict);
//    }
//
//    private boolean wordBreakHelper(String s, Map<String, Boolean> mem, List<String> wordDict) {
//        // In memory, directly return
//        if (mem.containsKey(s))
//            return mem.get(s);
//        // Whole string is a word, memorize and return
//        if (wordDict.contains(s))
//            return true;
//        // Try break every point
//        for (int i =0; i< s.length(); i++) {
//            String left = s.substring(0,i);
//            String right = s.substring(i);
//            // find the solution for s,
//            if (wordBreakHelper(left,mem,wordDict) && wordDict.contains(right)) {
//                mem.put(s,true);
//                return true;
//            }
//        }
//        // no solution for s, memorize and return
//        mem.put(s,false);
//        return false;
//    }

    /**
     * faster version
     * 先判断wordDict是否contains left part
     * time: O(n^2)
     * space: O(n)
     * @param s
     * @param wordDict
     * @return
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
//    }
//
//    private boolean dfs(String s, Set<String> wordDict, int start, Boolean[] memo) {
//       if (start == s.length())
//           return true;
//       if (memo[start] != null)
//           return memo[start];
//
//       for (int end = start + 1; end < s.length(); end++) {
//           if (wordDict.contains(s.substring(start, end)) && dfs(s, wordDict, end, memo)){
//               memo[start] = true;
//               return true;
//           }
//       }
//        memo[start] = false;
//        return false;
//    }

    /**
     *
     * @param s
     * @param dict
     * @return
     */
    public List<String> wordBreak(String s, List<String> dict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo, 0);
    }

    public List<String> dfs(String s, List<String> dict, Map<Integer, List<String>> memo, int start) {
        if (memo.containsKey(start))
            return memo.get(start);

        List<String> res = new ArrayList<>();
        if (start == s.length())
            res.add("");

        for (int end = start + 1; end <= s.length(); end++) {
            String left = s.substring(start,end);
            if (dict.contains(left)) {
                List<String> list = dfs(s, dict, memo, end);
                for (String item: list) {
                   if (item.equals(""))
                       res.add(left);
                   else
                       res.add(left + " " + item);
                }
            }
        }
        memo.put(start, res);
        return res;
    }

}
