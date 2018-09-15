package TwoPointers;

/**
 * @Number: #125. Valid Palindrome
 * @Descpription: Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int front = 0;
        int end = arr.length - 1;
        while (front < end) {
            if (!Character.isLetterOrDigit(arr[front])) {
                front++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[end])) {
                end--;
                continue;
            }
            if (arr[front] != arr[end])
                return false;
            front += 1;
            end -= 1;
        }
        return true;
    }
}
