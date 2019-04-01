package Sort;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {5,23,11,89,77,98,4,28,65,43};
//       MergeSort mergeSort = new MergeSort();
//       mergeSort.mergesort(nums);
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(nums);
       for (int n: nums)
           System.out.print(n + " ");
    }
}
