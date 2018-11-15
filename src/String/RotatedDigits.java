package String;

/**
 * @Number: #788. Rotated Digits
 * @Descpription: X is a good number if after rotating each digit individually by 180 degrees, we get a valid number
 * that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate
 * to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * @Author: Created by xucheng.
 */
public class RotatedDigits {
    /**
     * Valid if a number contains at least one 2,5,6,9
     * And no 3,4,or 7s
     * @param N
     * @return
     */
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) res++;
        }
        return res;
    }

    private boolean isValid(int i) {
       boolean valid = false;
       while (i > 0) {
           if (i % 10 == 2) valid = true;
           if (i % 10 == 5) valid = true;
           if (i % 10 == 6) valid = true;
           if (i % 10 == 9) valid = true;
           if (i % 10 == 3) return false;
           if (i % 10 == 4) return false;
           if (i % 10 == 7) return false;
           i = i / 10;
       }
       return valid;
    }
}
