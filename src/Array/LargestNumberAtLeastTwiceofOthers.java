package Array;

/**
 * @Number: #747. Largest Number At Least Twice of Others
 * @Descpription: In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 * @Author: Created by xucheng.
 */
public class LargestNumberAtLeastTwiceofOthers {
//    public int dominantIndex(int[] nums) {
//        int max = nums[0];
//        int maxIdx = 0;
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] > max) {
//                max = nums[i];
//                maxIdx = i;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]!= max && nums[i] * 2 > max) return -1;
//        }
//        return maxIdx;
//    }

    public int dominantIndex(int[] nums) {
        if(nums.length == 1)
            return 0;
        int firstMax = 0;
        int secondMax = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[firstMax]) {
                secondMax = firstMax;
                firstMax = i;
            }
            else if (nums[i] > nums[secondMax]) {
                secondMax = i;
            }
        }
        return nums[firstMax] >= nums[secondMax]*2 ? firstMax : -1;
    }
}
