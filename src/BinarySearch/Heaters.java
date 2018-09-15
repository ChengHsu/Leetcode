package BinarySearch;

import java.util.Arrays;

/**
 * @Number: #475. Heaters
 * @Descpription: Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * @Author: Created by xucheng.
 */
public class Heaters {
    //  Hard. Don't understand
//    先将取暖器数组排序，在遍历所有house，对每个house，在取暖器数组中进行binary search，如果命中，则说明取暖器位置和house位置重合，这个house的最小半径为0；如果没有命中，则使用返回的index，将index左边和右边的取暖器坐标与house坐标求差值，找出这个house最小半径。说白了，也是在查找house的最近左右取暖器
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
            System.out.println("Res: "+res);
        }

        return res;
    }
}
