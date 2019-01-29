package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #6. ZigZag Conversion
 * @Descpription: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * @Author: Created by xucheng.
 */
public class ZigZagConversion {
    /**
     * Iterative
     * Time: O(n)
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        // edge case
        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        // in case of s.len < numRows, not enough chars for all rows
        for (int i =0 ; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        // Iterate the string and Append chars to corresponding rows
        // The appropriate row can be tracked using two variables: the current row and the current direction.
        // The current direction changes only when we moved up to the topmost row or moved down to the bottommost row.
        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row: rows) ret.append(row);
        return  ret.toString();
    }
}
