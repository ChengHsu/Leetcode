package Array;

/**
 * @Number: #717. 1-bit and 2-bit Characters
 * @Descpription:We have two special characters. The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11). Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 * @Author: Created by xucheng.
 */
public class OneBitAndTwoBitCharacters {
    // if bits[i] == 0, then this is 1-bit character, if bits[0] == 1, then this is a 2-bit character.
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 1) return true;
            if (bits[i] == 0) continue;
            else if (bits[i] == 1) i++;
        }
        return false;
    }
}
