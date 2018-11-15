package String;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class EPIString {

    /**
     * Judge if a string is a palindrome
     * Time: O(n)
     * Space: O(1)
     *
     * @param s
     * @return
     */
    public static boolean isPalindromic(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    /**
     * Convert int to string
     * Encode the string digit by digit from back to front
     * Store into a StringBuilder and reverse to get the right order
     *
     * @param x
     * @return
     */
    public static String intToString(int x) {
        boolean isNegative = false;
        if (x < 0)
            isNegative = true;

        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) '0' + Math.abs(x % 10));
            x /= 10;
        } while (x != 0);

        if (isNegative)
            sb.append('-');
        sb.reverse();
        return sb.toString();
    }

    /**
     * Convert String to Int
     * Begin from the leftmost digit and with each succeeding digit, multiply the partial result by 10 and add that digit
     *
     * @param s
     * @return
     */
    public static int stringToInt(String s) {
        int res = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            final int digit = s.charAt(i) - '0';
            res += res * 10 + digit;
        }
        return s.charAt(0) == '-' ? -res : res;
    }

    /**
     * Brute force substring search
     * If a pattern is found, return the index of its 1st char
     * If not, return the length of the text
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int stupidStringSearch(String pattern, String text) {
        int patLen = pattern.length();
        int txtLen = text.length();
        for (int i = 0; i <= txtLen - patLen; i++) {
            int j;
            for (j = 0; j < patLen; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            if (j == patLen)
                return i;
        }
        return txtLen;
    }

    /**
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int alternateStringSearch(String pattern, String text) {
        int i, j;
        int patLen = pattern.length();
        int txtLen = text.length();
        for (i = 0, j = 0; i < txtLen && j < patLen; i++) {
            if (text.charAt(i) == pattern.charAt(j))
                j++;
            else {
                System.out.println("before: "+i);
                i -= j;
                System.out.println("i: "+i);
                j = 0;
            }
        }
        if (j == patLen) return i - patLen;
        else return txtLen;
    }


}
