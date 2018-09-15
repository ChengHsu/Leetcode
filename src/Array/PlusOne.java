package Array;

/**
 * @Descpription: #66.
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
   The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
   You may assume the integer does not contain any leading zero, except the number 0 itself.
 * @Author: Created by xucheng.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int flag = 1;
        int i = 0;
        for (i = digits.length - 1; i >= 0; i--) {
            digits[i] += flag;
            if (digits[i] > 9) {
                flag = 1;
                digits[i] = 0;
            } else {
                flag = 0;
            }
        }
        if (i == -1 && flag == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int j = 1; j <= digits.length; j++) {
                newDigits[j] = digits[j - 1];
            }
            return newDigits;
        } else return digits;
    }

}
