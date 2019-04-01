package Stack;

import java.util.Stack;

/**
 * @Number: #394. Decode String
 * @Descpription: Given an encoded string, return it's decoded string.
 * @Author: Created by xucheng.
 */
public class DecodeString {
    /**
     * note:
     * hard point: k和要重复的字符串长度都可能大于1，分离出k和字符串分别压栈
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();  // store k
        Stack<String> result = new Stack<>();  // store current result string
        int idx = 0;
        result.push("");

        while (idx < s.length()) {
            // convert k str to int then push into kStack
            if (Character.isDigit(s.charAt(idx))) {
                int start = idx;
                while (Character.isDigit(s.charAt(idx))) {
                    idx++;
                }
                count.push(Integer.parseInt(s.substring(start, idx)));
            } else if (s.charAt(idx) == '[') {
                result.push("");
                idx++;
            } else if (s.charAt(idx) == ']') {
                String str = result.pop();
                StringBuilder tmp = new StringBuilder();
                int k = count.pop();
                // repeat k times
                for (int i = 0; i < k; i++)
                    tmp.append(str);
                // pop出之前的和当前重复完的字符串进行拼接，然后将整个字符串压栈
                result.push(result.pop() + tmp.toString());
                idx++;
            } else
                result.push(result.pop() + s.charAt(idx++));

        }
        return result.pop();
    }
}
