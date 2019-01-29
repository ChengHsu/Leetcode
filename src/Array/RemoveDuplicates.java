package Array;

/**
 * @Descpription:
 * #26. Remove duplicates I:
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 * #80. Remove duplicates II:
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.


 * @Author: Created by xucheng.
 */
public class RemoveDuplicates {

    //    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0 ){
//            return 0;
//        }
//        int idx = 0;
//        Set<Integer> set = new HashSet<>();
//        for( int i = 0, len = nums.length; i < len ; i++) {
//            if(set.add(nums[i])) {
//                nums[idx++] = nums[i];
//            }
//        }
//        return idx;
//    }
    // Fast and slow pointers

    /**
     * The array is sorted.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int count = 1;
        // Use the fast pointers to skip duplicates when nums[fast] == nums[slow]
        // Add slow by 1 and set it to num[fast] store a different value when nums[fast] != nums[slow]
        for (int i  = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        for (int fast = 0; fast < nums.length; fast++ ) {
//            if (nums[slow] != nums[fast]) {
//                slow++;
//                nums[slow] = nums[fast];
//            }
//        }
//        return slow+1;
//    }

//  Remove duplicates II:
//    public int removeDuplicates(int[] nums) {
//        // edge case
//        if (nums.length <= 2)
//            return nums.length;
//        // count is the insert position
//        int count = 2;
//        for (int i = 2; i < nums.length; i++) {
//            if (nums[i] != nums[count - 2]) {
//                nums[count++] = nums[i];
//            }
//        }
//        return count;
//    }
}
