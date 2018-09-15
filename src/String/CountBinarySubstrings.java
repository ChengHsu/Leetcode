package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #696. Count Binary Substrings
 * @Descpription: Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 * @Author: Created by xucheng.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int consecutiveNums = 1;
        list.add(1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                consecutiveNums++;
            else if (s.charAt(i) != s.charAt(i - 1)) {
                list.add(consecutiveNums);
                consecutiveNums = 1;
            }
        }
        int  ans = 0;
        for (int i = 1; i < list.size(); i++) {
            ans += Math.min(list.get(i - 1), list.get(i));
        }
        System.out.println(ans);
        return ans;
    }
}
