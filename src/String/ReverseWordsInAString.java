package String;

/**
 * @Number: 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * 186. Reverse Words in a String II
 * Given an input string , reverse the string word by word.
 * 557. Reverse Words in a String III
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ReverseWordsInAString {
    /**
     * 151
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // process the string
        String[] words = s.trim().split(" +");
        // edge case
        if (words == null || words.length == 0)
            return "";
        if (words.length == 1)
            return words[0].toString();
        // swap the words
        int i = 0;
        int j = words.length - 1;
        while (i < j) {
            String tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
            i++;
            j--;
        }
//        String res = "";
//
//        for (int m = 0; m < words.length - 1; m++) {
//            res += words[m] + " ";
//        }
//        return res + words[words.length - 1];
        return String.join(" ", words);
    }

    /**
     * 186
     * Three steps
     * https://leetcode.com/problems/reverse-words-in-a-string-ii/discuss/53775/My-Java-solution-with-explanation
     * @param str
     */
    public void reverseWords(char[] str) {
//      1. Reverse the whole sentence
        reverse(str, 0, str.length - 1);
//      2. Reverse each word
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
//      3. Reverse the last word (Cuz no more ' ', so the last word won't be reversed in the for loop)
        reverse(str, start, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}
