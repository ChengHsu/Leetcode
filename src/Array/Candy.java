package Array;

import java.util.Arrays;

/**
 * @Number: #135. Candy
 * @Descpription: There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @Author: Created by xucheng.
 */
public class Candy {
    /**
     * Key Question: For each kid we have 3 cases:
     * 两遍扫描，第一遍正序，check if ratings[i] > ratings[i - 1]； 第二遍倒序， check if ratings[i] > ratings[i + 1]
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // Condition 1
        Arrays.fill(candies, 1);

        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        int sum = candies[ratings.length - 1];

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            sum += candies[i];
        }
        return sum;
    }
}
