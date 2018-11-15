package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #13. Roman to Integer
 * @Descpription: Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * @Author: Created by xucheng.
 */
public class RomanToInteger {
    private Map<Character, Integer> roman2int = new HashMap<>();

    /**
     * From end to front, if i <= i+1, add; else subtract
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        constructDict();
        int res = roman2int.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (roman2int.get(s.charAt(i + 1)) <= roman2int.get(s.charAt(i))) {
                res += roman2int.get(s.charAt(i));
            } else {
                res -= roman2int.get(s.charAt(i));
            }
        }
        return res;
    }

    public void constructDict() {
        roman2int.put('I', 1);
        roman2int.put('V', 5);
        roman2int.put('X', 10);
        roman2int.put('L', 50);
        roman2int.put('C', 100);
        roman2int.put('D', 500);
        roman2int.put('M', 1000);
    }
}
