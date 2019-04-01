package bytedance;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class woodPuzzle {
    public static boolean valid(int a, int b, int c) {
        if (Math.abs(a - b) >= c) return false;
        if (Math.abs(b - c) >= a) return false;
        if (Math.abs(a - c) >= b) return false;
        if (a + b <= c) return false;
        if (b + c <= a) return false;
        if (c + a <= b) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            List<Integer> res = new ArrayList<Integer>();
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                int o = cin.nextInt();
                int l = cin.nextInt();
                if (o == 1) {
                    // 添加木棒
                    res.add(l);
                } else {
                    // 删除木棒
                    int idx = res.indexOf(l);
                    if (idx == -1) {
                        System.out.println("No");
                        continue;
                    }
                    res.remove(idx);
                }
                int k = res.size();
                if (k >= 4) {
                    // 多边形的情况
                    int max = 0;
                    int s = 0;
                    for (int j = 0; j < k; j++) {
                        int tmp = res.get(j);
                        if (max < tmp) max = tmp;
                        s += tmp;
                    }
                    if (s <= 2 * max) System.out.println("No");
                    else
                        System.out.println("Yes");
                } else if (k == 3) {
                    // 三角形的情况
                    int a = res.get(0);
                    int b = res.get(1);
                    int c = res.get(2);
                    if (valid(a, b, c)) System.out.println("Yes");
                    else
                        System.out.println("No");
                } else
                    // 无法构成多边形
                    System.out.println("No");
            }
        }
    }
}


