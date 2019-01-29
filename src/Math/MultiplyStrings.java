package Math;

/**
 * @Number: 43. Multiply Strings
 * @Descpription: Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author: Created by xucheng.
 */
public class MultiplyStrings {
    /**
     * Use int array to store products of every pair of digits
     * https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] products = new int[len1 + len2];
        //1. compute products from each pair of digits from num1 and num2.
        for (int i = len1 - 1; i >= 0; i -- ) {
            for (int j = len2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                products[i+j+1] += digit1 * digit2;
            }
        }
        //2.carry each element over
        int carry = 0;
        for (int i =products.length - 1; i >= 0; i--){
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        //3.output the solution
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        // eliminate the leading 0
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
