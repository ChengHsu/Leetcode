package Array;

/**
 * @Number: #665. Non-decreasing Array
 * @Descpription: Given an array with n integers, check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * @Author: Created by xucheng.
 */
public class NonDecreasingArray {
    /**
     *1: 4，2，3
     *2: -1，4，2，3
     *3: 2，3，3，2，4
     * 判断修改那个数字其实跟再前面一个数的大小有关系，首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
     * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
     * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
     * 这是修改的情况，由于我们只有一次修改的机会，所以用一个变量cnt，初始化为1，修改数字后cnt自减1，当下次再需要修改时，如果cnt已经为0了，直接返回false。遍历结束后返回true，
     */
    public boolean checkPossibility(int[] nums) {
        int modifyTime = 1;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] < nums[i-1]) {
               if (modifyTime == 0) return false;
               if (i == 1 || nums[i] >= nums[i - 2]) nums[i - 1] = nums[i];
               else nums[i] = nums[i - 1];
               --modifyTime;
           }
        }
        return true;
    }
}
