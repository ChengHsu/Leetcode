package String;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Number: #12. Integer to Roman
 * @Descpription: Given an integer, convert it to a roman numeral.
 * @Author: Created by xucheng.
 */
public class IntegerToRoman {
    /**
     * Find the largest number that < num, append it and subtract it from num.
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Map<Integer, String> int2roman = new LinkedHashMap<>();
        int2roman.put(1, "I");
        int2roman.put(4, "IV");
        int2roman.put(5, "V");
        int2roman.put(9, "IX");
        int2roman.put(10, "X");
        int2roman.put(40, "XL");
        int2roman.put(50, "L");
        int2roman.put(90, "XC");
        int2roman.put(100, "C");
        int2roman.put(400, "CD");
        int2roman.put(500, "D");
        int2roman.put(900, "CM");
        int2roman.put(1000, "M");

        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            Map.Entry<Integer, String> max = null;
            // find largest roman <= number
            for (Map.Entry<Integer, String> entry : int2roman.entrySet()) {
                if (entry.getKey() > num)
                    break;
                max = entry;
            }
            roman.append(max.getValue());
            num -= max.getKey();
        }
        return roman.toString();
    }
}
