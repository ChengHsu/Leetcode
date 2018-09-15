package Array;

/**
 * @Number: #485
 * @Descpription: Given a binary array, find the maximum number of consecutive 1s in this array.
 * @Author: Created by xucheng.
 */
public class MaxConsecutiveOnes {
//  两个临时变量，一个记录每次连续的值的大小，一个记录最大的连续值的大小，读到了 0 则比较最大值和当前值的大小，将最大值保存在我们需要返回的值中。
    public int findMaxConsecutiveOnes(int[] nums) {
        int MaxNumsOne = 0;
        int CurNumsOne = 0;
        for (int num: nums) {
            if(num == 1)
                CurNumsOne++;
            else CurNumsOne = 0;
            MaxNumsOne = Math.max(CurNumsOne,MaxNumsOne);
        }
        return MaxNumsOne;
    }
}
