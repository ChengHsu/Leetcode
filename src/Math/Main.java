package Math;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
      ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums,1));
    }
}
