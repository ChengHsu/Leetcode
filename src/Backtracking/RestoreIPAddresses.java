package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 93. Restore IP Addresses
 * @Descpription: Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * @Author: Created by xucheng.
 */
public class RestoreIPAddresses {
    /**
     * Definition of valid IP address:
     * 1. The length of the ip without '.' should be equal to the length of s;
     * 2. The digit order of ip should be same as the digit order of s;
     * 3. Each part separated by the '.' should not start with '0' except only '0';
     * 4. Each part separared by the '.' should not larger than 255;
     * 尝试所有组合：对于每个segment，分别取长度为1，2，3的字符串进行dfs
     * https://leetcode.com/problems/restore-ip-addresses/discuss/30944/Very-simple-DFS-solution
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        backtrack(res, s, 0, "", 0);
        return res;
    }

    // count:当前segment的个数
    private void backtrack(List<String> res, String ip, int currIdx, String restored, int count) {
        System.out.println("cnt: " + count + " restored: " + restored);
        if (count > 4)
            return;
        if (count == 4 && currIdx == ip.length()) {
            res.add(restored);
            return;
        }
        // max len of each segment is 3
        for (int i = 1; i < 4; i++) {
            if ((currIdx + i) > ip.length()) break;
            String str = ip.substring(currIdx, currIdx + i);
            System.out.println("str: " + str);
            if ((str.startsWith("0") && str.length() > 1) || Integer.parseInt(str) >= 256) continue;
            backtrack(res, ip, currIdx + i, restored + str + (count == 3 ? "" : "."), count + 1);
        }
    }
}
