package Array;

/**
 * @Number: #287. Find the Duplicate Number
 * @Descpription: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * @Author: Created by xucheng.
 */
public class FindtheDuplicateNumber {
    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/solution/
     * https://leetcode.com/problems/linked-list-cycle-ii/solution/
     * Floyd's Tortoise and Hare
     * If we interpret nums such that for each pair of index i and value v[i],
     * the "next" value v[j] is at index v[i], we can reduce this problem to cycle detection.
     * we can easily show that the constraints of the problem imply that a cycle must exist.
     * Because each number in nums is between 1 and n, it will necessarily point to an index that exists.
     * case1:
     * index 0 1 2 3 4
     * value 1,3,4,2,2
     * 0->1->3->2->4->2 cycle: 2->4->2
     * case2:
     * index 0 1 2 3 4
     * value 3,1,3,4,2
     * 0->3->4->2->3->4->2 cycle: 3->4->2->3
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        // Find the intersection point of the two runners.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
