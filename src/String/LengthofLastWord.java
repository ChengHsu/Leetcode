package String;

/**
 * @Number: 58. Length of Last Word
 * @Descpription: Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * A word is defined as a character sequence consists of non-space characters only.
 * @Author: Created by xucheng.
 */
public class LengthofLastWord {
    /**
     * Split()
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words == null || words.length == 0)
            return 0;
        else return words[words.length - 1].length();
    }

}
