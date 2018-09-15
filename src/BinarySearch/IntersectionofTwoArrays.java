package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Number: #349. Intersection of Two Arrays & 350. Intersection of Two Arrays II
 * @Descpription: Given two arrays, write a function to compute their intersection.
 * #349: Each element in the result must be unique.
 * #350: Each element in the result should appear as many times as it shows in both arrays.
 * @Author: Created by xucheng.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                hashSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[hashSet.size()];
        int k = 0;
        for (int val : hashSet) {
            res[k++] = val;
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for (int val : list) {
            res[k++] = val;
        }
        return res;
    }
}
