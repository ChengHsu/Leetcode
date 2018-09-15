package BinarySearch;

/**
 * @Number: #744. Find Smallest Letter Greater Than Target
 * @Descpription: Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * @Author: Created by xucheng.
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length;
        while (low < high) {
            int mid = (low + high) / 2;
            System.out.println("mid: "+mid);
            if (letters[mid] <= target) {
                low = mid + 1;
                System.out.println("low: "+low);
            } else high = mid;
        }
        return letters[low % letters.length];
    }
}
