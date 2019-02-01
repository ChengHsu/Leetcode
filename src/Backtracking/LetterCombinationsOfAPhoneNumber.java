package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Number: #17. Letter Combinations of a Phone Number
 * @Descpription: Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * @Author: Created by xucheng.
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<String, String> map = new HashMap<>();

    /**
     * Time: O(3^N * 4^M) where N is the number of digits that maps to 3 letters and M is the number of digits that maps to 4 letters
     * Space: O(3^N * 4^M) since one has to keep 3^N * 4^M solutions
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        numToLetters();
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String tmp = map.get(digits.charAt(i));
            letters.add(tmp);
        }
        backtrack(res, "", digits);
        return res;
    }

    private void backtrack(List<String> res, String currComb, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            res.add(currComb);
            return;
        }
        // if there are still digits to check
        String digit = next_digits.substring(0, 1);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = map.get(digit).substring(i, i + 1);
            // append the current letter to the combination
            // and proceed to the next digits
            backtrack(res, currComb + letter, next_digits.substring(1));
        }
    }

    private void numToLetters() {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }
}