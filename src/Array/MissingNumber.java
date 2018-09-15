package Array;

/**
 * @Descpription: #268
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * @Author: Created by xucheng.
 */
public class MissingNumber {
//  Sn = n*(n-1)/2  the missing number = Sum of 0,...,n numbers - Sum of current numbers.
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int Sn = n * (n - 1) / 2;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return Sn-sum;
    }
}
