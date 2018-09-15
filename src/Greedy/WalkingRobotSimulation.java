package Greedy;

/**
 * @Number: #874. Walking Robot Simulation
 * @Descpription: A robot on an infinite grid starts at point (0, 0) and faces north.
 * The robot can receive one of three possible types of commands:
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * @Author: Created by xucheng.
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int x = 0, y = 0, di = 0;
        return 0;
    }
}
