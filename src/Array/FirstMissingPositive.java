package Array;

/**
 * @Number: #41. First Missing Positive
 * @Descpription: Given an unsorted integer array, find the smallest missing positive integer.
 * @Author: Created by xucheng.
 */
public class FirstMissingPositive {
    /**
     * 给定数组应该包含的数默认是从1到数组中最大值
     * 第一次遍历：Bucket sort: 交换数组元素，使数组中第i位存放数值(i+1)
     * 第二次遍历：寻找第一个不符合要求的元素返回其下标
     *
     * @param A
     * @return
     */

//    public int firstMissingPositive(int[] nums) {
//        if (nums == null) return 1;
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i+1)) {
//                int tmp = nums[nums[i] - 1];
//                if (tmp == nums[i])
//                    break;
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = tmp;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i ++)
//            if (nums[i] != i + 1)
//                return i + 1;
//
//        return nums.length + 1;
//    }
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            // A[i] should equals to i + 1, if not keep swapping A[i] = A[A[i]-1]
            if (A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);
            // A[i] == i+1 || A[i] <= 0 || A[i] > A.length || else
            else i++;
        }
        i = 0;
        // Find first value that is not on its correct position
        while (i < A.length && A[i] == i + 1)
            i++;
        return i + 1;
    }

    private void swap(int[] A, int i, int j) {

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
