package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #520. Detect Capital
 * @Descpription: Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 1.All letters in this word are capitals, like "USA".
 * 2.All letters in this word are not capitals, like "leetcode".
 * 3.Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * @Author: Created by xucheng.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.equals("")) return false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c))
                list.add(i);
        }
        if (list.isEmpty()) return true;
        if (list.size() == word.length()) return true;
        if (list.size() == 1 && list.get(0) == 0) return true;
        return false;
    }
}
