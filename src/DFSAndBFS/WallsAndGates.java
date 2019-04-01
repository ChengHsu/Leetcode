package DFSAndBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Number: #286. Walls and Gates
 * @Descpription: You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 * @Author: Created by xucheng.
 */
public class WallsAndGates {

    /**
     * BFS
     * https://leetcode.com/problems/walls-and-gates/discuss/72745/Java-BFS-Solution-O(mn)-Time
     * 1. put all gates in the queue
     * 2.for every gate in the queue, update its neighbour and put them into the queue
     * time: O(mn)
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0];
            int col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row+1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE){
                rooms[row][col -1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col +1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }

    }
}
