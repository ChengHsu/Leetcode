package Array;

/**
 * @Descpription: #88.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * @Author: Created by xucheng.
 */
public class MergeSortedArray {
    public static int[] quickSort(int[] nums, int start, int end) {
        if(start < end) {
            int base = nums[start];
            int i = start, j = end;
            int temp;
            do {
                while((nums[i] < base) && (i < end))
                    i++;
                while((nums[j] > base) && (j > start))
                    j--;
                if(i <= j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            } while(i <= j);
            if(start < j)
                quickSort(nums,start,j);
            if(end > i)
                quickSort(nums,i,end);
        }
        return nums;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m,j = 0; i < m+n; i++) {
            nums1[i] = nums2[j++];
        }
        nums1 = quickSort(nums1,0,m+n-1);
    }
}
