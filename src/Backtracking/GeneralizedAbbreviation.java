package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: # 320. Generalized Abbreviation
 * @Descpription: Write a function to generate the generalized abbreviations of a wo
 * @Author: Created by xucheng.
 */
public class GeneralizedAbbreviation {
    /**
     * 0000 word
     * 0001 wor1
     * 0010 wo1d
     * 0011 wo2
     * 0100 w1rd
     * 0101 w1r1
     * 0110 w2d
     * 0111 w3
     * 1000 1ord
     * 1001 1or1
     * 1010 1o1d
     * 1011 1o2
     * 1100 2rd
     * 1101 2r1
     * 1110 3d
     * 1111 4
     * 凡是有0的地方都是原来的字母，单独的1还是1，若干个1在一起需要求出1的个数，用数字替换对应的字母
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), word, 0 ,0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, String word, int currIdx, int count) {
        int len = sb.length();
        if (currIdx == word.length()){
            if (count != 0)
                sb.append(count);
            res.add(sb.toString());
            return;
        }
        backtrack(res, sb, word, currIdx + 1, count + 1);
        if (count != 0) sb.append(count);
        sb.append(word.charAt(currIdx));
        backtrack(res, sb, word, currIdx + 1, 0);
        sb.setLength(len);// reset builder to the original state
    }


}
