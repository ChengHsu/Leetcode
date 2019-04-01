package Math;

import java.util.Arrays;

/**
 * @Number: #973. K Closest Points to Origin
 * @Descpription: We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * @Author: Created by xucheng.
 */
public class KClosestPointsToOrigin {
    /**
     * time: O(n log n)
     * space: O(n)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0 || points[0].length == 0)
            return new int[0][0];

        // 1. calculate every point's distance
        int N = points.length;
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = dist(points[i]);
        }
        // 2. sort the distances
        Arrays.sort(dist);
        // 3. find the K-th distance
        int KthDist = dist[K - 1];
        int[][] ans = new int[K][2];
        int t = 0;
        // 4. iterate every point and calculate the distance again, put all the points whose distance <= K
        for (int i = 0; i < N; i++) {
            if (dist(points[i]) <= KthDist)
                ans[t++] = points[i];
        }
        return ans;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
