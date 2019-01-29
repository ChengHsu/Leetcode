package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Number: 249. Group Shifted Strings
 * @Descpription: Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * @Author: Created by xucheng.
 */
public class GroupShiftedStrings {
    /**
     * The basic idea is to set a key for each group: the sum of the difference between the adjacent chars in one string.
     * Then we can easily group the strings belonging to the same shifting sequence with the same key.
     * use the HashMap to store each group
     * https://leetcode.com/problems/group-shifted-strings/discuss/67452/Concise-10-lines-JAVA-Solution-with-explanation
     *
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
//      按照字符串第一个字母排序，若第一个字母一样就比较第二个，以此类推
        Arrays.sort(strings);

        for (String s : strings) {
            String key = "";
            for (int i = 1; i < s.length(); i++)
//          (s.charAt(i) - s.charAt(i - 1) + 26) 中 + 26防止 s.charAt(i) - s.charAt(i - 1) < 0
                key += String.format("%2d", (s.charAt(i) - s.charAt(i - 1) + 26) % 26);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
