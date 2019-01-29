package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: 66. Plus One
 * @Descpription: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * @Author: Created by xucheng.
 */
public class PlusOne {
    /**
     * 考虑进位和长度+1的情况，若计算完第一位为0， 则create new array,set newArray[0] = 1, copy 其他的数字
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >=0; i--) {
            digits[i] += flag;
            if (digits[i] > 9) {
                digits[i] = 0;
                flag = 1;
            }
            else flag = 0;
        }
        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        else return digits;
    }
}
