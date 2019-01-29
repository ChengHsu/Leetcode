package String;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class IsPermutationOfPalindrome {
    // To be a permutation of palindrome, a string can have no more than one character whose number is odd
    // 1. An "even" string must have all characters' numbers that r even
    // 2. An "odd" string must have exactly onr character with an odd count
    boolean isPermutationOfPalindrome(String str) {
        int countOdd = 0;
        int[] table = new int['z' - 'a' + 1];
        for (char c : str.toCharArray()) {
            table[c - 'a']++;
            if (table[c - 'a'] % 2 == 1)
                countOdd++;
            else countOdd--;
        }
        return countOdd <= 1;
    }
}
