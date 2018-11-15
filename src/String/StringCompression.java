package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #443.String Compression
 * @Descpription: Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * @Author: Created by xucheng.
 */
public class StringCompression {
    /**
     * Failed on ["a","a","a","b","b","a","a"]
     * Output: ["a","5","b","2"]
     * Expected: ["a","3","b","2","a","2"]
     * @param chars
     * @return
     */
//    public int compress(char[] chars) {
//        // Edge case
//        if (chars.length == 1)
//            return 1;
//        Map<Character, Integer> map = new HashMap<>();
//        boolean isEnd = false;
//        for (int i = 0; i < chars.length; i++) {
//            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
//        }
//        int len = 0;
//        for (Character c : map.keySet()) {
//            chars[len++] = c;
//            if (map.get(c) == 1)
//                continue;
//            else {
//                char[] digits = map.get(c).toString().toCharArray();
//                for (Character digit : digits) {
//                    chars[len++] = digit;
//                }
//            }
//        }
//        return len;
//    }

    /**
     * Use an "end" pointer to the find the end of substring with same chars
     * If number of same char is 1, just add it to the array
     * If >1, add it and also its number char by char
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            int end = i;
            while (end < chars.length && chars[end] == chars[i]) {
                end++;
            }
            if (end == i + 1) {
                chars[start++] = chars[i];
            } else {
                chars[start++] = chars[i];
                char[] count = String.valueOf(end - i).toCharArray();
                for (int l = 0; l < count.length; l++) {
                    chars[start++] = count[l];
                }
            }
            i = end - 1;
        }
        return start;
    }

}
