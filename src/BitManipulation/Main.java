package BitManipulation;

import java.util.Arrays;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
//        String[] words = {"abcw","baz","foo","bar"};
//       MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
//       maximumProductOfWordLengths.maxProduct(words);
        // -9 -3 4 5 7
        //  l        r

        int[] nums = {4,5,-3,7,-9};
        int minSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            for (int j = i ; j < nums.length; j++){
                if(Math.abs(nums[i] + nums[j]) < minSum)
                    minSum = Math.abs(nums[i] + nums[j]);
            }
        }
        System.out.println(minSum);
        return;
    }
}
