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
    /**
     * 349
     * two pointers
     * time: O(n log n)
     * space: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[i]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else
                j++;
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }

    /**
     * 349
     * binary search
     * for every number in nums1, search if that number is in nums2
     * time: O(n log n)
     * space: O(n）
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums1) {
            if (binarySearch(nums2,num))
                set.add(num);
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == num)
                return true;
            else if (nums[mid] < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }


    /**
     * 350
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
     * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
     * @param nums1
     * @param nums2
     * @return
     */
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
