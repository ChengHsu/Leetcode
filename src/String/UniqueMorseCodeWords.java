package String;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * @Number: #804. Unique Morse Code Words
 * @Descpription: International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cba" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 * @Author: Created by xucheng.
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word: words) {
            StringBuilder char2morse = new StringBuilder();
            for (char c: word.toCharArray()){
                // c-'a' gets the index of c in MORSE
                char2morse.append(MORSE[c-'a']);
            }
            set.add(char2morse.toString());
        }
        return set.size();
    }
}

