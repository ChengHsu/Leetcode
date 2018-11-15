package String;

import java.util.HashMap;

/**
 * @Number: #383. Ransom Note
 * @Descpription: Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * @Author: Created by xucheng.
 */
public class RansomNote {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        HashMap<Character, Integer> countRansom = new HashMap<>();
//        HashMap<Character, Integer> countMagazine = new HashMap<>();
//        for (char c : ransomNote.toCharArray())
//            countRansom.put(c, countRansom.getOrDefault(c, 0) + 1);
//        for (char c : magazine.toCharArray())
//            countMagazine.put(c, countMagazine.getOrDefault(c, 0) + 1);
//        for (char c : countMagazine.keySet())
//            System.out.println("key: " + c + " " + countMagazine.get(c));
//        for (char c : countRansom.keySet()) {
//            if (!countMagazine.containsKey(c) || (countMagazine.containsKey(c) && countMagazine.get(c) < countRansom.get(c)))
//                return false;
//        }
//        return true;
//    }

    // Use one array to record the occurrence
    // increase if it's in magazine decrease if it's in ransom note
    // if occurrence < 0 means magazine can not afford to construct ransom note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c: magazine.toCharArray())
            count[c-'a']++;
        for (char c: ransomNote.toCharArray())
        {
            count[c-'a']--;
            if (count[c-'a'] < 0)
                return false;
        }
        return true;
    }
}
