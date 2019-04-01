package Sort;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MergeSort {
    private int[] nums;
    private int[] newNums;
    private int length;


    public void mergesort(int inputArr[]) {
        this.nums = inputArr;
        this.length = inputArr.length;
        this.newNums = new int[length];
        doMergeSort(0, length - 1);
    }

    public void doMergeSort(int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            // sorts the left side of the array
            doMergeSort(left, mid);
            // sorts the right side of the array
            doMergeSort(mid + 1, right);
            // merge both sides
            mergeHalves(left, mid, right);
        }
    }

    // merge 2 sorted parts
    public void mergeHalves(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            newNums[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            if (newNums[i] <= newNums[j]) {
                nums[idx++] = newNums[i];
                i++;
            } else {
                nums[idx++] = newNums[j];
                j++;
            }
        }
        // copy the rest of the first part
        while (i <= mid) {
            nums[idx++] = newNums[i++];
        }

    }
}
