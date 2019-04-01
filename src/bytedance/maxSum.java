package bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Number: The number of questions
 * @Descpription: 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。
 * 这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。
 * n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 * @Author: Created by xucheng.
 */

public class maxSum {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNext()) {
            n = cin.nextInt();
            String[] str = new String[n];
            Element[] e = new Element[10];
            for (int i = 0; i < 10; i++)
                e[i] = new Element();
            for (int i = 0; i < n; i++) {
                str[i] = cin.next();
                int l = str[i].length();
                long base = 1;
                for (int j = l - 1; j >= 0; j--, base *= 10) {
                    int idx = str[i].charAt(j) - 'A';
                    // 标记该字符不能为0
                    if (j == 0) e[idx].flag = 1;
                    e[idx].w += base;
                }
            }
            Arrays.sort(e, new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    return o1.w > o2.w ? 1 : (o1.w == o2.w ? 0 : -1);
                }

            });
            long s = 0;
            // 权值最低且不能为0的情况
            if (e[0].flag == 1) {
                int k = 0;
                for (; k < 10; k++) if (e[k].flag == 0) break;
                Element tmp = e[k];
                for (; k > 0; k--) e[k] = e[k - 1];
                e[0] = tmp;
            }
            // 权值越大映射的值越大
            for (int i = 9; i >= 0; i--) {
                s += e[i].w * i;
                //System.out.println(e[i].flag+" "+e[i].w);
            }

            System.out.println(s);

        }
    }
}

// 记录字符的权重和标识符，flag=0，表示该字符可以为0，反之，说明该字符不能为0.
class Element {
    long w;
    int flag;
}
