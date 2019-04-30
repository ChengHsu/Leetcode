package InterviewPrep.WePay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class TextJustification {
    /**
     * iterate the words, during each iteration, we generate one line at a time
     * If it's one word then it is easy, the result is just that word.
     * If it's the last line then the result is all words separated by a single space.
     * Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.
     * time: O(n)
     * space: O(n)
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0)
            return new ArrayList<>();

        int index = 0;
        List<String> res = new ArrayList<>();
        while (index < words.length) {
            int currLen = words[index].length();
            int lastWordIdx = index + 1;
            // forward to the right as far as possible
            while (lastWordIdx < words.length) {
                if (currLen + words[lastWordIdx].length() + 1 > maxWidth)
                    break;
                currLen += words[lastWordIdx++].length() + 1;
            }

            StringBuilder sb = new StringBuilder();

            // append the 1st word of this line
            sb.append(words[index]);

            // # of places between words
            int diff = lastWordIdx - index - 1;

            // last line or just one word - left justified
            if (lastWordIdx == words.length || diff == 0) {
                for (int i = index + 1; i < lastWordIdx; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i =  sb.length(); i < maxWidth; i++)
                    sb.append(" ");
            }
            else {
                // maxWidth - currLen: # of spaces that need inserted in total
                // (maxWidth - currLen) / diff: # of spaces needed to be inserted between each pair of words
                int spaces = (maxWidth - currLen) / diff;
                // if maxWidth - currLen is odd, then  # of spaces needed between each pair of words is different,
                // we distribute extra spaces from left to right util it reaches 0
                // e.g. maxWidth - currLen = 7,for: this is an, should distribute 4 spaces between "this" and "is" and
                // distribute 3 spaces between "is" and "an", in this case 5 spaces between "this" and "is" and 4 spaces
                // between "is" and "an"
                int extraSpaces = (maxWidth - currLen) % diff;
                for (int i = index + 1; i < lastWordIdx; i++) {
                    for (int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            index = lastWordIdx;
        }
        return res;
    }
}
