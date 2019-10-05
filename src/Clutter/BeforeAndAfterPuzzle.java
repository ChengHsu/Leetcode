package Clutter;

import Array.BestTimeToBuyAndSellStock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: OA
 * @Author: Created by xucheng.
 */
public class BeforeAndAfterPuzzle {
    /**
     * time: O(n) where n is the number of phrases
     * space: O(n) for using the HashMap
     */
    public List<String> generate_phrases(List<String> phrases) {
        List<String> res = new ArrayList<>(); // result list
        // corner case: return empty list if input is null or empty
        if(phrases == null || phrases.size() == 0) return res;

        HashMap<String, List<Integer>> map = new HashMap<>(); // store indices of strings starts with their 1st word
        for(int i = 0; i < phrases.size(); i++) {
            String phrase = phrases.get(i);
            String firstWord = phrase.substring(0, phrase.indexOf(" "));
            map.putIfAbsent(firstWord, new ArrayList<>());
            map.get(firstWord).add(i);
        }

        // search for last word of current string as the key in the map
        // combine any two matched strings into one and add it into result list
        for(int i = 0; i < phrases.size(); i++) {
            String phrase = phrases.get(i);
            String lastWord = phrase.substring(phrase.lastIndexOf(" ") + 1);
            if(map.containsKey(lastWord)) {
                List<Integer> indices = map.get(lastWord);
                for(Integer idx: indices) {
                    String tmp = phrases.get(idx);
                    res.add(phrase + tmp.substring(tmp.indexOf(" ")));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BeforeAndAfterPuzzle b  = new BeforeAndAfterPuzzle();
        List<String> input = new ArrayList<>();
        input.add("mission statement");
        input.add("a quick bite to eat");
        input.add("a chip off the old block");
        input.add("chocolate bar");
        input.add("mission impossible");
        input.add("a man on a mission");
        input.add("block party");
        input.add("eat my words");
        input.add("bar of soap");
        List<String> res = b.generate_phrases(input);
        for(String str: res)
            System.out.println(str);
    }
}
