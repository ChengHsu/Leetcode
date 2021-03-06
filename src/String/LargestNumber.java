package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Number: #179. Largest Number
 * @Descpription: Given a list of non negative integers, arrange them such that they form the largest number.
 * @Author: Created by xucheng.
 */
public class LargestNumber {

    /**
     * Compare; 如果[ab]组成的结果大于[ba]组成的结果，那么a>b
     */
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs)
            largestNumberStr += numAsStr;

        return largestNumberStr;
    }
}



