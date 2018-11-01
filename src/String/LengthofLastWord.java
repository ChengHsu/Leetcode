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
//    public int lengthOfLastWord(String s) {
//        int len = 0;
//        if (s.length() == 0) return 0;
//        if (s.length() == 1) {
//            if (s.charAt(s.length() - 1) == ' ')
//                return 0;
//            else return 1;
//        }
//        int i = s.length() - 1;
////      Remove empty space chars at the end of string
//        while (i >= 0) {
//            if (s.charAt(i) == ' ')
//                i--;
//            else break;
//        }
////      count the length of the last word
//        while (i >= 0) {
//            if (s.charAt(i) == ' ')
//                break;
//            else {
//                i--;
//                len++;
//            }
//        }
//        return len;
//    }

//  split() will remove all the empty chars at the end of the string
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(i+": "+words[i]);
        }
        if (words == null || words.length == 0)
            return 0;
        else return words[words.length-1].length();
    }

}
