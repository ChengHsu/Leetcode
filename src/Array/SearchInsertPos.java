package Array;

/**
 * @Descpription: #35.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
   You may assume no duplicates in the array.
 * @Author: Created by xucheng.
 */
public class SearchInsertPos {
// linear search
//    public int searchInsert(int[] nums, int target) {
//        int hasTar = 0;
//        int gTar = 0;
//        int idx = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] == target) {
//                hasTar = 1;
//                idx = i;
//                System.out.println(idx);
//            }
//            else if(nums[i] > target && gTar == 0 && hasTar == 0){
//                gTar = 1;
//                idx = i ;
//            }
//        }
//        if((hasTar == 1) || (hasTar == 0 && gTar == 1))
//        {
//            return idx;
//        }
//        else if(hasTar == 0 && gTar == 0){
//            return nums.length;
//        }
//        return 0;
//    }

//  binary search
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

}
