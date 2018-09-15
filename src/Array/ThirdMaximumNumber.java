package Array;

/**
 * @Number: #414
 * @Descpription: Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * @Author: Created by xucheng.
 */
public class ThirdMaximumNumber {

//  use three variables to record first three max numbers of the array and update them when in the loop.
//  if third max number doesn't exist, return the max one.
    public int thirdMax(int[] nums) {
        int max = nums[0];
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num:nums
             ) {
            if(num == firstMax || num == secondMax || num == thirdMax) continue;
            if(num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;

            }
            else if(num < firstMax && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            }
            else if(num < secondMax && num > thirdMax) {
                thirdMax = num;
            }
        }
        return (thirdMax == Long.MIN_VALUE) ? (int)firstMax: (int)thirdMax;
    }
}
