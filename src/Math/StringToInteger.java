package Math;

/**
 * @Number: 8. String to Integer (atoi)
 * @Descpription: implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
 * possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * @Author: Created by xucheng.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;

        // Check if empty string
        if (str == null || str.length() == 0)
            return 0;

        // remove white spaces from the string
        while (index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index == str.length()) return 0;

        // get the sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // convert to the actual number and make sure it's not overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            // check for overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = total * 10 + digit;
            index++; // increment the counter
        }
        return total * sign;
    }
}
