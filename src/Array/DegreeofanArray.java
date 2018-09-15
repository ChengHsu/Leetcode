package Array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #697.Degree of an Array
 * @Descpription: Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * @Author: Created by xucheng.
 */
public class DegreeofanArray {
//    public int findShortestSubArray(int[] nums) {
////  The shortest subarray starts from the 1st occurrence of mode number anf end with the last occurrence of mode number
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return 1;
//
//        Map<Integer, Integer> left = new HashMap(),
//                right = new HashMap(), count = new HashMap();
//
//        for (int i = 0; i < nums.length; i++) {
//            int x = nums[i];
//            if (left.get(x) == null) left.put(x, i);
//            right.put(x, i);
//            count.put(x, count.getOrDefault(x, 0) + 1);
//        }
//
//        int ans = nums.length;
//        int degree = Collections.max(count.values());
//        System.out.println(degree);
//        int start = 0;
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] == degree) {
//                start = i;
//                break;
//            }
//        int end = 0;
//        for (int i = nums.length - 1; i >= 0; i--)
//            if (nums[i] == degree) {
//                end = i;
//                break;
//            }
//        return (end - start + 1);
//    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}
