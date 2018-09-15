package String;

/**
 * @Number: #38. Count and Say
 * @Descpription: The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * @Author: Created by xucheng.
 */
public class CountAndSay {
    // Again
    // Recursion: Str(n) = Str(n-1) + count and say

    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev)
                count++;
            else {
                sb.append(count).append(prev);
                count = 1;
                prev = curr;
            }
        }
        System.out.println("Before: "+sb);
        sb.append(count).append(prev);
        System.out.println("After: "+sb);
        return sb.toString();
    }
}
