package test;

/**
 * @Author: Created by xucheng.
 */
public class Main{
    public static void main(String[] args){
      Main main = new Main();
      System.out.println(main.exchange(2));
    }

    public int exchange(int n) {
        // corner case
        if(n == 0)
            return 0;
        if (n == 1)
            return 1;

        int remain = n;
        int total = n;
        while (remain != 0) {
            if (remain == 1)
                break;
            // curr: 当前可以换的笔
            int curr = remain / 2;
            // total: 最多可以换的笔
            total += curr;
            // remain : 用当前的笔做一次交换后剩余的用过的笔
            remain = remain % 2 + curr;
        }
        return total;
    }
}