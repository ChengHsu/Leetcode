package bytedance;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class magicWeight {

    static List<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            String[] strs = new String[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                strs[i] = scan.next();
            }
            arrange(strs, 0, n);
            for (int i = 0; i < list.size(); i++) {
                if (weight(list.get(i)) == k)
                    count++;
            }
            System.out.println(count);
        }
    }

    public static void arrange(String[] arr, int start, int len) {
        if (start == len - 1) {
            String temp = "";
            for (int i = 0; i < arr.length; i++)
                temp += arr[i];
            list.add(temp);
        } else {
            for (int i = start; i < len; i++) {
                swap(arr, start, i);
                arrange(arr, start + 1, len);
                swap(arr, start, i);
            }
        }
    }

    public static void swap(String[] arr, int x, int y) {
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int weight(String str) {
        int ans = 0;
        int len = str.length();
        for (int i = 1; i <= str.length(); i++) {
            if (str.substring(0, i).equals(str.substring(len - i, len)) && str.substring(0, len - i).equals(str.substring(i, len)))
                ans++;
        }
        return ans;
    }
}