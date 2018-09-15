package TwoPointers;

/**
 * @Number: #345. Reverse Vowels of a String
 * @Descpription: Write a function that takes a string as input and reverse only the vowels of a string.
 * @Author: Created by xucheng.
 */


public class ReverseVowelsofaString {

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else return false;
    }

    public String reverseVowels(String s) {
        int front = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int i = 0;
        while (front < end) {
            if (isVowel(arr[front]) && isVowel(arr[end])) {
                char tmp = arr[front];
                arr[front] = arr[end];
                arr[end] = tmp;
                front += 1;
                end -= 1;
            } else if (!isVowel(arr[front]) && isVowel(arr[end])) {
                front += 1;
            } else if (isVowel(arr[front]) && !isVowel(arr[end])) {
                end -= 1;
            } else if (!isVowel(arr[front]) && !isVowel(arr[end])) {
                front += 1;
                end -= 1;
            }
        }
        return new String(arr);
    }
}
