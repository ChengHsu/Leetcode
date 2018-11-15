package String;

/**
 * @Number: 557. Reverse Words in a String III
 * @Descpription: Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 * @Author: Created by xucheng.
 */
public class ReverseWordsinaStringIII {
//    public String reverseWords(String s) {
//        String[] words = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < words.length; j++) {
//            for (int i = words[j].length() - 1; i >= 0; i--) {
//                sb.append(words[j].charAt(i));
//            }
//            if (j != words.length - 1)
//                sb.append(" ");
//        }
//        return sb.toString();
//    }
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word: words) {
            res.append(new StringBuilder(word).reverse().append(" "));
        }
        // Delete leading and ending spaces
        return res.toString().trim();
    }
}
