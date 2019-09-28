package Yext;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class IntToEngish {
    public static void main(String[] args) {
        IntToEngish intToEngish = new IntToEngish();
        System.out.println(intToEngish.numToWords(870));
    }

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numToWords(int num) {
        if(num == 0) return "Zero";
        boolean isNeg = false;
        if(num < 0) {
            isNeg = true;
            num = -num;
        }
        String res = helper(num);
        res = res.trim();
        return isNeg ? "Negative " + res : res;
    }

    private String helper(int num) {
        if(num == 0) return "";
        else if(num < 20)
            return LESS_THAN_20[num] + " ";
        else if(num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
