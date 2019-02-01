package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #282. Expression Add Operators
 * @Descpription: Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * @Author: Created by xucheng.
 */
public class ExpressionAddOperators {
    /**
     * https://www.youtube.com/watch?v=v05R1OIIg08
     * DFS
     * DFS(expr, pos, prev, curr):
     * for i in range():
     * n = int(num[pos:pos+i])
     * DFS(expr + '+' + n, pos + i, + n, curr + n);
     * DFS(expr + '-' + n, pos + i, - n, curr + n);
     * DFS(expr + '*' + n, pos + i, prev * n, curr - prev + prev * n);
     * Time: 字符串copy O(n^2), n digits有 n-1 spaces, 每个space可以填 +，-，*，space 4种 O(4^(n - 1)), 所以O(n^2 * 4^(n - 1))
     * Space: O(n^2)
     *
     * @param num
     * @param target
     * @return
     */
    private List<String> ans; //  answers
    private char[] num;//  digits of input number string
    private char[] exp; //  one current expression
    private int target; // target number

    public List<String> addOperators(String num, int target) {
        this.num = num.toCharArray();
        this.ans = new ArrayList<>();
        this.target = target;
        this.exp = new char[num.length() * 2]; // maxLen:在所有n个数字的(n-1)个spaces之间都加上一个op -> n(n-1)
        dfs(0, 0, 0, 0);
        return ans;
    }

    /**
     * @param pos  当前处理的digit的index
     * @param len  当前expr的长度
     * @param prev 上一个节点(operator+数字，若为乘法ze为连乘的所有数字表达式)
     * @param curr 当前表达式的值
     */
    private void dfs(int pos, int len, long prev, long curr) {
        if (pos == num.length) {
            if (curr == target)
                // 找到答案时从exp中取出一个substring,因为exp大小为num.length() * 2，当前exp可能没有这么长
                ans.add(new String(exp, 0, len));
            return;
        }

        int s = pos; // expr现在dfs到的字符的位置
        int l = len; // 初始expr的长度
        if (s != 0) ++len; // 不是第一个节点，要给op留个位置，op的idx就是l

        long n = 0;
        while (pos < num.length) {
            if (num[s] == '0' && pos - s > 0) break; // 0X... invalid number
            n = n * 10 + (int) (num[pos] - '0');
            if (n > Integer.MAX_VALUE) break; // too long
            exp[len++] = num[pos++]; // copy exp
            // first node单独处理, 前面没有op
            if (s == 0) {
                dfs(pos, len, n, n);
                continue;
            }
            exp[l] = '+';
            dfs(pos, len, n, curr + n);
            exp[l] = '-';
            dfs(pos, len, -n, curr - n);
            exp[l] = '*';
            dfs(pos, len, prev * n, curr - prev + prev * n);
        }
    }
}
