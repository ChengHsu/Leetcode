package String;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Number: #819. Most Common Word
 * @Descpription: Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * @Author: Created by xucheng.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> occurrence = new HashMap<>();
        // Pre-processing the paragraph: eliminate punctuation | convert to lowercase | split by space
        // Regex: []: match any one thing in []   +: repeat
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        // record the occurrence of each word
        for (String word : words)
            occurrence.put(word, occurrence.getOrDefault(word, 0) + 1);
        // remove the banned word from the map
        for (String word: banned)
            if (occurrence.containsKey(word))
                occurrence.remove(word);
        // Find the word with max value in the map
        String res = null;
        for (String word: occurrence.keySet())
            if (res == null || occurrence.get(word) > occurrence.get(res))
                res = word;
        return res;
    }
}
