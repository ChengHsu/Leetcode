package Backtracking;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,4,5,6,7,8};
        Collections.rotate(Arrays.asList(arr), -4);
        System.out.println(Arrays.toString(arr));

        System.out.println();
    }




}
