package Math;

/**
 * @Number: #67. Add Binary
 * @Descpription: Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * @Author: Created by xucheng.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // 用0补齐较短字符串左侧至两字符串一样长，从最右端逐位相加，每轮计算时考虑进位

        // 将较短字符串补至和较长字符串一样长，长度为较长字符串的长度
       int maxLen = Math.max(a.length(), b.length());
       //  因为长度不确定 用StringBuilder用来存放相加的结果
       StringBuilder sb = new StringBuilder();
       // 进位
       int carry = 0;
       //逐位计算
       for (int i = 0; i < maxLen; i++) {
           // 从字符串最右端开始取数 字符转为数字需减48，即字符0
           int tmpA = (a.length() > i) ? (a.charAt(a.length() - i - 1) - '0') : 0;
           int tmpB = (b.length() > i) ? (b.charAt(b.length() - i - 1) - '0') : 0;
           // 相加得到的结果取模 因为结果大于1就进位
            sb.insert(0, (tmpA + tmpB + carry) % 2);
            // 计算进位
            carry = (tmpA + tmpB + carry) > 1 ? 1 : 0;
       }
       // 最高位若有进位则在最前面存1
       if (carry == 1)
           sb.insert(0, 1);
       return sb.toString();
    }
}
