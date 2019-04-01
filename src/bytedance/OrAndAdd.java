package bytedance;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */


import java.util.Scanner;

public class OrAndAdd {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            long x = scan.nextInt();
            long k = scan.nextInt();
            long bitNum = 1; //指向x的当前位
            long ans = 0;   //y的各位的值累加，累加完毕得到y
            while (k > 0) {
                if ((x & bitNum) == 0) {   //如果当前x位为0
                    ans += (bitNum * (k & 1)); //则将k的最后一位取出来与填入x对应的为零的位并累加这一位的值
                    k = k >> 1;         //k取出最后一位，即向右移一位
                }
                //上面无论x的当前位为0或1,bitNum都向左移一位
                bitNum = bitNum << 1;
            }
            System.out.println(ans);//最后输出ans，即是y的值。
        }
    }
}

