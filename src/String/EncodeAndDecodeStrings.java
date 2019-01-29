package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #271. Encode and Decode Strings
 * @Descpription: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over
 * the network and is decoded back to the original list of strings.
 * @Author: Created by xucheng.
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i =0;
        while (i < s.length()) {
            // 从指定位置开始往后找给定字符第一次出现的位置
            int slash = s.indexOf('/',i);
            // 字符串大小是slash前面的数值
            int size = Integer.valueOf(s.substring(i,slash));
            // 截取字符串
            res.add(s.substring(slash + 1, slash + size + 1));
            // 定位下一串的开始位置
            i = slash + size + 1;
        }
        return res;
    }
}
