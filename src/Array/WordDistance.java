package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Number: #244. Shortest Word Distance II
 * @Descpription: Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
 * @Author: Created by xucheng.
 */
public class WordDistance {
    // 直接把 Shortest Word Distance的solution改成class会time limited error:
    // You are iterating the given array every time you receive a query.
    // So if the words given to you are the last two words of the array then the performance of your code goes down when the shortest method is called multiple times.
    // Hint: Why are you iterating the complete array for just 2 words?
//    private String[] word;
//
//    public WordDistance(String[] words) {
//        word = words;
//    }
//
//    public int shortest(String word1, String word2) {
//        int min = word.length;
//        int idx1 = -1;
//        int idx2 = -1;
//
//        for (int i = 0; i < word.length; i++) {
//            if (word[i].equals(word1))
//                idx1 = i;
//            else if (word[i].equals(word2))
//                idx2 = i;
//            if (idx1 != -1 && idx2 != -1)
//                min = Math.min(min, Math.abs(idx1 - idx2));
//        }
//        return min;
//    }


    // Solution:

    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

    /**
     * Put all the indices into HashMap
     * @param words
     */
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> indices = hashMap.getOrDefault(words[i], new ArrayList<>());
            indices.add(i);
            hashMap.put(words[i],indices);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (word1 == word2) {
            ArrayList<Integer> iList = hashMap.get(word1);
            return iList.get(1) - iList.get(0);
        }
        for (int idx1: hashMap.get(word1))
            for (int idx2: hashMap.get(word2))
                min = Math.min(min,Math.abs(idx1 - idx2));
        return min;
    }
}
