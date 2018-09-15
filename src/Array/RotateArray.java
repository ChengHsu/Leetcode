package Array;

/**
 * @Descpription: #189.
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Answer: https://leetcode.com/articles/rotate-array/
 * @Author: Created by xucheng.
 */


public class RotateArray {
//    Brute Force : to rotate all the elements of the array in
// k steps by rotating the elements by one unit in each step
//        Time complexity: O(n* K)
//    public void rotate(int[] nums, int k) {
//        int tmp, prev;
//        int len = nums.length;
//        for(int i = 0 ; i < k ; i++) {
//            prev = nums[len-1];
//            for(int j = 0; j < len; j++) {
//                tmp = nums[j];
//                nums[j] = prev;
//                prev = tmp;
//            }
//        }
//    }

//  create an extra array in which we place very element of the array in its correct position
//    i.e. the number at index i in the original array is placed at the index(i+k).
//    Then copy the new array to the original one
//    Time complexity: O(n)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] a = new int[len];
        for(int i = 0; i < len; i++) {
           a[(i+k) % len] = nums[i];
        }
        for(int i = 0; i < len; i++)
        {
            nums[i] = a[i];
            System.out.println(nums[i]);
        }

    }

//     利用k把数组分成两部分，分别reverse两部分，再reverse整个数组
//    Time complexity: O(1)
//    public void rotate(int[] nums, int k) {
//        int len = nums.length;
//        int tmpK = k % len;
//        int middle = len - tmpK;
//        reverse(nums,0,middle - 1);
//        reverse(nums,middle,len-1);
//        reverse(nums,0,len-1);
//        for (int i = 0; i < len; i++) {
//            System.out.println(nums[i]);
//        }
//    }
//
//    public void reverse(int[] nums, int start, int end){
//        while ( start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
}
