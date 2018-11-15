package String;

import java.util.Arrays;

/**
 * @Number: #455. Assign Cookies
 * @Descpription: Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size sj.
 * If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * @Author: Created by xucheng.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Greedy
        // Sort two arrays in ascending order
        // Assign cookies to the child with minimum greed factor
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            // It comes to the next child only when the current one is contented with a cookie
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
        }
        return count;
    }
}
