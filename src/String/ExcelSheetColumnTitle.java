package String;

/**
 * @Number: 168. Excel Sheet Column Title
 * @Descpription: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * @Author: Created by xucheng.
 */
public class ExcelSheetColumnTitle {
    /**
     * convert int to char
     * Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return res.toString();
    }
}
