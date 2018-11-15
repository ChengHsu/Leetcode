package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Number: #657. Robot Return to Origin
 * @Descpription: There is a robot starting at position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * The move sequence is represented by a string, and the character moves[i] represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true.
 * Otherwise, return false.
 * @Author: Created by xucheng.
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int numsU = 0;
        int numsD = 0;
        int numsL = 0;
        int numsR = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'U')
                numsU++;
            if (c == 'D')
                numsD++;
            if (c == 'L')
                numsL++;
            if (c == 'R')
                numsR++;
        }
        if (numsU == numsD && numsL == numsR)
            return true;
        else return false;
    }
}
