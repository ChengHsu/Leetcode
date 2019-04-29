package InterviewPrep.WePay;

/**
 * @Number: 151. Reverse Words in a String
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");

        // corner case
        if (words == null || words.length == 0)
            return "";
        if (words.length == 1)
            return words[0];

        int start = 0;
        int end = words.length - 1;
        while (start < end) {
            String tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }
        return String.join(" ", words);
    }


    /**
     * input:  “   This is an  question ”
     * output: “ question  an is This   ”
     *
     * @param
     * @return
     */
    public String reverseWordsWithSpaces(String str) {
        char[] strChars = str.toCharArray();
        //1. Reverse the whole sentence
        reverse(strChars, 0, strChars.length - 1);
//      2. Reverse each word
        int start = 0;
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] == ' ') {
                reverse(strChars, start, i - 1);
                start = i + 1;
            }
        }
//      3. Reverse the last word (Cuz no more ' ', so the last word won't be reversed in the for loop)
        reverse(strChars, start, strChars.length - 1);

        return new String(strChars);
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
