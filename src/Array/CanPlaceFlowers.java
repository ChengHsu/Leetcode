package Array;

/**
 * @Number: #605.Can Place Flowers
 * @Descpription: Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n,return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * @Author: Created by xucheng.
 */
public class CanPlaceFlowers {
    // Find out the extra max number of flowers, count, that can be planted for the given flowerbed arrangement.
    // Traverse over all the elements of the flowerbed and find 0s. For every 0, check if its both adjacent positions are also empty.
    // For the first and last elements, we need not check the previous and the next adjacent positions respectively.
    // If count >= n, return true, otherwise, return false.
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0 && n == 1)
                return true;
            if (flowerbed[0] == 0 && n == 0)
                return true;
            if (flowerbed[0] == 1 && n == 0)
                return true;
            if (flowerbed[0] == 1 && n == 1)
                return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    count++;
                }
                if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 2] == 0) {
                    flowerbed[flowerbed.length - 1] = 1;
                    count++;
                } else if (i > 0 && i < flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
                    {
                        flowerbed[i] = 1;
                        count++;
                    }

                }
            }
            if (count >= n) return true;
        }
        return false;
    }
}
