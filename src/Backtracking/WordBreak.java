package Backtracking;

import java.util.*;

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
     * https://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
     * https://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
     * Memorization recursive
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> mem = new HashMap<>();
        return wordBreakHelper(s, mem, wordDict);
    }

    private boolean wordBreakHelper(String s, Map<String, Boolean> mem, List<String> wordDict) {
        // In memory, directly return
        if (mem.containsKey(s))
            return mem.get(s);
        // Whole string is a word, memorize and return
        if (wordDict.contains(s))
            return true;
        // Try break every point
        for (int i =0; i< s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            // find the solution for s
            if (wordBreakHelper(left,mem,wordDict) && wordDict.contains(right)) {
                mem.put(s,true);
                return true;
            }
        }
        // no solution for s, memorize and return
        mem.put(s,false);
        return false;
    }

    /**
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<String, List<String>> done = new HashMap<>();
        done.put("", new ArrayList<>());
        done.get("").add("");

        return dfs(s, dict, done);
    }

    List<String> dfs(String s, Set<String> dict, Map<String, List<String>> done) {
        if (done.containsKey(s)) {
            return done.get(s);
        }
        List<String> ans = new ArrayList<>();

        for (int len = 1; len <= s.length(); len++) {  //将s 分割成s1 s2  其中s1长度为len
            String left = s.substring(0, len);
            String right = s.substring(len);

            if (dict.contains(left)) {
                List<String> s2_res = dfs(right, dict, done);
                for (String item : s2_res) {
                    if (item == "") {
                        ans.add(left);
                    } else {
                        ans.add(left + " " + item);
                    }
                }
            }
        }
        done.put(s, ans);
        return ans;
    }
}
