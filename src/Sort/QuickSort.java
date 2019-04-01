package Sort;

/**
 * @Number:
 * @Descpription: Implementation of QuickSort
 * @Author: Created by xucheng.
 */
public class QuickSort {
    public void quicksort(int[] nums){
        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int left, int right) {
        if(left >= right)
            return;

        int mid = (right - left) / 2 + left;
        int pivot = nums[mid];
        int index = partition(nums, left, right, pivot);
        quicksort(nums, left, index - 1);
        quicksort(nums, index, right);
    }

    // return dividing point of the partition
    private int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right){
            while (nums[left] < pivot)
                left++;
            while (nums[right] > pivot)
                right--;
            if (left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
