package String.Palindrome;

/**
 * @Number: #9. Palindrome Number
 * @Descpription: Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 * @Author: Created by xucheng.
 */
public class PalindromeNumber {
    /**
     * Integer to String
     * @param x
     * @return
     */
//    public boolean isPalindrome(int x) {
//        if (x < 0)
//            return false;
//        if (x >= 0 && x <= 9)
//            return true;
//
//        char[] chars = String.valueOf(x).toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != chars[chars.length - i - 1])
//                return false;
//        }
//        return true;
//    }


    /**
     * https://leetcode.com/problems/palindrome-number/solution/
     * Follow Up
     * 1. Without converting int to string, can reverse the int and if it equals to original one, it's palindrome
     * But overflow may appear
     * 2. Therefore, just reverse the second half of int and compare it with the first
     * <p>
     * time:  O(log 10(n)). We divided the input by 10 for every iteration
     * space: O(1)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // special case: x < 0 & the last digit of x is 0 but x != 0
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        // special case: x only has one digit
        if (x >= 0 && x <= 9)
            return true;

        int reversedHalfNum = 0;
        // When break from while loop, x becomes the first half of the number, reversedHalfNum becomes the reversed second half
        while (x > reversedHalfNum) {
            reversedHalfNum = reversedHalfNum * 10 + x % 10;
            x /= 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedHalfNum || x == reversedHalfNum / 10;
    }
}
