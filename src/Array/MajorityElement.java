package Array;

/**
 * @Descpription: #169
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @Author: Created by xucheng.
 */
public class MajorityElement {

    //    Moore voting algorithm: 每找出两个不同的element，就成对删除即count--，最终剩下的一定就是所求的

    public int majorityElement(int[] nums) {
        int count = 0;
        int elem = 0;
        for (int i = 0; i < nums.length; i++) {
            // count = 0：前面的相互抵消，重新以当前元素作为elem
            if (count == 0) {
                elem = nums[i];
                count = 1;
            } else
                // 如果遇到相同的就加1，遇到不同的就减1
                {
                if (elem == nums[i]) {
                    count++;
                } else count--;
            }
        }
        return elem;
    }
}
