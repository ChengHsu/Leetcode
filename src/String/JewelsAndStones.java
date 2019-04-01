package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #771. Jewels and Stones
 * @Descpription: You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * @Author: Created by xucheng.
 */
public class JewelsAndStones {
    /**
     * time: O(J.Len + S.Len)
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0)
            return 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : S.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        int ans = 0;
        for (int i = 0; i < J.length(); i++) {
            if (freq.containsKey(J.charAt(i)))
                ans += freq.get(J.charAt(i));
        }

        return ans;
    }
}
