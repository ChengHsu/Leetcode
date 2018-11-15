package Array;

/**
 * @Descpription: #26.
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
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
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        // Use the fast pointers to skip duplicates when nums[fast] == nums[slow]
        // Add slow by 1 and set it to num[fast] store a different value when nums[fast] != nums[slow]
        for (int fast  = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
