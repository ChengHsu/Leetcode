package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Number: 893. Groups of Special-Equivalent Strings
 * @Descpription: You are given an array A of strings.
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string
 * not in S is not special-equivalent with any string in S.
 * Return the number of groups of special-equivalent strings from A.
 * @Author: Created by xucheng.
 */
public class GroupsofSpecialEquivalentStrings {
    /**
     * https://www.youtube.com/watch?v=WJ4NtyrakT0
     * Sort and substring at even and odd positions separately
     * Add them to hash set to eliminate the duplicate
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String word: A) {
            String odd = "",even = "";
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) even += word.charAt(i);
                else odd += word.charAt(i);
            }
            odd = sort_string(odd);
            even = sort_string(even);
            seen.add(odd+even);
        }
        return seen.size();
    }

    private String sort_string(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return String.valueOf(a);
    }
}
