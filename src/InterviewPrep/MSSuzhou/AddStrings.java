package InterviewPrep.MSSuzhou;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class AddStrings {
    /**
     corner case: 两数长度不一样 & 首部两位数相加大于10进位，整个结果前面+1
     time: O(n)
     space: O(n)
     */
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        while(i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0? (num1Chars[i--]-'0') : 0;
            int b = j >= 0? (num2Chars[j--]-'0') : 0;
            int sum = a + b + carry;
            res.insert(0, sum % 10);
            carry = sum / 10;
        }
        return res.toString();
    }
}
