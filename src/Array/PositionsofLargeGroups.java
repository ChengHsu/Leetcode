package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Number: #830. Positions of Large Groups
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class PositionsofLargeGroups {
    // Two pointers
    public List<List<Integer>> largeGroupPositions(String S) {
       List<List<Integer>> idx = new ArrayList<>();
       int start = 0;
       for (int end = 0; end < S.length(); end++) {
           if (end == S.length()-1 || S.charAt(end) != S.charAt(end+1)) {
               if (end - start + 1 >= 3)
                   idx.add(Arrays.asList(new Integer[]{start,end}));
               start = end+1;
           }

        }
        return idx;
    }
}
