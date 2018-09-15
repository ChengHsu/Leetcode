package Stack;

import BinarySearch.ArrangingCoins;
import BinarySearch.PeakIndexinaMountainArray;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {

    public static void main(String[] args) {
//       ValidParentheses validParentheses = new ValidParentheses();
//        System.out.println(validParentheses.isValid(""));
//        MinStack minStack = new MinStack();
//        minStack.push(2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.push(4);
//        System.out.println("top: "+minStack.top());
//        System.out.println(minStack.getMin());
//          Queue<Integer> queue = new LinkedList<>();
//          queue.add(1);
//          queue.add(2);
//        System.out.println(queue);
//        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
//        String S = "ab#c"; String T = "ad#c";
//        boolean b = backspaceStringCompare.backspaceCompare(S,T);
//        System.out.println(b);
//        ArrangingCoins arrangingCoins = new ArrangingCoins();
//        System.out.println(arrangingCoins.arrangeCoins(8));
        int[] A = {0,1,0};
        PeakIndexinaMountainArray peakIndexinaMountainArray = new PeakIndexinaMountainArray();
        peakIndexinaMountainArray.peakIndexInMountainArray(A);
    }
}
