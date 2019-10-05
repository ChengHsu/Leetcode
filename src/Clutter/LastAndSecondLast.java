package Clutter;

/**
 * @Descpription: OA
 * @Author: Created by xucheng.
 */
public class LastAndSecondLast {
    /**
     * Input1: APPLE
     * Output1: E L
     * Input2: bat
     * Output2: t a
     * time: O(1)
     * space: O(1)
     * @param word
     */
    public String lastLetters(String word) {
        int len = word.length();
        // corner case; return just one character following a space
        if(len == 1) return word.charAt(0) + " ";
        // return last two characters separated by one space
        return word.charAt(len - 1) + " " + word.charAt(len - 2);
    }

    public static void main(String[] args) {
        LastAndSecondLast lastAndSecondLast = new LastAndSecondLast();
        System.out.println(lastAndSecondLast.lastLetters("b"));
    }
}
