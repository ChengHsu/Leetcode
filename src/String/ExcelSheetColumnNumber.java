package String;

/**
 * @Number: 171. Excel Sheet Column Number
 * @Descpription: Given a column title as appear in an Excel sheet, return its corresponding column number.
 * @Author: Created by xucheng.
 */
public class ExcelSheetColumnNumber {
    /**
     * 26进制->10进制
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length()- i - 1);
        return res;
    }
}
