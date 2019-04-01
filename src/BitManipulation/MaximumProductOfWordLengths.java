package BitManipulation;

/**
 * @Number: #318. Maximum Product of Word Lengths
 * @Descpription: Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * @Author: Created by xucheng.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            // convert every word to its binary format
            //  "a" then its binary format would be 1, because a is the first letter in the alphabets.
            //  "ab" would have the binary format 11,
            //  "ac" would have the binary format 101,
            //  "d" would have the binary format 1000, because d is the forth letter in the alphabets.
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        // AND every binary format ,if == 0, then they don't share common letters
        int maxProd = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((value[i] & value[j]) == 0)
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        return maxProd;
    }
}
