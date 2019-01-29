package Array;

/**
 * @Number: #243. Shortest Word Distance
 * @Descpription: Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * # 245. Shortest Word Distance III
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * @Author: Created by xucheng.
 */
public class ShortestWordDistance {
    /**
     * Brute Force
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || words.length == 1)
            return 0;

        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        min = Math.min(min, Math.abs(i - j));
                    }
                }
            }
        }
        return min;
    }

    /**
     * One Pass
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance_sim(String[] words, String word1, String word2) {
        if (words.length == 0 || words.length == 1)
            return 0;
        int min = words.length;
        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                idx1 = i;
            else if (words[i].equals(word2))
                idx2 = i;
            if (idx1 != -1 && idx2 != -1)
                min = Math.min(min, Math.abs(idx1 - idx2));
        }
        return min;

    }

    /**
     * Shortest Word Distance III
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int res = words.length;
        boolean flag = true;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && flag ) {
                i1 = i;
                if (i2 >= 0) res = Math.min(res, i1 - i2);
                if (word1.equals(word2)) flag = false;
            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 >= 0) res = Math.min(res, i2 - i1);
                if (word1.equals(word2)) flag = true;
            }
        }
        return res;
    }

}
