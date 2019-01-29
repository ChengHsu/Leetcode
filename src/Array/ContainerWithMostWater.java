package Array;

/**
 * @Number: #11. Container With Most Water
 * @Descpription: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * @Author: Created by xucheng.
 */
public class ContainerWithMostWater {
    /**
     * Two pointers:
     * At every step, we find out the area formed between them,
     * update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int front = 0;
        int end = height.length - 1;
        int maxAera = 0;
        while (front < end) {
            maxAera = Math.max(maxAera, (end - front) * Math.min(height[front], height[end]));
            // front and end do not move at the same time
            if (height[front] < height[end])
                front++;
            else
                end--;
        }
        return maxAera;
    }
}
