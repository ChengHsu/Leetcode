package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Number: 293. Flip Game
 * @Descpription: You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * 294. Flip Game II
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 * @Author: Created by xucheng.
 */
public class FlipGame {
    /**
     * 293
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }

    /**
     * 294
     * Recursion: if opponent doesn't win, then we win.
     * Time: O(n - 1)!
     * @param s
     * @return
     */
    public boolean canWin(String s) {
        char[] list = s.toCharArray();
        return helper(list);
    }

    private boolean helper(char[] list) {
//      For all possible moves made by us, check whether the opponent will win at the next move
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == '-' || list[i + 1] == '-') continue;
            list[i] = '-';
            list[i + 1] = '-';
//          After turning "++" into "--", it's the opponent's turn to make a move
            boolean otherWin = helper(list);
            //need to go back to the original state before return
            list[i] = '+';
            list[i + 1] = '+';
//          if the opponent doesn't win, then we win
            if (!otherWin) return true;
        }
        return false;
    }

}
