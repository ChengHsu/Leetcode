package String;

import java.util.Stack;

/**
 * @Number:316. Remove Duplicate Letters
 * @Descpription: Given a string which contains only lowercase letters, remove duplicate letters so that every letter
 * appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * @Author: Created by xucheng.
 */
public class RemoveDuplicateLetters {
    /**
     * Stack
     * https://leetcode.com/problems/remove-duplicate-letters/discuss/76769/Java-solution-using-Stack-with-comments
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] charFreq = new int[26];
        boolean[] visited = new boolean[26];
        char[] ch = s.toCharArray();
        for (char c : ch)
            charFreq[c - 'a']++;
        Stack<Character> st = new Stack<>();
        int idx;
        for (char c : ch) {
            idx = c - 'a';
            //decrement number of characters remaining in the string to be analysed
            charFreq[idx]--;
            //if character is already present in stack, dont bother
            if (visited[idx]) continue;

            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later
            while (!st.empty() && c < st.peek() && charFreq[st.peek() - 'a'] != 0){
                visited[st.pop() - 'a'] = false;
            }
            //add current character and mark it as visited
            st.push(c);
            visited[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
