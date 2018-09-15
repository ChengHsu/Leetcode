package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Number: #824. Goat Latin
 * @Descpription: A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * @Author: Created by xucheng.
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        for (char c: new char[]{'a','e','i','o','u','A','E','I','O','U'})
            vowel.add(c);
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for ( String word : S.split(" ") ) {
            char start = word.charAt(0);
            if (vowel.contains(start)) {
                ans.append(word);
            }
            else {
                // remove 1st char: replace(start,"") will remove all chars in word that == start
                // substring(startIdx, endIdx): return a substring from startIdx to endIdx, char at endIdx isn't included.
                ans.append(word.substring(1));
                ans.append(word.substring(0,1));
            }
            ans.append("ma");
            for (int i = 0; i < count; i++)
                ans.append("a");
            count++;
            ans.append(" ");
        }
        // delete extra " " at the end of string
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
