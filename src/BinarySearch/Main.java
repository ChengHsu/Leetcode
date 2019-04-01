package BinarySearch;

import TwoPointers.ListNode;
import TwoPointers.PalindromeLinkedList;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums,2));
    }
}
