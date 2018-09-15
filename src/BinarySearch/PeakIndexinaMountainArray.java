package BinarySearch;

/**
 * @Number: #852. Peak Index in a Mountain Array
 * @Descpription: Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * @Author: Created by xucheng.
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
//        linear search
//        int i = 0;
//        while (A[i] < A[i + 1]) i++;
//        return i;

//        binary search
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}
